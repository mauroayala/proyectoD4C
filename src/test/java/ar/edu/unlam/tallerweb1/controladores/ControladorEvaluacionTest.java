package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.SpringTest;     
//no hace falta extends SpringTest
import ar.edu.unlam.tallerweb1.modelo.Diagnostico;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
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
	   controladorEvaluacion = new ControladorEvaluacion(servicioEvaluacion,servicioDiagnostico);
   }
   
   
   @Test
   @Transactional @Rollback
   public void siTengorRespuestasPuedoEvaluar(){
       ModelMap model = new ModelMap();


		ArrayList<String> respuesta = new ArrayList();
    	respuesta.add("A"); 
    	respuesta.add("A"); 
    	respuesta.add("A"); 
    	respuesta.add("A"); 
    	respuesta.add("A"); 
    	respuesta.add("A"); 
    	respuesta.add("A"); 
    	respuesta.add("A"); 
    	respuesta.add("A"); 
    	respuesta.add("A"); 
    	respuesta.add("A"); 
    	respuesta.add("A");  
    	
    	
//       givenTengoRespuestas();
        
   	 String pregunta1 = "a";
   	 String pregunta2= "a";
   	 String pregunta3= "a";
   	 String pregunta4= "a";
   	 String pregunta5= "a";
   	 String pregunta6= "a";
   	 String pregunta7= "a";
   	 String pregunta8= "a";
   	 String pregunta9= "a";
   	 String pregunta10= "a";
   	 String pregunta11= "a";
   	 String pregunta12= "a";
   	 
   	Diagnostico diagnostico = new Diagnostico(); 
   	//tengo que hacer el teste de entity diagnostico
 //  	when(servicioDiagnostico.buscarDiagnostico(pregunta1, pregunta2, pregunta3, pregunta4, pregunta5, pregunta6, pregunta7, pregunta8, pregunta9, pregunta10, pregunta11, pregunta12).thenReturn(diagnostico);
   	
  // 	whenSepuedeBuscarDiagnostico();
   	thanObtengoDiagnostico();
   	
   	
   }
   
   
	private void givenTengoRespuestas() {
	 String pregunta1 = "a";
	 String pregunta2= "a";
	 String pregunta3= "a";
	 String pregunta4= "a";
	 String pregunta5= "a";
	 String pregunta6= "a";
	 String pregunta7= "a";
	 String pregunta8= "a";
	 String pregunta9= "a";
	 String pregunta10= "a";
	 String pregunta11= "a";
	 String pregunta12= "a";
	
}


	private void whenSepuedeBuscarDiagnostico(String pregunta1,String pregunta2,String pregunta3,String pregunta4, String pregunta5, String pregunta6, String pregunta7, String pregunta8, String pregunta9, String pregunta10, String pregunta11, String pregunta12) {
		mav=controladorEvaluacion.verificoDiagnostico(pregunta1, pregunta2, pregunta3, pregunta4, pregunta5, pregunta6, pregunta7, pregunta8, pregunta9, pregunta10, pregunta11, pregunta12);		
	}

	private void thanObtengoDiagnostico() {
		// TODO Auto-generated method stub
		assertThat(mav.getViewName()).isEqualTo("muestro-diagnostico"); 
	}



	

   
}
