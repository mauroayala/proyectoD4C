package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Evaluacion;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Plato;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioIngrediente;

import java.util.List;
import org.hibernate.Query;

 import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;
 
@Repository("repositorioEvaluacion")
public class RepositorioEvaluacionImpl implements  RepositorioEvaluacion {

 
	private SessionFactory sessionFactory;

	 
    @Autowired
	public RepositorioEvaluacionImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory; 
	}


	@Override
	public List<Evaluacion> damePreguntas() {
		

        final Session session = this.sessionFactory.getCurrentSession();
        return session.createCriteria(Evaluacion.class)
             //   .add( Restrictions.eq("id_evaluacion", (long) 11111 ) )
                .list();
	}
	
 
 
	
	

}
