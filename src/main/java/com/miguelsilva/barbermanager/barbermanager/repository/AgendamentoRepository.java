package com.miguelsilva.barbermanager.barbermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.miguelsilva.barbermanager.barbermanager.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findByBarbeiroIdAndDataHora(Long barbeiroId, String dataHora);

    List<Agendamento> findByDataHoraStartingWith(String data);
}
