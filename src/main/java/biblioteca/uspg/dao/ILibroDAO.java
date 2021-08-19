package biblioteca.uspg.dao;
//acceso a datos 

import org.springframework.data.jpa.repository.JpaRepository;

import biblioteca.uspg.model.Libro;

public interface ILibroDAO extends JpaRepository<Libro,Integer> {

	 
}
