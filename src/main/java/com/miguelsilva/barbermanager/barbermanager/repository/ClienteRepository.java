package com.miguelsilva.barbermanager.barbermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.miguelsilva.barbermanager.barbermanager.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
