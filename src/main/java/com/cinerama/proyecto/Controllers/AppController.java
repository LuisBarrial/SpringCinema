package com.cinerama.proyecto.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/indexUsuario")
    public String verPaginaDeInicioU(){
        return "indexUsuario.html";
    }

    @GetMapping("/login")
    public String iniciarSesion(){
        return "login";
    }

    @GetMapping("/admin")
    public String verPaginaDeInicio() {
        return "admin/indexAdmin.html";
    }
}
