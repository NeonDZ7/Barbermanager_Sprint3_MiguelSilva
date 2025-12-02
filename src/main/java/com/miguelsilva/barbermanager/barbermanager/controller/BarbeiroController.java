package com.miguelsilva.barbermanager.barbermanager.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.miguelsilva.barbermanager.barbermanager.model.Barbeiro;
import com.miguelsilva.barbermanager.barbermanager.service.BarbeiroService;

@RestController
@RequestMapping("/barbeiros")
@CrossOrigin("*")
public class BarbeiroController {

    private final BarbeiroService service;

    public BarbeiroController(BarbeiroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Barbeiro> listar() {
        return service.listar();
    }

    @PostMapping
    public Barbeiro criar(@RequestBody Barbeiro b) {
        return service.salvar(b);
    }

    @GetMapping("/{id}")
    public Barbeiro buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @PutMapping("/{id}")
    public Barbeiro atualizar(@PathVariable Long id, @RequestBody Barbeiro bAtualizado) {
        Barbeiro barbeiro = service.buscar(id);
        if(barbeiro != null) {
            barbeiro.setNome(bAtualizado.getNome());
            barbeiro.setTelefone(bAtualizado.getTelefone());
            return service.salvar(barbeiro);
        }
        return null;
    }
}
