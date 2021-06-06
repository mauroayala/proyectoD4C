package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPlato;
import ar.edu.unlam.tallerweb1.modelo.Plato;

@Service("servicioPlato")
@Transactional
public class ServicioPlatoImpl implements ServicioPlato {

 
    private RepositorioPlato repositorioPlato;
    
    @Autowired
    public ServicioPlatoImpl(RepositorioPlato repositorioPlato) {
    this.repositorioPlato = repositorioPlato;	
    }

	@Override
	public List<Plato> buscarPlato(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plato> damePlatos() {
		// TODO Auto-generated method stub
 		return repositorioPlato.damePlatos();
	}

	@Override
	public List<Plato> buscarPlatoPorIngredientes(List<Integer> ingredientes) {
		
		if(ingredientes.size()==0) {
			throw new IngredientesVacios();
		}
 		return repositorioPlato.damePlatosPorIngredientes(ingredientes);
 		
	}

	@Override
	public Plato buscarPorId(Integer id_plato) { 
		if(id_plato==null) {
			throw new PlatoVacio();
		} 
		
 		return repositorioPlato.damePlatoPorId((long) id_plato);

	}
    
    
 

 
} 
 