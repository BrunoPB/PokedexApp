package app;

import java.sql.*;

public class DAO {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String porta = "3306";
    private String database = "Pokedex";
    private String user = "brunosql";
    private String senha = "Acessosql#Dex";
    private Connection conexao = null;

    public DAO() {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            System.out.println("Falha no carregamento do Driver: " + e.getMessage());
        }
        try {
            String url = ("jdbc:mysql://localhost:" + porta + "/" + database);
            conexao = DriverManager.getConnection(url, user, senha);
        } catch (Exception e) {
            System.out.println("Falha na conexao com o Banco de Dados: " + e.getMessage());
        }
    }

    public Connection getConexao() {
        return this.conexao;
    }
}
