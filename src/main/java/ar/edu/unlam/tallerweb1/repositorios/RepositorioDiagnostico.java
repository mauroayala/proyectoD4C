package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Diagnostico;
import ar.edu.unlam.tallerweb1.modelo.Evaluacion;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;

import java.util.List;

 public interface RepositorioDiagnostico{

	Diagnostico buscarDiagnostico(Integer valora, Integer valorb, Integer valorc);

  }
