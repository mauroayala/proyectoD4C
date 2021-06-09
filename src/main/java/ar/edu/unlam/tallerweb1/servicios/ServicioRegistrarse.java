package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.DatosDeRegistro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioRegistrarse {

    Usuario registrar (DatosDeRegistro datosDeRegistro);
    boolean isValidPassword(String password);

}
