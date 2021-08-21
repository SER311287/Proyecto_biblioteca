package biblioteca.uspg.controller;

//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

//exposicion de servicios 

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	// metodo mostrar  datos 
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE ) 
	public Optional<Libro> listarPorId(@PathVariable("id") Integer id){
		return service.listarPorId(id);	
	}
	
	// metodo agregar datos 
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Libro registrar(@RequestBody Libro lib){
		return service.registrar(lib);
	}
	
	// metodo modificar
	@PutMapping( produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Libro modificar(@RequestBody Libro libro) {
		return service.modificar(libro);
	}
	
	//metodo eliminar 
	
	@DeleteMapping(value="/{id}") 
	public void eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
		
		
	}			
	

}
