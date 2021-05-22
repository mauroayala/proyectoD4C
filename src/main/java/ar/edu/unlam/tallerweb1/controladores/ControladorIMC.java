package ar.edu.unlam.tallerweb1.controladores;
import ar.edu.unlam.tallerweb1.servicios.AlturaInvalida;
import ar.edu.unlam.tallerweb1.servicios.PesoInvalido;
import ar.edu.unlam.tallerweb1.servicios.ServicioCalcularIMC;
import ar.edu.unlam.tallerweb1.servicios.ServicioIMCImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorIMC {

    private ServicioCalcularIMC servicio;

    @Autowired
    public ControladorIMC (ServicioCalcularIMC servicio){
        this.servicio = servicio;
    }

    public ModelAndView calcularImcCompleto(Double altura, Double peso) {

        ModelMap model = new ModelMap();

        try {
            servicio.calcularImcCompleto(altura, peso);
        } catch (AlturaInvalida e){
            return IMCFallido(model,"Altura inválida");
        } catch (PesoInvalido e){
            return IMCFallido(model, "Peso inválido");
        }
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
