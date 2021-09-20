package com.gdg.gestiondegastos.controllers;

import com.gdg.gestiondegastos.entities.Grupo;
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
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    // @Autowired
    // private PasswordEncoder clave;

    // Este es un get para ver la principal y así ver los cambios
    @GetMapping("/paginaPrincipal")
    public String principal() {
        return "principal";
    }

    @GetMapping("/inicio/{idUsuario}")
    public String inicio(Model m, @PathVariable Integer idUsuario) {
        Usuario user = repoUsuario.getById(idUsuario);

        m.addAttribute("presupuestoPersonal", user.getId());

        return "principal";
    }

    @GetMapping("/agregar")
    public String agregarUsuario(Model m, Usuario usuario) {
        m.addAttribute("usuario", new Usuario());
        // repoUsuario.save(usuario);
        return "crearUsuario";
    }

    @GetMapping("/principal")
    public String principal(Model m) {
        // m.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/crear")
    public String crear(Model m, Usuario usuario) {

        // usuario.setContrasenya(clave.encode(usuario.getContrasenya()));
        repoUsuario.save(usuario);
        return "login";
    }

    @PostMapping("/ingresar") // hacer login
    public String ingresar(Model m, String username, String password) {

        Usuario usuario = new Usuario();
        System.out.println(" USUARIO  1    " + username);
        try {
            usuario = repoUsuario.findByCorreo(username);
            System.out.println(" USUARIO   2   " + usuario.getNombre());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (usuario.getNombre() != null)

        // if (usuario.getContrasenya()== clave.encode(password))
        {
            return "principal";
        } else {
            return "login";
        }
    }

    @GetMapping("/grupo/{idGrupo}")
    public String verGrupos(Model m, @PathVariable Integer idGrupo) {

        m.addAttribute("grupo", repoGrupo.findById(idGrupo).get());
        m.addAttribute("movimientos", repoMovimientos.leerPorGrupo(idGrupo));

        m.addAttribute("presupuesto", repoPresupuesto.findByIdGrupo(idGrupo));

        return "grupos";
    }

    @GetMapping("/grupo/{idGrupo}/gestionar")
    public String gestionarGrupos(Model m, @PathVariable Integer idGrupo) {

        m.addAttribute("grupos", repoGrupo.findById(idGrupo).get().getUsuarioGrupo());

        return "gestionGrupos";
    }

    @GetMapping("/grupo/{idGrupo}/borrarUsuario")
    public String borrarUsuario(Integer idUsuarioGrupo, Integer idGrupo) {
        repoUsuarioGrupo.deleteById(idUsuarioGrupo);
        return "redirect:/gestion/grupo/{idGrupo}/gestionar";
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
    @PostMapping("/grupo/{idGrupo}/guardarMovimiento")
    public String guardarMovimiento(Model m, Movimiento mov, Integer idUsuarioGrupo, @PathVariable Integer idGrupo) {
        UsuarioGrupo ug = repoUsuarioGrupo.findById(idUsuarioGrupo).get();
        mov.setUsuarioGrupo(ug);
        repoMovimientos.save(mov);

        Presupuesto p = repoPresupuesto.findByIdGrupo(idGrupo);
        p.setCantidadFinal(p.getCantidadFinal() + mov.getCantidad());
        repoPresupuesto.save(p);
        return "redirect:/gestion/paginaPrincipal";
    }
}
