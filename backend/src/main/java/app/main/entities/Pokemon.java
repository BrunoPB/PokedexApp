package app.main.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "Pokemon")
public class Pokemon {

    @Id
    @Column(nullable = false, name = "Numero", unique = true)
    private Integer Numero;

    @Column(nullable = false, name = "Nome", length = 30, unique = true)
    private String Nome;

    @Column(nullable = false, name = "Tipo1", length = 10)
    private String Tipo1;

    @Column(nullable = true, name = "Tipo2", length = 10)
    private String Tipo2;

    @Column(nullable = false, name = "HP")
    private Integer HP;

    @Column(nullable = false, name = "Attack")
    private Integer Attack;

    @Column(nullable = false, name = "Defense")
    private Integer Defense;

    @Column(nullable = false, name = "SpAtk")
    private Integer SpAtk;

    @Column(nullable = false, name = "SpDef")
    private Integer SpDef;

    @Column(nullable = false, name = "Speed")
    private Integer Speed;

    @Column(nullable = false, name = "Mega")
    private boolean Mega;

    @Column(nullable = false, name = "Lendario")
    private boolean Lendario;

    @Column(nullable = false, name = "Regiao", length = 15)
    private String Regiao;

    @ManyToMany(mappedBy = "Pokemons")
    private List<Usuario> Usuarios = new ArrayList<Usuario>();

    // Constructors
    public Pokemon() {
    }

    public Pokemon(Integer numero, String nome, String tipo1, Integer hp, Integer attack, Integer defense,
            Integer spatk, Integer spdef, Integer speed, boolean mega, boolean lendario, String regiao) {
        this.Numero = numero;
        this.Nome = nome;
        this.Tipo1 = tipo1;
        this.Tipo2 = null;
        this.HP = hp;
        this.Attack = attack;
        this.Defense = defense;
        this.SpAtk = spatk;
        this.SpDef = spdef;
        this.Speed = speed;
        this.Mega = mega;
        this.Lendario = lendario;
        this.Regiao = regiao;
    }

    public Pokemon(Integer numero, String nome, String tipo1, String tipo2, Integer hp, Integer attack, Integer defense,
            Integer spatk, Integer spdef, Integer speed, boolean mega, boolean lendario, String regiao) {
        this.Numero = numero;
        this.Nome = nome;
        this.Tipo1 = tipo1;
        this.Tipo2 = tipo2;
        this.HP = hp;
        this.Attack = attack;
        this.Defense = defense;
        this.SpAtk = spatk;
        this.SpDef = spdef;
        this.Speed = speed;
        this.Mega = mega;
        this.Lendario = lendario;
        this.Regiao = regiao;
    }

    public Pokemon(Pokemon pokemon) {
        this.Numero = pokemon.Numero;
        this.Nome = pokemon.Nome;
        this.Tipo1 = pokemon.Tipo1;
        this.Tipo2 = pokemon.Tipo2;
        this.HP = pokemon.HP;
        this.Attack = pokemon.Attack;
        this.Defense = pokemon.Defense;
        this.SpAtk = pokemon.SpAtk;
        this.SpDef = pokemon.SpDef;
        this.Speed = pokemon.Speed;
        this.Mega = pokemon.Mega;
        this.Lendario = pokemon.Lendario;
        this.Regiao = pokemon.Regiao;
    }

    // Getters and Setters
    public Integer getNumero() {
        return this.Numero;
    }

    public void setNumero(Integer Numero) {
        this.Numero = Numero;
    }

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getTipo1() {
        return this.Tipo1;
    }

    public void setTipo1(String Tipo1) {
        this.Tipo1 = Tipo1;
    }

    public String getTipo2() {
        return this.Tipo2;
    }

    public void setTipo2(String Tipo2) {
        this.Tipo2 = Tipo2;
    }

    public Integer getHP() {
        return this.HP;
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    public Integer getAttack() {
        return this.Attack;
    }

    public void setAttack(Integer Attack) {
        this.Attack = Attack;
    }

    public Integer getDefense() {
        return this.Defense;
    }

    public void setDefense(Integer Defense) {
        this.Defense = Defense;
    }

    public Integer getSpAtk() {
        return this.SpAtk;
    }

    public void setSpAtk(Integer SpAtk) {
        this.SpAtk = SpAtk;
    }

    public Integer getSpDef() {
        return this.SpDef;
    }

    public void setSpDef(Integer SpDef) {
        this.SpDef = SpDef;
    }

    public Integer getSpeed() {
        return this.Speed;
    }

    public void setSpeed(Integer Speed) {
        this.Speed = Speed;
    }

    public boolean isMega() {
        return this.Mega;
    }

    public void setMega(boolean Mega) {
        this.Mega = Mega;
    }

    public boolean isLendario() {
        return this.Lendario;
    }

    public void setLendario(boolean Lendario) {
        this.Lendario = Lendario;
    }

    public String getRegiao() {
        return this.Regiao;
    }

    public void setRegiao(String Regiao) {
        this.Regiao = Regiao;
    }
}
