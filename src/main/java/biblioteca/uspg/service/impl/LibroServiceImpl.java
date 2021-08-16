package biblioteca.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.uspg.dao.ILibroDAO;
import biblioteca.uspg.model.Libro;
import biblioteca.uspg.service.ILibroService;

@Service 
public class LibroServiceImpl implements ILibroService{
	// metodos exportados 

	@Autowired	
	private ILibroDAO dao;
	
	@Override
	public Libro registrar(Libro t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Libro modificar(Libro t) {
		// TODO Auto-generated method stub
		return dao.save(t);
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
		
	}

	@Override
	public Optional<Libro> listarPorId(int id) {
		// TODO Auto-generated method stub
		
		return dao.findById(id);
	}

	@Override
	public List<Libro> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
