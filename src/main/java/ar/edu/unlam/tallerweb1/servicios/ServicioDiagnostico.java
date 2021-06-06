package ar.edu.unlam.tallerweb1.servicios;

 import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Diagnostico;
import ar.edu.unlam.tallerweb1.modelo.Evaluacion;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;

 public interface ServicioDiagnostico {

	Diagnostico buscarDiagnostico(String pregunta1, String pregunta2, String pregunta3, String pregunta4,
			String pregunta5, String pregunta6, String pregunta7, String pregunta8, String pregunta9, String pregunta10,
			String pregunta11, String pregunta12);

 	
	
}
