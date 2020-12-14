package br.com.spring.estacionamento.controller.dto;

import br.com.spring.estacionamento.model.Cliente;
import br.com.spring.estacionamento.repository.ClienteRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RelatorioDto {
    private LocalDateTime datainicio;
    private LocalDateTime datafim;
    private List<Cliente> verificados;

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

    public void relatorio(ClienteRepository clienteRepository){
        double saldoun;
        double saldototal = 0;
        for(Cliente clientes: clienteRepository.findBystatus(false)){
            if(clientes.getHorasaida().isAfter(datainicio) && clientes.getHorasaida().isBefore(datafim)){
                verificados.add(clientes);
            }
        }
        for(Cliente clientes: verificados){
            saldoun = clientes.getSaldo();
            saldototal += saldoun;
        }
    }

    public static List<ClienteDto> converter(List<Cliente> clientes) {
        return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
    }
}
