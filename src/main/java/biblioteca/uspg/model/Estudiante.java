package biblioteca.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="estudiante")

public class Estudiante {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id_estudiante;
	
	@Size(min=3 , max=30 , message =" nombre minimo tres caracteres ")
	@Column(name="carnet",nullable=false, length=50)
	Integer carnet;
	@Size(min=3 , max=30 , message =" nombre minimo tres caracteres ")
	@Column(name="nombre",nullable=false, length=50)
	String nombre;
	@Size(min=3 , max=30 , message =" nombre minimo tres caracteres ")
	@Column(name="direccion",nullable=false, length=50)
	String direccion;
	@Size(min=3 , max=30 , message =" nombre minimo tres caracteres ")
	@Column(name="carrera",nullable=false, length=50)
	String carrera;
	@Size(min=3 , max=30 , message =" nombre minimo tres caracteres ")
	@Column(name="edad",nullable=false, length=50)
	Integer edad;
	
	public Integer getId_estudiante() {
		return id_estudiante;
	}
	public void setId_estudiante(Integer id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	
	
	public Integer getCarnet() {
		return carnet;
	}
	public void setCarnet(Integer carnet) {
		this.carnet = carnet;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	}
	
	
	


