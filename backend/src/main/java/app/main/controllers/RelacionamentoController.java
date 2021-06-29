package app.main.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.main.entities.Relacionamento;
import app.main.services.RelacionamentoService;

@RestController
@RequestMapping(path = "/api/relacionamento")
public class RelacionamentoController {

    private final RelacionamentoService relacionamentoService;

    @Autowired
    public RelacionamentoController(RelacionamentoService relacionamentoService) {
        this.relacionamentoService = relacionamentoService;
    }

    @GetMapping
    public List<Relacionamento> readAll() {
        return relacionamentoService.readAll();
    }

    // Statement stat = null;
    // ResultSet rs = null;

    // public RelacionamentoController(Connection conexao) {
    // try {
    // this.stat = conexao.createStatement();
    // } catch (Exception e) {
    // System.out.println("Erro criando o Statement => " + e.getMessage());
    // }
    // }

    // public void add(Relacionamento relac) {
    // String comandosql = ("INSERT INTO Relacionamento VALUES (" +
    // relac.getUsuario_ID() + ", "
    // + relac.getPokemon_ID() + ");");
    // doCUD(comandosql);
    // }

    // public void delete(Relacionamento relac) {
    // String comandosql = ("DELETE FROM Relacionamento WHERE Relacionamento_ID = "
    // + relac.getUsuario_ID()
    // + " AND Pokemon_ID = " + relac.getPokemon_ID() + ";");
    // doCUD(comandosql);
    // }

    // private void doCUD(String comandosql) {
    // try {
    // stat.executeUpdate(comandosql);
    // } catch (SQLException e) {
    // System.err.println("Erro ao executar o comando => " + e.getMessage());
    // }
    // }

    // public ArrayList<Relacionamento> readAll() {
    // String comandosql = "SELECT * FROM Relacionamento;";
    // ArrayList<Relacionamento> QueryRelacs = new ArrayList<>();
    // try {
    // rs = stat.executeQuery(comandosql);
    // while (rs.next()) {
    // Relacionamento relac = new Relacionamento(rs.getInt("Usuario_ID"),
    // rs.getInt("Pokemon_ID"));
    // QueryRelacs.add(relac);
    // }
    // } catch (SQLException e) {
    // System.err.println("Erro ao fazer Query => " + e.getMessage());
    // }
    // return QueryRelacs;
    // }

    // public boolean existRelationByIDs(int idUser, int idPoke) {
    // boolean exists = false;
    // String comandosql = ("SELECT * FROM Relacionamento WHERE Usuario_ID = " +
    // idUser + " AND Pokemon_ID = " + idPoke
    // + ";");
    // try {
    // rs = stat.executeQuery(comandosql);
    // if (rs.next()) {
    // exists = true;
    // }
    // } catch (SQLException e) {
    // System.err.println("Erro ao fazer Query => " + e.getMessage());
    // }
    // return exists;
    // }

    // public boolean existRelationByNames(String user, String poke) {
    // boolean exists = false;
    // String comandosql = ("SELECT Usuario.Nome, Pokemon.Nome FROM Usuario JOIN
    // Relacionamento ON Usuario.ID = Relacionamento.Usuario_ID JOIN Pokemon ON
    // Pokemon.ID = Relacionamento.Pokemon_ID WHERE Usuario.Nome = '"
    // + user + "' AND Pokemon.Nome = '" + poke + "';");
    // try {
    // rs = stat.executeQuery(comandosql);
    // if (rs.next()) {
    // exists = true;
    // }

    // } catch (SQLException e) {
    // System.err.println("Erro ao fazer Query => " + e.getMessage());
    // }
    // return exists;
    // }
}
