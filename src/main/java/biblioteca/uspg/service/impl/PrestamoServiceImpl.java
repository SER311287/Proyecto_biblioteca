package biblioteca.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.uspg.dao.IPrestamoDAO;
import biblioteca.uspg.model.Prestamo;
import biblioteca.uspg.service.IPrestamoService;
@Service

public class PrestamoServiceImpl implements IPrestamoService{
	
	@Autowired
	private IPrestamoDAO dao;
	
	@Override
	public Prestamo registrar(Prestamo t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Prestamo modificar(Prestamo t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public Optional<Prestamo> listarPorId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Prestamo> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
