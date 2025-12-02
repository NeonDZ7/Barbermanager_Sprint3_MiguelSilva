package com.miguelsilva.barbermanager.barbermanager.model;

import jakarta.persistence.*;

@Entity
public class Barbeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;

    public Barbeiro() {}

    public Barbeiro(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}
