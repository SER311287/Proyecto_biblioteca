package biblioteca.uspg.model;

import java.util.Objects;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="pais")
 
public class Pais  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id_pais;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_autor", 
	nullable = false, 
	foreignKey = @ForeignKey(name = "pais_autor"))
	Autor autor;

	public Integer getId_pais() {
		return id_pais;
	}

	public void setId_pais(Integer id_pais) {
		this.id_pais = id_pais;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
}