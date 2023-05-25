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
    
    private float investimentoCampanhaReal;
    private float faturamentoCampanhaReal;
    private float lucroCampanhaReal;
    
    private float investimentoCampanhaEsperado;
    private float faturamentoCampanhaEsperado;
    private float lucroCampanhaEsperado; 
    
    
}
