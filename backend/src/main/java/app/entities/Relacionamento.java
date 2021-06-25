package app.entities;

public class Relacionamento {
    private int Usuario_ID;
    private int Pokemon_ID;

    // Getters and Setter
    public int getUsuario_ID() {
        return this.Usuario_ID;
    }

    public void setUsuario_ID(int Usuario_ID) {
        this.Usuario_ID = Usuario_ID;
    }

    public int getPokemon_ID() {
        return this.Pokemon_ID;
    }

    public void setPokemon_ID(int Pokemon_ID) {
        this.Pokemon_ID = Pokemon_ID;
    }

    // Constructors
    public Relacionamento(int usuario_id, int pokemon_id) {
        this.Usuario_ID = usuario_id;
        this.Pokemon_ID = pokemon_id;
    }

    public Relacionamento(Relacionamento relacionamento) {
        this.Usuario_ID = relacionamento.Usuario_ID;
        this.Pokemon_ID = relacionamento.Pokemon_ID;
    }
}
