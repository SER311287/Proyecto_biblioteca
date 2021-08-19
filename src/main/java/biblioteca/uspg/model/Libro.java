package biblioteca.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="libro")
public class Libro {	
@Id	
@GeneratedValue(strategy=GenerationType.IDENTITY)
Integer id_libro;    

@Column(name ="titulo",nullable=false, length=100)
String titulo;

@Column(name ="edicion",nullable=false, length=100)
String edicion;
@Column(name ="isbn",nullable=false, length=20)
Integer isbn;
@Column(name ="ejemplar",nullable=false, length=1000)
Integer ejemplar;
@Column(name ="ejemplar_disponible",nullable=false, length=3000)
Integer ejemplar_disponible;
@Column(name ="Costo_prestamo_por_dia",nullable=false, length=30)
Float costo_prestamo_por_dia;




public Integer getId_libro() {
	return id_libro;
}
public void setId_libro(Integer id_libro) {
	this.id_libro = id_libro;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getEdicion() {
	return edicion;
}
public void setEdicion(String edicion) {
	this.edicion = edicion;
}
public Integer getIsbn() {
	return isbn;
}
public void setIsbn(Integer isbn) {
	this.isbn = isbn;
}
public Integer getEjemplar() {
	return ejemplar;
}
public void setEjemplar(Integer ejemplar) {
	this.ejemplar = ejemplar;
}
public Integer getEjemplar_disponible() {
	return ejemplar_disponible;
}
public void setEjemplar_disponible(Integer ejemplar_disponible) {
	this.ejemplar_disponible = ejemplar_disponible;
}
public Float getCosto_prestamo_por_dia() {
	return costo_prestamo_por_dia;
}
public void setCosto_prestamo_por_dia(Float costo_prestamo_por_dia) {
	this.costo_prestamo_por_dia = costo_prestamo_por_dia;
}

	

}
