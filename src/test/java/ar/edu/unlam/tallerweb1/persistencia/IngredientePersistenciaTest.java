package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;
 
 
public class IngredientePersistenciaTest extends SpringTest{
	

	 
    @Test
    @Transactional @Rollback
    public void quieroPoderGuardarUnIngrediente(){
    	
    	Ingrediente ing = givenExisteUnIngrediente();
    	Long id = whenGuardoUnIngrediente(ing);
    	thenLaPuedoBuscarPorSuId(id);
    	
       }

	private Ingrediente givenExisteUnIngrediente() {
		// TODO Auto-generated method stub
		Ingrediente ing = new Ingrediente();
		ing.setId_categoriaIngrediente(1);
		ing.setNombre("TOMATE");
		return ing;
	}

	private Long whenGuardoUnIngrediente(Ingrediente ing) {
		// TODO Auto-generated method stub
		session().save(ing);
		return ing.getId();
		
	}

	private void thenLaPuedoBuscarPorSuId(Long id) {
		// TODO Auto-generated method stub
	Ingrediente ingredienteBuscado = session().get(Ingrediente.class, id);	
	assertThat(ingredienteBuscado).isNotNull();
	}


	
	
    @Test
    @Transactional @Rollback
    public void quieroPoderModificarUnIngrediente(){
    	
    	Ingrediente ing = givenExisteUnIngrediente();
    	Long id =  givenPersistoUnIngrediente(ing);
    	String nuevoNombre = "Lechuga";
    	ing.setNombre(nuevoNombre);
    	  whenModificoIngrediente(ing);
    	thenElIngredienteTieneElNuevoNombre(nuevoNombre,id);
    	
       }

	private void thenElIngredienteTieneElNuevoNombre(String nuevoNombre, Long id) {
		Ingrediente ingredienteBuscado = session().get(Ingrediente.class, id);	
		assertThat(ingredienteBuscado.getNombre()).isEqualTo(nuevoNombre);
		
	}

	private void whenModificoIngrediente(Ingrediente ing) {
		session().update(ing);
		//return ing.getId();
	}

	private Long givenPersistoUnIngrediente(Ingrediente ing) { 
		session().save(ing);
		return ing.getId();
	}
    
    
}
