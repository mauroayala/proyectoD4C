package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.DatosIMC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorIMC {


    public Boolean validarAltura(Double altura) {
        if(altura > 1.50 && altura < 2.80){
            return true;
        }else{
            return false;
        }
    }

    public Boolean validarPeso(Double peso) {
        if(peso > 20 && peso < 640){
            return true;
        }else{
            return false;
        }
    }

    public ModelAndView calcularImcCompleto(Double altura, Double peso) {
        ModelMap model = new ModelMap();
        Double IMC;
        String compCorporal = "";
        if (validarAltura(altura).equals(false)){
            return IMCFallido(model,"Altura inválida");
        }
        if (validarPeso(peso).equals(false)){
            return IMCFallido(model, "Peso inválido");
        }
        IMC = peso / (altura*altura);
        if(IMC < 18.5){
            compCorporal = "Bajo peso";
        }else if(IMC < 18.5 && IMC < 29.9){
            compCorporal = "Normal";
        }else if(IMC < 25.0 && IMC < 24.9){
            compCorporal = "Sobrepeso";
        }else if(IMC > 30.0){
            compCorporal = "Obeso";
        }
        new DatosIMC(altura,peso,IMC,compCorporal);
        return IMCValido(model);
    }

    private ModelAndView IMCFallido(ModelMap model, String motivo){
        model.put("IMC", false);
        model.put("error", motivo);
        return new ModelAndView("calcularIMC", model);
    }

    private ModelAndView IMCValido(ModelMap model){
        model.put("IMC", true);
        return new ModelAndView("home", model);
    }

}
