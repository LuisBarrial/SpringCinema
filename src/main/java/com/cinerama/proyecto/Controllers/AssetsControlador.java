package com.cinerama.proyecto.Controllers;

import com.cinerama.proyecto.service.AlmacenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assets")
public class AssetsControlador {
	@Autowired
	private AlmacenServiceImpl almacenServicio;

	@GetMapping("/{filename:.+}")
	public Resource obtenerRecurso(@PathVariable("filename") String filename){
		return almacenServicio.cargarComoRecurso(filename);
	}

}