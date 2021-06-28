package app;

import java.sql.SQLException;

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

        try {
            dao.getConexao().close();
        } catch (SQLException e) {
            System.err.println("Erro fechando conexao => " + e.getMessage());
        }
    }
}
