package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.DatosDeRegistro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //MVC -> ModeloVistaConstrolador. La vista es donde se muestran los datos, el modelo es donde viajan los datos a la vista y el controlador orquesta el flujo.
//por eso generalmente los controladores devuelven un objeto del tipo model and view

public class ControladorRegistrarse {

    private ServicioRegistrarse servicio;

    @Autowired
    public ControladorRegistrarse(ServicioRegistrarse servicio) {
            this.servicio = servicio;
    }


    @RequestMapping("/registro")
    public ModelAndView irARegistrar() {

        ModelMap modelo = new ModelMap();
        DatosDeRegistro datos = new DatosDeRegistro();
        modelo.put("datosDeRegistro", datos);
        return new ModelAndView("registro", modelo);
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public ModelAndView registrar(@ModelAttribute("datosDeRegistro") DatosDeRegistro datosDeRegistro){
        ModelMap model = new ModelMap();
        try {
            servicio.registrar(datosDeRegistro);
        } catch (ClavesNoCoinciden e){
            return registroFallido(model,"Las claves no coinciden");
        } catch (EmailInvalido e){
            return registroFallido(model, "El email es inválido");
        } catch (ClaveInvalida e){
        return registroFallido(model, "El clave es inválida");
        } catch (UsuarioExistente e){
            return registroFallido(model, "Ya se registró un usuario con este email");
        }
        return registroExitoso(model);
    }

    private ModelAndView registroExitoso(ModelMap model){
        model.put("registrado", true);
        Usuario usuario = new Usuario();
        model.put("usuario", usuario);
        return new ModelAndView("login", model);
    }

    private ModelAndView registroFallido(ModelMap model, String motivo){
        model.put("registrado", false);
        model.put("error", motivo);
        return new ModelAndView("registro", model);
    }

}

