package app.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import app.main.entities.Relacionamento;
import app.main.repositories.RelacionamentoRepository;

@Service
@Component
public class RelacionamentoService {
    private final RelacionamentoRepository relacRepo;

    @Autowired
    public RelacionamentoService(RelacionamentoRepository relacRepo) {
        this.relacRepo = relacRepo;
    }

    @GetMapping
    public List<Relacionamento> readAll() {
        return relacRepo.findAll();
    }
}
