package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;  
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioIngrediente;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
 
@Service("servicioIngrediente")
@Transactional
public class ServicioIngredienteImpl implements ServicioIngrediente {

 
    private RepositorioIngrediente repositorioIngrediente;
    
    
    @Autowired
	public ServicioIngredienteImpl(RepositorioIngrediente repositorioIngrediente) {
	    this.repositorioIngrediente = repositorioIngrediente;	
	}

	
     
   
    

	@Override
	public List<Ingrediente> buscarPorCategoria(Integer id) {
 
	    return repositorioIngrediente.buscarPorCategoria(id);

	}






	@Override
	public Ingrediente buscarPorId(Long id) {
	    return repositorioIngrediente.buscarPorId(id);

	}

 
} 
 