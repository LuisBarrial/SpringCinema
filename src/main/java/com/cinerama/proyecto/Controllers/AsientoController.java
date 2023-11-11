package com.cinerama.proyecto.Controllers;

import com.cinerama.proyecto.models.entitys.Asientos;
import com.cinerama.proyecto.service.AsientoService;
import com.cinerama.proyecto.service.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AsientoController {
    @Autowired
    private AsientoService asientoService;

    @Autowired
    private FuncionService funcionService;

    @PostAuthorize("hasAuthority('READ_ALL_PRODUCTS', 'CREATE_INVOICE')")
    @RequestMapping(value = "/usuario/pelicula/{idpelicula}/sala/{idsala}/{horario}/api/guardarInfo",method = RequestMethod.POST)
    public void agregarUsuario(@RequestBody Asientos asientos, @PathVariable("idpelicula") Integer id, @PathVariable("idsala") Integer idsala, @PathVariable("horario") String horario) {
        asientos.setFecha(LocalDateTime.now());
        LocalDateTime now = asientos.getFecha();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        int identificador =funcionService.findFuncionByHorarioAndSalaAndPelicula(horario,String.valueOf(idsala),String.valueOf(id)).getId();

        asientos.setFuncion(funcionService.findById(identificador));
        String formatDateTime = now.format(formatter);
        asientos.setIdcliente("User"+formatDateTime+asientos.getCosto());
        asientoService.save(asientos);
    }

    @GetMapping("usuario/pelicula/{idpelicula}/sala/{idsala}/{horario}/api/asientos")
    public List<Asientos> obtenerAsiento(@PathVariable("idpelicula") Integer id, @PathVariable("idsala") Integer idsala, @PathVariable("horario") String horario){

        int identificador =funcionService.findFuncionByHorarioAndSalaAndPelicula(horario,String.valueOf(idsala),String.valueOf(id)).getId();
        List<Asientos> asientos1 = asientoService.findAll();

        List<Asientos> asientosaux =new ArrayList<Asientos>();

        for (int i=0; i<asientoService.findAll().size(); i++)
        {
            if (asientos1.get(i).getFuncion().getId() == identificador){
                asientosaux.add(asientos1.get(i));
            }
        }

        return asientosaux;
    }

}
