package app.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.main.entities.Pokemon;
import app.main.repositories.PokemonRepository;

@Service
@Component
public class PokemonService {
    private final PokemonRepository pokeRepo;

    @Autowired
    public PokemonService(PokemonRepository pokeRepo) {
        this.pokeRepo = pokeRepo;
    }

    public List<Pokemon> readAll() {
        return pokeRepo.findAll();
    }
}
