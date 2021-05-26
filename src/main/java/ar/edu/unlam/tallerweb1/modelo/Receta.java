package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name = "receta")

public class Receta {

	// La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_receta;
	private Integer id_plato; 
	private Long id_ingrediente; 
	private String cantidad; 
	private String principal; 
	 

    public Long getId_receta() {
		return id_receta;
	}
	public void setId_receta(Long id_receta) {
		this.id_receta = id_receta;
	}
	public Integer getId_plato() {
		return id_plato;
	}
	public void setId_plato(Integer id_plato) {
		this.id_plato = id_plato;
	}
 
	public Long getId_ingrediente() {
		return id_ingrediente;
	}
	public void setId_ingrediente(Long id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
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
	public Receta(){}
	//cambiar cantidad a string
    public Receta(Integer idPlato,Long idIngrediente,String cantidad){
		this.id_plato = idPlato;
		this.id_ingrediente = idIngrediente;
		this.cantidad = cantidad;

	}
 
}
