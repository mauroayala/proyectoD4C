package ar.edu.unlam.tallerweb1.controladores;
 
import ar.edu.unlam.tallerweb1.SpringTest;      
//no hace falta extends SpringTest
import ar.edu.unlam.tallerweb1.modelo.Diagnostico;
import ar.edu.unlam.tallerweb1.modelo.Evaluacion;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.servicios.FaltanRespuestas;
import ar.edu.unlam.tallerweb1.servicios.PreguntasVacias;
import ar.edu.unlam.tallerweb1.servicios.ServicioDiagnostico;
import ar.edu.unlam.tallerweb1.servicios.ServicioEvaluacion;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@Controller
public class ControladorEvaluacionTest {
	
    private ControladorEvaluacion controladorEvaluacion;  
    private ModelAndView mav; 
    private ServicioEvaluacion servicioEvaluacion;  
	private ServicioDiagnostico servicioDiagnostico;

   @Before
   public void init() {
	   servicioEvaluacion = mock(ServicioEvaluacion.class);
	   servicioDiagnostico = mock(ServicioDiagnostico.class);
	   
	   controladorEvaluacion = new ControladorEvaluacion(servicioEvaluacion,servicioDiagnostico);
   }
   
 
	
    @Test
    @Transactional
    @Rollback
    public void siTengoPreguntasPuedoHacerUnTest(){
        ModelMap model = new ModelMap();
        String pregunta= "Pregunta"; 
        String respuesta_a= "respuesta_a"; 
        String respuesta_b= "respuesta_b"; 
        String respuesta_c= "respuesta_c"; 
        
        
  		List<Evaluacion> listaDePreguntas= new LinkedList<>();
 		
  		listaDePreguntas.add(new Evaluacion(pregunta,respuesta_a,respuesta_b,respuesta_c));
  		
    	when(servicioEvaluacion.buscarPreguntas()).thenReturn(listaDePreguntas);
    	
    	whenSepuedeBuscarPreguntas();
    	thanObtengoLaEvaluacion();
    	
    	
    }
    
	private void whenSepuedeBuscarPreguntas() {
		mav=controladorEvaluacion.hacerEvaluacion(null);		
	}
 
    
	private void thanObtengoLaEvaluacion() {
		// TODO Auto-generated method stub
		assertThat(mav.getViewName()).isEqualTo("hacer-evaluacion"); 
	}


	

    @Test
    @Transactional
    @Rollback
    public void siNoTengoPreguntasNoPuedoHacerUnTest(){
 
     	doThrow(PreguntasVacias.class)
     	.when(servicioEvaluacion)
     	.buscarPreguntas();
  
    	whenSepuedeBuscarPreguntas();
    	thanVuelvoAlaHome();
    	
    	
    }
    
 
	private void thanVuelvoAlaHome() {
 		assertThat(mav.getViewName()).isEqualTo("redirect:/index"); 
		assertThat(mav.getModel().get("msj")).isEqualTo("Momentaneamente no contamos con preguntas para realizar el test."); 		

	}
	
	
 
	
	
	

    @Test
    @Transactional
    @Rollback

    public void siNoTengoRespuestasNoPuedoDarUnDiagnostico(){

    	doThrow(FaltanRespuestas.class)
     	.when(servicioDiagnostico)
     	.buscarDiagnostico(null,null,null,null,null,null,null,null,null,null,null,null);
     	
 
     	whenBuscoDiagnostico();
    	thanVuelvoAlasPreguntas();
    	
    	
    }
    
	private void whenBuscoDiagnostico() {
		mav=controladorEvaluacion.verificoDiagnostico(null,null,null,null,null,null,null,null,null,null,null,null);		
	}

	private void thanVuelvoAlasPreguntas() {
 		assertThat(mav.getViewName()).isEqualTo("redirect:/hacer-evaluacion"); 
		assertThat(mav.getModel().get("msj")).isEqualTo("Debe completar todas las respuestar para poder hacer el test."); 		

	}
	
   
}
