package org.example.repository;

import org.example.model.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, UUID> {
    List<NotaFiscal> findByCliente(String cliente);

    Optional<NotaFiscal> findByNumero(String numero);

    List<NotaFiscal> findByEmitidaEm(LocalDate emitidaEm);

}

