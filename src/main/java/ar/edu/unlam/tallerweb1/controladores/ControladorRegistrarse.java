package ar.edu.unlam.tallerweb1.controladores;


import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller //MVC -> ModeloVistaConstrolador. La vista es donde se muestran los datos, el modelo es donde viajan los datos a la vista y el controlador orquesta el flujo.
//por eso generalmente los controladores devuelven un objeto del tipo model and view

public class ControladorRegistrarse {

    private Map <String, Usuario> tablaUsuarios = new HashMap<>(); //para podes guardar los usuarios registrados asi no registrar los que ya están

    public ModelAndView registrar(String email, String clave, String confirmarClave){
        ModelMap model = new ModelMap();
        if(!clave.equals(confirmarClave)){
            return registroFallido(model, "claves no coinciden");
        }
        if (!email.contains("@")) {
            return registroFallido(model, "email invalido");
        }
        if (!isValidPassword(clave)) {
            return registroFallido(model, "contraseña invalida");
        }
        if(!tablaUsuarios.containsKey(email)) {
            tablaUsuarios.put(email, new Usuario(email, clave));
            //registrado = true;//model.put("registrado", Boolean.TRUE); ->dentro del model (model map) -> id - variable
            //vista = "login";//return new ModelAndView ("login", model); // (model and view) -> vista - model map
            return registroExitoso(model);
        } else {
            return registroFallido(model, "usuario ya existe");
        }
    }

    private ModelAndView registroExitoso(ModelMap model){
        model.put("registrado", true);
        return new ModelAndView("login", model);
    }

    private ModelAndView registroFallido(ModelMap model, String motivo){
        model.put("registrado", false);
        model.put("error", motivo);
        return new ModelAndView("registro", model);
    }

    public static boolean isValidPassword(String password) {

        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{7,20}$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);

        return m.matches();
    }
}

