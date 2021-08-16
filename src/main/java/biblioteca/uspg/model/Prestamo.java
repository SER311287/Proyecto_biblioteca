package biblioteca.uspg.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prestamo")
public class Prestamo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id_lector;
	
	@Column(name ="id_libro",nullable=false, length=20)
	Integer id_libro;
	@Column(name ="fecha_prestamo",nullable=false)
	LocalDate fecha_prestamo;
	@Column(name ="fecha_entrega",nullable=false)
	LocalDate fecha_entrega;
	@Column(name ="devuelto",nullable=false, length=10)
	String devuelto;
	
	
	public Integer getId_lector() {
		return id_lector;
	}
	public void setId_lector(Integer id_lector) {
		this.id_lector = id_lector;
	}
	public Integer getId_libro() {
		return id_libro;
	}
	public void setId_libro(Integer id_libro) {
		this.id_libro = id_libro;
	}
	public LocalDate getFecha_prestamo() {
		return fecha_prestamo;
	}
	public void setFecha_prestamo(LocalDate fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}
	public LocalDate getFecha_entrega() {
		return fecha_entrega;
	}
	public void setFecha_entrega(LocalDate fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}
	public String getDevuelto() {
		return devuelto;
	}
	public void setDevuelto(String devuelto) {
		this.devuelto = devuelto;
	}
	
	
	
}
