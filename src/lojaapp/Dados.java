package lojaapp;

import java.io.Serializable;
import java.util.ArrayList;

public class Dados implements Serializable {
    
    private ArrayList<Produto> produtosListados = new ArrayList<>();
    private ArrayList<Produto> produtosVendidos = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Integer> temposDeSessao = new ArrayList<>();
    
    private float investimento;
    private float faturamento;
    private float lucro;

    public Dados() {
    }

    public ArrayList<Produto> getProdutosListados() {
        return produtosListados;
    }

    public void setProdutosListados(ArrayList<Produto> produtosListados) {
        this.produtosListados = produtosListados;
    }

    public ArrayList<Produto> getProdutosVendidos() {
        return produtosVendidos;
    }

    public void setProdutosVendidos(ArrayList<Produto> produtosVendidos) {
        this.produtosVendidos = produtosVendidos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Integer> getTemposDeSessao() {
        return temposDeSessao;
    }

    public void setTemposDeSessao(ArrayList<Integer> temposDeSessao) {
        this.temposDeSessao = temposDeSessao;
    }

    public float getInvestimento() {
        return investimento;
    }

    public void setInvestimento(float investimento) {
        this.investimento = investimento;
    }

    public float getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(float faturamento) {
        this.faturamento = faturamento;
    }

    public float getLucro() {
        return lucro;
    }

    public void setLucro(float lucro) {
        this.lucro = lucro;
    }
    
}
