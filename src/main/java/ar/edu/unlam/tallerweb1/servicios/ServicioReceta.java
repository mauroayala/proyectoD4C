package ar.edu.unlam.tallerweb1.servicios;

 import java.util.ArrayList;  
import java.util.HashMap;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Receta;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioReceta {

  
  
	List<Receta> buscarReceta(Integer idingrediente);

	List<Receta> buscarIngredientesDeLaReceta(Plato idPlato);

 	
	
}
