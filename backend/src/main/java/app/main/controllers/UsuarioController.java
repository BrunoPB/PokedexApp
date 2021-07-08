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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.main.entities.Pokemon;
import app.main.entities.Usuario;
import app.main.repositories.PokemonRepository;
import app.main.repositories.UsuarioRepository;

@RestController
@CrossOrigin("http://localhost:4200")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository, PokemonRepository pokemonRepository) {
        this.usuarioRepository = usuarioRepository;
        this.pokemonRepository = pokemonRepository;
    }

    @GetMapping(path = "/usuarios")
    public List<Usuario> readAll() {
        return usuarioRepository.findAll();
    }

    @GetMapping(path = "/usuarios/id/{id}")
    @ResponseBody
    public Usuario readOne(@PathVariable Integer id) {
        return usuarioRepository.findById(id).get();
    }

    @GetMapping(path = "/usuarios/nome/{nome}")
    @ResponseBody
    public Usuario readByName(@PathVariable String nome) {
        return usuarioRepository.findByName(nome);
    }

    @PostMapping(path = "/usuarios")
    @ResponseBody
    public Usuario add(@RequestParam String nome, @RequestParam String senha,
            @RequestParam(required = false) Integer pokperfil) {
        Usuario user = new Usuario(nome, senha, pokperfil);
        usuarioRepository.save(user);
        return user;
    }

    @PutMapping(path = "/usuarios")
    @ResponseBody
    public Usuario update(@RequestParam String nome, @RequestParam String senha,
            @RequestParam(required = false) Integer pokperfil) {
        Usuario user = usuarioRepository.findByName(nome);
        if (user != null) {
            user = new Usuario(nome, senha, pokperfil);
            usuarioRepository.save(user);
        } else {
            System.err.println("Erro => Usuario inexistente. Nao foi possivel exclui-lo.");
        }
        return user;
    }

    @DeleteMapping(path = "/usuarios/delete/{id}")
    @ResponseBody
    public Optional<Usuario> delete(@PathVariable Integer id) {
        Optional<Usuario> item = usuarioRepository.findById(id);
        if (item.isPresent()) {
            usuarioRepository.deleteById(id);
        } else {
            System.err.println("Erro => Usuario inexistente." + " Nao foi possivel exclui-lo.");
        }
        return item;
    }

    // ==================RELACIONAMENTO CONTROLLER==================
    private final PokemonRepository pokemonRepository;

    @GetMapping(path = "/relacionamento/usuario/{id}")
    @ResponseBody
    public List<Pokemon> getRelationUsuario(@PathVariable Integer id) {
        List<Pokemon> userPokeList = usuarioRepository.findById(id).get().getPokemons();
        System.out.println(userPokeList);
        if (userPokeList == null) {
            System.err.println("Erro => Nao foi possivel encontrar relacionamentos."
                    + " Esse usuario existe? Ele tem esse Pokemon?");
        }
        return userPokeList;
    }

    @PostMapping(path = "/relacionamento")
    public void addRelation(@RequestParam Integer idUser, @RequestParam Integer nPoke) {
        Optional<Usuario> user = usuarioRepository.findById(idUser);
        if (user.isPresent()) {
            Optional<Pokemon> poke = pokemonRepository.findById(nPoke);
            if (poke.isPresent()) {
                user.get().getPokemons().add(poke.get());
                poke.get().getUsuarios().add(user.get());
                usuarioRepository.save(user.get());
                pokemonRepository.save(poke.get());
            } else {
                System.err.println("Erro => Pokemon inexistente. " + "Nao foi possivel criar o relacionamento.");
            }
        } else {
            System.err.println("Erro => Usuario inexistente. " + "Nao foi possivel criar o relacionamento.");
        }
    }

    @DeleteMapping(path = "/relacionamento/deletepokemon/{nPoke}/from/{idUser}")
    public void deleteRelation(@PathVariable Integer idUser, @PathVariable Integer nPoke) {
        Optional<Usuario> user = usuarioRepository.findById(idUser);
        if (user.isPresent()) {
            Optional<Pokemon> poke = pokemonRepository.findById(nPoke);
            if (poke.isPresent()) {
                List<Pokemon> pokeList = user.get().getPokemons();
                if (pokeList.contains(poke.get())) {
                    user.get().getPokemons().remove(poke.get());
                    poke.get().getUsuarios().remove(user.get());
                    usuarioRepository.save(user.get());
                    pokemonRepository.save(poke.get());
                } else {
                    System.err.println("Erro => Relação inexistente. " + "Nao foi possivel apagar o relacionamento.");
                }
            } else {
                System.err.println("Erro => Pokemon inexistente." + " Nao foi possivel apagar o relacionamento.");
            }
        } else {
            System.err.println("Erro => Usuario inexistente. " + "Nao foi possivel apagar o relacionamento.");
        }
    }

}
