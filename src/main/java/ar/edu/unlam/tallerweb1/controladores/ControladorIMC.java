package ar.edu.unlam.tallerweb1.controladores;
import ar.edu.unlam.tallerweb1.modelo.DatosIMC;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.AlturaInvalida;
import ar.edu.unlam.tallerweb1.servicios.PesoInvalido;
import ar.edu.unlam.tallerweb1.servicios.ServicioCalcularIMC;
import ar.edu.unlam.tallerweb1.servicios.ServicioIMCImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorIMC {

    private ServicioCalcularIMC servicio;

    @Autowired
    public ControladorIMC (ServicioCalcularIMC servicio){
        this.servicio = servicio;
    }

    @RequestMapping("/calcularIMC")
    public ModelAndView irACalcularIMC() {

        ModelMap modelo = new ModelMap();
        DatosIMC datos = new DatosIMC();
        modelo.put("usuario", datos);

        return new ModelAndView("calcularIMC", modelo);
    }

    @RequestMapping(path = "/calcular", method = RequestMethod.GET)
    public ModelAndView calcularImcCompleto(@ModelAttribute DatosIMC datos) {

        ModelMap model = new ModelMap();

        try {
            servicio.calcularImcCompleto(datos.getAltura(), datos.getPeso());
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