package app.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
        String comandosql = ("DELETE FROM Relacionamento WHERE Relacionamento_ID = " + relac.getUsuario_ID()
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

    public ArrayList<Relacionamento> readAll() {
        String comandosql = "SELECT * FROM Relacionamento;";
        ResultSet rs = null;
        ArrayList<Relacionamento> QueryRelacs = new ArrayList<>();
        try {
            rs = stat.executeQuery(comandosql);
            while (rs.next()) {
                Relacionamento relac = new Relacionamento(rs.getInt("Usuario_ID"), rs.getInt("Pokemon_ID"));
                QueryRelacs.add(relac);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fazer Query => " + e.getMessage());
        }
        return QueryRelacs;
    }
}
