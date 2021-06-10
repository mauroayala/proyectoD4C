package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Diagnostico;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Receta;
import ar.edu.unlam.tallerweb1.servicios.FaltanRespuestas;
import ar.edu.unlam.tallerweb1.servicios.IngredientesVacios;
import ar.edu.unlam.tallerweb1.servicios.PlatoVacio;
import ar.edu.unlam.tallerweb1.servicios.PreguntasVacias;
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

      try {
      model.put("preguntas",servicioEvaluacion.buscarPreguntas());
      model.put("msj",msj);
      return new  ModelAndView("hacer-evaluacion",model);
      }catch(PreguntasVacias e){
 		 model.put("msj","Momentaneamente no contamos con preguntas para realizar el test.");
		 return new ModelAndView("redirect:/index",model);
		 
	 }
      
      
	}

    
    
    
      @RequestMapping(path = "verifico-Diagnostico")
    public ModelAndView verificoDiagnostico(@RequestParam(value="pregunta1", required = false) String pregunta1,@RequestParam(value="pregunta2", required = false) String pregunta2,@RequestParam(value="pregunta3", required = false) String pregunta3,@RequestParam(value="pregunta4", required = false) String pregunta4,@RequestParam(value="pregunta5", required = false) String pregunta5,@RequestParam(value="pregunta6", required = false) String pregunta6,@RequestParam(value="pregunta7", required = false) String pregunta7,@RequestParam(value="pregunta8", required = false) String pregunta8,@RequestParam(value="pregunta9", required = false) String pregunta9,@RequestParam(value="pregunta10", required = false) String pregunta10,@RequestParam(value="pregunta11", required = false) String pregunta11,@RequestParam(value="pregunta12", required = false) String pregunta12){

          ModelMap model = new ModelMap();
          //SERVICIO TIENE QUE DISPARAR UNA EXEPCION CUANDO NO COMPLETA TODOS LOS CAMPOS
          try {
        	  Diagnostico resultadoDiagnostico=  servicioDiagnostico.buscarDiagnostico(pregunta1,pregunta2,pregunta3,pregunta4,pregunta5,pregunta6,pregunta7,pregunta8,pregunta9,pregunta10,pregunta11,pregunta12); 
               model.put("resultado",resultadoDiagnostico);
              return new ModelAndView("ver-resultado", model);

          } 
          catch (FaltanRespuestas p){
              model.put("msj","Debe completar todas las respuestar para poder hacer el test.");
      		 return new ModelAndView("redirect:/hacer-evaluacion",model);

          }
 	}


 


 
      
      
      
      
 
      
      
      

 
}
