package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;    
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioReceta;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Receta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioReceta")
@Transactional
public class ServicioRecetaImpl implements ServicioReceta {

    private RepositorioReceta repositorioReceta;

    @Autowired
    public ServicioRecetaImpl(RepositorioReceta repositorioReceta) {
    this.repositorioReceta = repositorioReceta;	
    }

    
    
 	@Override
	public List<Receta> buscarReceta(Integer idingrediente) {
 		return repositorioReceta.dameRecetas(idingrediente);
	}

	@Override
	public List<Receta> buscarIngredientesDeLaReceta(Plato plato) {
	 
		if(plato==null) {
			throw new PlatoVacio();
		} 
  		return repositorioReceta.dameRecetasPorPlato(plato);

	}

 
 

 
} 
 