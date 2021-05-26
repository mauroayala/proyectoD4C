package ar.edu.unlam.tallerweb1.controladores;

 
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Receta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioIngrediente;
import ar.edu.unlam.tallerweb1.servicios.ServicioReceta;
import ar.edu.unlam.tallerweb1.servicios.IngredientesVacios;
import ar.edu.unlam.tallerweb1.servicios.PlatoVacio;

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
     
   @Before
   public void init() {
	   servicioReceta = mock(ServicioReceta.class);
	   controladorReceta = new ControladorReceta(servicioReceta);
   }

     
 
    @Test
    @Transactional
    public void siTengoPlatoEncuentroReceta(){
    	      	
 		List<Receta> listaReceta= new LinkedList<>();
 		Integer idPlato = 1;
 		Long idIngrediente = (long) 1;
 		String cantidad = "1";
 		listaReceta.add(new Receta(idPlato,idIngrediente,cantidad));
 		listaReceta.add(new Receta(idPlato,idIngrediente,cantidad));
 		
		when(servicioReceta.buscarIngredientesDeLaReceta(idPlato)).thenReturn(listaReceta);

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
    	      	
 		List<Receta> listaReceta= new LinkedList<>();
 		Integer idPlato = 1; 
 		
		when(servicioReceta.buscarIngredientesDeLaReceta(idPlato)).thenReturn(listaReceta);

    	whenNoEncuentroLaRecetaDelPlato(idPlato);
    	thanObtengoRecetaVacia();
    }


	private void whenNoEncuentroLaRecetaDelPlato(Integer idPlato) {
		mav=controladorReceta.muestroReceta(idPlato);		
	}

	private void thanObtengoRecetaVacia() {
		// TODO Auto-generated method stub
		assertThat(mav.getModel().get("receta")).isNull();
		assertThat(mav.getViewName()).isEqualTo("ver-receta"); 
	}
	
	
    @Test
    @Transactional
    public void siNoTengoIdNoTengoReceta(){
    	      	
  		Integer idPlato = null; 
 		
     	doThrow(PlatoVacio.class)
     	.when(servicioReceta)
     	.buscarIngredientesDeLaReceta(idPlato);
     	
     	
    	whenNoEncuentroLaRecetaDelPlato(idPlato);
    	thanNoTengoReceta();
    }


    private void thanNoTengoReceta() {
		assertThat(mav.getModel().get("msj")).isEqualTo("No se encontro una receta para el plato."); 		
	}

}
