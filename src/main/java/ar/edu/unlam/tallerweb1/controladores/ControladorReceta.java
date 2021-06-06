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
public class ControladorReceta {

    @Autowired
	private ServicioReceta servicioReceta;
    @Autowired
	private ServicioIngrediente servicioIngrediente;
    
    @Autowired
	private ServicioPlato servicioPlato;
    
    private ModelAndView mav; 
    
	@Autowired
	public ControladorReceta(ServicioReceta servicioReceta,ServicioIngrediente servicioIngrediente,ServicioPlato servicioPlato) {
		this.servicioReceta = servicioReceta;
		this.servicioPlato = servicioPlato;
		this.servicioIngrediente = servicioIngrediente;
 	}
 
	
	
    @RequestMapping(path = "muestroReceta" , method = RequestMethod.GET)
      public ModelAndView muestroReceta(@RequestParam("idPlato") Integer idPlato){
          ModelMap model = new ModelMap();
 
          try {
        	  Plato plato = servicioPlato.buscarPorId(idPlato);
        	List<Receta> resultadoBusqueda =  servicioReceta.buscarIngredientesDeLaReceta(plato); 
              if (resultadoBusqueda.isEmpty()){
                  model.put("receta",null);
                  model.put("msj","No se encontro la receta.");  
                  return new ModelAndView("ver-receta", model);

              } 
              
       		List<Ingrediente> listaIngredientesUtilizados= new LinkedList<>();

           /*   for (Receta receta: resultadoBusqueda) {
            	Long idIngrediente=receta.getId_ingrediente();
               	Ingrediente ingrediente =  servicioIngrediente.buscarPorId(idIngrediente); 
               	listaIngredientesUtilizados.add(ingrediente);
            	}
              
              model.put("listaIngredientesUtilizados",listaIngredientesUtilizados);*/
              model.put("receta",resultadoBusqueda);
              return new ModelAndView("ver-receta", model);

          } 
          catch (PlatoVacio p){
              model.put("msj","No se encontro una receta para el plato.");
              return new ModelAndView("ver-receta", model);

          }
          
       }
      
      
      

 
}
