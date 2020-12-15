package br.com.spring.estacionamento.controller;

import br.com.spring.estacionamento.controller.dto.ClienteDto;
import br.com.spring.estacionamento.controller.dto.RelatorioDto;
import br.com.spring.estacionamento.controller.form.RelatoriosForm;
import br.com.spring.estacionamento.model.Cliente;
import br.com.spring.estacionamento.repository.ClienteRepository;
import br.com.spring.estacionamento.repository.MarcaRepository;
import br.com.spring.estacionamento.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;


@RestController
@RequestMapping("/relatorios")
public class RelatoriosController {

    LocalDateTime datainicio;
    LocalDateTime datafim;

    List<Cliente> verificados;

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

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public String getFluxoTotal(){
        double saldoun = 0;
        double saldototal = 0;
        List<Cliente> clientes = clienteRepository.findBystatus(false);
        for (Cliente cliente: clientes) {
            saldoun = cliente.getSaldo();
            saldototal += saldoun;
        }
        String resposta = String.format("O caixa total é: " + saldototal);
        return resposta;
    }

    @GetMapping("/{placa}")
    public String relatorioPlaca(@PathVariable("placa") String placa){
        double saldoun = 0;
        double saldototal = 0;
        String estacionado;
        List<Cliente> clientes = clienteRepository.findByplaca(placa);
        for (Cliente cliente: clientes) {
            saldoun = cliente.getSaldo();
            saldototal += saldoun;
        }
        String resposta = String.format("O caixa total do cliente é: " + saldototal);
        return resposta;
    }


    @GetMapping("/periodo/datainicio/{datainicio}/datafim/{datafim}")
    public String relatorio(@PathVariable("datainicio") String datainicio, @PathVariable("datafim") String datafim){
        String resposta = clienteService.relatorio(datainicio, datafim);
        return resposta;
    }

}
