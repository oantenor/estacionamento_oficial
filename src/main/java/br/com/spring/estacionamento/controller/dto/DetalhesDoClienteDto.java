package br.com.spring.estacionamento.controller.dto;

import br.com.spring.estacionamento.model.MarcaCarro;

import java.time.LocalDateTime;

public class DetalhesDoClienteDto {
    private Long id;
    private String placa;
    private String modelo;
    private LocalDateTime horasaida;
    private LocalDateTime horaentrada;
    private Boolean status;
    private Double saldo;
    private MarcaCarro marca;
}
