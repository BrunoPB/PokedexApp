package app.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import app.entities.Usuario;

public class UsuarioController {
    Statement stat = null;

    public UsuarioController(Connection conexao) {
        try {
            this.stat = conexao.createStatement();
        } catch (Exception e) {
            System.out.println("Erro criando o Statement => " + e.getMessage());
        }
    }

    public void add(Usuario user) {
        String comandosql = ("INSERT INTO Usuario (ID, Nome, Senha) VALUES (" + user.getID() + ", '" + user.getNome()
                + "', '" + user.getSenha() + "');");
        doCUD(comandosql);
    }

    public void update(Usuario user) {
        String comandosql = ("UPDATE Usuario SET Nome = '" + user.getNome() + "', Senha = '" + user.getSenha() + "'");
        if (user.getPokPerfil() > 0) {
            comandosql += (", PokPerfil = " + user.getPokPerfil());
        }
        comandosql += (" WHERE ID = " + user.getID() + ";");
        doCUD(comandosql);
    }

    public void delete(int id) {
        String comandosql = ("DELETE FROM Usuario WHERE ID = " + id + ";");
        doCUD(comandosql);
    }

    private void doCUD(String comandosql) {
        try {
            stat.executeUpdate(comandosql);
        } catch (SQLException e) {
            System.err.println("Erro ao executar o comando SQL => " + e.getMessage());
        }
    }
}