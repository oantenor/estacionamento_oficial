package br.com.spring.estacionamento.service;

import br.com.spring.estacionamento.model.Cliente;
import br.com.spring.estacionamento.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private List<Cliente> verificados;
    private double total = 0;

    @Autowired
    ClienteRepository clienteRepository;

    public String relatorio(String datainicio, String datafim){
        total = 0;
        verificados = new ArrayList<>();
        double saldoun = 0;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime datain = LocalDateTime.parse(datainicio, format);
        LocalDateTime dataf = LocalDateTime.parse(datafim, format);
        for(Cliente clientes: clienteRepository.findBystatus(false)){
            if(clientes.getHorasaida().isAfter(datain) && clientes.getHorasaida().isBefore(dataf)){
                verificados.add(clientes);
            }
        }
        for(Cliente clientes: verificados){
            saldoun = clientes.getSaldo();
            total += saldoun;
        }
        String resposta = ("O valor do caixa total no período especificado é: " + total);
        return resposta;
    }


}
