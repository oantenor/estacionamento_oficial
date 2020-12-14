package br.com.spring.estacionamento.repository;


import br.com.spring.estacionamento.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByplaca(String placa);
    Cliente findFirstByPlacaAndStatus(String placa, Boolean status);
    List<Cliente> findBystatus(Boolean status);
    List<Cliente> findByhorasaida(LocalDateTime horasaida);
    //List<Cliente> findBystatus(Boolean status);


//    Cliente encontraPlaca(String placa);

/*List<Cliente> findBymodelo(String modelo);
    List<Cliente> findBystatus(Boolean status);
    List<Cliente> findBydataentrada(LocalDateTime dataentrada);
    List<Cliente> findBydatasaida(LocalDateTime datasaida);*/
}
