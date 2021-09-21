package com.gdg.gestiondegastos.controllers;

import com.gdg.gestiondegastos.dto.UsuarioDto;
import com.gdg.gestiondegastos.entities.Movimiento;
import com.gdg.gestiondegastos.entities.Presupuesto;
import com.gdg.gestiondegastos.entities.Usuario;
import com.gdg.gestiondegastos.entities.UsuarioGrupo;
import com.gdg.gestiondegastos.repositories.GrupoRepository;
import com.gdg.gestiondegastos.repositories.MovimientosRepository;
import com.gdg.gestiondegastos.repositories.PresupuestoRepository;
import com.gdg.gestiondegastos.repositories.UsuarioGrupoRepository;
import com.gdg.gestiondegastos.repositories.UsuarioRepository;
import com.mysql.cj.Constants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/gestion")
public class GestionDeGastosController {

    @Autowired
    private UsuarioRepository repoUsuario;
    @Autowired
    private GrupoRepository repoGrupo;
    @Autowired
    private UsuarioGrupoRepository repoUsuarioGrupo;
    @Autowired
    private PresupuestoRepository repoPresupuesto;
    @Autowired
    private MovimientosRepository repoMovimientos;
    // @Autowired
    // private ModelMapper obj;
    @Autowired
    private PasswordEncoder clave;

    // Este es un get para ver la principal y asÃ­ ver los cambios
    @GetMapping("/paginaPrincipal")
    public String principal() {
        return "principal";
    }

    @GetMapping("/agregar")
    public String agregarUsuario(Model m, Usuario usuario) {
        m.addAttribute("usuario", new Usuario());
        // repoUsuario.save(usuario);
        return "crearUsuario";
    }

    @GetMapping("/principal") // Pagina de inicio principal
    public String principal(Model m) {
        // m.addAttribute("usuario", new Usuario());
        return "login";
    }
    /*
     * @GetMapping("/principal2") public String principal2(Model m) { //
     * m.addAttribute("usuario", new Usuario()); return "login2"; }
     */

    @PostMapping("/crear")
    public String crear(Model m, Usuario usuario) throws ClassNotFoundException, SQLException {
        Usuario usu = repoUsuario.findByCorreo(usuario.getCorreo());
        if (usu != null) {
            m.addAttribute("msg", "Correo ya registrado. Utilice otro");
            return "crearUsuario";
        } else {
            usuario.setContrasenya(clave.encode(usuario.getContrasenya()));
            repoUsuario.save(usuario);
            return "login";
        }
    }

