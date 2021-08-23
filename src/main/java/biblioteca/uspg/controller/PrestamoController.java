package biblioteca.uspg.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import biblioteca.uspg.exception.ModeloNotFoundException;
import biblioteca.uspg.model.Prestamo;
import biblioteca.uspg.service.IPrestamoService;

@RestController
@RequestMapping("/prestamo")
public class PrestamoController {
	@Autowired
	private IPrestamoService service ;
	
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Prestamo>>prestamo(){
		return new ResponseEntity<List<Prestamo>>(service.listar(),HttpStatus.OK);
				
	}
	
	@GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public EntityModel<Prestamo> listarPorId(@PathVariable("id") Integer id){
		Optional<Prestamo> prestamo = service.listarPorId(id);
		
		if(!prestamo.isPresent()) {
			
			throw new ModeloNotFoundException("ID NO ENCONTRADO:"+ id);
		}
		
		EntityModel<Prestamo>resource = EntityModel.of(prestamo.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("prestamo-resource"));
		//return service.listarPorId(id);
		return resource;
	
	}
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>registrar(@RequestBody @Valid Prestamo presta){
		
	Prestamo prestamo = service.registrar(presta);
	
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(prestamo.getId_lector()).toUri();
	
	return ResponseEntity.created(location).build();
			
	}
	
	@PutMapping(produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody Prestamo presta){
		Optional<Prestamo> prestamo=service.listarPorId(presta.getId_lector());
		
		if(!prestamo.isPresent()) {
			 throw new ModeloNotFoundException("ID NO ENCONTRADO: " + presta.getId_lector());
		 }else {
			 service.modificar(presta);
		 }
		 return new ResponseEntity<Object>(HttpStatus.OK);
		 
		 //return service.modificar(prestamo); 
	}
	
	@DeleteMapping(value = "/{id}") 
	 public void eliminar(@PathVariable("id") Integer id) {
		 Optional<Prestamo> prestamo = service.listarPorId(id);
		 if(!prestamo.isPresent()) {
			 throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		 } else {
			 service.eliminar(id); 
		 }
		
	}
	

}
