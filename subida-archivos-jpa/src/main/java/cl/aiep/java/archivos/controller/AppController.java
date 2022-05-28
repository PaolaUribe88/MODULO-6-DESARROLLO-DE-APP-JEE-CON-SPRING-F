package cl.aiep.java.archivos.controller;

import java.io.IOException;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cl.aiep.java.archivos.model.Archivo;
import cl.aiep.java.archivos.repository.ArchivoRepository;

@Controller
public class AppController {

	@Autowired
	ArchivoRepository archivoRepository;
	
	@GetMapping("/")//recive
	public String formulario() {
		return "formulario";
	}
	@PostMapping("/")//envia
	public String procesarFormulario(@RequestParam("archivo")MultipartFile archivo) {
		try {
			String nombreArchivo = archivo.getOriginalFilename();//devuelve el nombre del archivo k subi
			String tipoArchivos = archivo.getContentType();
			byte[] contenidoArchivo = archivo.getBytes();
			Archivo archivoBD = Archivo.builder().datos(contenidoArchivo).filename(nombreArchivo).tipoarchivo(tipoArchivos).build();
			
			archivoRepository.saveAndFlush(archivoBD);
			
			return "redirect:/cualquier-pagina";
		} catch (Exception e) {
			
			return "formulario";
		}		
	}

	@GetMapping("/archivo/{disposicion}/{id}")//le digo al browser si tiene que descargar o intentar mostrar el archivo
	public ResponseEntity<byte[]> mostrarDescargarArchivo (
		@PathVariable ("disposicion")String disposicion,
		@PathVariable("id") Archivo archivo
		){
		String disposition = null;
		if ("a".equalsIgnoreCase(disposicion)) {
			disposition ="attachment";
			//htt://localhost:8081/archivo/a/1 ASI LE DIGO PARA QUE DESCARGUE EL ARCHIVO(A = ATTACHMENT)
		}else {
			disposition ="inline";
			//htt://localhost:8081/archivo/i/1 ASI LE DIGO PARA QUE MUESTRE EL ARCHIVO ( I = INLINE)
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, disposition)
				.contentType(MediaType.valueOf(archivo.getTipoarchivo()))
				.body(archivo.getDatos());
		
	}
}
