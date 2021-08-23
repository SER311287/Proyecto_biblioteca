package biblioteca.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import biblioteca.uspg.model.Estudiante;



public interface IEstudianteDAO extends JpaRepository<Estudiante ,Integer>{

}
