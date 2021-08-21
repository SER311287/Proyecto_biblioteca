package biblioteca.uspg.controller;

import java.util.List;
import java.util.Optional;
import java.net.URI;

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

// import com.sun.org.apache.xerces.internal.util.URI;

import biblioteca.uspg.exception.ModeloNotFoundException;
import biblioteca.uspg.model.Pais;
import biblioteca.uspg.service.IPaisService;
// import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@RestController
@RequestMapping("/pais")
public class PaisController {
	// inyeccion de dependencia
	@Autowired
	private IPaisService service;
	
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pais>>pais(){
		return new ResponseEntity<List<Pais>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public EntityModel<Pais> listarPorId(@PathVariable("id") Integer id){
		Optional<Pais> pais = service.listarPorId(id);
		
		if(!pais.isPresent()) {
			
			throw new ModeloNotFoundException("ID NO ENCONTRADO:"+ id);
		}
		
		EntityModel<Pais>resource = EntityModel.of(pais.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("pais-resource"));
		//return service.listarPorId(id);
		return resource;
	
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>registrar(@RequestBody @Valid Pais pai_s){
		
	Pais pais = service.registrar(pai_s);
	
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(pais.getId_pais()).toUri();
	
	return ResponseEntity.created(location).build();
			
	}
	@PutMapping(produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody Pais p_ais){
		Optional<Pais> pais=service.listarPorId(p_ais.getId_pais());
		
		if(!pais.isPresent()) {
			 throw new ModeloNotFoundException("ID NO ENCONTRADO: " + p_ais.getId_pais());
		 }else {
			 service.modificar(p_ais);
		 }
		 return new ResponseEntity<Object>(HttpStatus.OK);
		 
		 //return service.modificar(autor); 
	}
	@DeleteMapping(value = "/{id}") 
	 public void eliminar(@PathVariable("id") Integer id) {
		 Optional<Pais> pais = service.listarPorId(id);
		 if(!pais.isPresent()) {
			 throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		 } else {
			 service.eliminar(id); 
		 }
		
	}





	

}
