package biblioteca.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="estudiante")

public class Estudiante {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id_lector;
	@Column(name="carnet",nullable=false, length=30)
	Integer carnet;
	@Column(name="nombre",nullable=false, length=50)
	String nombre;
	@Column(name="direccion",nullable=false, length=30)
	String direccion;
	@Column(name="carrera",nullable=false, length=30)
	String carrera;
	@Column(name="edad",nullable=false, length=13)
	Integer edad;
	
	public Integer getId_lector() {
		return id_lector;
	}
	public void setId_lector(Integer id_lector) {
		this.id_lector = id_lector;
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
	
	
	


