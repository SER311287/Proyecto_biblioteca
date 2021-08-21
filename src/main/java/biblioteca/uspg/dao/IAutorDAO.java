package biblioteca.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import biblioteca.uspg.model.Autor;

public interface IAutorDAO extends JpaRepository<Autor,Integer> {

}
