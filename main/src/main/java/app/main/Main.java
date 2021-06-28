package app.main;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.main.controllers.PokemonController;
import app.main.controllers.RelacionamentoController;
import app.main.controllers.UsuarioController;
import app.main.entities.Usuario;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

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
