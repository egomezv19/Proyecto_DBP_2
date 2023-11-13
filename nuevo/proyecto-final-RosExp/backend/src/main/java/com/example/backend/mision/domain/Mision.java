package com.example.backend.mision.domain;

import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "mision")
public class Mision {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    private String nombreMision;
    private Date inicioMision;
    private Date finMision;
    private Boolean disponible;
    private Double cantidadPresupuesto;
    private Integer tiempoDuracion;

    public Mision(){}
    public Mision(Long id, String nombreMision, Date inicioMision, Date finMision, Boolean disponible, Double cantidadPresupuesto, Integer tiempoDuracion){
        this.id = id;
        this.nombreMision = nombreMision;
        this.inicioMision = inicioMision;
        this.finMision = finMision;
        this.disponible = disponible;
        this.cantidadPresupuesto = cantidadPresupuesto;
        this.tiempoDuracion  = tiempoDuracion;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreMision() {
        return this.nombreMision;
    }

    public void setNombreMision(String nombreMision) {
        this.nombreMision = nombreMision;
    }

    public Date getInicioMision() {
        return this.inicioMision;
    }

    public void setInicioMision(Date inicioMision) {
        this.inicioMision = inicioMision;
    }

    public Date getFinMision() {
        return this.finMision;
    }

    public void setFinMision(Date finMision) {
        this.finMision = finMision;
    }

    public Boolean getDisponible() {
        return this.disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Double getCantidadPresupuesto() {
        return this.cantidadPresupuesto;
    }

    public void setCantidadPresupuesto(Double cantidadPresupuesto) {
        this.cantidadPresupuesto = cantidadPresupuesto;
    }

    public Integer getTiempoDuracion() {
        return this.tiempoDuracion;
    }

    public void setTiempoDuracion(Integer tiempoDuracion) {
        this.tiempoDuracion = tiempoDuracion;
    }
    
}
