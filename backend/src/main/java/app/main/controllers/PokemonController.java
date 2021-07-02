package app.main.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.main.entities.Pokemon;
import app.main.repositories.PokemonRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonController(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @GetMapping(path = "/get")
    @ResponseBody
    public List<Pokemon> readAll() {
        return (List<Pokemon>) pokemonRepository.findAll();
    }

    @GetMapping(path = "/get/{number}")
    @ResponseBody
    public Pokemon readOne(@PathVariable Integer number) {
        return pokemonRepository.findById(number).get();
    }

    @PostMapping(path = "/post")
    @ResponseBody
    public Pokemon add(@RequestParam Integer numero, @RequestParam String nome, @RequestParam String tipo1,
            @RequestParam(required = false) String tipo2, @RequestParam Integer hp, @RequestParam Integer attack,
            @RequestParam Integer defense, @RequestParam Integer spatk, @RequestParam Integer spdef,
            @RequestParam Integer speed, @RequestParam boolean mega, @RequestParam boolean lendario,
            @RequestParam String regiao) {
        Pokemon poke = new Pokemon(numero, nome, tipo1, tipo2, hp, attack, defense, spatk, spdef, speed, mega, lendario,
                regiao);
        pokemonRepository.save(poke);
        return poke;
    }

    @PutMapping(path = "/update")
    @ResponseBody
    public Pokemon update(@RequestParam Integer numero, @RequestParam String nome, @RequestParam String tipo1,
            @RequestParam(required = false) String tipo2, @RequestParam Integer hp, @RequestParam Integer attack,
            @RequestParam Integer defense, @RequestParam Integer spatk, @RequestParam Integer spdef,
            @RequestParam Integer speed, @RequestParam boolean mega, @RequestParam boolean lendario,
            @RequestParam String regiao) {
        Pokemon poke = new Pokemon(numero, nome, tipo1, tipo2, hp, attack, defense, spatk, spdef, speed, mega, lendario,
                regiao);
        pokemonRepository.save(poke);
        return poke;
    }

    @DeleteMapping(path = "/delete/{number}")
    @ResponseBody
    public Optional<Pokemon> delete(@PathVariable Integer number) {
        Optional<Pokemon> item = pokemonRepository.findById(number);
        if (item.isPresent()) {
            pokemonRepository.deleteById(number);
        } else {
            System.err.println("Erro => Pokemon inexistente. Nao foi possivel exclui-lo.");
        }
        return item;
    }

    // Statement stat = null;
    // ResultSet rs = null;

    // public PokemonController(Connection conexao) {
    // try {
    // this.stat = conexao.createStatement();
    // } catch (Exception e) {
    // System.out.println("Erro criando o Statement => " + e.getMessage());
    // }
    // }

    // public void add(Pokemon pokemon) {
    // String comandosql = ("INSERT INTO Pokemon ");
    // boolean tipo2 = (pokemon.getTipo2() != null);
    // if (!tipo2) {
    // comandosql += ("(ID, Numero, Nome, Tipo1, HP, Attack, Defense, `Sp. Atk`,
    // `Sp. Def`, Speed, Mega, Lendario, Regiao) ");
    // }
    // comandosql += ("VALUES (" + pokemon.getID() + ", " + pokemon.getNumero() + ",
    // '" + pokemon.getNome() + "', '"
    // + pokemon.getTipo1() + "', ");
    // if (tipo2) {
    // comandosql += ("'" + pokemon.getTipo2() + "', ");
    // }
    // comandosql += (pokemon.getHP() + ", " + pokemon.getAttack() + ", " +
    // pokemon.getDefense() + ", "
    // + pokemon.getSpAtk() + ", " + pokemon.getSpDef() + ", " + pokemon.getSpeed()
    // + ", ");
    // if (pokemon.isMega()) {
    // comandosql += "'T', ";
    // } else {
    // comandosql += "'F', ";
    // }
    // if (pokemon.isLendario()) {
    // comandosql += "'T', ";
    // } else {
    // comandosql += "'F', ";
    // }
    // comandosql += ("'" + pokemon.getRegiao() + "');");
    // doCUD(comandosql);
    // }

    // public void delete(Integer id) {
    // String comandosql = ("DELETE FROM Pokemon WHERE ID = " + id + ";");
    // doCUD(comandosql);
    // }

    // private void doCUD(String comandosql) {
    // try {
    // stat.executeUpdate(comandosql);
    // } catch (SQLException e) {
    // System.err.println("Erro ao executar o comando => " + e.getMessage());
    // }
    // }

    // public ArrayList<Pokemon> readAll() {
    // String comandosql = "SELECT * FROM Pokemon;";
    // ArrayList<Pokemon> QueryPokemons = new ArrayList<>();
    // try {
    // rs = stat.executeQuery(comandosql);
    // while (rs.next()) {
    // Integer id = rs.getInt("ID"), numero = rs.getInt("Numero"), hp =
    // rs.getInt("HP"),
    // attack = rs.getInt("Attack"), defense = rs.getInt("Defense"), spatk =
    // rs.getInt("Sp. Atk"),
    // spdef = rs.getInt("Sp. Def"), speed = rs.getInt("Speed");
    // String nome = rs.getString("Nome"), tipo1 = rs.getString("Tipo1"), tipo2 =
    // rs.getString("Tipo2"),
    // regiao = rs.getString("Regiao");

    // boolean mega = rs.getString("Mega").equals("T") ? true : false,
    // lendario = rs.getString("Lendario").equals("T") ? true : false;

    // Pokemon poke = new Pokemon(id, numero, nome, tipo1, tipo2, hp, attack,
    // defense, spatk, spdef, speed,
    // mega, lendario, regiao);

    // QueryPokemons.add(poke);
    // }
    // } catch (SQLException e) {
    // System.err.println("Erro ao fazer Query => " + e.getMessage());
    // }
    // return QueryPokemons;
    // }

    // public Pokemon readByID(Integer id) {
    // String comandosql = ("SELECT * FROM Pokemon WHERE ID = " + id + ";");
    // Pokemon poke = null;
    // try {
    // rs = stat.executeQuery(comandosql);
    // rs.next();
    // Integer numero = rs.getInt("Numero"), hp = rs.getInt("HP"), attack =
    // rs.getInt("Attack"),
    // defense = rs.getInt("Defense"), spatk = rs.getInt("Sp. Atk"), spdef =
    // rs.getInt("Sp. Def"),
    // speed = rs.getInt("Speed");
    // String nome = rs.getString("Nome"), tipo1 = rs.getString("Tipo1"), tipo2 =
    // rs.getString("Tipo2"),
    // regiao = rs.getString("Regiao");

    // boolean mega = rs.getString("Mega").equals("T") ? true : false,
    // lendario = rs.getString("Lendario").equals("T") ? true : false;

    // poke = new Pokemon(id, numero, nome, tipo1, tipo2, hp, attack, defense,
    // spatk, spdef, speed, mega, lendario,
    // regiao);
    // } catch (SQLException e) {
    // System.err.println("Erro ao fazer Query => " + e.getMessage());
    // }
    // return poke;
    // }

    // public Pokemon readByName(String nome) {
    // String comandosql = ("SELECT * FROM Pokemon WHERE Nome = '" + nome + "';");
    // Pokemon poke = null;
    // try {
    // rs = stat.executeQuery(comandosql);
    // rs.next();
    // Integer id = rs.getInt("ID"), numero = rs.getInt("Numero"), hp =
    // rs.getInt("HP"),
    // attack = rs.getInt("Attack"),
    // defense = rs.getInt("Defense"), spatk = rs.getInt("Sp. Atk"), spdef =
    // rs.getInt("Sp. Def"),
    // speed = rs.getInt("Speed");
    // String tipo1 = rs.getString("Tipo1"), tipo2 = rs.getString("Tipo2"), regiao =
    // rs.getString("Regiao");

    // boolean mega = rs.getString("Mega").equals("T") ? true : false,
    // lendario = rs.getString("Lendario").equals("T") ? true : false;

    // poke = new Pokemon(id, numero, nome, tipo1, tipo2, hp, attack, defense,
    // spatk, spdef, speed, mega, lendario,
    // regiao);
    // } catch (SQLException e) {
    // System.err.println("Erro ao fazer Query => " + e.getMessage());
    // }
    // return poke;
    // }
}
