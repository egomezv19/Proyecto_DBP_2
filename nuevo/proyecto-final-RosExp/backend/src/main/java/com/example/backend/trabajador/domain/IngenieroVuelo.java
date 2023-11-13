package com.example.backend.trabajador.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "ingenierovuelo" )
public class IngenieroVuelo extends Trabajador {

    private String campoTrabajo;

    public IngenieroVuelo(){}
    
    public IngenieroVuelo(String campoTrabajo){
        this.campoTrabajo = campoTrabajo;
    }

    public String getCampoTrabajo(){
        return campoTrabajo;
    }

    public void setCampoTrabajo(String campoTrabajo){
        this.campoTrabajo = campoTrabajo;
    }

}