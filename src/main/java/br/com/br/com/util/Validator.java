package br.com.br.com.util;

import br.com.dominio.Jogador;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsavel pelas validações do jogo.
 *
 */
public class Validator {

    public static List<String> validate(List<Jogador> jogadores){
        List<String> erros = new ArrayList<String>();

        if(jogadores.isEmpty()){
            erros.add("É preciso inicializar a lista de jogadores.");
        } else if(jogadores.size() < 2){
            erros.add("É preciso ter pelo menos 2 jogadores.");
        }

        if(erros.isEmpty()){
            erros.addAll(validaNomes(jogadores));
        }

        return erros;
    }

    private static List<String> validaNomes(List<Jogador> jogadores){
        List<String> erros = new ArrayList<String>();

        for (Integer i = 0; i < jogadores.size(); i++) {
            if(jogadores.get(i).getNome().trim().isEmpty()){
                erros.add("Não pode ter jogador com nome vazio.");
                break;
            }

            if(erros.isEmpty()){
                for (Integer j = 0; j < jogadores.size(); j++) {
                    if(i != j && jogadores.get(i).getNome().trim().equals(jogadores.get(j).getNome().trim())){
                        erros.add("Existem jogadores com nomes repetidos.");
                        break;
                    }
                }
            }
        }

        return erros;
    }
}
