package com.cinerama.proyecto.Controllers;

import com.cinerama.proyecto.models.entitys.Asientos;
import com.cinerama.proyecto.models.entitys.Usuario;
import com.cinerama.proyecto.service.AsientoService;
import com.cinerama.proyecto.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class WordController {
    @Autowired
    private WordService wordServiceApi;

    @Autowired
    private AsientoService asientosDao;

    @RequestMapping(value = "/usuario/pelicula/{idpelicula}/sala/{idsala}/{horario}/api/crearboleto", method = RequestMethod.POST)
    public void run(@RequestBody Asientos asientos, Usuario usuario, @PathVariable("idpelicula") Integer idpelicula, @PathVariable("idsala") Integer idsala, @PathVariable("horario") String horario, String... args) throws Exception {

        asientos.setFecha(LocalDateTime.now());
        LocalDateTime now = asientos.getFecha();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        String formatDateTime = now.format(formatter);
        asientos.setIdcliente("User"+formatDateTime);
        wordServiceApi.gaurdarInfoUsuario(asientos);



        wordServiceApi.createWord("Boleto de Compra","src/main/resources/templates/Imagenes/EMPRESALOGO.png","ticket102.docx");
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getDownloadData() throws Exception {

        String regData = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        byte[] output = regData.getBytes();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("charset", "utf-8");
        responseHeaders.setContentType(MediaType.valueOf("text/html"));
        responseHeaders.setContentLength(output.length);
        responseHeaders.set("Content-disposition", "attachment; filename=filename.txt");

        return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
    }
}
