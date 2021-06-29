package app.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Pokemon")
public class Pokemon {
    @Id
    private int ID;

    @Column(nullable = false, name = "Numero")
    private int Numero;

    @Column(nullable = false, name = "Nome", length = 30)
    private String Nome;

    @Column(nullable = false, name = "Tipo1", length = 10)
    private String Tipo1;

    @Column(nullable = true, name = "Tipo2", length = 10)
    private String Tipo2;

    @Column(nullable = false, name = "HP")
    private int HP;

    @Column(nullable = false, name = "Attack")
    private int Attack;

    @Column(nullable = false, name = "Defense")
    private int Defense;

    @Column(nullable = false, name = "Sp. Atk")
    private int SpAtk;

    @Column(nullable = false, name = "Sp. Def")
    private int SpDef;

    @Column(nullable = false, name = "Speed")
    private int Speed;

    @Column(nullable = false, name = "Mega")
    private boolean Mega;

    @Column(nullable = false, name = "Lendario")
    private boolean Lendario;

    @Column(nullable = false, name = "Regiao", length = 15)
    private String Regiao;

    // Constructors
    public Pokemon(int id, int numero, String nome, String tipo1, String tipo2, int hp, int attack, int defense,
            int spatk, int spdef, int speed, boolean mega, boolean lendario, String regiao) {
        this.ID = id;
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
        this.ID = pokemon.ID;
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
    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNumero() {
        return this.Numero;
    }

    public void setNumero(int Numero) {
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

    public int getHP() {
        return this.HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttack() {
        return this.Attack;
    }

    public void setAttack(int Attack) {
        this.Attack = Attack;
    }

    public int getDefense() {
        return this.Defense;
    }

    public void setDefense(int Defense) {
        this.Defense = Defense;
    }

    public int getSpAtk() {
        return this.SpAtk;
    }

    public void setSpAtk(int SpAtk) {
        this.SpAtk = SpAtk;
    }

    public int getSpDef() {
        return this.SpDef;
    }

    public void setSpDef(int SpDef) {
        this.SpDef = SpDef;
    }

    public int getSpeed() {
        return this.Speed;
    }

    public void setSpeed(int Speed) {
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
