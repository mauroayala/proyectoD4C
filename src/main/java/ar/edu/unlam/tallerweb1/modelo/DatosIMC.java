package ar.edu.unlam.tallerweb1.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DatosIMC {

    private Double altura;
    private Double peso;
    private Double IMC;
    private String compCorporal;

    public DatosIMC (Double altura, Double peso, Double IMC, String compCorporal){

        this.altura = altura;
        this.peso = peso;
        this.IMC = IMC;
        this.compCorporal = compCorporal;
    }

    public DatosIMC() {
    }

    public Double getAltura() {
        return altura;
    }

    public Double getPeso() {
        return peso;
    }

    public Double getIMC() {
        return IMC;
    }

    public String getCompCorporal() {
        return compCorporal;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setIMC(Double IMC) {
        this.IMC = IMC;
    }

    public void setCompCorporal(String compCorporal) {
        this.compCorporal = compCorporal;
    }

}
