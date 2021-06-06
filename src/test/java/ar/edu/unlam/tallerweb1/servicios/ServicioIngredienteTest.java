package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Plato; 
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioIngrediente;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioIngrediente;
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
public class ServicioIngredienteTest {
	
    private ServicioIngrediente servicioIngrediente;  
    private RepositorioIngrediente repositorioIngrediente;
    
    @Before
    public void init() {
    	repositorioIngrediente = mock (RepositorioIngrediente.class);
    	servicioIngrediente= new ServicioIngredienteImpl(repositorioIngrediente);
    }
   
  


}
