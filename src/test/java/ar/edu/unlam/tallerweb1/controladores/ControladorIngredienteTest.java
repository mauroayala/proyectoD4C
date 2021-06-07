package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.SpringTest;    
//no hace falta extends SpringTest

import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.servicios.ServicioIngrediente;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@Controller
public class ControladorIngredienteTest {
	
    private ControladorIngrediente controladorIngrediente;  
    private ModelAndView mav; 
    private ServicioIngrediente servicioIngrediente;  
     
   @Before
   public void init() { 
	   servicioIngrediente = mock(ServicioIngrediente.class);
	   controladorIngrediente = new ControladorIngrediente(servicioIngrediente);
   }

  
    @Test
    @Transactional
    public void siTengoIngredientesPuedoBuscar(){
         Integer verduras = 1;  
 		List<Ingrediente> listaDeIngredientes = new LinkedList<>();
 		
 		listaDeIngredientes.add(new Ingrediente("Choclo",1));
    	when(servicioIngrediente.buscarPorCategoria(verduras)).thenReturn(listaDeIngredientes);
    	
    	whenSepuedeBuscarIngredientes();
    	thanObtengoListadoCategoria();
    	
    	
    }
    
	private void whenSepuedeBuscarIngredientes() {
		mav=controladorIngrediente.seleccionDeIngredientes(null);		
	}

	private void thanObtengoListadoCategoria() {
		// TODO Auto-generated method stub
		assertThat(mav.getViewName()).isEqualTo("seleccionarIngredientes"); 
	}


 

 
	
	
	
	
	
	
	
	
	
	
	 //aca solo hice un test , porque siempre tengo ingrdientes. La base parte de tener ingredientes


}
