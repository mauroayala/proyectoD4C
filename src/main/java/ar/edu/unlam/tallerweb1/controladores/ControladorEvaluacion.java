package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Diagnostico;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Receta;
import ar.edu.unlam.tallerweb1.servicios.PlatoVacio;
import ar.edu.unlam.tallerweb1.servicios.ServicioEvaluacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioDiagnostico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ControladorEvaluacion{

	private ServicioEvaluacion servicioEvaluacion;
	private ServicioDiagnostico servicioDiagnostico;
 

    @Autowired
    public ControladorEvaluacion(ServicioEvaluacion servicioEvaluacion,ServicioDiagnostico servicioDiagnostico){
        this.servicioEvaluacion = servicioEvaluacion;
        this.servicioDiagnostico = servicioDiagnostico;
    }
    
    

    @RequestMapping(path = "hacer-evaluacion")
  public ModelAndView hacerEvaluacion(@RequestParam(value = "msj", required = false) String msj) {


      ModelMap model = new ModelMap();

      
      model.put("preguntas",servicioEvaluacion.buscarPreguntas());
      model.put("msj",msj);
      return new  ModelAndView("hacer-evaluacion",model);
      
	}

    
    
    
      @RequestMapping(path = "verifico-Diagnostico")
    public ModelAndView verificoDiagnostico(@RequestParam("pregunta1") String pregunta1,@RequestParam("pregunta2") String pregunta2,@RequestParam("pregunta3") String pregunta3,@RequestParam("pregunta4") String pregunta4,@RequestParam("pregunta5") String pregunta5,@RequestParam("pregunta6") String pregunta6,@RequestParam("pregunta7") String pregunta7,@RequestParam("pregunta8") String pregunta8,@RequestParam("pregunta9") String pregunta9,@RequestParam("pregunta10") String pregunta10,@RequestParam("pregunta11") String pregunta11,@RequestParam("pregunta12") String pregunta12){

          ModelMap model = new ModelMap();
          //SERVICIO TIENE QUE DISPARAR UNA EXEPCION CUANDO NO COMPLETA TODOS LOS CAMPOS
          try {
        	  Diagnostico resultadoDiagnostico=  servicioDiagnostico.buscarDiagnostico(pregunta1,pregunta2,pregunta3,pregunta4,pregunta5,pregunta6,pregunta7,pregunta8,pregunta9,pregunta10,pregunta11,pregunta12); 
 
               model.put("resultado",resultadoDiagnostico);
              return new ModelAndView("ver-resultado", model);

          } 
          catch (PlatoVacio p){
              model.put("msj","No se encontro una receta para el plato.");
              return new ModelAndView("ver-receta", model);

          }
 	}


 


 
      
      
      
      
 
      
      
      

 
}
