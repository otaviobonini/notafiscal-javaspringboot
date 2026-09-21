package org.example.dto;

import java.math.BigDecimal;

public record NotaDTO(String numero, String cliente, BigDecimal valor) {}