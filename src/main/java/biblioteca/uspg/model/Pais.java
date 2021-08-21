package biblioteca.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="pais")

public class Pais {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id_pais;
	
	@Size(min=3 , max=30 , message =" nombre minimo tres caracteres ")
	@Column(name ="nombre_pais",nullable=false, length=50)
	String nombre_pais;
	
	
	
	
	public Integer getId_pais() {
		return id_pais;
	}
	public void setId_pais(Integer id_pais) {
		this.id_pais = id_pais;
	}
	public String getNombre_pais() {
		return nombre_pais;
	}
	public void setNombre_pais(String nombre_pais) {
		this.nombre_pais = nombre_pais;
	}

}