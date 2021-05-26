package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
// Clase que modela el concepto de Usuario, la anotacion @Entity le avisa a hibernate que esta clase es persistible
// el paquete ar.edu.unlam.tallerweb1.modelo esta indicado en el archivo hibernateCOntext.xml para que hibernate
// busque entities en él
@Entity
@Table(name = "ingredientes")

public class Ingrediente {

	// La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// para el resto de los atributo no se usan anotaciones entonces se usa el default de hibernate: la columna se llama igual que
	// el atributo, la misma admite nulos, y el tipo de dato se deduce del tipo de dato de java.
	@Column(nullable=false)
	private String nombre; 

	private Integer id_categoriaIngrediente; 
	
	public Integer getId_categoriaIngrediente() {
		return id_categoriaIngrediente;
	}
	public void setId_categoriaIngrediente(Integer id_categoriaIngrediente) {
		this.id_categoriaIngrediente = id_categoriaIngrediente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	} 
 

    public Ingrediente(){}
    public Ingrediente (String nombre,Integer id_categoriaIngrediente){
		this.nombre = nombre;
		this.id_categoriaIngrediente = id_categoriaIngrediente;

	}
}
