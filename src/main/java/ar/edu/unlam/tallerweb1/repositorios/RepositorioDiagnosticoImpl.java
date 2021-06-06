package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Diagnostico;
import ar.edu.unlam.tallerweb1.modelo.Evaluacion;
import ar.edu.unlam.tallerweb1.modelo.Ingrediente;
import ar.edu.unlam.tallerweb1.modelo.Receta;
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
 
@Repository("repositorioDiagnostico")
public class RepositorioDiagnosticoImpl implements  RepositorioDiagnostico {

 
	private SessionFactory sessionFactory;

	 
    @Autowired
	public RepositorioDiagnosticoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory; 
	}


	@Override
	public Diagnostico buscarDiagnostico(Integer valora, Integer valorb, Integer valorc) {
		 
	      final Session session = this.sessionFactory.getCurrentSession();
	        return (Diagnostico) session.createCriteria(Diagnostico.class)
	                .add( Restrictions.eq("respuesta_a",valora  ) )
	                .add( Restrictions.eq("respuesta_b",valorb  ) )
	                .add( Restrictions.eq("respuesta_c",valorc  ) )
	                .uniqueResult();
	        
	        
	        
	}

 
	

}
