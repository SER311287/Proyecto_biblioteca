package biblioteca.uspg.service;

import java.util.List;
import java.util.Optional;


public interface ICRUD <T>{
	// Agregamos los metodos
	
	T registrar(T t);
	T modificar (T t);
	void eliminar(int id);
	Optional<T> listarPorId(int id);
	List<T> listar();

}
