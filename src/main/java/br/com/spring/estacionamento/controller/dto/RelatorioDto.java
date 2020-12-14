package br.com.spring.estacionamento.controller.dto;

import br.com.spring.estacionamento.model.Cliente;
import br.com.spring.estacionamento.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RelatorioDto {
    private LocalDateTime datainicio;
    private LocalDateTime datafim;
    private double total;


    public LocalDateTime getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(LocalDateTime datainicio) {
        this.datainicio = datainicio;
    }

    public LocalDateTime getDatafim() {
        return datafim;
    }

    public void setDatafim(LocalDateTime datafim) {
        this.datafim = datafim;
    }

}
