package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.SpringTest;    

import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioIngrediente;
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
import org.springframework.ui.ModelMap;
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

// no hace falta extends SpringTest

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
    	 
        ModelMap model = new ModelMap();
        Integer verduras = 1; 
        
        model.put("verduras",servicioIngrediente.buscarPorCategoria(verduras)); 
        
         
 		List<Ingrediente> listaDeIngredientes = new LinkedList<>();
 		
 		listaDeIngredientes.add(new Ingrediente("Choclo",1));
    	when(servicioIngrediente.buscarPorCategoria(verduras)).thenReturn(listaDeIngredientes);
    	
    	whenSepuedeBuscarIngredientes(verduras);
    	thanObtengoListadoCategoria();
    	
    	
    }
    
	private void whenSepuedeBuscarIngredientes(Integer verduras) {
		mav=controladorIngrediente.seleccionDeIngredientes(null);		
	}

	private void thanObtengoListadoCategoria() {
		// TODO Auto-generated method stub
		assertThat(mav.getViewName()).isEqualTo("seleccionarIngredientes"); 
	}


 

 

}
