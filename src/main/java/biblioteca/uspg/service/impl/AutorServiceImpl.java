package biblioteca.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.uspg.dao.IAutorDAO;
import biblioteca.uspg.model.Autor;
import biblioteca.uspg.service.IAutorService;
@Service
public class AutorServiceImpl implements IAutorService {

	@Autowired
	private IAutorDAO dao;
	
	@Override
	public Autor registrar(Autor autor) {
		autor.getPais().forEach(det -> det.setAutor(autor));
		return dao.save(autor);
	}

	@Override
	public Autor modificar(Autor t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
		
	}

	@Override
	public Optional<Autor> listarPorId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Autor> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
