package com.miguelsilva.barbermanager.barbermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.miguelsilva.barbermanager.barbermanager.model.Barbeiro;

public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {
    
}
