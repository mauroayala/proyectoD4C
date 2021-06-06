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
@Table(name = "evaluacion")

public class Evaluacion {

	// La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id_evaluacion;

	private String pregunta; 
	private String respuesta_a; 
	private String respuesta_b; 
	private String respuesta_c; 
	
	public Long getId_evaluacion() {
		return id_evaluacion;
	}
	public void setId_evaluacion(Long id_evaluacion) {
		this.id_evaluacion = id_evaluacion;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String getRespuesta_a() {
		return respuesta_a;
	}
	public void setRespuesta_a(String respuesta_a) {
		this.respuesta_a = respuesta_a;
	}
	public String getRespuesta_b() {
		return respuesta_b;
	}
	public void setRespuesta_b(String respuesta_b) {
		this.respuesta_b = respuesta_b;
	}
	public String getRespuesta_c() {
		return respuesta_c;
	}
	public void setRespuesta_c(String respuesta_c) {
		this.respuesta_c = respuesta_c;
	}


    public Evaluacion(){}
    public Evaluacion (String pregunta,String respuesta_a,String respuesta_b,String respuesta_c){
		this.pregunta = pregunta;
		this.respuesta_a = respuesta_a;
		this.respuesta_b = respuesta_b;
		this.respuesta_c = respuesta_c;
 
	}
}
