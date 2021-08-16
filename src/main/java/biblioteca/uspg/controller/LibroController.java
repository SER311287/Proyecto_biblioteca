package biblioteca.uspg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import biblioteca.uspg.model.Libro;
import biblioteca.uspg.service.ILibroService;

// notacion de controller 

@RestController
@RequestMapping("/libro")

public class LibroController {
	//inyeccion de dependencias
	
	@Autowired
	private ILibroService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Libro>> listar(){ 
 		return new ResponseEntity<List<Libro>>(service.listar(), HttpStatus.OK); 
	 }

}
