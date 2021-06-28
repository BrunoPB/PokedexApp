package app.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import app.entities.Relacionamento;

public class RelacionamentoController {
    Statement stat = null;

    public RelacionamentoController(Connection conexao) {
        try {
            this.stat = conexao.createStatement();
        } catch (Exception e) {
            System.out.println("Erro criando o Statement => " + e.getMessage());
        }
    }

    public void add(Relacionamento relac) {
        String comandosql = ("INSERT INTO Relacionamento VALUES (" + relac.getUsuario_ID() + ", "
                + relac.getPokemon_ID() + ");");
        doCUD(comandosql);
    }

    public void delete(Relacionamento relac) {
        String comandosql = ("DELETE FROM Relacionamento WHERE Usuario_ID = " + relac.getUsuario_ID()
                + " AND Pokemon_ID = " + relac.getPokemon_ID() + ";");
        doCUD(comandosql);
    }

    private void doCUD(String comandosql) {
        try {
            stat.executeUpdate(comandosql);
        } catch (SQLException e) {
            System.err.println("Erro ao executar o comando => " + e.getMessage());
        }
    }
}
