package br.com.dominio;

import br.com.pedra_papel_tesoura.App.Opcoes;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por armazenar as informações do jogador.
 *
 */
public class Jogador {

    private String nome;
    private List<Opcoes> opcaoUsadaNaRodada;
    private Integer numeroVitorias;
    private Integer numeroDerrotas;
    private Integer numeroEmpates;

    public Jogador(String nome){
        this.nome = nome;
        this.opcaoUsadaNaRodada = new ArrayList<Opcoes>();
        this.numeroDerrotas = 0;
        this.numeroVitorias = 0;
        this.numeroEmpates = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Opcoes> getOpcaoUsadaNaRodada() {
        return opcaoUsadaNaRodada;
    }

    public void setOpcaoUsadaNaRodada(List<Opcoes> opcaoUsadaNaRodada) {
        this.opcaoUsadaNaRodada = opcaoUsadaNaRodada;
    }

    public Integer getNumeroVitorias() {
        return numeroVitorias;
    }

    public void setNumeroVitorias(Integer numeroVitorias) {
        this.numeroVitorias = numeroVitorias;
    }

    public Integer getNumeroDerrotas() {
        return numeroDerrotas;
    }

    public void setNumeroDerrotas(Integer numeroDerrotas) {
        this.numeroDerrotas = numeroDerrotas;
    }

    public Integer getNumeroEmpates() {
        return numeroEmpates;
    }

    public void setNumeroEmpates(Integer numeroEmpates) {
        this.numeroEmpates = numeroEmpates;
    }
}
