package com.miguelsilva.barbermanager.barbermanager.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.miguelsilva.barbermanager.barbermanager.model.Cliente;
import com.miguelsilva.barbermanager.barbermanager.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @PostMapping
    public Cliente criar(@RequestBody Cliente c) {
        return service.salvar(c);
    }

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cAtualizado) {
        Cliente cliente = service.buscarPorId(id);
        if(cliente != null) {
            cliente.setNome(cAtualizado.getNome());
            cliente.setTelefone(cAtualizado.getTelefone());
            return service.salvar(cliente);
        }
        return null;
    }
}
