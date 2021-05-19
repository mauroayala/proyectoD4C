package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;


@Controller
public class ControladorIMCTest {

    private ControladorIMC controladorImc = new ControladorIMC();
    private Double altura;
    private Double peso;
    private String motivo;
    private ModelAndView mav;

    @Test
    public void siLaAlturaEsInvalidaNoTendriaQuePoderCalcular(){

        altura = 3.80;
        peso = 89.9;
        motivo = "Altura inválida";

        dadoQueLaAlturaEsInvalida(altura);

        cuandoCalculoImc(altura, peso);

        entoncesNoCalculaPorAltura();
    }

    private void entoncesNoCalculaPorAltura() {

        assertThat(mav.getModel().get("IMC")).isEqualTo(Boolean.FALSE);
        assertThat(mav.getViewName()).isEqualTo("calcularIMC");
        assertThat(mav.getModel().get("error")).isEqualTo(motivo);

    }

    private void cuandoCalculoImc(Double altura, Double peso) {

        mav = controladorImc.calcularImcCompleto(altura, peso);
    }

    private void dadoQueLaAlturaEsInvalida (Double altura){

        assertThat(controladorImc.validarAltura(altura)).isEqualTo(Boolean.FALSE);

    }

    @Test
    public void siElPesoEsInvalidoNoTendriaQuePoderCalcular(){

        altura = 1.80;
        peso = 1000.0;
        motivo = "Peso inválido";

        dadoQueElPesoEsInvalido(peso);

        cuandoCalculoImc(altura, peso);

        entoncesNoCalculaPorPeso();

    }

    private void entoncesNoCalculaPorPeso() {

        assertThat(mav.getModel().get("IMC")).isEqualTo(Boolean.FALSE);
        assertThat(mav.getViewName()).isEqualTo("calcularIMC");
        assertThat(mav.getModel().get("error")).isEqualTo(motivo);
    }

    private void dadoQueElPesoEsInvalido(Double peso) {

        assertThat(controladorImc.validarPeso(peso)).isEqualTo(Boolean.FALSE);

    }

    @Test
    public void calculoIMCExitoso(){

        altura = 1.80;
        peso = 80.0;

        dadoQueLosDatosSonValidos(altura, peso);

        cuandoCalculoImc(altura,peso);

        entoncesSeCalculaExitosamente();
    }

    private void entoncesSeCalculaExitosamente() {

        assertThat(mav.getModel().get("IMC")).isEqualTo(Boolean.TRUE);
        assertThat(mav.getViewName()).isEqualTo("home");

    }

    private void dadoQueLosDatosSonValidos(Double altura, Double peso) {

        assertThat(controladorImc.validarAltura(altura)).isEqualTo(Boolean.TRUE);
        assertThat(controladorImc.validarPeso(peso)).isEqualTo(Boolean.TRUE);

    }
}
