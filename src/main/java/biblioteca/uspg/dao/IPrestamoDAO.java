package biblioteca.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import biblioteca.uspg.model.Prestamo;

public interface IPrestamoDAO extends JpaRepository<Prestamo , Integer>{

}
