package app.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.entities.Pokemon;

public class PokemonController {
    Statement stat = null;

    public PokemonController(Connection conexao) {
        try {
            this.stat = conexao.createStatement();
        } catch (Exception e) {
            System.out.println("Erro criando o Statement => " + e.getMessage());
        }
    }

    public void add(Pokemon pokemon) {
        String comandosql = ("INSERT INTO Pokemon ");
        boolean tipo2 = (pokemon.getTipo2() != null);
        if (!tipo2) {
            comandosql += ("(ID, Numero, Nome, Tipo1, HP, Attack, Defense, `Sp. Atk`, `Sp. Def`, Speed, Mega, Lendario, Regiao) ");
        }
        comandosql += ("VALUES (" + pokemon.getID() + ", " + pokemon.getNumero() + ", '" + pokemon.getNome() + "', '"
                + pokemon.getTipo1() + "', ");
        if (tipo2) {
            comandosql += ("'" + pokemon.getTipo2() + "', ");
        }
        comandosql += (pokemon.getHP() + ", " + pokemon.getAttack() + ", " + pokemon.getDefense() + ", "
                + pokemon.getSpAtk() + ", " + pokemon.getSpDef() + ", " + pokemon.getSpeed() + ", ");
        if (pokemon.isMega()) {
            comandosql += "'T', ";
        } else {
            comandosql += "'F', ";
        }
        if (pokemon.isLendario()) {
            comandosql += "'T', ";
        } else {
            comandosql += "'F', ";
        }
        comandosql += ("'" + pokemon.getRegiao() + "');");
        doCUD(comandosql);
    }

    public void delete(int id) {
        String comandosql = ("DELETE FROM Pokemon WHERE ID = " + id + ";");
        doCUD(comandosql);
    }

    private void doCUD(String comandosql) {
        try {
            stat.executeUpdate(comandosql);
        } catch (SQLException e) {
            System.err.println("Erro ao executar o comando => " + e.getMessage());
        }
    }

    public ArrayList<Pokemon> readAll() {
        String comandosql = "SELECT * FROM Pokemon;";
        ResultSet rs = null;
        ArrayList<Pokemon> QueryPokemons = new ArrayList<>();
        try {
            rs = stat.executeQuery(comandosql);
            while (rs.next()) {
                int id = rs.getInt("ID"), numero = rs.getInt("Numero"), hp = rs.getInt("HP"),
                        attack = rs.getInt("Attack"), defense = rs.getInt("Defense"), spatk = rs.getInt("Sp. Atk"),
                        spdef = rs.getInt("Sp. Def"), speed = rs.getInt("Speed");
                String nome = rs.getString("Nome"), tipo1 = rs.getString("Tipo1"), tipo2 = rs.getString("Tipo2"),
                        regiao = rs.getString("Regiao");

                boolean mega = rs.getString("Mega").equals("T") ? true : false,
                        lendario = rs.getString("Lendario").equals("T") ? true : false;

                Pokemon poke = new Pokemon(id, numero, nome, tipo1, tipo2, hp, attack, defense, spatk, spdef, speed,
                        mega, lendario, regiao);

                QueryPokemons.add(poke);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fazer Query => " + e.getMessage());
        }
        return QueryPokemons;
    }
}
