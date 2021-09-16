package com.gdg.gestiondegastos.controllers;

import com.gdg.gestiondegastos.entities.Usuario;
import com.gdg.gestiondegastos.repositories.GrupoRepository;
import com.gdg.gestiondegastos.repositories.MovimientosRepository;
import com.gdg.gestiondegastos.repositories.PresupuestoRepository;
import com.gdg.gestiondegastos.repositories.UsuarioGrupoRepository;
import com.gdg.gestiondegastos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    
    
    
    @PostMapping("/agregar")
    public String agregarUsuario(Model m, Usuario usuario){
        repoUsuario.save(usuario);
        
        return "login";
    }
    
    @GetMapping("/grupos")
    public String verGrupos(Model m, Integer idGrupo){
        
        //m.addAttribute("nombrePresupuesto", repoPresupuesto.findByIdGrupo(idGrupo).get());
        //m.addAttribute("grupo", repoGrupo.findById(idGrupo));
        
        m.addAttribute("grupo", repoGrupo.findById(idGrupo).get());
        //m.addAttribute("usuarioGrupo", repoUsuarioGrupo.findById(idGrupo).get().getMovimiento().get(0).getConcepto());
        //m.addAttribute("usuarioGrupo", repoUsuarioGrupo.findById(idGrupo).get().getUsuario().getNombre());
        //m.addAttribute("usuarioGrupo", repoUsuarioGrupo.findById(idGrupo).get().getMovimiento().get(0).getCantidad());
        m.addAttribute("presupuesto", repoPresupuesto.findByIdGrupo(idGrupo));
        
        return "grupos";
    }

}
