package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.DatosIMC;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	
	Usuario consultarUsuario (Usuario usuario);
	void guardar(Usuario usuario);
	void modificar(Usuario usuario);
	void guardarDatosIMC(Usuario usuario, DatosIMC datos);
	Usuario buscarDatosIMC(Usuario usuario);
	Usuario buscarPorId(Long id);
	Usuario buscarPorEmail(String email);
}
