package br.com.spring.estacionamento.controller.form;

import br.com.spring.estacionamento.model.Cliente;
import br.com.spring.estacionamento.repository.ClienteRepository;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class RelatoriosForm {
    private LocalDateTime horaentrada;
    private LocalDateTime horasaida;
    private LocalDateTime datainicio;
    private LocalDateTime datafim;
    private List<Cliente> verificados;

    public void setDatainicio(LocalDateTime datainicio) {
        this.datainicio = datainicio;
    }

    public void setDatafim(LocalDateTime datafim) {
        this.datafim = datafim;
    }



}
