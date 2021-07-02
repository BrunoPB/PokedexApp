package app.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.main.entities.Usuario;
import app.main.repositories.UsuarioRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/usuarios")
    public List<Usuario> readAll() {
        return usuarioRepository.findAll();
    }

    @PostMapping("/usuarios")
    public void add(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    // Statement stat = null;
    // ResultSet rs = null;

    // public UsuarioController(Connection conexao) {
    // try {
    // this.stat = conexao.createStatement();
    // } catch (Exception e) {
    // System.out.println("Erro criando o Statement => " + e.getMessage());
    // }
    // }

    // public void add(Usuario user) {
    // String comandosql = ("INSERT INTO Usuario (ID, Nome, Senha) VALUES (" +
    // user.getID() + ", '" + user.getNome()
    // + "', '" + user.getSenha() + "');");
    // doCUD(comandosql);
    // }

    // public void update(Usuario user) {
    // String comandosql = ("UPDATE Usuario SET Nome = '" + user.getNome() + "',
    // Senha = '" + user.getSenha() + "'");
    // if (user.getPokPerfil() > 0) {
    // comandosql += (", PokPerfil = " + user.getPokPerfil());
    // }
    // comandosql += (" WHERE ID = " + user.getID() + ";");
    // doCUD(comandosql);
    // }

    // public void delete(Integer id) {
    // String comandosql = ("DELETE FROM Usuario WHERE ID = " + id + ";");
    // doCUD(comandosql);
    // }

    // private void doCUD(String comandosql) {
    // try {
    // stat.executeUpdate(comandosql);
    // } catch (SQLException e) {
    // System.err.println("Erro ao executar o comando SQL => " + e.getMessage());
    // }
    // }

    // public ArrayList<Usuario> readAll() {
    // String comandosql = "SELECT * FROM Usuario;";
    // ArrayList<Usuario> QueryUsers = new ArrayList<>();
    // try {
    // rs = stat.executeQuery(comandosql);
    // while (rs.next()) {
    // Usuario user = new Usuario(rs.getInt("ID"), rs.getString("Nome"),
    // rs.getString("Senha"),
    // rs.getInt("PokPerfil"));
    // QueryUsers.add(user);
    // }
    // } catch (SQLException e) {
    // System.err.println("Erro ao fazer Query => " + e.getMessage());
    // }
    // return QueryUsers;
    // }

    // @GetMapping(path = "/api/usuario/{id}")
    // public Usuario readByID(@PathVariable("id") Integer id) {
    // String comandosql = ("SELECT * FROM Usuario WHERE ID = " + id + ";");
    // Usuario user = null;
    // try {
    // rs = stat.executeQuery(comandosql);
    // rs.next();
    // user = new Usuario(id, rs.getString("Nome"), rs.getString("Senha"),
    // rs.getInt("PokPerfil"));
    // } catch (SQLException e) {
    // System.err.println("Erro ao fazer Query => " + e.getMessage());
    // }
    // return user;
    // }

    // public Usuario readByName(String nome) {
    // String comandosql = ("SELECT * FROM Usuario WHERE Nome = '" + nome + "';");
    // Usuario user = null;
    // try {
    // rs = stat.executeQuery(comandosql);
    // rs.next();
    // user = new Usuario(rs.getInt("ID"), nome, rs.getString("Senha"),
    // rs.getInt("PokPerfil"));
    // } catch (SQLException e) {
    // System.err.println("Erro ao fazer Query => " + e.getMessage());
    // }
    // return user;
    // }
}
