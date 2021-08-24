package biblioteca.uspg.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="autor")
public class Autor {
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id_autor;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_libro", 
	nullable = false, 
	foreignKey = @ForeignKey(name = "autor_id_libro"))
	private Libro libro;
	
	@OneToMany(mappedBy="autor",
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE,
					CascadeType.REMOVE},
			 fetch = FetchType.LAZY,
			 orphanRemoval = true
			)
	private List<Pais> pais;
	 

	@Size(min=3 , max=30 , message =" nombre minimo tres caracteres ")
	@Column(name ="nombre",nullable=false, length=100)
	String nombre;
	@Size(min=3 , max=30 , message =" nombre minimo tres caracteres ")
	
	@Column(name ="edad",nullable=false, length=13)
	Integer edad;
	


	public Integer getId_autor() {
		return id_autor;	
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_autor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(id_autor, other.id_autor);
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public List<Pais> getPais() {
		return pais;
	}
	public void setPais(List<Pais> pais) {
		this.pais = pais;
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
	
	
	
	

}
