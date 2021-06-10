package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.DatosIMC;
import ar.edu.unlam.tallerweb1.servicios.ServicioIMCImpl;
import org.springframework.stereotype.Controller;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.assertThat;

@Controller
public class ControladorIMCTest {

    private ControladorIMC controladorImc = new ControladorIMC(new ServicioIMCImpl());
    private Double altura;
    private Double peso;
    private String motivo;
    private ModelAndView mav;
    private ServicioIMCImpl servicioIMC = new ServicioIMCImpl();

    @Test
    public void siLaAlturaEsInvalidaNoTendriaQuePoderCalcular(){

        altura = 3.80;
        peso = 89.9;
        motivo = "Altura inválida";
        DatosIMC datos = new DatosIMC();
        datos.setAltura(altura);
        datos.setPeso(peso);

        dadoQueLaAlturaEsInvalida(altura);

        cuandoCalculoImc(datos);

        entoncesNoCalculaPorAltura();
    }

    private void entoncesNoCalculaPorAltura() {

        assertThat(mav.getModel().get("IMC")).isEqualTo(Boolean.FALSE);
        assertThat(mav.getViewName()).isEqualTo("calcularIMC");
        assertThat(mav.getModel().get("error")).isEqualTo(motivo);

    }

    private void cuandoCalculoImc(DatosIMC datos) {

        mav = controladorImc.calcularImcCompleto(datos);
    }

    private void dadoQueLaAlturaEsInvalida (Double altura){

        assertThat(servicioIMC.validarAltura(altura)).isEqualTo(Boolean.FALSE);

    }

    @Test
    public void siElPesoEsInvalidoNoTendriaQuePoderCalcular(){

        altura = 1.80;
        peso = 1000.0;
        motivo = "Peso inválido";
        DatosIMC datos = new DatosIMC();
        datos.setAltura(altura);
        datos.setPeso(peso);

        dadoQueElPesoEsInvalido(peso);

        cuandoCalculoImc(datos);

        entoncesNoCalculaPorPeso();

    }

    private void entoncesNoCalculaPorPeso() {

        assertThat(mav.getModel().get("IMC")).isEqualTo(Boolean.FALSE);
        assertThat(mav.getViewName()).isEqualTo("calcularIMC");
        assertThat(mav.getModel().get("error")).isEqualTo(motivo);
    }

    private void dadoQueElPesoEsInvalido(Double peso) {

        assertThat(servicioIMC.validarPeso(peso)).isEqualTo(Boolean.FALSE);

    }

    @Test
    public void calculoIMCExitoso(){

        altura = 1.80;
        peso = 80.0;
        DatosIMC datos = new DatosIMC();
        datos.setAltura(altura);
        datos.setPeso(peso);

        dadoQueLosDatosSonValidos(altura, peso);

        cuandoCalculoImc(datos);

        entoncesSeCalculaExitosamente();
    }

    private void entoncesSeCalculaExitosamente() {

        assertThat(mav.getModel().get("IMC")).isEqualTo(Boolean.TRUE);
        assertThat(mav.getViewName()).isEqualTo("home");

    }

    private void dadoQueLosDatosSonValidos(Double altura, Double peso) {

        assertThat(servicioIMC.validarAltura(altura)).isEqualTo(Boolean.TRUE);
        assertThat(servicioIMC.validarPeso(peso)).isEqualTo(Boolean.TRUE);

    }
}
