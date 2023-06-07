package lojaapp.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuarios implements Serializable {
    
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}
