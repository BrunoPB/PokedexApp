package app.main.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer ID;

    @Column(nullable = false, length = 30, name = "Nome", unique = true)
    private String Nome;

    @Column(nullable = false, length = 30, name = "Senha")
    private String Senha;

    @Column(nullable = true, name = "PokPerfil")
    private Integer PokPerfil;

    @ManyToMany
    @JoinTable(name = "Relacionamento", joinColumns = @JoinColumn(name = "ID_Usuario"), inverseJoinColumns = @JoinColumn(name = "N_Pokemon"))
    private List<Pokemon> Pokemons = new ArrayList<Pokemon>();

    // Getters and Setters
    public Integer getID() {
        return this.ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getSenha() {
        return this.Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public Integer getPokPerfil() {
        return this.PokPerfil;
    }

    public void setPokPerfil(Integer PokPerfil) {
        this.PokPerfil = PokPerfil;
    }

    // Constructors
    public Usuario(Integer id, String nome, String senha, Integer pokperfil) {
        this.ID = id;
        this.Nome = nome;
        this.Senha = senha;
        this.PokPerfil = pokperfil;
    }

    public Usuario(Integer id, String nome, String senha) {
        this.ID = id;
        this.Nome = nome;
        this.Senha = senha;
        this.PokPerfil = null;
    }

    public Usuario(Usuario usuario) {
        this.ID = usuario.ID;
        this.Nome = usuario.Nome;
        this.Senha = usuario.Senha;
        this.PokPerfil = usuario.PokPerfil;
    }
}
