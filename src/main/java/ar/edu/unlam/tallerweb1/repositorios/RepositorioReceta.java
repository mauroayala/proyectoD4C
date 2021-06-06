package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Receta;
import ar.edu.unlam.tallerweb1.modelo.Plato; 

import java.util.List;

 public interface RepositorioReceta { 
 
	 
List<Receta> dameRecetas(Integer idIngrediente);

List<Receta> dameRecetasPorPlato(Plato idPlato);

 }
