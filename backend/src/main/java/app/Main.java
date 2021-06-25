package app;

import spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        DAO dao = new DAO();

        System.out.println(dao.getConexao());
    }
}
