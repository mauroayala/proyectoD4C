package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Receta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioRecetaImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioReceta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


@Controller
public class ServicioRecetaTest {
	
    private ServicioReceta servicioReceta;  
    private RepositorioReceta repositorioReceta;
    
    @Before
    public void init() {
    	repositorioReceta = mock (RepositorioReceta.class);
    	servicioReceta= new ServicioRecetaImpl(repositorioReceta);
    }

    
  @Test(expected = PlatoVacio.class)
  public void noTengoIdPlatoEntoncesNoTengoReceta() {
	  Plato plato= null;
	  givenBuscoReceta(plato);
	  
  }

	private void givenBuscoReceta(Plato plato) {
		servicioReceta.buscarIngredientesDeLaReceta(plato);
	}
	  

	
	 
	  @Test
	  public void tengoPlatoDevuelvoReceta() { 
			Plato plato=new Plato("Pollo y Lechuga");
		  	givenBuscoReceta(plato);
		  	thenUtiliceElRepositoio(plato);
		  
	  }

	private void thenUtiliceElRepositoio(Plato plato) { 
		verify(repositorioReceta,times(1)).dameRecetasPorPlato(plato);
	}
	  


}
