package br.com.spring.estacionamento.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import br.com.spring.estacionamento.controller.dto.ClienteDto;
import br.com.spring.estacionamento.controller.form.AtualizaClienteForm;
import br.com.spring.estacionamento.controller.form.ClienteForm;
import br.com.spring.estacionamento.model.Cliente;
import br.com.spring.estacionamento.model.MarcaCarro;
import br.com.spring.estacionamento.repository.ClienteRepository;
import br.com.spring.estacionamento.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping
    public List<ClienteDto> lista(String placa) {
        if(placa == null){
            List<Cliente> clientes = clienteRepository.findAll();
            return ClienteDto.converter(clientes);
        }
        else{
            List<Cliente> clientes = clienteRepository.findByplaca(placa);
            return ClienteDto.converter(clientes);
        }
    }

    @PostMapping
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody ClienteForm form, UriComponentsBuilder uriBuilder){
        Cliente cliente = form.converter(marcaRepository);
        clienteRepository.save(cliente);
        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDto(cliente));
    }

    @GetMapping("/{id}")
    public ClienteDto detalharId(@PathVariable Long id){
        Cliente cliente1 = clienteRepository.getOne(id);
        return new ClienteDto(cliente1);
    }

    @PutMapping("/{placa}")
    @Transactional
    public ClienteDto atualizar_teste(@PathVariable("placa") String placa, Boolean status, @RequestBody AtualizaClienteForm form){
        Cliente cliente1 = clienteRepository.findFirstByPlacaAndStatus(placa, status);
        cliente1.setHorasaida(LocalDateTime.now());
        cliente1.setStatus(false);
        LocalDateTime h1 = cliente1.getHoraentrada();
        LocalDateTime h2 = cliente1.getHorasaida();
        Long diff = ChronoUnit.HOURS.between(h1, h2);
        if(diff < 1){
            cliente1.setSaldo(5.0);
        }
        else{
            cliente1.setSaldo(5.0 + diff*2);
        }
        Cliente cliente1Atualizado = clienteRepository.save(cliente1);
        return new ClienteDto(cliente1Atualizado);
    }


    /*@PutMapping("/{placa}")
    @Transactional
    public ClienteDto atualizar_teste(@PathVariable("placa") String placa, Boolean status){
        Cliente cliente1 = clienteRepository.findFirstByPlacaAndStatus(placa, status);
        Cliente atualizado = clienteRepository.save(cliente1);
        return new ClienteDto(atualizado);
    }*/



    /*@PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ClienteDto> atualizar(@PathVariable Long id, @RequestBody AtualizaClienteForm form){
        Cliente cliente = form.atualizar(id, clienteRepository);
        return ResponseEntity.ok(new ClienteDto(cliente));
    }*/


}
