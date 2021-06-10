package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

public class UsuarioPersistenciaTest extends SpringTest {

    @Test @Transactional @Rollback
    public void siGuardoUnUsuarioGuardarlo(){

        Usuario usuario = dadoQueExisteUnUsuario();

        Long id = cuandoGuardoUnUsuario(usuario);

        entoncesLoPuedoBuscarPorId(id);

    }

    private void entoncesLoPuedoBuscarPorId(Long id) {
        Usuario usuarioBuscado = session().get(Usuario.class, id);
        assertThat(usuarioBuscado).isNotNull();
    }

    private Long cuandoGuardoUnUsuario(Usuario usuario) {
        session().save(usuario);
        return usuario.getId();
    }

    private Usuario dadoQueExisteUnUsuario() {
        return new Usuario();
    }


}
