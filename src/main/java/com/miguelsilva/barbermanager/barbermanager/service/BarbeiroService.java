package com.miguelsilva.barbermanager.barbermanager.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.miguelsilva.barbermanager.barbermanager.model.Barbeiro;
import com.miguelsilva.barbermanager.barbermanager.repository.BarbeiroRepository;

@Service
public class BarbeiroService {

    private final BarbeiroRepository repo;

    public BarbeiroService(BarbeiroRepository repo) {
        this.repo = repo;
    }

    public List<Barbeiro> listar() {
        return repo.findAll();
    }

    public Barbeiro salvar(Barbeiro b) {
        return repo.save(b);
    }

    public Barbeiro buscar(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
