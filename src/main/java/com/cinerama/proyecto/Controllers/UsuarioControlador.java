package com.cinerama.proyecto.Controllers;

import com.cinerama.proyecto.Controllers.dto.UsuarioRegistroDTO;
import com.cinerama.proyecto.models.entitys.Sede;
import com.cinerama.proyecto.models.entitys.Usuario;
import com.cinerama.proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioControlador {
    @Autowired
    private UsuarioService usuarioServicio;

    public UsuarioControlador(UsuarioService usuarioServicio) {
        super();
        this.usuarioServicio = usuarioServicio;
    }

    @ModelAttribute("usuarioadmin")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    @GetMapping("/admin/usuarios/nuevo")
    public String mostrarFormularioDeRegistro() {
        return "admin/formularios/registrarAdmin";
    }

    @PostMapping("/admin/usuarios/guardar")
    public String registrarCuentaDeUsuario(@ModelAttribute("usuarioadmin") UsuarioRegistroDTO registroDTO) {
        usuarioServicio.guardar(registroDTO);
        return "redirect:/admin";
    }

    @GetMapping("/admin/usuarios")
    public String listarUsuarios(Model modelo){
        List<Usuario> listaUsuario = usuarioServicio.listarUsuarios();
        modelo.addAttribute("listaUsuario", listaUsuario);
        return "admin/listas/usuarios";
    }

    @GetMapping("/admin/usuarios/eliminar/{id}")
    public String eliminarPelicula(@PathVariable("id") Long id, Model modelo){
        usuarioServicio.deleteById(id);
        return "redirect:/admin/usuarios";
    }
}
