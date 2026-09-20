package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class NotaFiscal {

    @Id
    @GeneratedValue
    private UUID id;

    private String numero;
    private String cliente;
    private BigDecimal valor;
    private LocalDate emitidaEm;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getEmitidaEm() {
        return emitidaEm;
    }

    public void setEmitidaEm(LocalDate emitidaEm) {
        this.emitidaEm = emitidaEm;
    }
}
