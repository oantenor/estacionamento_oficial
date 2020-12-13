package br.com.spring.estacionamento.repository;

import br.com.spring.estacionamento.model.MarcaCarro;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface MarcaRepository extends JpaRepository<MarcaCarro, Long>{
    MarcaCarro findBynome(String nome);
}
