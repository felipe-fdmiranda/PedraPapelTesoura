package br.com.pedra_papel_tesoura;

import br.com.br.com.util.AppUtil;
import br.com.br.com.util.Validator;
import br.com.dominio.Jogador;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe principal da execução do jogo pedra, papel e tesoura.
 *
 */
public class App 
{
    private static final Integer NUMERO_RODADAS = 10;

    public enum Opcoes {
        PEDRA, PAPEL, TESOURA;
    }

    private static List<Jogador> jogadores = new ArrayList<Jogador>();

    public static void main( String[] args ){
        AppUtil.inicializarJogadores(jogadores);

        if(Validator.isJogadoresValidos(jogadores)){
            jogar();
            mostrarResultado();
        }
    }

    public static void jogar(){
        System.out.println( "Iniciando jogo." );

        try {
            for(Integer rodada = 0; rodada < NUMERO_RODADAS; rodada++ ){
                AppUtil.gerarOpcoesDaRodada(jogadores);
                AppUtil.gerarResultadoDaRodada(jogadores, rodada);
            }
        } catch (EnumConstantNotPresentException enumException){
            System.out.println(enumException.constantName());
        }

        System.out.println( "Jogo finalizado." );
    }

    public static void mostrarResultado(){
        System.out.println("\nResultados: ");
        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getNome() + ":" +
                " V:" + jogador.getNumeroVitorias() +
                " D:" + jogador.getNumeroDerrotas() +
                " E:" + jogador.getNumeroEmpates());
        }
    }
}
