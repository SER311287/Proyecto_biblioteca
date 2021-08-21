package biblioteca.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import biblioteca.uspg.model.Pais;

public interface IPaisDAO extends JpaRepository<Pais,Integer> {

}
