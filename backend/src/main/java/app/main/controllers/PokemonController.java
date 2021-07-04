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
@CrossOrigin("http://localhost:4200")
@RequestMapping("/pokemons")
public class PokemonController {

    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonController(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @GetMapping()
    @ResponseBody
    public List<Pokemon> readAll() {
        return (List<Pokemon>) pokemonRepository.findAll();
    }

    @GetMapping(path = "/number/{number}")
    @ResponseBody
    public Pokemon readOne(@PathVariable Integer number) {
        return pokemonRepository.findById(number).get();
    }

    @GetMapping(path = "/name/{name}")
    @ResponseBody
    public Pokemon readOne(@PathVariable String name) {
        return pokemonRepository.findByName(name);
    }

    @PostMapping()
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

    @PutMapping()
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
}
