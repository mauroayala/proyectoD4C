package ar.edu.unlam.tallerweb1.repositorios;

 import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
 
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioPlato")
public class RepositorioPlatoImpl implements RepositorioPlato{

	//  hibernateContext.xml
	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioPlatoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory; 
	}

	@Override
	public List<Plato> damePlatos() {
        final Session session = this.sessionFactory.getCurrentSession();
        return session.createCriteria(Plato.class)
                 .list();
	}

	@Override
	public List<Plato> damePlatosPorIngredientes(List<Integer> ingredientes) {
		String where ="";
		Integer cantidadIngrediente= ingredientes.size();
		  for (int i=0;i<cantidadIngrediente;i++) {
				where +=" receta.id_ingrediente='" +  ingredientes.get(i)+"'";
				if(i+1<ingredientes.size()) {
				where +=" or ";
				}
		    }
		  
   
		SQLQuery query =	sessionFactory.getCurrentSession().createSQLQuery(""
				+ "SELECT platos.*,COUNT(platos.id_plato) "
				+ "from receta "
				+ "LEFT JOIN platos on (receta.id_plato=platos.id_plato)"
				+ "where"
				+ where + ""
			    + "GROUP by  (platos.id_plato)"
			    + "HAVING COUNT(platos.id_plato)="+cantidadIngrediente+"")
				;
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
return query.list();
		//  List<Plato>  platos = query.list(); 1.14
		
 
 	}

	@Override
	public List<Plato> damePlatosPorIngredientes() {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public Plato damePlatoPorId(Long id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Plato.class, id);
	}
	
}
