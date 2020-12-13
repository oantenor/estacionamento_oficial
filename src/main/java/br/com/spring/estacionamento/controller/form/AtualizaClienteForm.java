package br.com.spring.estacionamento.controller.form;

import br.com.spring.estacionamento.model.Cliente;
import br.com.spring.estacionamento.repository.ClienteRepository;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class AtualizaClienteForm{
    private LocalDateTime horaentrada;
    private LocalDateTime horasaida;
    private Boolean status;
    private Double saldo;

    public LocalDateTime getHorasaida() {
        return horasaida;
    }

    public void setHorasaida(LocalDateTime horasaida) {
        this.horasaida = LocalDateTime.now();
    }

    public void setStatus(Boolean status){
        this.status = false;
    }

    public void setSaldo(Double saldo){
        this.saldo = 10.0;
    }

    public Cliente atualizar_teste(String placa, ClienteRepository clienteRepository){
        Cliente cliente = clienteRepository.findFirstByPlacaAndStatus(placa, status);
        cliente.setHorasaida(LocalDateTime.now());
        cliente.setStatus(false);
        cliente.setSaldo(this.saldo);
        return cliente;
    }

}
