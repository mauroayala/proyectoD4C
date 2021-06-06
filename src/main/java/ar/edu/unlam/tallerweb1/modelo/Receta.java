package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;  

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

 

@Entity
@Table(name = "receta")

public class Receta {

	// La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_receta;
	
//	@ManyToOne(optional =false , cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinColumn(name="id_plato")
    @ManyToOne
    @JoinColumn(name = "id_plato")
	private Plato plato; 
	
	//FetchType. ES EL QUE CARGA O NO LA OTRA ENTIDAD , mappedBy="receta"
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "receta", cascade = CascadeType.ALL)
 //   @Column(name = "id_ingrediente", insertable=false, updatable=false)
	
    @ManyToOne
    @JoinColumn(name = "id_ingrediente")
 	private Ingrediente ingrediente; 
	
	private String cantidad; 
	private String principal; 
	 

    public Long getId_receta() {
		return id_receta;
	}
	public void setId_receta(Long id_receta) {
		this.id_receta = id_receta;
	}
  
 
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}

 
 
	public Plato getPlato() {
		return plato;
	}
	public void setPlato(Plato plato) {
		this.plato = plato;
	}
	public Ingrediente getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	public Receta(){}
	//cambiar cantidad a string

    public Receta(Plato idPlato,Ingrediente id_ingrediente,String cantidad){
		this.plato = idPlato;
		this.ingrediente = id_ingrediente;
		this.cantidad = cantidad;

	}
    
    
}
