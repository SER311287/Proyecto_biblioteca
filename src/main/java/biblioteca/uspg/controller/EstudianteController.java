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

//import com.sun.org.apache.xerces.internal.util.URI;

import biblioteca.uspg.exception.ModeloNotFoundException;
import biblioteca.uspg.model.Estudiante;
import biblioteca.uspg.service.IEstudianteService;
//import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController  {
	@Autowired
	private IEstudianteService service;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Estudiante>>estudiante(){
		return new ResponseEntity<List<Estudiante>>(service.listar(),HttpStatus.OK);
	}
		
		@GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
		public EntityModel<Estudiante> listarPorId(@PathVariable("id") Integer id){
			Optional<Estudiante> estudiante = service.listarPorId(id);
			
			if(!estudiante.isPresent()) {
				
				throw new ModeloNotFoundException("ID NO ENCONTRADO:"+ id);
			}
			
			EntityModel<Estudiante>resource = EntityModel.of(estudiante.get());
			WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
			resource.add(linkTo.withRel("estudiante-resource"));
			//return service.listarPorId(id);
			return resource;
		
		}
		
		
		
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>registrar(@RequestBody @Valid Estudiante estud){
		Estudiante estudiante=service.registrar(estud);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(estudiante.getId_estudiante()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	 @PutMapping(produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> modificar(@RequestBody Estudiante estudi){
			Optional<Estudiante> estudiante=service.listarPorId(estudi.getId_estudiante());
			
			if(!estudiante.isPresent()) {
				 throw new ModeloNotFoundException("ID NO ENCONTRADO: " + estudi.getId_estudiante());
			 }else {
				 service.modificar(estudi);
			 }
			 return new ResponseEntity<Object>(HttpStatus.OK);
			 
			 //return service.modificar(estudiante); 
		}
	 
	 
	 @DeleteMapping(value = "/{id}") 
	 public void eliminar(@PathVariable("id") Integer id) {
		 Optional<Estudiante> estudiante = service.listarPorId(id);
		 if(!estudiante.isPresent()) {
			 throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		 } else {
			 service.eliminar(id); 
		 }
		
	}
	
	
	
	
	

}
