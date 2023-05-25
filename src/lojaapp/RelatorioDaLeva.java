package lojaapp;

import java.io.Serializable;
import java.util.ArrayList;

public class RelatorioDaLeva implements Serializable {

    public RelatorioDaLeva() {
    }
    
    private float totalProdutos;
    private float totalProdutosListados;
    private float totalProdutosVendidos;
    
    private float tempoMedioDeSessao;
    
    private float percentualVendas;
    private float percentualDevolucao;
    private float percentualExtravio;
    
    private float investimentoCampanha;
    private float faturamentoCampanha;
    private float lucroCampanha;
    
    
}
