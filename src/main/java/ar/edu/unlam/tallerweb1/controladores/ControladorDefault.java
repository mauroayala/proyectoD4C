package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioReceta; 
import ar.edu.unlam.tallerweb1.servicios.ServicioPlato; 
import ar.edu.unlam.tallerweb1.servicios.PlatoVacio;
import ar.edu.unlam.tallerweb1.servicios.ServicioIngrediente;
 

import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Receta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List; 

@Controller
public class ControladorDefault{
	
    @RequestMapping(path = "index")
  public ModelAndView seleccionDeIngredientes(@RequestParam(value = "msj", required = false) String msj) {
      ModelMap model = new ModelMap();
      model.put("msj",msj);
      return new  ModelAndView("index",model);
      
	}

      
      

 
}
