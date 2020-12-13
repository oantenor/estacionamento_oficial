package br.com.spring.estacionamento.controller.dto;

import br.com.spring.estacionamento.model.Cliente;
import br.com.spring.estacionamento.model.MarcaCarro;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDto{
    private Long id;
    private String placa;
    private String modelo;
    private LocalDateTime horaentrada;
    private LocalDateTime horasaida;
    private Boolean status;
    private Double saldo;
    private MarcaCarro marca;
    private Double precoinicial;
    private Double precohora;

    public ClienteDto(Cliente cliente){
        this.id = cliente.getId();
        this.placa = cliente.getPlaca();
        this.modelo = cliente.getModelo();
        this.horasaida = cliente.getHorasaida();
        this.horaentrada = cliente.getHoraentrada();
        this.status = cliente.getStatus();
        this.saldo = cliente.getSaldo();
        this.marca = cliente.getMarca();
        this.precohora = 2.0;
        this.precoinicial = 5.0;
    }

    public Long getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public LocalDateTime getHoraentrada() {
        return horaentrada;
    }

    public LocalDateTime getHorasaida() {
        return horasaida;
    }

    public Boolean getStatus() {
        return status;
    }

    public Double getSaldo() {
        return saldo;
    }

    public MarcaCarro getMarca(){
        return marca;
    }

    public Double getPrecoinicial() {
        return precoinicial;
    }

    public void setPrecoinicial(Double precoinicial) {
        this.precoinicial = precoinicial;
    }

    public Double getPrecohora() {
        return precohora;
    }

    public void setPrecohora(Double precohora) {
        this.precohora = precohora;
    }

    public static List<ClienteDto> converter(List<Cliente> clientes) {
        return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
    }
}
