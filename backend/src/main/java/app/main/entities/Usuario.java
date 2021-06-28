package app.main.entities;

public class Usuario {
    private int ID;
    private String Nome;
    private String Senha;
    private int PokPerfil;

    // Getters and Setters
    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
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

    public int getPokPerfil() {
        return this.PokPerfil;
    }

    public void setPokPerfil(int PokPerfil) {
        this.PokPerfil = PokPerfil;
    }

    // Constructors
    public Usuario(int id, String nome, String senha, int pokperfil) {
        this.ID = id;
        this.Nome = nome;
        this.Senha = senha;
        this.PokPerfil = pokperfil;
    }

    public Usuario(int id, String nome, String senha) {
        this.ID = id;
        this.Nome = nome;
        this.Senha = senha;
        this.PokPerfil = 0;
    }

    public Usuario(Usuario usuario) {
        this.ID = usuario.ID;
        this.Nome = usuario.Nome;
        this.Senha = usuario.Senha;
        this.PokPerfil = usuario.PokPerfil;
    }
}
