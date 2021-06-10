package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.DatosDeRegistro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioRegistrarseTest {

    private RepositorioUsuario repositorioUsuario;
    private ServicioRegistrarse servicio;
    private static String MAIL = "cons@gmail.com";
    private static String PASS = "123Constanza";

    @BeforeEach
    public void init(){
        repositorioUsuario = mock(RepositorioUsuario.class);
        servicio = new ServicioRegistrarseImpl(repositorioUsuario);
    }

    @Test
    public void siTodoEsCorrectoYNoExisteElUsuarioDeberiaRegistrar(){

        dadoQueElUsuarioNoExiste(MAIL);

        DatosDeRegistro datosDeRegistro = new DatosDeRegistro(MAIL,PASS,PASS);
        Usuario usuarioRegistrado = cuandoRegistroElUsuario(datosDeRegistro);

        entoncesRegistraExitosamente(usuarioRegistrado);
    }

    private void dadoQueElUsuarioNoExiste(String email) {
        when(repositorioUsuario.buscarPorEmail(email)).thenReturn(null);
    }

    private void entoncesRegistraExitosamente(Usuario usuarioRegistrado) {
        assertThat(usuarioRegistrado).isNotNull();

    }

    private Usuario cuandoRegistroElUsuario(DatosDeRegistro datosDeRegistro) {
        Usuario usuarioRegistrado = servicio.registrar(datosDeRegistro);
        return usuarioRegistrado;
    }
    

    @Test
    public void siLasClavesNoCoincidenYElUsuarioNoExisteNoDeberiaRegistrar(){

        Assertions.assertThrows(ClavesNoCoinciden.class, () -> {

            dadoQueElUsuarioNoExiste(MAIL);

            DatosDeRegistro datosDeRegistro = new DatosDeRegistro(MAIL,PASS,PASS + "ccc");
            Usuario usuarioRegistrado = cuandoRegistroElUsuario(datosDeRegistro);

            entoncesNoDeberiaRegistrar(usuarioRegistrado);
        });

    }

    private void entoncesNoDeberiaRegistrar(Usuario usuarioRegistrado) {
        assertThat(usuarioRegistrado).isNull();
    }

    @Test
    public void siElEmailEsInvalidoYElUsuarioNoExisteNoDeberiaRegistrar(){

        Assertions.assertThrows(EmailInvalido.class, () -> {

            dadoQueElUsuarioNoExiste(MAIL);

            DatosDeRegistro datosDeRegistro = new DatosDeRegistro("MAIL",PASS,PASS);
            Usuario usuarioRegistrado = cuandoRegistroElUsuario(datosDeRegistro);

            entoncesNoDeberiaRegistrar(usuarioRegistrado);
        });

    }

    @Test
    public void siLaClaveEsInvalidaYElUsuarioNoExisteNoDeberiaRegistrar(){

        Assertions.assertThrows(ClaveInvalida.class, () -> {

            dadoQueElUsuarioNoExiste(MAIL);

            DatosDeRegistro datosDeRegistro = new DatosDeRegistro(MAIL,"1","1");
            Usuario usuarioRegistrado = cuandoRegistroElUsuario(datosDeRegistro);

            entoncesNoDeberiaRegistrar(usuarioRegistrado);
        });

    }

    @Test
    public void siElUsuarioYaExisteNoDeberiaRegistrar(){

        Assertions.assertThrows(UsuarioExistente.class, () -> {

            dadoQueElUsuarioExiste(MAIL);

            DatosDeRegistro datosDeRegistro = new DatosDeRegistro(MAIL,PASS,PASS);
            Usuario usuarioRegistrado = cuandoRegistroElUsuario(datosDeRegistro);

            entoncesNoDeberiaRegistrar(usuarioRegistrado);
        });

    }

    private void dadoQueElUsuarioExiste(String mail) {
        when(repositorioUsuario.buscarPorEmail(mail)).thenReturn(new Usuario());
    }

}
