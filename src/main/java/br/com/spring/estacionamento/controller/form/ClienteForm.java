package br.com.spring.estacionamento.controller.form;

import br.com.spring.estacionamento.model.Cliente;
import br.com.spring.estacionamento.model.MarcaCarro;
import br.com.spring.estacionamento.repository.ClienteRepository;
import br.com.spring.estacionamento.repository.MarcaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public class ClienteForm {
    @NotNull @NotEmpty @NotBlank
    private String placa;
    @NotNull @NotEmpty
    private String modelo;
    @NotNull @NotEmpty
    private LocalDateTime horaentrada;

    private Double saldo;

    //private LocalDateTime horasaida;

    private Boolean status;

    @NotNull @NotEmpty
    private String nomeMarcaCarro;


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDateTime getHoraentrada() {
        return horaentrada;
    }

    public void setHoraentrada(LocalDateTime horaentrada) {
        this.horaentrada = LocalDateTime.now();
    }

    /*public void setHorasaida(LocalDateTime horasaida) {
        this.horasaida = horasaida;
    }*/

    public void setSaldo(Double saldo){
        this.saldo = 5.0;
    }

    public void setStatus(Boolean status){
        this.status = true;
    }

    public String getNomeMarcaCarro() {
        return nomeMarcaCarro;
    }

    public void setNomeMarcaCarro(String nomeMarcaCarro) {
        this.nomeMarcaCarro = nomeMarcaCarro;
    }

    public Cliente converter(MarcaRepository marcaRepository){
        MarcaCarro marcaCarro = marcaRepository.findBynome(nomeMarcaCarro);
        return new Cliente(placa, modelo, horaentrada, status, marcaCarro);
    }
}
