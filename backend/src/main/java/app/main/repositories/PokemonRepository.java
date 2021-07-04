package app.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.main.entities.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    @Query("SELECT p FROM Pokemon p WHERE p.Nome = ?1")
    public Pokemon findByName(String nome);
}
