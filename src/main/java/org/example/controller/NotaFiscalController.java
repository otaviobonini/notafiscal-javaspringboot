package org.example.controller;

import org.example.dto.NotaDTO;
import org.example.model.NotaFiscal;
import org.example.service.NotaFiscalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/notas")
public class NotaFiscalController {
    private final NotaFiscalService service;

    public NotaFiscalController(NotaFiscalService service) {
        this.service = service;
    }

    @GetMapping
    public List<NotaFiscal> listar() {
        return service.getNotasFiscais();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarNota(@PathVariable UUID id) {
        Optional<NotaFiscal> nota = service.deleteNotaFiscal(id);

        if (nota.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<NotaFiscal> criarNota(@RequestBody NotaDTO nota) {
        NotaFiscal notaCriada = service.createNotaFiscal(nota.numero() , nota.cliente(), nota.valor());
        return ResponseEntity.status(201).body(notaCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotaFiscal> editarNota(@RequestBody NotaDTO nota, @PathVariable UUID id){
        Optional<NotaFiscal> notaEditada = service.updateNotaFiscal(id, nota.cliente(), nota.valor() );
        if (notaEditada.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(200).body(notaEditada.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaFiscal> listarNota(@PathVariable UUID id) {
        Optional<NotaFiscal> nota = service.getNotaFiscalById(id);

        if (nota.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(nota.get());
    }


}