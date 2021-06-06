package ar.edu.unlam.tallerweb1.modelo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

 
// Clase que modela el concepto de Usuario, la anotacion @Entity le avisa a hibernate que esta clase es persistible
// el paquete ar.edu.unlam.tallerweb1.modelo esta indicado en el archivo hibernateCOntext.xml para que hibernate
// busque entities en él
@Entity
@Table(name = "diagnostico")

public class Diagnostico {

	// La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id_diagnostico;

	private String descripcion; 
	private Integer respuesta_a; 
	private Integer respuesta_b; 
	private Integer respuesta_c; 
	

	public Long getId_diagnostico() {
		return id_diagnostico;
	}
	public void setId_diagnostico(Long id_diagnostico) {
		this.id_diagnostico = id_diagnostico;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	} 


    public Diagnostico(){}
    public Diagnostico (String descripcion,Integer respuesta_a,Integer respuesta_b,Integer respuesta_c){
		this.descripcion = descripcion;
		this.respuesta_a = respuesta_a;
		this.respuesta_b = respuesta_b;
		this.respuesta_c = respuesta_c;
 
	}
	public Integer getRespuesta_a() {
		return respuesta_a;
	}
	public void setRespuesta_a(Integer respuesta_a) {
		this.respuesta_a = respuesta_a;
	}
	public Integer getRespuesta_b() {
		return respuesta_b;
	}
	public void setRespuesta_b(Integer respuesta_b) {
		this.respuesta_b = respuesta_b;
	}
	public Integer getRespuesta_c() {
		return respuesta_c;
	}
	public void setRespuesta_c(Integer respuesta_c) {
		this.respuesta_c = respuesta_c;
	}
}
