package br.com.br.com.util;

import br.com.dominio.Jogador;

import java.util.List;

/**
 * Classe responsavel pelas validações do jogo.
 *
 */
public class Validator {

    public static Boolean isJogadoresValidos(List<Jogador> jogadores){
        Boolean isJogadoresValidos = true;

        if(jogadores.isEmpty()){
            System.out.println("É preciso inicializar a lista de jogadores.");
            isJogadoresValidos = false;
        } else if(jogadores.size() < 2){
            System.out.println("É preciso ter pelo menos 2 jogadores.");
            isJogadoresValidos = false;
        }

        if(isJogadoresValidos){
            isJogadoresValidos = validaNomes(jogadores);
        }

        return isJogadoresValidos;
    }

    private static Boolean validaNomes(List<Jogador> jogadores){
        Boolean nomesValidos = true;

        for (Integer i = 0; i < jogadores.size(); i++) {
            if(jogadores.get(i).getNome().trim().isEmpty()){
                System.out.println("Não pode ter jogarador com nome vazio.");
                nomesValidos = false;
                break;
            }

            if(nomesValidos){
                for (Integer j = 0; j < jogadores.size(); j++) {
                    if(i != j && jogadores.get(i).getNome().trim().equals(jogadores.get(j).getNome().trim())){
                        System.out.println("Existem jogaradores com nomes repetidos.");
                        nomesValidos = false;
                        break;
                    }
                }
            }
        }

        return nomesValidos;
    }
}
