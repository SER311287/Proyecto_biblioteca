package biblioteca.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="libro_autor")
public class Libro_autor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Integer id_libro_autor;
	

public Integer getId_libro_autor() {
	return id_libro_autor;
}
public void setId_libro_autor(Integer id_libro_autor) {
	this.id_libro_autor = id_libro_autor;
}
@Column(name="id_libro",nullable=false, length=13)	
Integer id_libro;
@Column(name="id_autor",nullable=false, length=13)
Integer id_autor;
public Integer getId_libro() {
	return id_libro;
}
public void setId_libro(Integer id_libro) {
	this.id_libro = id_libro;
}
public Integer getId_autor() {
	return id_autor;
}
public void setId_autor(Integer id_autor) {
	this.id_autor = id_autor;
}
}
