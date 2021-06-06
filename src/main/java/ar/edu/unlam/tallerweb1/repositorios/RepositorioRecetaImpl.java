package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.modelo.Receta;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioReceta")
public class RepositorioRecetaImpl implements RepositorioReceta{

	//  hibernateContext.xml
	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioRecetaImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory; 
	}

	@Override
	public List<Receta> dameRecetas(Integer idIngrediente) {
        final Session session = this.sessionFactory.getCurrentSession();
        return session.createCriteria(Receta.class)
                .add( Restrictions.eq("id_categoriaIngrediente", new Integer(idIngrediente) ) )
                .list();
	}

 


	@Override
	public List<Receta> dameRecetasPorPlato(Plato plato) {
        final Session session = this.sessionFactory.getCurrentSession();
        return session.createCriteria(Receta.class)
                .add( Restrictions.eq("plato", plato ) )
                .list();
	}

 


}
