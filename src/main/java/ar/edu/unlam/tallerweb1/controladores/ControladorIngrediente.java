package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.servicios.ServicioIngrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ControladorIngrediente {

	private ServicioIngrediente servicioIngrediente;
 

    @Autowired
    public ControladorIngrediente(ServicioIngrediente servicioIngrediente){
        this.servicioIngrediente = servicioIngrediente;
    }
    
    

      @RequestMapping(path = "seleccionar-ingrediente")
//	public ModelAndView seleccionDeIngredientes(@RequestParam("msj") Optional String msj) {
    public ModelAndView seleccionDeIngredientes(@RequestParam(value = "msj", required = false) String msj) {


        ModelMap model = new ModelMap();
        Integer verduras = 1;
        Integer carnes = 2;
        Integer lacteos = 3;
        Integer harinas = 4;
        Integer conservas = 5;
        
        model.put("verduras",servicioIngrediente.buscarPorCategoria(verduras));
        model.put("carnes",servicioIngrediente.buscarPorCategoria(carnes));
        model.put("lacteos",servicioIngrediente.buscarPorCategoria(lacteos));
        model.put("harinas",servicioIngrediente.buscarPorCategoria(harinas));
        model.put("conservas",servicioIngrediente.buscarPorCategoria(conservas));
        model.put("msj",msj);
        return new  ModelAndView("seleccionarIngredientes",model);
        
 	}


 
      
      
      
      
 
      
      
      

 
}
