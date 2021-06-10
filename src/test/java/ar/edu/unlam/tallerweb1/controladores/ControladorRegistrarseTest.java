package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.DatosDeRegistro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistrarse;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistrarseImpl;
import ar.edu.unlam.tallerweb1.servicios.UsuarioExistente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Controller
public class ControladorRegistrarseTest {

    private final Usuario USUARIO = usuario("constanza@gmail.com", "123Constanza"); // se crea estático así no se puede cambiar en otra ocasión
    private ControladorRegistrarse controlador;
    private ServicioRegistrarse servicio;
    private ModelAndView mav;

    @BeforeEach
    public void init(){
        servicio = mock(ServicioRegistrarse.class);
        controlador = new ControladorRegistrarse(servicio);
    }

    @Test
    public void siElUsuarioNoExisteDeberiaPoderRegistrarse(){
        //preparación
        dadoQueNoExisteElUsuario(USUARIO);

        DatosDeRegistro datos = new DatosDeRegistro(USUARIO.getEmail(), USUARIO.getPassword(), USUARIO.getPassword());

        //ejecución
        cuandoRegistroElUsuario(datos);

        //validación
        entoncesElUsuarioSeRegistra();

    }

    @Test
    public void siElUsuarioExisteNoDeberiaPoderRegistrarse(){
        //preparación
        dadoQueExisteElUsuario(USUARIO);

        DatosDeRegistro datos = new DatosDeRegistro(USUARIO.getEmail(), USUARIO.getPassword(), USUARIO.getPassword());

        //ejecución
        cuandoRegistroElUsuario(datos);

        //validación
        entoncesElUsuarioNoSeRegistraPor("Ya se registró un usuario con este email");

    }

    @Test
    public void siLasClavesNoCoincidenNoDeberiaRegistrar(){
        //preparación
        dadoQueNoExisteElUsuario(USUARIO);

        DatosDeRegistro datos = new DatosDeRegistro(USUARIO.getEmail(), USUARIO.getPassword(), USUARIO.getPassword() + "0000");

        //ejecución
        cuandoRegistroElUsuario(datos);

        //validación
        entoncesElUsuarioNoSeRegistraPor("Las claves no coinciden");

    }

    @Test
    public void siLaElMailEsInvalidoNoDeberiaRegistrar(){
        //preparación
        dadoQueNoExisteElUsuario(USUARIO);

        DatosDeRegistro datos = new DatosDeRegistro("constanza", USUARIO.getPassword(), USUARIO.getPassword());

        //ejecución
        cuandoRegistroElUsuario(datos);

        //validación
        entoncesElUsuarioNoSeRegistraPor("El email es inválido");
    }

    @Test
    public void siLaClaveEsInvalidoNoDeberiaRegistrar(){
        //preparación
        dadoQueNoExisteElUsuario(USUARIO);

        DatosDeRegistro datos = new DatosDeRegistro(USUARIO.getEmail(), "x", "x");
        //ejecución
        cuandoRegistroElUsuario(datos);

        //validación
        entoncesElUsuarioNoSeRegistraPor("El clave es inválida");
    }

    private void cuandoRegistroElUsuario(DatosDeRegistro datos) {
        mav = controlador.registrar(datos);
    }

    private void entoncesElUsuarioNoSeRegistraPor(String motivo) {

        assertThat(mav.getModel().get("registrado")).isEqualTo(Boolean.FALSE);
        assertThat(mav.getViewName()).isEqualTo("registro");
        assertThat(mav.getModel().get("error")).isEqualTo(motivo);

    }

    private void dadoQueExisteElUsuario(Usuario usuario) {
        when(servicio.registrar(any())).thenThrow(UsuarioExistente.class);
    }

    private void dadoQueNoExisteElUsuario(Usuario usuario) {
        DatosDeRegistro datosRegistro = new DatosDeRegistro();
        datosRegistro.setEmail(usuario.getEmail());
        datosRegistro.setPassword(usuario.getPassword());
        datosRegistro.setConfirmaPassword(usuario.getPassword());
        when(servicio.registrar(datosRegistro)).thenReturn(new Usuario());
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
