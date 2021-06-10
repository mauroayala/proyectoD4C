package ar.edu.unlam.tallerweb1.controladores;

 
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;  
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Receta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioIngrediente;
import ar.edu.unlam.tallerweb1.servicios.ServicioReceta;
import ar.edu.unlam.tallerweb1.servicios.IngredientesVacios;
import ar.edu.unlam.tallerweb1.servicios.PlatoVacio;
import ar.edu.unlam.tallerweb1.servicios.ServicioIngrediente;
import ar.edu.unlam.tallerweb1.servicios.ServicioPlato;

import org.hibernate.SessionFactory;
//import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Rollback;
//import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//import javax.transaction.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

 
@Controller
public class ControladorRecetaTest  {
	
	 
    private ControladorReceta controladorReceta;  
    private ModelAndView mav; 
    private ServicioReceta servicioReceta;  
    private ServicioIngrediente servicioIngrediente;  
    private ServicioPlato servicioPlato;  
     
   @Before
   public void init() {
	   servicioIngrediente = mock(ServicioIngrediente.class);
	   servicioReceta = mock(ServicioReceta.class);
	   servicioPlato= mock(ServicioPlato.class);
	   controladorReceta = new ControladorReceta(servicioReceta,servicioIngrediente,servicioPlato);
   }

     
 
    @Test
    @Transactional
    public void siTengoPlatoEncuentroReceta(){
    	      	
 		List<Receta> listaReceta= new LinkedList<>();
 		Ingrediente ingrediente= new Ingrediente("Pollo",2);
 		Ingrediente ingrediente2= new Ingrediente("Lechuga",2);

 		
 		Integer idPlato = 1;
 		Plato platoNew=new Plato("Pollo y Lechuga");
 		String cantidad = "1";
 		Long idIngrediente= (long) 1;
 		listaReceta.add(new Receta(platoNew,ingrediente,cantidad));
 		listaReceta.add(new Receta(platoNew,ingrediente2,cantidad));
 		
		when(servicioPlato.buscarPorId(idPlato)).thenReturn(platoNew);
		when(servicioReceta.buscarIngredientesDeLaReceta(platoNew)).thenReturn(listaReceta);

    	whenSepuedeMostrarLaReceta(idPlato);
    	thanObtengoReceta();
    }


	private void whenSepuedeMostrarLaReceta(Integer idPlato) {
		mav=controladorReceta.muestroReceta(idPlato);		
	}

	private void thanObtengoReceta() {
		// TODO Auto-generated method stub
		assertThat(mav.getModel().get("receta")).isNotNull();
		assertThat(mav.getViewName()).isEqualTo("ver-receta"); 
	}

  

	
	
    @Test
    @Transactional
    public void tengoPlatoSinReceta(){
    	      	
 		List<Receta> listaReceta= null;
 		Integer idPlato = 1; 
 		Plato platoNew=new Plato("Pollo y Lechuga");

		when(servicioReceta.buscarIngredientesDeLaReceta(platoNew)).thenReturn(listaReceta);

    	whenNoEncuentroLaRecetaDelPlato(idPlato);
    	thanObtengoRecetaVacia();
    }


	private void whenNoEncuentroLaRecetaDelPlato(Integer idPlato) {
		mav=controladorReceta.muestroReceta(idPlato);		
	}

	private void thanObtengoRecetaVacia() {
 		assertThat(mav.getModel().get("receta")).isNull();
		assertThat(mav.getViewName()).isEqualTo("ver-receta"); 
	}
	
	
    @Test
    @Transactional
    public void siNoTengoIdNoTengoReceta(){
    	      	
  		Integer idPlato = null; 
 		Plato platoNew=new Plato("Pollo y Lechuga");

     	doThrow(PlatoVacio.class)
     	.when(servicioPlato)
     	.buscarPorId(idPlato);
 
     	
    	whenNoEncuentroLaRecetaDelPlato(idPlato);
    	thanNoTengoReceta();
    }


    private void thanNoTengoReceta() {
		assertThat(mav.getModel().get("msj")).isEqualTo("El codigo del plato no es correcto."); 		
	}

}
