package com.example.backend.cohete.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "cohete")
public class Cohete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    private String nombreCohete;
    private Double empujeCohete;
    private Double longitudCohete;
    private Double pesoDespegue;
    private String motor;
    private Double diametro;
    private Double velocidadMaxima;
    private Integer cantidadEtapa;
    private Boolean propulsor;
    private Boolean aleta;
    public Cohete(){}
    public Cohete(Long id, String nombreCohete, Double empujeCohete, Double longitudCohete, Double pesoDespegue, String motor, Double diametro, Double velocidadMaxima, Integer cantidadEtapa, Boolean propulsor, Boolean aleta){
                 this.id = id;
                 this.nombreCohete = nombreCohete;
                 this.empujeCohete = empujeCohete;
                 this.longitudCohete = longitudCohete;
                 this.pesoDespegue = pesoDespegue;
                 this.motor = motor;
                 this.diametro = diametro;
                 this.velocidadMaxima = velocidadMaxima;
                 this.cantidadEtapa = cantidadEtapa;
                 this.propulsor = propulsor;
                 this.aleta = aleta;}

    //getters y setters 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCohete() {
        return nombreCohete;
    }

    public void setNombreCohete(String nombreCohete) {
        this.nombreCohete= nombreCohete;
    }

    public Double getEmpujeCohete() {
        return empujeCohete;
    }

    public void setEmpujeCohete(Double empujeCohete) {
        this.empujeCohete = empujeCohete;
    }

    public Double getLongitudCohete() {
        return longitudCohete;
    }

    public void setLongitudCohete(Double longitudCohete) {
        this.longitudCohete = longitudCohete;
    }

    public Double getPesoDespegue() {
        return pesoDespegue;
    }

    public void setPesoDespegue(Double pesoDespegue) {
        this.pesoDespegue = pesoDespegue;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Double getDiametro() {
        return diametro;
    }

    public void setDiametro(Double diametro) {
        this.diametro = diametro;
    }

    public Double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(Double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public Integer getCantidadEtapa() {
        return cantidadEtapa;
    }

    public void setCantidadEtapa(Integer cantidadEtapa) {
        this.cantidadEtapa = cantidadEtapa;
    }

    public Boolean getPropulsor() {
        return propulsor;
    }

    public void setPropulsor(Boolean propulsor) {
        this.propulsor = propulsor;
    }

    public Boolean getAleta() {
        return aleta;
    }

    public void setAleta(Boolean aleta) {
        this.aleta = aleta;
    }
    
}