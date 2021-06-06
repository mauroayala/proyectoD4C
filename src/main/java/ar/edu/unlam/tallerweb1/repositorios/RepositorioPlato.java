package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Plato; 

import java.util.List;

 public interface RepositorioPlato {
	 
	 Plato damePlatoPorId(Long id);

	List<Plato> damePlatos();

	List<Plato> damePlatosPorIngredientes();

	List<Plato> damePlatosPorIngredientes(List<Integer> ingredientes); 
 
 	
 }
