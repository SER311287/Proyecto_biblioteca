package biblioteca.uspg.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// import com.sun.org.apache.xerces.internal.util.URI;

import biblioteca.uspg.exception.ModeloNotFoundException;
import biblioteca.uspg.model.Autor;
import biblioteca.uspg.service.IAutorService;

@RestController
@RequestMapping ("/autor")

public class AutorController {
	@Autowired
	private IAutorService service;
	
	@GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)public 
		ResponseEntity<List<Autor>>listar(){
		return new ResponseEntity<List<Autor>>(service.listar(), HttpStatus.OK); 
	}
	
	@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public EntityModel<Autor> listarPorId(@PathVariable("id") Integer id){ 
		Optional<Autor> autor = service.listarPorId(id);
		
		if(!autor.isPresent()) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO:  " + id);
		}
			
		
		EntityModel<Autor>resource = EntityModel.of(autor.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("autor-resource"));
		//return service.listarPorId(id);
		return resource;
	}
	 
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>registrar(@RequestBody @Valid Autor autor_){
		
	Autor autor = service.registrar(autor_);
	
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(autor.getId_autor()).toUri();
	
	return ResponseEntity.created(location).build();
			
	}
	
	@PutMapping(produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody Autor aut){
		Optional<Autor> autor=service.listarPorId(aut.getId_autor());
		
		if(!autor.isPresent()) {
			 throw new ModeloNotFoundException("ID NO ENCONTRADO: " + aut.getId_autor());
		 }else {
			 service.modificar(aut);
		 }
		 return new ResponseEntity<Object>(HttpStatus.OK);
		 
		 //return service.modificar(autor); 
	}
		
	@DeleteMapping(value = "/{id}") 
	 public void eliminar(@PathVariable("id") Integer id) {
		 Optional<Autor> autor = service.listarPorId(id);
		 if(!autor.isPresent()) {
			 throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		 } else {
			 service.eliminar(id); 
		 }
		
	}
	

}
	

	
	
	
	
	

