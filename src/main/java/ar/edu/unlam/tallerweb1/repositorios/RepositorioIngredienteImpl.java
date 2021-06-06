package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Ingrediente;  
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
 
@Repository("repositorioIngrediente")
public class RepositorioIngredienteImpl implements RepositorioIngrediente {

  
	
  //  private static RepositorioIngrediente instance = new RepositorioIngrediente();
  //  public static RepositorioIngrediente getInstance() { return instance; }
	//  hibernateContext.xml SEBA QUITO ESTO -> ("repositorioIngrediente")
	private SessionFactory sessionFactory;

	 
    @Autowired
	public RepositorioIngredienteImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory; 
	}
	
 

    @Override
    public List<Ingrediente> buscarPorCategoria(Integer id_categoriaIngrediente) {
        final Session session = this.sessionFactory.getCurrentSession();
        return session.createCriteria(Ingrediente.class)
                .add( Restrictions.eq("id_categoriaIngrediente", new Integer(id_categoriaIngrediente) ) )
                .addOrder(Order.asc("nombre"))
                .list();
    }



	@Override
	public void guardar(Ingrediente ingrediente) {
		sessionFactory.getCurrentSession().save(ingrediente);
	}



	@Override
	public Ingrediente buscarPor(Long id) {
		return sessionFactory.getCurrentSession().get(Ingrediente.class, id);
 	}



	@Override
	public Ingrediente buscarIngredientePorNombre(String nombre) {
	
		//3.criteria
	//	sessionFactory.getCurrentSession().createCriteria(getClass()); //
	/*	return (Ingrediente) sessionFactory.getCurrentSession().createCriteria(Ingrediente.class)
		.add(Restrictions.eq("nombre", nombre))
		.uniqueResult();
		*/
		
	      final Session session = this.sessionFactory.getCurrentSession();
	        return (Ingrediente) session.createCriteria(Ingrediente.class)
	                .add(Restrictions.eq("nombre",nombre) )
	                .uniqueResult();
	        
        
        
		//

	/*	
		//1.native query CASO DONDE SOLO PUEDO USARLO? 
	SQLQuery query =	sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM ingrediente where nombre like '%"+nombre+"%'");
	 List <Ingrediente> ingredientes = query.list();
	
	 //2.queries no se si importe bien el query
	
	 	Query query2 =	sessionFactory.getCurrentSession().createQuery("from auto where id=:id");
		query2.setString("id",nombre);
		
		Ingrediente ingredientes2 =(Ingrediente) query.uniqueResult();
			
		DIO VERDE
		
		return null;*/
	}



	@Override
	public Ingrediente buscarPorId(Long id) {
	      final Session session = this.sessionFactory.getCurrentSession();
	        return (Ingrediente) session.createCriteria(Ingrediente.class)
	                .add(Restrictions.eq("id",id) )
	                .uniqueResult();
	}

 
 
	

 
	
	

}
