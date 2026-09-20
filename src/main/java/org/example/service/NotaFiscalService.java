package org.example.service;

import org.example.model.NotaFiscal;
import org.example.repository.NotaFiscalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NotaFiscalService {
    private final NotaFiscalRepository repository;

    public NotaFiscalService(NotaFiscalRepository repository) {
        this.repository = repository;
    }
    @Transactional
    public NotaFiscal createNotaFiscal(String numero, String cliente, BigDecimal valor) {
        if (valor == null || valor.signum() <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }
        if (cliente == null){
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        if (numero == null){
            throw new IllegalArgumentException("Número não pode ser nulo");
        }
        if (this.repository.findByNumero(numero).isPresent()) {
            throw new IllegalArgumentException("Já existe nota com o número " + numero);
        }

        NotaFiscal nota = new NotaFiscal();
        nota.setNumero(numero);
        nota.setCliente(cliente);
        nota.setValor(valor);
        nota.setEmitidaEm(LocalDate.now());
        this.repository.save(nota);
        return nota;
    }
    public List<NotaFiscal> getNotasFiscais() {
        return this.repository.findAll();
    }

    @Transactional
    public Optional<NotaFiscal> deleteNotaFiscal(UUID id) {

        Optional<NotaFiscal> nota = this.repository.findById(id);
        if (nota.isEmpty()) {
            return Optional.empty();
        }
        this.repository.deleteById(id);
        return nota;
    }

    public Optional<NotaFiscal> getNotaFiscalById(UUID id) {
        return this.repository.findById(id);
    }

    @Transactional
    public Optional<NotaFiscal> updateNotaFiscal(UUID id, String cliente, BigDecimal valor) {
        if (valor == null || valor.signum() <= 0){
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }
        if (cliente == null){
            throw new IllegalArgumentException("Cliente não pode ser nulo");

        }
        Optional<NotaFiscal> encontrada = this.repository.findById(id);
        if (encontrada.isEmpty()) {
            return Optional.empty();
        }

        NotaFiscal nota = encontrada.get();
        nota.setCliente(cliente);
        nota.setValor(valor);

        return Optional.of(nota);
    }
}
