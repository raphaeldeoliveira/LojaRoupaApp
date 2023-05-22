package lojaapp;

import java.io.Serializable;

public class Usuario implements Serializable {
    
    private String usuario;
    private String senha;
    private String email;

    public Usuario(String ususario, String senha) {
        this.usuario = ususario;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String ususario) {
        this.usuario = ususario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
