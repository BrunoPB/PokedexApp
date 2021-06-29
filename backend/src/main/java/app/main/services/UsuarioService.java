package app.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import app.main.entities.Usuario;
import app.main.repositories.UsuarioRepository;

@Service
@Component
public class UsuarioService {
    private final UsuarioRepository userRepo;

    @Autowired
    public UsuarioService(UsuarioRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public List<Usuario> readAll() {
        return userRepo.findAll();
    }
}
