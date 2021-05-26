package ar.edu.unlam.tallerweb1.servicios;

 import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Ingrediente;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioIngrediente {

  
 
	List<Ingrediente> buscarPorCategoria(Integer id);
	Ingrediente buscarPorId(Long id);
	
	
}
