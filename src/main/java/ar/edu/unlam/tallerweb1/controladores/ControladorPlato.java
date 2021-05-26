package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioPlato;  
import ar.edu.unlam.tallerweb1.servicios.IngredientesVacios;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Plato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ControladorPlato {

	private ServicioPlato servicioPlato;
    private ModelAndView mav; 
    
	@Autowired
	public ControladorPlato(ServicioPlato servicioPlato) {
		this.servicioPlato = servicioPlato;
	}
 
	
	
    @RequestMapping(path = "busco-plato" , method = RequestMethod.GET)
	public ModelAndView buscoPlato(@RequestParam("ingredientes[]") List<Integer> ingredientes) {
	//public void foo(@RequestParam("number[]") List<String> to)	
	 try {
		List<Plato>	resultadoBusqueda = servicioPlato.buscarPlatoPorIngredientes(ingredientes);
		 ModelMap model = new ModelMap();

		if(resultadoBusqueda.size()>0) {
			 model.put("platos", resultadoBusqueda);
			 model.put("ingredientes", ingredientes.size());
			 return new ModelAndView("selecciona-plato",model);
		}else {
			 model.put("msj","No contamos platos con esos ingredientes");
		    //return new ModelAndView("seleccionarIngredientes",model);	
			 return new ModelAndView("redirect:/seleccionar-ingrediente",model);
			 }
	 }
	 catch(IngredientesVacios e){
		 ModelMap model = new ModelMap();
		 model.put("msj","Debe seleccionar al menos un ingrediente");
		 return new ModelAndView("redirect:/seleccionar-ingrediente",model);
		 
	 }
	 
	 
	 
 }
  
      
 
      
      
      

 
}
