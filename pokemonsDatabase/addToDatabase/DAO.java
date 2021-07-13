import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/PokedexAppDB";
    private String user = "brunosql";
    private String senha = "Acessosql#Dex";
    private Connection conexao = null;

    public DAO() {
    }

    public void connectBD() {
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, senha);
            System.out.println("Driver carregado!");
        } catch (Exception e) {
            System.err.println("ERROR => " + e.getMessage());
        }
    }

    public Connection getConexao() {
        return conexao;
    }
}