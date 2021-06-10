package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;   
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioEvaluacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import ar.edu.unlam.tallerweb1.modelo.Evaluacion;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
 
@Service("servicioEvaluacion")
@Transactional
public class ServicioEvaluacionImpl implements ServicioEvaluacion {

	
	 
    private RepositorioEvaluacion repositorioEvaluacion;
    
    
    @Autowired
	public ServicioEvaluacionImpl(RepositorioEvaluacion repositorioEvaluacion) {
	    this.repositorioEvaluacion = repositorioEvaluacion;	
	}

	
     
    
    
	@Override
	public List<Evaluacion> buscarPreguntas() {
		List<Evaluacion> preguntas=repositorioEvaluacion.damePreguntas();
		
 		if(preguntas.size()==0) {
			throw new PreguntasVacias();
		} 
 		else {
  		return preguntas;
 		}
  		
	}

  
} 
 