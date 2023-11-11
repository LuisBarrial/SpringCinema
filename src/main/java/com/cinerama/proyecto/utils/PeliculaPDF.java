package com.cinerama.proyecto.utils;

import com.cinerama.proyecto.models.entitys.Pelicula;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;

@Component("admin/listas/peliculas")
public class PeliculaPDF extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        @SuppressWarnings("unchecked")
        List<Pelicula> listaPeliculas = (List<Pelicula>) model.get("listaPeliculas");

        /*Fuentes, tamaños y colores para cada seccion*/
        Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD,20, Color.BLUE);
        Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD ,12,Color.BLUE);
        Font fuenteDataCeldas = FontFactory.getFont(FontFactory.COURIER ,10,Color.BLACK);

        document.setPageSize(PageSize.LETTER.rotate());
        document.setMargins(-20, -20, 30, 20);
        document.open();
        PdfPCell celda = null;

        /*Tabla Para El Titulo del PDF*/
        PdfPTable tablaTitulo = new PdfPTable(1);

        celda = new PdfPCell(new Phrase("Lista de peliculas", fuenteTitulo));
        celda.setBorder(0);
        celda.setBackgroundColor(new Color(40,190,138));
        celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
        celda.setPadding(30);

        tablaTitulo.addCell(celda);
        tablaTitulo.setSpacingAfter(30);

        /*Tabla Para Mostrar Listado de Productos*/
        PdfPTable tablaPeliculas = new PdfPTable(6);
        tablaPeliculas.setWidths(new float[] {0.8f, 2f, 2f, 2f, 2f, 1.5f});

        celda = new PdfPCell(new Phrase("ID", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaPeliculas.addCell(celda);

        celda = new PdfPCell(new Phrase("NOMBRES", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaPeliculas.addCell(celda);

        celda = new PdfPCell(new Phrase("DURACION", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaPeliculas.addCell(celda);

        celda = new PdfPCell(new Phrase("GENERO", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaPeliculas.addCell(celda);

        celda = new PdfPCell(new Phrase("CLASIFICACION", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaPeliculas.addCell(celda);

        celda = new PdfPCell(new Phrase("ESTADO", fuenteTituloColumnas));
        celda.setBackgroundColor(Color.lightGray);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(10);
        tablaPeliculas.addCell(celda);

        /*Bucle For, mostrar todos los datos de los clientes*/
        for (Pelicula  pelicula : listaPeliculas) {
            celda = new PdfPCell(new Phrase(pelicula.getId().toString(), fuenteDataCeldas));
            celda.setPadding(5);
            tablaPeliculas.addCell(celda);

            celda = new PdfPCell(new Phrase(pelicula.getNombre(), fuenteDataCeldas));
            celda.setPadding(5);
            tablaPeliculas.addCell(celda);

            celda = new PdfPCell(new Phrase(pelicula.getDuracion(), fuenteDataCeldas));
            celda.setPadding(5);
            tablaPeliculas.addCell(celda);

            celda = new PdfPCell(new Phrase(pelicula.getGeneroPelicula().toString(), fuenteDataCeldas));
            celda.setPadding(5);
            tablaPeliculas.addCell(celda);

            celda = new PdfPCell(new Phrase(pelicula.getClasificacion().toString(), fuenteDataCeldas));
            celda.setPadding(5);
            tablaPeliculas.addCell(celda);

            celda = new PdfPCell(new Phrase(pelicula.getEstadop().toString(), fuenteDataCeldas));
            celda.setPadding(5);
            tablaPeliculas.addCell(celda);
        }

        /*Anexamos las Tablas al Documento*/
        document.add(tablaTitulo);
        document.add(tablaPeliculas);
    }
}
