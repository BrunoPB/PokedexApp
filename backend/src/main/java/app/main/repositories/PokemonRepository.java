package app.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.main.entities.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

}
