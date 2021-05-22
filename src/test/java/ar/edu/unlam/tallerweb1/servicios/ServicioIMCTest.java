package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.servicios.PesoInvalido;
import ar.edu.unlam.tallerweb1.modelo.DatosIMC;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ServicioIMCTest {

    private ServicioIMCImpl servicio = new ServicioIMCImpl();
    private Double altura;
    private Double peso;
    private DatosIMC datosIMC;

    @Test
    public void siLosDatosSonCorrectosDeberiaCalcular(){

        altura = 1.80;
        peso = 80.0;

        dadoQueLosDatosSonCorrectos(altura, peso);

        cuandoCalculoIMC(altura, peso);

        entoncesCalculaBien();

        }
    public void dadoQueLosDatosSonCorrectos(Double altura, Double peso){

        servicio.validarAltura(altura);
        servicio.validarPeso(peso);
    }

    public void cuandoCalculoIMC(Double altura, Double peso){

        datosIMC = servicio.calcularImcCompleto(altura, peso);
    }

    public void entoncesCalculaBien(){

        assertThat(datosIMC).isNotNull();
    }

    @Test
    public void siElPesoEsInvalidoNoDeberiaCalcular(){

        Assertions.assertThrows(PesoInvalido.class, () -> {
            altura = 1.80;
            peso = 800.0;

            dadoQueElPesoEsIncorrectos(peso);

            cuandoCalculoIMC(altura, peso);

            entoncesNoCalcula();
        });
    }

    private void entoncesNoCalcula() {

        assertThat(datosIMC).isNull();
    }

    private void dadoQueElPesoEsIncorrectos(Double peso) {

        servicio.validarPeso(peso);
    }

    @Test
    public void siLaAlturaEsInvalidaNoDeberiaCalcular(){

        Assertions.assertThrows(AlturaInvalida.class, () -> {
            altura = 4.80;
            peso = 80.0;

            dadoQueLaAlturaEsIncorrecta(altura);

            cuandoCalculoIMC(altura, peso);

            entoncesNoCalcula();
        });
    }


    private void dadoQueLaAlturaEsIncorrecta(Double altura) {

        servicio.validarAltura(altura);
    }

}
