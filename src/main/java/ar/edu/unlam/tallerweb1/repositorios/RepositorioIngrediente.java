package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Ingrediente;

import java.util.List;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioIngrediente { 
 
	List<Ingrediente> buscarPorCategoria(Integer id_categoriaIngrediente);

	void guardar(Ingrediente ingrediente);

	Ingrediente buscarPor(Long id);

	Ingrediente buscarIngredientePorNombre(String nombre);

	Ingrediente buscarPorId(Long  id);

 
  //  private static RepositorioIngrediente instance = new RepositorioIngrediente();
  //  public static RepositorioIngrediente getInstance() { return instance; }

 }
