package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Receta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioRecetaImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioDiagnostico;
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
public class ServicioDiagnosticoTest {
	
    private ServicioDiagnostico servicioDiagnostico;  
    private RepositorioDiagnostico repositorioDiagnostico;
    
    @Before
    public void init() {
    	repositorioDiagnostico = mock (RepositorioDiagnostico.class);
    	servicioDiagnostico= new ServicioDiagnosticoImpl(repositorioDiagnostico);
    }

    
  @Test(expected = FaltanRespuestas.class)
  public void noTengoTodasLasRespuestasNoTengoDiagnostico() {
	  Plato plato= null;
	  givenBuscoDiagnostico(null,null,null,null,null,null,null,null,null,null,null,null);
	  
  }

	private void givenBuscoDiagnostico(String pregunta1, String pregunta2, String pregunta3, String pregunta4,
			String pregunta5, String pregunta6, String pregunta7, String pregunta8, String pregunta9, String pregunta10,
			String pregunta11, String pregunta12) {
		
		servicioDiagnostico.buscarDiagnostico(pregunta1,pregunta2,pregunta3,pregunta4,pregunta5,pregunta6,pregunta7,pregunta8,pregunta9,pregunta10,pregunta11,pregunta12);
		
	}
	  

	
	 
	 // @Test
	  public void tengoPlatoDevuelvoReceta() { 
			Plato plato=new Plato("Pollo y Lechuga");
			  givenBuscoDiagnostico(null,null,null,null,null,null,null,null,null,null,null,null);
		  	thenUtiliceElRepositoio(plato);
		  
	  }

	private void thenUtiliceElRepositoio(Plato plato) { 
//		verify(repositorioReceta,times(1)).dameRecetasPorPlato(plato);
	}
	  


}
