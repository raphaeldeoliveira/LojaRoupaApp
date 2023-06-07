package lojaapp.Model;

import java.io.Serializable;

public class Produto implements Serializable {
    
   private String nome;
   private float precoCompra;
   private float precoVenda;
   private float lucro;
   private String categoria;
   private String genero;

    public Produto() {
    }

    public Produto(String nome, float precoCompra, float precoVenda, String categoria, String genero) {
        this.nome = nome;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.categoria = categoria;
        this.genero = genero;
        
        calcularLucro();
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String tipo) {
        this.categoria = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public float getLucro() {
        return lucro;
    }

    public void setLucro(float lucro) {
        this.lucro = lucro;
    }
   
   public void calcularLucro() {
       if (getPrecoCompra() == 0 || getPrecoVenda() == 0) {
           // deu erro, pois o lucro nao pode ser calculado
       }
       else {
           setLucro(getPrecoVenda() - getPrecoCompra());
       }
   }
   
}
