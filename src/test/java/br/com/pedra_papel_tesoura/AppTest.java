package br.com.pedra_papel_tesoura;

import br.com.br.com.util.AppUtil;
import br.com.br.com.util.Validator;
import br.com.dominio.Jogador;
import junit.framework.TestCase;
import br.com.pedra_papel_tesoura.App.Opcoes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase{

    public void testValidacaoListaSemJogadores(){
        List<Jogador> jogadores = new ArrayList<Jogador>();
        List<String> erro = Validator.validate(jogadores);
        assertEquals("É preciso inicializar a lista de jogadores.", erro.get(0));
    }

    public void testValidacaoListaMenosDeDoisJogadores(){
        List<Jogador> jogadores = gerarJogadoresByNomes("Pedro");
        List<String> erro = Validator.validate(jogadores);
        assertEquals("É preciso ter pelo menos 2 jogadores.", erro.get(0));
    }

    public void testValidacaoJogadorSemNome(){
        List<Jogador> jogadores = gerarJogadoresByNomes(" ", "Lucas");
        List<String> erro = Validator.validate(jogadores);
        assertEquals("Não pode ter jogador com nome vazio.", erro.get(0));
    }

    public void testValidacaoJogadorNomeRepetido(){
        List<Jogador> jogadores = gerarJogadoresByNomes("Lucas", "Lucas");
        List<String> erro = Validator.validate(jogadores);
        assertEquals("Existem jogadores com nomes repetidos.", erro.get(0));
    }

    public void testPrimeiroJogadorColocouPapel(){
        List<Jogador> jogadores = gerarJogadoresByNomes("Pedro", "Lucas");
        AppUtil.gerarOpcoesDaRodada(jogadores);
        assertEquals(jogadores.get(0).getOpcaoUsadaNaRodada().get(0), Opcoes.PAPEL);
    }

    public void testEmpate(){
        testarGeracaoDoResultadoEmpate(Opcoes.PEDRA, Opcoes.PEDRA);
        testarGeracaoDoResultadoEmpate(Opcoes.PAPEL, Opcoes.PAPEL);
        testarGeracaoDoResultadoEmpate(Opcoes.TESOURA, Opcoes.TESOURA);
    }

    private void testarGeracaoDoResultadoEmpate(Opcoes opcao1, Opcoes opcao2){
        List<Jogador> jogadores = gerarJogadoresByNomes("Pedro", "Lucas");

        jogadores.get(0).setOpcaoUsadaNaRodada(Arrays.asList(opcao1));
        jogadores.get(1).setOpcaoUsadaNaRodada(Arrays.asList(opcao2));

        Integer numeroEmpateJogador1Antes = jogadores.get(0).getNumeroEmpates();
        Integer numeroEmpateJogador2Antes = jogadores.get(1).getNumeroEmpates();

        AppUtil.gerarResultadoDaRodada(jogadores, 0);

        assertEquals(jogadores.get(0).getNumeroEmpates() - numeroEmpateJogador1Antes, 1);
        assertEquals(jogadores.get(1).getNumeroEmpates() - numeroEmpateJogador2Antes, 1);
    }

    public void testVitoriaJogador1DerrotaJogador2(){
        testarVitoriaJogador1DerrotaJogador2(Opcoes.PEDRA, Opcoes.TESOURA);
        testarVitoriaJogador1DerrotaJogador2(Opcoes.PAPEL, Opcoes.PEDRA);
        testarVitoriaJogador1DerrotaJogador2(Opcoes.TESOURA, Opcoes.PAPEL);
    }

    private void testarVitoriaJogador1DerrotaJogador2(Opcoes opcao1, Opcoes opcao2){
        List<Jogador> jogadores = gerarJogadoresByNomes("Pedro", "Lucas");

        jogadores.get(0).setOpcaoUsadaNaRodada(Arrays.asList(opcao1));
        jogadores.get(1).setOpcaoUsadaNaRodada(Arrays.asList(opcao2));

        Integer numeroVitoriasJogador1Antes = jogadores.get(0).getNumeroVitorias();
        Integer numeroDerrotasJogador2Antes = jogadores.get(1).getNumeroDerrotas();

        AppUtil.gerarResultadoDaRodada(jogadores, 0);

        assertEquals(jogadores.get(0).getNumeroVitorias() - numeroVitoriasJogador1Antes, 1);
        assertEquals(jogadores.get(1).getNumeroDerrotas() - numeroDerrotasJogador2Antes, 1);
    }

    private List<Jogador> gerarJogadoresByNomes(String... nomes){
        List<Jogador> jogadores = new ArrayList<Jogador>();
        for (String nome : nomes) {
            jogadores.add(new Jogador(nome));
        }
        return jogadores;
    }
}
