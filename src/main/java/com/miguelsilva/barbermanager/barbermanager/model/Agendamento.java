package com.miguelsilva.barbermanager.barbermanager.model;

import jakarta.persistence.*;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;
    private String dataHora;
    private String servico;
    private Double preco;

    private Long barbeiroId;
    private String status;

    public Agendamento() {}

    public Long getId() { return id; }
    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public String getDataHora() { return dataHora; }
    public void setDataHora(String dataHora) { this.dataHora = dataHora; }
    public String getServico() { return servico; }
    public void setServico(String servico) { this.servico = servico; }
    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }
    public Long getBarbeiroId() { return barbeiroId; }
    public void setBarbeiroId(Long barbeiroId) { this.barbeiroId = barbeiroId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
