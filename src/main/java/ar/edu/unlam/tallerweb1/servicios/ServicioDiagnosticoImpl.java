package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;    
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioDiagnostico;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import ar.edu.unlam.tallerweb1.modelo.Diagnostico;
import ar.edu.unlam.tallerweb1.modelo.Evaluacion;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
 
@Service("servicioDiagnostico")
@Transactional
public class ServicioDiagnosticoImpl implements ServicioDiagnostico {

	
	private Integer valora=1;    		
	private Integer valorb=1;
	private Integer valorc=1; 

	
    private RepositorioDiagnostico repositorioDiagnostico;
    
    
    @Autowired
	public ServicioDiagnosticoImpl(RepositorioDiagnostico repositorioDiagnostico) {
	    this.repositorioDiagnostico = repositorioDiagnostico;	
	}


	@Override
	public Diagnostico buscarDiagnostico(String pregunta1, String pregunta2, String pregunta3, String pregunta4,
			String pregunta5, String pregunta6, String pregunta7, String pregunta8, String pregunta9, String pregunta10,
			String pregunta11, String pregunta12) {
	  	
		 Integer respuestas_a= 0;
		 Integer respuestas_b= 0;
		 Integer respuestas_c= 0;
		
		ArrayList<String> respuesta = new ArrayList();
    	respuesta.add(pregunta1); 
    	respuesta.add(pregunta2); 
    	respuesta.add(pregunta3); 
    	respuesta.add(pregunta4); 
    	respuesta.add(pregunta5); 
    	respuesta.add(pregunta6); 
    	respuesta.add(pregunta7); 
    	respuesta.add(pregunta8); 
    	respuesta.add(pregunta9); 
    	respuesta.add(pregunta10); 
    	respuesta.add(pregunta11); 
    	respuesta.add(pregunta12);  
    	
     	
   
    	
    	for(int i = 0; i < respuesta.size(); i++) {
           // e es null  
          	if(respuesta.get(i)==null){
    			throw new FaltanRespuestas(); 
        	}
    String e = respuesta.get(i);
     	if (e.equals("a")) {
    			respuestas_a++;
    		} 
      	if (e.equals("b")) {
			respuestas_b++;
    		} 
      	if (e.equals("c")) {
		respuestas_c++;
      		}
    	  }
    	Integer totalRespuestas=respuestas_c+respuestas_b+respuestas_a;
 
    	
    	if (respuestas_a.equals(respuestas_b)) {
       	     valora =1;    		
      		 valorb =1;
      		 valorc =0; 
       	}
       	
       	if (respuestas_a.equals(respuestas_c)) {
       		 valora =1;    		
         		 valorb =0;
         		 valorc =1; 
          	}
       	
       	if (respuestas_b.equals(respuestas_c)) {
       			valora =0;    		
         		 valorb =1;
         		 valorc =1; 
          	}
          	
    	if(respuestas_a>respuestas_b  && respuestas_a>respuestas_c  ) {
    		 valora =1;    		
    		 valorb =0;
    		 valorc =0;

    	}
    	
    	if(respuestas_b>respuestas_a && respuestas_b>respuestas_c  ) {
    		 valora =0;    		
    		 valorb =1;
    		 valorc =0;

    	}
    	
    	if(respuestas_c>respuestas_a && respuestas_c>respuestas_b ) {
    		 valora =0;    		
    		 valorb =0;
    		 valorc =1;

    	}

     
    	


    	
    	return repositorioDiagnostico.buscarDiagnostico(valora,valorb,valorc);
	}

	
     
    
 
  
} 
 