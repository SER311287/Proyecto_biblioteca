package biblioteca.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="autor")
public class Autor {
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id_autor;
	
	@Size(min=3 , max=30 , message =" nombre minimo tres caracteres ")
	@Column(name ="nombre",nullable=false, length=100)
	String nombre;
	@Size(min=3 , max=30 , message =" nombre minimo tres caracteres ")
	@Column(name ="pais",nullable=false, length=100)
	String pais;
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	@Column(name ="edad",nullable=false, length=13)
	Integer edad;
	@Column(name="id_pais",nullable=false, length=13)
	Integer id_pais;
	
	
	
	public Integer getId_autor() {
		return id_autor;
	}
	public void setId_autor(Integer id_autor) {
		this.id_autor = id_autor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Integer getId_pais() {
		return id_pais;
	}
	public void setId_pais(Integer id_pais) {
		this.id_pais = id_pais;
	}
	
	
	

}
