package com.miguelsilva.barbermanager.barbermanager.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.miguelsilva.barbermanager.barbermanager.model.Agendamento;
import com.miguelsilva.barbermanager.barbermanager.repository.AgendamentoRepository;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repo;

    public AgendamentoService(AgendamentoRepository repo) {
        this.repo = repo;
    }

    public List<Agendamento> listarTodos() {
        return repo.findAll();
    }

    public Agendamento salvar(Agendamento ag) {
        boolean ocupado = !repo
            .findByBarbeiroIdAndDataHora(ag.getBarbeiroId(), ag.getDataHora())
            .isEmpty();

        if (ocupado) return null;

        if (ag.getStatus() == null) {
            ag.setStatus("SCHEDULED");
        }
        return repo.save(ag);
    }

    public Agendamento buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Agendamento atualizar(Long id, Agendamento agAtualizado) {
        Optional<Agendamento> opt = repo.findById(id);
        if (!opt.isPresent()) return null;

        Agendamento agExistente = opt.get();

        if (agAtualizado.getBarbeiroId() != null && agAtualizado.getDataHora() != null) {
            List<Agendamento> conflitos = repo.findByBarbeiroIdAndDataHora(
                    agAtualizado.getBarbeiroId(), agAtualizado.getDataHora());

            boolean conflitoComOutro = conflitos.stream()
                    .anyMatch(a -> !a.getId().equals(id));

            if (conflitoComOutro) {
                return null;
            }
        }

        if (agAtualizado.getNomeCliente() != null) agExistente.setNomeCliente(agAtualizado.getNomeCliente());
        if (agAtualizado.getDataHora() != null) agExistente.setDataHora(agAtualizado.getDataHora());
        if (agAtualizado.getServico() != null) agExistente.setServico(agAtualizado.getServico());
        if (agAtualizado.getPreco() != null) agExistente.setPreco(agAtualizado.getPreco());
        if (agAtualizado.getBarbeiroId() != null) agExistente.setBarbeiroId(agAtualizado.getBarbeiroId());
        if (agAtualizado.getStatus() != null) agExistente.setStatus(agAtualizado.getStatus());

        return repo.save(agExistente);
    }

    public void cancelar(Long id) {
        Agendamento ag = buscarPorId(id);
        if (ag != null) {
            ag.setStatus("CANCELLED");
            repo.save(ag);
        }
    }

    public void toggleStatus(Long id) {
        Agendamento ag = buscarPorId(id);
        if (ag != null) {
            if ("CANCELLED".equalsIgnoreCase(ag.getStatus())) {
                ag.setStatus("SCHEDULED");
            } else {
                ag.setStatus("CANCELLED");
            }
            repo.save(ag);
        }
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }

    public List<Agendamento> relatorioPorDia(String data) {
        return repo.findByDataHoraStartingWith(data);
    }
}
