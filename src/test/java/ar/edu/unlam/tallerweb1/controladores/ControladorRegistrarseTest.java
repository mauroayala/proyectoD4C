package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;

@Controller
public class ControladorRegistrarseTest {

    private final Usuario USUARIO = usuario("constanza@gmail.com", "123Cons"); // se crea estático así no se puede cambiar en otra ocasión
    private ControladorRegistrarse controladorRegistro = new ControladorRegistrarse(); // creo una instancia de controlador así puedo usarlo
    private ModelAndView mav;

    //registro con éxito :)
    //registro erroneo por contraseña inadecuada :)
    //registro erroneo por usuario ya existe :)
    //          agregar validacion mensaje de error :)
    //registro erroneo por mail invalido :)
    // registro erroneo por clave no coincide :)
    //          encapsular los datos de registro en un objeto TODO

    @Test
    public void siElUsuarioNoExisteDeberiaPoderRegistrarse(){
        //preparación
        dadoQueNoExisteElUsuario(USUARIO);

        //ejecución
        cuandoRegistroElUsuarioConfirmandoClave(USUARIO.getEmail(), USUARIO.getPassword(), USUARIO.getPassword());

        //validación
        entoncesElUsuarioSeRegistra();

    }

    @Test
    public void siElUsuarioExisteNoDeberiaPoderRegistrarse(){
        //preparación
        dadoQueExisteElUsuario(USUARIO);

        //ejecución
        cuandoRegistroElUsuarioConfirmandoClave(USUARIO.getEmail(), USUARIO.getPassword(), USUARIO.getPassword());

        //validación
        entoncesElUsuarioNoSeRegistraPor("usuario ya existe");

    }

    @Test
    public void siLasClavesNoCoincidenNoDeberiaRegistrar(){
        //preparación
        dadoQueNoExisteElUsuario(USUARIO);

        //ejecución
        cuandoRegistroElUsuarioConfirmandoClave(USUARIO.getEmail(), USUARIO.getPassword(), USUARIO.getPassword() + "0000");

        //validación
        entoncesElUsuarioNoSeRegistraPor("claves no coinciden");

    }

    @Test
    public void siLaElMailEsInvalidoNoDeberiaRegistrar(){
        //preparación
        dadoQueNoExisteElUsuario(USUARIO);

        //ejecución
        cuandoRegistroElUsuarioConfirmandoClave("constanza", USUARIO.getPassword(), USUARIO.getPassword());

        //validación
        entoncesElUsuarioNoSeRegistraPor("email invalido");
    }

    @Test
    public void siLaClaveEsInvalidoNoDeberiaRegistrar(){
        //preparación
        dadoQueNoExisteElUsuario(USUARIO);

        //ejecución
        cuandoRegistroElUsuarioConfirmandoClave(USUARIO.getEmail(), "x", "x");

        //validación
        entoncesElUsuarioNoSeRegistraPor("contraseña invalida");
    }

    private void cuandoRegistroElUsuarioConfirmandoClave(String email, String password, String confirmapass) {
        mav = controladorRegistro.registrar(email, password, confirmapass);
    }

    private void entoncesElUsuarioNoSeRegistraPor(String motivo) {
        assertThat(mav.getModel().get("registrado")).isEqualTo(Boolean.FALSE);
        assertThat(mav.getViewName()).isEqualTo("registro");
        assertThat(mav.getModel().get("error")).isEqualTo(motivo);

    }

    private void dadoQueExisteElUsuario(Usuario usuario) {
        controladorRegistro.registrar(usuario.getEmail(),usuario.getPassword(), usuario.getPassword());
    }

    private void dadoQueNoExisteElUsuario(Usuario usuario) {
    }

    private void entoncesElUsuarioSeRegistra() {
        assertThat(mav.getModel().get("registrado")).isEqualTo(Boolean.TRUE); //valida que devuelva true, porque si devuelve true se registró
        assertThat(mav.getViewName()).isEqualTo("login"); //acá valida que al registrar, lleve al login
    }

    private Usuario usuario(String mail, String clave){
        Usuario usuario = new Usuario();
        usuario.setEmail(mail);
        usuario.setPassword(clave);
        return usuario;
    }

}
