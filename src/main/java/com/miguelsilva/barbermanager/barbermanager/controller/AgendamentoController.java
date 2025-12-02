package com.miguelsilva.barbermanager.barbermanager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.miguelsilva.barbermanager.barbermanager.model.Agendamento;
import com.miguelsilva.barbermanager.barbermanager.service.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
@CrossOrigin("*")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Agendamento> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Agendamento criar(@RequestBody Agendamento ag) {
        return service.salvar(ag);
    }

    @GetMapping("/{id}")
    public Agendamento buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Agendamento atualizar(@PathVariable Long id, @RequestBody Agendamento agAtualizado) {
        return service.atualizar(id, agAtualizado);
    }

    @PutMapping("/{id}/cancelar")
    public void cancelar(@PathVariable Long id) {
        service.cancelar(id);
    }

    @PutMapping("/{id}/toggleStatus")
    public void toggleStatus(@PathVariable Long id) {
        service.toggleStatus(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping("/relatorio/{data}")
    public List<Agendamento> relatorio(@PathVariable String data) {
        return service.relatorioPorDia(data);
    }
}
