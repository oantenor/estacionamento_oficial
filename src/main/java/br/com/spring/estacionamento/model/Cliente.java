package br.com.spring.estacionamento.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
public class Cliente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;

    private String modelo;

    private LocalDateTime horasaida;

    private LocalDateTime horaentrada;

    private Boolean status;

    private Double saldo;

    @ManyToOne
    private MarcaCarro marca;

    @Transient
    private Double precoinicial = 5.0;

    @Transient
    private Double precohora = 2.0;

    @Transient
    private int ano;

    @Transient
    private int mes;

    @Transient
    private int dia;

    public Cliente(){

    }

    public Cliente(String placa, String modelo, LocalDateTime horaentrada, Boolean status, MarcaCarro marca) {
        this.placa = placa;
        this.modelo = modelo;
        this.horaentrada = LocalDateTime.now();
        //this.horasaida = horasaida;
        this.status = true;
        this.saldo = 5.0;
        this.marca = marca;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        this.horaentrada = horaentrada;
    }

    public LocalDateTime getHorasaida() {
        return horasaida;
    }

    public void setHorasaida(LocalDateTime horasaida) {
        this.horasaida = horasaida;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status){
        /*long diff = ChronoUnit.SECONDS.between(horaentrada, horasaida);
        if(diff == 0){
            this.status = true;
        }
        else{
            this.status = false;
        }*/
        this.status = status;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public MarcaCarro getMarca() {
        return marca;
    }

    public void setMarca(MarcaCarro marca) {
        this.marca = marca;
    }

    public int getDiaSaida(LocalDateTime horasaida){
        return horasaida.getDayOfMonth();
    }

    public int getMesSaida(LocalDateTime horasaida){
        return horasaida.getMonthValue();
    }

    public int getAnoSaida(LocalDateTime horasaida){
        return horasaida.getYear();
    }
}
