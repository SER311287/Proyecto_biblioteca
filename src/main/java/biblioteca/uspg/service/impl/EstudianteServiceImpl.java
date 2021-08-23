package biblioteca.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.uspg.dao.IEstudianteDAO;
import biblioteca.uspg.model.Estudiante;
import biblioteca.uspg.service.IEstudianteService;

@Service

public class EstudianteServiceImpl implements IEstudianteService {
	
	@Autowired
	private IEstudianteDAO dao;
	
	@Override
	public Estudiante registrar(Estudiante t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Estudiante modificar(Estudiante t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
		
	}

	@Override
	public Optional<Estudiante> listarPorId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Estudiante> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
