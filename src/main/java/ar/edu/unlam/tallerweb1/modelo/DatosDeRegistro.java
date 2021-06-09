package ar.edu.unlam.tallerweb1.modelo;

public class DatosDeRegistro {

    private String email;
    private String password;
    private String confirmaPassword;

    public DatosDeRegistro(String email, String password, String confirmaPassword) {
        this.email = email;
        this.password = password;
        this.confirmaPassword = confirmaPassword;
    }

    public DatosDeRegistro() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmaPassword() {
        return confirmaPassword;
    }

    public void setConfirmaPassword(String confirmaPassword) {
        this.confirmaPassword = confirmaPassword;
    }
}
