package app;

import java.sql.SQLException;
import java.util.ArrayList;

import app.controllers.PokemonController;
import app.controllers.RelacionamentoController;
import app.controllers.UsuarioController;
import app.entities.Pokemon;
import app.entities.Relacionamento;
import app.entities.Usuario;
import spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        DAO dao = new DAO();
        dao.connect();
        UsuarioController contUser = new UsuarioController(dao.getConexao());
        RelacionamentoController contRelac = new RelacionamentoController(dao.getConexao());
        PokemonController contPoke = new PokemonController(dao.getConexao());

        // ArrayList<Usuario> users = contUser.readAll();
        // System.out.println("=====================================");
        // for (int i = 0; i < users.size(); i++) {
        // System.out.println("ID: " + users.get(i).getID());
        // System.out.println("Nome: " + users.get(i).getNome());
        // System.out.println("Senha: " + users.get(i).getSenha());
        // System.out.println("PokPerfil: " + users.get(i).getPokPerfil());
        // System.out.println("=====================================");
        // }

        // ArrayList<Pokemon> poke = contPoke.readAll();
        // System.out.println("=====================================");
        // for (int i = 0; i < poke.size(); i++) {
        // System.out.println("ID: " + poke.get(i).getID());
        // System.out.println("Numero: " + poke.get(i).getNumero());
        // System.out.println("Nome: " + poke.get(i).getNome());
        // System.out.println("Tipo 1: " + poke.get(i).getTipo1());
        // System.out.println("Tipo 2: " + poke.get(i).getTipo2());
        // System.out.println("HP: " + poke.get(i).getHP());
        // System.out.println("Attack: " + poke.get(i).getAttack());
        // System.out.println("Defense: " + poke.get(i).getDefense());
        // System.out.println("Sp. Atk: " + poke.get(i).getSpAtk());
        // System.out.println("Sp. Def: " + poke.get(i).getSpDef());
        // System.out.println("Speed: " + poke.get(i).getSpeed());
        // System.out.println("Mega: " + poke.get(i).isMega());
        // System.out.println("Lendario: " + poke.get(i).isLendario());
        // System.out.println("Regiao: " + poke.get(i).getRegiao());
        // System.out.println("=====================================");
        // }

        // ArrayList<Relacionamento> relac = contRelac.readAll();
        // System.out.println("=====================================");
        // for (int i = 0; i < relac.size(); i++) {
        // System.out.println("ID Usuario: " + relac.get(i).getUsuario_ID());
        // System.out.println("ID Pokemon: " + relac.get(i).getPokemon_ID());
        // System.out.println("=====================================");
        // }

        // Usuario userByID = contUser.readByID(3);
        // System.out.println("=====================================");
        // System.out.println("ID: " + userByID.getID());
        // System.out.println("Nome: " + userByID.getNome());
        // System.out.println("Senha: " + userByID.getSenha());
        // System.out.println("PokPerfil: " + userByID.getPokPerfil());
        // System.out.println("=====================================");

        // Usuario userByName = contUser.readByName("BrunowLOL");
        // System.out.println("=====================================");
        // System.out.println("ID: " + userByName.getID());
        // System.out.println("Nome: " + userByName.getNome());
        // System.out.println("Senha: " + userByName.getSenha());
        // System.out.println("PokPerfil: " + userByName.getPokPerfil());
        // System.out.println("=====================================");

        // System.out.println(contRelac.existRelationByIDs(1, 384));
        // System.out.println(contRelac.existRelationByNames("IKazart", "Rayquaza"));
        // System.out.println(contRelac.existRelationByNames("IKazart", "Mewtwo"));
        // System.out.println(contRelac.existRelationByIDs(3, 150));

        // Pokemon poke = contPoke.readByName("Mewtwo");
        // System.out.println("=====================================");
        // System.out.println("ID: " + poke.getID());
        // System.out.println("Numero: " + poke.getNumero());
        // System.out.println("Nome: " + poke.getNome());
        // System.out.println("Tipo 1: " + poke.getTipo1());
        // System.out.println("Tipo 2: " + poke.getTipo2());
        // System.out.println("HP: " + poke.getHP());
        // System.out.println("Attack: " + poke.getAttack());
        // System.out.println("Defense: " + poke.getDefense());
        // System.out.println("Sp. Atk: " + poke.getSpAtk());
        // System.out.println("Sp. Def: " + poke.getSpDef());
        // System.out.println("Speed: " + poke.getSpeed());
        // System.out.println("Mega: " + poke.isMega());
        // System.out.println("Lendario: " + poke.isLendario());
        // System.out.println("Regiao: " + poke.getRegiao());
        // System.out.println("=====================================");

        try {
            dao.getConexao().close();
        } catch (SQLException e) {
            System.err.println("Erro fechando conexao => " + e.getMessage());
        }
    }
}
