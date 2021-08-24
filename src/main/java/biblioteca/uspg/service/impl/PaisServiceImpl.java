package biblioteca.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.uspg.dao.IPaisDAO;
import biblioteca.uspg.model.Pais;
import biblioteca.uspg.service.IPaisService;
@Service

public class PaisServiceImpl implements IPaisService {
	
	// inyeccion de dependencias 
	
	@Autowired
	private IPaisDAO dao;
	
	

	
	
	
	@Override
	public Pais registrar(Pais t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Pais modificar(Pais t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
		
	}

	@Override
	public Optional<Pais> listarPorId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Pais> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
