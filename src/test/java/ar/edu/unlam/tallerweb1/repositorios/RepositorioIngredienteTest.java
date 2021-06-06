package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Ingrediente;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorRegistrarse;

import org.hibernate.SessionFactory;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;


public class RepositorioIngredienteTest extends SpringTest{
	
 	@Autowired
	private RepositorioIngrediente repositorio;
  
	@Test
	@Transactional
	@Rollback
	public void guardarUnIngredienteDeberiaPersistir() {



		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setId_categoriaIngrediente(1);
		ingrediente.setNombre("TOMATE");
		repositorio.guardar(ingrediente);
		
		Ingrediente ingredienteBuscado = repositorio.buscarPor(ingrediente.getId());

		assertThat(ingredienteBuscado).isNotNull();

	
	}
	 



 

private Ingrediente givenExisteIngrediente(String nombre , Integer idIngrediente) {
	Ingrediente ingrediente  = new Ingrediente();
	ingrediente.setId_categoriaIngrediente(idIngrediente);
	ingrediente.setNombre(nombre);
	return ingrediente;
} 

private Long whenGuardoIngrediente(Ingrediente ingrediente) {
	repositorio.guardar(ingrediente);
	return ingrediente.getId();
}

 
 

 

@Test
@Transactional 
@Rollback
public void poderBuscarPorCategoria() {

	Ingrediente ingrediente = givenExisteIngrediente("Melon", 1);
	
	Long id = whenGuardoIngrediente(ingrediente);

	Integer categoria = 1;
	List<Ingrediente> listado = whenLoPuedoBuscarCategoria(categoria);
	 
	 thenTengoListaCargada(listado);

}



private void thenTengoListaCargada(List<Ingrediente> listado) {
	// TODO Auto-generated method stub
	assertThat(listado.size()).isEqualTo(1);
}



private List<Ingrediente> whenLoPuedoBuscarCategoria(Integer categoria) {
	return repositorio.buscarPorCategoria(categoria);

}


 
 
 
 

}