    @GetMapping("/info")
    @ResponseBody
    public String info() {

        // UsuarioDto
        // usuValidado=(UsuarioDto)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        // System.out.print(SecurityContextHolder.getContext().getAuthentication());
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @Autowired
    private AuthenticationManager am;

    @PostMapping("/ingresar") // hacer login
    public String ingresar(Model m, String correo, String contrasenya) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(correo, contrasenya);
        Authentication auth = am.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(auth);

        Usuario usuario = new Usuario();
        System.out.println(" USUARIO  1    " + correo);
        try {
            usuario = repoUsuario.findByCorreo(correo);
            System.out.println(" USUARIO   2   " + usuario.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (usuario.getNombre() != null) {
            return "redirect:inicio";
        } else {
            return "login";
        }
    }

    /*
     * @PostMapping("/ingresar2") // Pruebas public String ingresar2(Model m, String
     * correo, String contrasenya, RedirectAttributes redirectAttrs) {
     * 
     * //UsernamePasswordAuthenticationToken token = new
     * UsernamePasswordAuthenticationToken(correo, contrasenya); //Authentication
     * auth = am.authenticate(token);
     * //SecurityContextHolder.getContext().setAuthentication(auth); Usuario usuario
     * = new Usuario(); //System.out.println(" USUARIO  1    " + correo); try {
     * usuario = repoUsuario.findByCorreo(correo);
     * //System.out.println(" USUARIO   2   " + usuario.getNombre()); } catch
     * (Exception e) { e.printStackTrace(); }
     * 
     * if (usuario.getNombre() != null) {
     * redirectAttrs.addFlashAttribute("idUsuario", usuario.getId()); return
     * "redirect:/gestion/inicio"; } else { return "login"; } }
     */

    // Antes del Security
    @GetMapping("/inicio")
    public String inicio(Model m) {
        UsuarioDto usuValidado = (UsuarioDto) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        Usuario user = repoUsuario.findById(usuValidado.getId()).get();
        // user = repoUsuario.getById(idUsuario);

        // Suma todas las cantidades iniciales indicadas en el presupuesto del usuario
        m.addAttribute("presupuestoPersonal",
                user.getUsuarioGrupo().stream().map(x -> x.getGrupo().getPresupuesto()).collect(Collectors
                        .summingDouble(p -> p.stream().collect(Collectors.summingDouble(z -> z.getCantidadInicio())))));

        m.addAttribute("movimientos", repoMovimientos.leerPorUsuario(usuValidado.getId()));

        return "principal";
    }

    /*
     * //Despues del Security
     * 
     * @GetMapping("/inicio") public String inicio(Model m,@RequestParam Integer
     * idUsuario) { Usuario user = repoUsuario.findById(idUsuario).get(); // user =
     * repoUsuario.getById(idUsuario);
     * 
     * // Suma todas las cantidades iniciales indicadas en el presupuesto del
     * usuario m.addAttribute("presupuestoPersonal",
     * user.getUsuarioGrupo().stream().map(x ->
     * x.getGrupo().getPresupuesto()).collect(Collectors .summingDouble(p ->
     * p.stream().collect(Collectors.summingDouble(z -> z.getCantidadInicio())))));
     * 
     * m.addAttribute("movimientos", repoMovimientos.leerPorUsuario(idUsuario));
     * 
     * return "principal"; }
     */

    @GetMapping("/grupo/{idGrupo}")
    public String verGrupos(Model m, @PathVariable Integer idGrupo) {

        m.addAttribute("grupo", repoGrupo.findById(idGrupo).get());
        m.addAttribute("movimientos", repoMovimientos.leerPorGrupo(idGrupo));
        m.addAttribute("presupuesto", repoPresupuesto.findByIdGrupo(idGrupo));
        return "grupos";
    }

    @GetMapping("/grupo/{idGrupo}/gestionar")
    public String gestionarGrupos(Model m, @PathVariable Integer idGrupo) {

        m.addAttribute("usuarioGrupo", repoUsuarioGrupo.leerPorGrupo(idGrupo));

        return "gestionGrupos";
    }

    /*
     * //Sin ajax
     * 
     * @GetMapping("/grupo/{idGrupo}/borrarUsuario") public String
     * borrarUsuario(Integer idUsuarioGrupo, Integer idGrupo) {
     * repoUsuarioGrupo.deleteById(idUsuarioGrupo); return
     * "redirect:/gestion/grupo/{idGrupo}/gestionar"; }
     */

    // Con ajax
    @GetMapping("/grupo/{idGrupo}/borrarUsuario")
    public String borrarUsuario(Integer idUsuarioGrupo, Integer idGrupo) {
        repoUsuarioGrupo.deleteById(idUsuarioGrupo);
        return "redirect:/gestion/grupo/{idGrupo}";
    }

    /*
     * @GetMapping("/movimientos") public String verMovimientos(Model m, Integer
     * idMovimiento) { m.addAttribute("movimiento",
     * repoMovimientos.findById(idMovimiento).get());
     * 
     * return "movimientos"; }
     */

    /*
     * @PostMapping("/grupo/{idGrupo}/nuevoMovimiento") public String
     * nuevoMovimientos(Model m, Integer idUsuarioGrupo){ Movimiento mov = new
     * Movimiento();
     * mov.setUsuarioGrupo(repoUsuarioGrupo.findById(idUsuarioGrupo).get());
     * m.addAttribute("movimiento", mov);
     * 
     * return "nuevoMov"; }
     */
    // Ejemplo ded url: http://localhost:8080/gestion/grupo/6
    @GetMapping("/grupo/{idGrupo}/nuevoMovimiento")

    public String nuevoMovimientos(Model m, Integer idUsuarioGrupo) {
        Movimiento mov = new Movimiento();
        mov.setUsuarioGrupo(repoUsuarioGrupo.findById(idUsuarioGrupo).get());
        m.addAttribute("movimiento", mov);

        return "nuevoMov";
    }

    //
    @PostMapping("/grupo/guardarMovimiento")
    public String guardarMovimiento(Model m, Movimiento mov, Integer idUsuarioGrupo, Integer idGrupo) {
        UsuarioGrupo ug = repoUsuarioGrupo.findById(idUsuarioGrupo).get();
        mov.setUsuarioGrupo(ug);
        repoMovimientos.save(mov);

        Presupuesto p = repoPresupuesto.findByIdGrupo(idGrupo);
        p.setCantidadFinal(p.getCantidadFinal() + mov.getCantidad());
        repoPresupuesto.save(p);
        return "redirect:/gestion/grupo/" + idGrupo;
    }
}
