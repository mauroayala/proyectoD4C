package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.DatosDeRegistro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("servicioRegistrarse")
@Transactional
public class ServicioRegistrarseImpl implements ServicioRegistrarse{

    private RepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicioRegistrarseImpl(RepositorioUsuario repositorioUsuario){
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override

    public Usuario registrar(DatosDeRegistro datosDeRegistro) {
        if(!datosDeRegistro.getPassword().equals(datosDeRegistro.getConfirmaPassword())){
            throw new ClavesNoCoinciden();
        }
        else if(!datosDeRegistro.getEmail().contains("@")) {
            throw new EmailInvalido();
        }
        else if (!isValidPassword(datosDeRegistro.getPassword())) {
            throw new ClaveInvalida();
        }
        else if((repositorioUsuario.buscarPorEmail(datosDeRegistro.getEmail())) == null) {
            Usuario usuarioNuevo = new Usuario(datosDeRegistro.getEmail(),datosDeRegistro.getPassword());
            repositorioUsuario.guardar(usuarioNuevo);
            return usuarioNuevo;
        } else {
            throw new UsuarioExistente();
        }
    }

    public boolean isValidPassword(String password) {

        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{7,20}$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);

        return m.matches();
    }
}
