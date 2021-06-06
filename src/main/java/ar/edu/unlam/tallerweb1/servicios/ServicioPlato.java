package ar.edu.unlam.tallerweb1.servicios;

 import java.util.ArrayList; 
import java.util.HashMap;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Plato;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioPlato {

  
 
	Plato buscarPorId(Integer id_plato);
	
	List<Plato> buscarPlato(String nombre);

	List<Plato> damePlatos();

	List<Plato> buscarPlatoPorIngredientes(List<Integer> ingredientes);

 	
	
}
