package com.miguelsilva.barbermanager.barbermanager.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.miguelsilva.barbermanager.barbermanager.model.Cliente;
import com.miguelsilva.barbermanager.barbermanager.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Cliente salvar(Cliente c) {
        return repository.save(c);
    }

    public Cliente buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
