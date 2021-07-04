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

import app.main.entities.Usuario;
import app.main.repositories.UsuarioRepository;

@RestController
@CrossOrigin("localhost:4200")
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping()
    public List<Usuario> readAll() {
        return usuarioRepository.findAll();
    }

    @GetMapping(path = "/id/{id}")
    @ResponseBody
    public Usuario readOne(@PathVariable Integer id) {
        return usuarioRepository.findById(id).get();
    }

    @PostMapping()
    @ResponseBody
    public Usuario add(@RequestParam String nome, @RequestParam String senha,
            @RequestParam(required = false) Integer pokperfil) {
        Usuario user = new Usuario(nome, senha, pokperfil);
        usuarioRepository.save(user);
        return user;
    }

    @PutMapping()
    @ResponseBody
    public Usuario update(@RequestParam String nome, @RequestParam String senha,
            @RequestParam(required = false) Integer pokperfil) {
        Usuario user = new Usuario(nome, senha, pokperfil);
        usuarioRepository.save(user);
        return user;
    }

    @DeleteMapping(path = "/delete/{id}")
    @ResponseBody
    public Optional<Usuario> delete(@PathVariable Integer id) {
        Optional<Usuario> item = usuarioRepository.findById(id);
        if (item.isPresent()) {
            usuarioRepository.deleteById(id);
        } else {
            System.err.println("Erro => Usuario inexistente. Nao foi possivel exclui-lo.");
        }
        return item;
    }
}
