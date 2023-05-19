package lojaapp;

public class Usuario {
    
    private String usuario;
    private String senha;

    public Usuario(String ususario, String senha) {
        this.usuario = ususario;
        this.senha = senha;
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
