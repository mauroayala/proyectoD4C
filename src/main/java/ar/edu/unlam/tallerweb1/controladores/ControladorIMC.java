package ar.edu.unlam.tallerweb1.controladores;
import ar.edu.unlam.tallerweb1.modelo.DatosIMC;
import ar.edu.unlam.tallerweb1.servicios.AlturaInvalida;
import ar.edu.unlam.tallerweb1.servicios.PesoInvalido;
import ar.edu.unlam.tallerweb1.servicios.ServicioCalcularIMC;
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

    @RequestMapping("/calcular")
    public ModelAndView irACalcularIMC() {

        ModelMap modelo = new ModelMap();
        DatosIMC datos = new DatosIMC();
        modelo.put("datosIMC", datos);
        return new ModelAndView("calcularIMC", modelo);
    }

    @RequestMapping(path = "/calcularImcCompleto", method = RequestMethod.POST)
    public ModelAndView calcularImcCompleto(@ModelAttribute("datosIMC") DatosIMC datos) {

        DatosIMC datos1;
        ModelMap model = new ModelMap();

        try {
            datos1 = servicio.calcularImcCompleto(datos.getAltura(), datos.getPeso());
        } catch (AlturaInvalida e){
            return IMCFallido(model,"Altura inválida");
        } catch (PesoInvalido e){
            return IMCFallido(model, "Peso inválido");
        }
        return IMCValido(model, datos1);
    }

    private ModelAndView IMCFallido(ModelMap model, String motivo){
        model.put("IMC", false);
        model.put("error", motivo);
        return new ModelAndView("calcularIMC", model);
    }

    private ModelAndView IMCValido(ModelMap model, DatosIMC datos){
        model.put("IMC", true);
        model.put("IMCCalculado", datos.getIMC());
        model.put("compCorporalCalculada", datos.getIMC());
        return new ModelAndView("index", model);
    }

}