package br.com.br.com.util;

import br.com.dominio.Jogador;
import br.com.pedra_papel_tesoura.App.Opcoes;

import java.util.List;
import java.util.Random;

/**
 * Classe com metodos auxiliares para serem usandos no jogo.
 *
 */
public class AppUtil {

    public static void inicializarJogadores(List<Jogador> jogadores){
        jogadores.add(new Jogador("Pedro"));
        jogadores.add(new Jogador("Lucas"));
    }

    public static void gerarOpcoesDaRodada(List<Jogador> jogadores){
        for (Jogador jogador : jogadores) {

            if(jogador.getNome().equals(jogadores.get(0).getNome())){
                //primeiro jogador da lista sempre jogará PAPEL
                jogador.getOpcaoUsadaNaRodada().add(Opcoes.PAPEL);
            } else {
                jogador.getOpcaoUsadaNaRodada().add(AppUtil.gerarOpcaoAleatoria());
            }
        }
    }

    private static Opcoes gerarOpcaoAleatoria(){
        Random gerador = new Random();
        switch (gerador.nextInt(3)){
            case 0:
                return Opcoes.PEDRA;
            case 1:
                return Opcoes.PAPEL;
            case 2:
                return Opcoes.TESOURA;
        }

        throw new EnumConstantNotPresentException(Opcoes.class,"Não foi possível gerar a opção aleatória.");
    }

    /*Regras:
        -Pedra ganha da tesoura
        -Tesoura ganha do papel
        -Papel ganha da pedra
        -Caso dois jogadores façam o mesmo gesto, ocorre um empate*/
    public static void gerarResultadoDaRodada(List<Jogador> jogadores, Integer rodada){
        Jogador jogador1 = jogadores.get(0);
        Jogador jogador2 = jogadores.get(1);

        Opcoes opcao1 = jogador1.getOpcaoUsadaNaRodada().get(rodada);
        Opcoes opcao2 = jogador2.getOpcaoUsadaNaRodada().get(rodada);

        if(opcao1.name().equals(opcao2.name())){
            addEmpate(jogador1);
            addEmpate(jogador2);
        } else if(opcao1.equals(Opcoes.PEDRA) && opcao2.equals(Opcoes.TESOURA)){
            addVitoria(jogador1);
            addDerrota(jogador2);
        } else if(opcao1.equals(Opcoes.PEDRA) && opcao2.equals(Opcoes.PAPEL)){
            addDerrota(jogador1);
            addVitoria(jogador2);
        } else if(opcao1.equals(Opcoes.PAPEL) && opcao2.equals(Opcoes.PEDRA)){
            addVitoria(jogador1);
            addDerrota(jogador2);
        } else if(opcao1.equals(Opcoes.PAPEL) && opcao2.equals(Opcoes.TESOURA)){
            addDerrota(jogador1);
            addVitoria(jogador2);
        } else if(opcao1.equals(Opcoes.TESOURA) && opcao2.equals(Opcoes.PEDRA)){
            addDerrota(jogador1);
            addVitoria(jogador2);
        } else if(opcao1.equals(Opcoes.TESOURA) && opcao2.equals(Opcoes.PAPEL)){
            addVitoria(jogador1);
            addDerrota(jogador2);
        }
    }

    private static void addVitoria(Jogador jogador){
        jogador.setNumeroVitorias(jogador.getNumeroVitorias() + 1);
    }

    private static void addDerrota(Jogador jogador){
        jogador.setNumeroDerrotas(jogador.getNumeroDerrotas() + 1);
    }
    private static void addEmpate(Jogador jogador){
        jogador.setNumeroEmpates(jogador.getNumeroEmpates() + 1);
    }
}
