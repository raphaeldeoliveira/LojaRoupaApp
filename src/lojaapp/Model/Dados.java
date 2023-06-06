package lojaapp.Model;

import lojaapp.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Dados implements Serializable {
    
    private ArrayList<Produto> produtosListados = new ArrayList<>();
    private ArrayList<Produto> produtosVendidos = new ArrayList<>();
    
    private float investimento;
    private float faturamentoReal;
    private float lucroReal;
    private float faturamentoEsperado;
    private float lucroEsperado;
    
    private int quantidadeExtraviados;
    private float somatorioPVExtraviados;
    private float somatorioPCExtraviados;

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
    
    public float getInvestimento() {
        return investimento;
    }

    public void setInvestimento(float investimento) {
        this.investimento = investimento;
    }

    public float getFaturamentoReal() {
        return faturamentoReal;
    }

    public void setFaturamentoReal(float faturamentoReal) {
        this.faturamentoReal = faturamentoReal;
    }

    public float getLucroReal() {
        return lucroReal;
    }

    public void setLucroReal(float lucroReal) {
        this.lucroReal = lucroReal;
    }

    public float getFaturamentoEsperado() {
        return faturamentoEsperado;
    }

    public void setFaturamentoEsperado(float faturamentoEsperado) {
        this.faturamentoEsperado = faturamentoEsperado;
    }

    public float getLucroEsperado() {
        return lucroEsperado;
    }

    public void setLucroEsperado(float lucroEsperado) {
        this.lucroEsperado = lucroEsperado;
    }

    public int getQuantidadeExtraviados() {
        return quantidadeExtraviados;
    }

    public void setQuantidadeExtraviados(int quantidadeExtraviados) {
        this.quantidadeExtraviados = quantidadeExtraviados;
    }

    public float getSomatorioPVExtraviados() {
        return somatorioPVExtraviados;
    }

    public void setSomatorioPVExtraviados(float somatorioPVExtraviados) {
        this.somatorioPVExtraviados = somatorioPVExtraviados;
    }

    public float getSomatorioPCExtraviados() {
        return somatorioPCExtraviados;
    }

    public void setSomatorioPCExtraviados(float somatorioPCExtraviados) {
        this.somatorioPCExtraviados = somatorioPCExtraviados;
    }
    
}
