import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    static DAO dao = new DAO();
    static Statement stat = null;

    public static void main(String[] args) {
        dao.connectBD();
        try {
            stat = dao.getConexao().createStatement();
            System.out.println("Connection established!");
        } catch (SQLException e) {
            System.err.println("ERROR => " + e.getMessage());
        }
        File arq = new File("./../pokemon.csv");
        Scanner sc = null;
        try {
            sc = new Scanner(arq);
        } catch (FileNotFoundException e) {
            System.err.println("ERROR => " + e.getMessage());
        }

        sc.nextLine();
        for (int i = 0; i < 1037; i++) {
            String pokeStats[] = sc.nextLine().split(",");
            if (Integer.parseInt(pokeStats[1]) == 1) {
                setPoke(pokeStats);
            }
        }
        System.out.println("Pokemon database successfully added!");
    }

    public static void setPoke(String poke[]) {
        Pokemon pokemon = new Pokemon(Integer.parseInt(poke[0]), poke[2], poke[3], Integer.parseInt(poke[8]),
                Integer.parseInt(poke[9]), Integer.parseInt(poke[10]), Integer.parseInt(poke[11]),
                Integer.parseInt(poke[12]), Integer.parseInt(poke[13]));

        if (poke[4].length() == 0) {
            pokemon.setTipo2(null);
        } else {
            pokemon.setTipo2(poke[4]);
        }

        switch (Integer.parseInt(poke[5])) {
            case 1:
                pokemon.setRegiao("Kanto");
                break;
            case 2:
                pokemon.setRegiao("Johto");
                break;
            case 3:
                pokemon.setRegiao("Hoenn");
                break;
            case 4:
                pokemon.setRegiao("Sinnoh");
                break;
            case 5:
                pokemon.setRegiao("Unova");
                break;
            case 6:
                pokemon.setRegiao("Kalos");
                break;
            case 7:
                pokemon.setRegiao("Alola");
                break;
            case 8:
                pokemon.setRegiao("Galar");
                break;
            default:
                System.err.println("ERROR WITH REGION!");
                break;
        }

        if (Integer.parseInt(poke[6]) == 1) {
            pokemon.setLendario(true);
        } else {
            pokemon.setLendario(false);
        }

        if (Integer.parseInt(poke[7]) == 1) {
            pokemon.setMega(true);
        } else {
            pokemon.setMega(false);
        }

        String update = ("INSERT INTO Pokemon VALUES(" + pokemon.getNumero() + "," + pokemon.getAtk() + ", "
                + pokemon.getDef() + ", " + pokemon.getHp() + ", " + poke[6] + ", " + poke[7] + ", " + pokemon.getNome()
                + ", '" + pokemon.getRegiao() + "', " + pokemon.getSpatk() + ", " + pokemon.getSpdef() + ", "
                + pokemon.getSpd() + ", " + pokemon.getTipo1() + ", " + pokemon.getTipo2() + ");");
        try {
            stat.executeUpdate(update);
        } catch (SQLException e) {
            System.err.println("ERROR ADDING POKEMON " + pokemon.getNome() + ". " + e.getMessage());
        }
    }
}
