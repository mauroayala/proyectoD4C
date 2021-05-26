package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.SpringTest;      

import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioIngrediente;
import ar.edu.unlam.tallerweb1.servicios.ServicioPlato;
import ar.edu.unlam.tallerweb1.servicios.IngredientesVacios;

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

// no hace falta extends SpringTest

@Controller
public class ControladorPlatoTest  {
	
	 
    private ControladorPlato controladorPlato ;  
    private ModelAndView mav; 
    private ServicioPlato servicioPlato ;  
     
   @Before
   public void init() {
	   servicioPlato = mock(ServicioPlato.class);
	   controladorPlato = new ControladorPlato(servicioPlato);
   }

     
 
    @Test
    @Transactional
    public void siTengoIngredientesSePuedeBuscarElPlato(){
    	
    	ArrayList ingredientes = new ArrayList();
    	ingredientes.add(1);
    	ingredientes.add(2);
    	ingredientes.add(3);
    	ingredientes.add(4);
    	ingredientes.add(5);
    	
     	//teniendo un ingrediente-> como obtengo este ingrediente ? lo obtengo por que me lo da una vista
     	givenVariosIngredientes(ingredientes);
     	
 		List<Plato> listaDeplatos = new LinkedList<>();
 		listaDeplatos.add(new Plato("Chipa"));
 		
		when(servicioPlato.buscarPlatoPorIngredientes(ingredientes)).thenReturn(listaDeplatos);

    	whenSepuedeBuscarPlato(ingredientes);
    	thanObtengoPlato();
    }


	private void givenVariosIngredientes(List<Integer> ingredientes) {
		// TODO Auto-generated method stub
		
	}


	private void whenSepuedeBuscarPlato(List<Integer> ingredientes) {
		// TODO Auto-generated method stub cambiar controladorIngrediente a controladorPlato ante ultimo video 36.18 https://ingunlamedu.sharepoint.com/sites/TallerWeb12/Documentos%20compartidos/Forms/AllItems.aspx?id=%2Fsites%2FTallerWeb12%2FDocumentos%20compartidos%2FReuniones%20TN%2FRecordings%2FClase%2013May21%20%2D%20Kata%20punta%20a%20punta%2D20210513%5F191310%2DGrabaci%C3%B3n%20de%20la%20reuni%C3%B3n%2Emp4&parent=%2Fsites%2FTallerWeb12%2FDocumentos%20compartidos%2FReuniones%20TN%2FRecordings
	mav=controladorPlato.buscoPlato(ingredientes);
	}


	private void thanObtengoPlato() {
		// TODO Auto-generated method stub
		assertThat(mav.getViewName()).isEqualTo("selecciona-plato"); 
	}

 
	 
	
    @Test
    @Transactional
    public void siNoTengoIngredientesSeleccionadosNoPuedoBuscarPlato(){
    	
    	ArrayList ingredientes = new ArrayList(); 
    	
     	givenVariosIngredientes(ingredientes);

		//when(servicioPlato.buscarPlatoPorIngredientes(ingredientes)).thenThrow(IngredientesVacios.class);
	
     	doThrow(IngredientesVacios.class)
     	.when(servicioPlato)
     	.buscarPlatoPorIngredientes(ingredientes);
     	
    	//teniendo un ingrediente-> como obtengo este ingrediente ? lo obtengo por que me lo da una vista
    	whenSepuedeBuscarPlato(ingredientes);
    	
    	thanVuelveAseleccionarIngredientes();
    }


	private void thanVuelveAseleccionarIngredientes() {
		assertThat(mav.getModel().get("msj")).isEqualTo("Debe seleccionar al menos un ingrediente"); 		
		assertThat(mav.getViewName()).isEqualTo("redirect:/seleccionar-ingrediente"); 		
	}

    
	
	
    @Test
    @Transactional
    public void NoTengoPlatosParaLosIngredientesUtilizados(){
    	
    	List<Integer> ingredientes =new ArrayList() ;
    	ingredientes.add(1);
    	ingredientes.add(2);
    	ingredientes.add(3);
    	ingredientes.add(4);
    	ingredientes.add(5);
    	
     	//teniendo un ingrediente-> como obtengo este ingrediente ? lo obtengo por que me lo da una vista
     	givenVariosIngredientes(ingredientes);
     	
 		List<Plato> listaDeplatos = new LinkedList<>();
  		
		when(servicioPlato.buscarPlatoPorIngredientes(ingredientes)).thenReturn(listaDeplatos);

    	whenSepuedeBuscarPlato(ingredientes);
    	
    	thanNoEncontrePlatos();
    }



	private void thanNoEncontrePlatos() {
		assertThat(mav.getModel().get("msj")).isEqualTo("No contamos platos con esos ingredientes"); 		
		assertThat(mav.getViewName()).isEqualTo("redirect:/seleccionar-ingrediente"); 		
	}
    

}
