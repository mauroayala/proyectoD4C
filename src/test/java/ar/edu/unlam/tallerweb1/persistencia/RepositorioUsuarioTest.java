package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.DatosIMC;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import javax.transaction.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioUsuarioTest extends SpringTest {

    @Autowired
    private RepositorioUsuario repo;

    @Test
    @Transactional
    @Rollback
    public void siGuardoUnUsuarioDeberiaPoderBuscarloPorId(){

        Usuario usuario = dadoQueExisteUnUsuario();

        Long id = cuandoGuardoUnUsuarioId(usuario);

        entoncesLoPuedoBuscarPorId(id);

    }

    private void entoncesLoPuedoBuscarPorId(Long id) {
        Usuario usuarioBuscado = repo.buscarPorId(id);
        assertThat(usuarioBuscado).isNotNull();
    }

    private Long cuandoGuardoUnUsuarioId(Usuario usuario) {
        repo.guardar(usuario);
        return usuario.getId();
    }

    private Usuario dadoQueExisteUnUsuario() {
        return new Usuario();
    }

    @Test
    @Transactional
    @Rollback
    public void siGuardoUnUsuarioDeberiaPoderBuscarloPorEmail(){

        String email1 = "cons@gmail.com";
        String email2 = "abc@gmail.com";

        Usuario usuario = dadoQueExisteUnUsuarioConEmail(email1);
        Usuario usuario2 = dadoQueExisteUnUsuarioConEmail(email2);

        Usuario usuarioBuscado = cuandoLoBuscoPorEmail(usuario.getEmail());

        entoncesLoEncuentra(usuarioBuscado, email1);
    }

    private void entoncesLoEncuentra(Usuario usuarioBuscado, String email) {
        assertThat(usuarioBuscado).isNotNull();
        assertThat(usuarioBuscado.getEmail()).isEqualTo(email);
    }

    private Usuario dadoQueExisteUnUsuarioConEmail(String email) {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        repo.guardar(usuario);
        return usuario;
    }

    private Usuario cuandoLoBuscoPorEmail(String email) {
        Usuario usuarioBuscado = repo.buscarPorEmail(email);
        return usuarioBuscado;
    }

    @Test
    @Transactional
    @Rollback
    public void siGuardoImcDeberiaPoderBuscarlo() {

        Double altura = 1.80;
        Double peso = 80.0;
        Double IMC = 24.7;
        String comp ="Normal";

        DatosIMC datos = new DatosIMC(altura,peso,IMC,comp);

        Usuario usuario = dadoQueExisteUnUsuarioConIMC();

        cuandoGuardoElIMC(usuario, datos);

        entoncesLoPuedoBuscarLosDatos(usuario,altura,peso,IMC,comp);

    }

    private void entoncesLoPuedoBuscarLosDatos(Usuario usuario, Double altura, Double peso, Double IMC, String comp) {

        Usuario usuario1 = repo.buscarDatosIMC(usuario);
        assertThat(usuario1.getAltura()).isNotNull();
        assertThat(usuario1.getAltura()).isEqualTo(altura);
        assertThat(usuario1.getPeso()).isNotNull();
        assertThat(usuario1.getPeso()).isEqualTo(peso);
        assertThat(usuario1.getIMC()).isNotNull();
        assertThat(usuario1.getIMC()).isEqualTo(IMC);
        assertThat(usuario1.getCompCorporal()).isNotNull();
        assertThat(usuario1.getCompCorporal()).isEqualTo(comp);
    }

    private void cuandoGuardoElIMC(Usuario usuario, DatosIMC datos) {
        repo.guardarDatosIMC(usuario,datos);
    }

    private Usuario dadoQueExisteUnUsuarioConIMC() {
        Usuario usuario = new Usuario();
        return usuario;
    }

}
