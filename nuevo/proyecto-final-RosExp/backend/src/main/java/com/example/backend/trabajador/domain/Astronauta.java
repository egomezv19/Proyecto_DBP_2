package com.example.backend.trabajador.domain;

import jakarta.persistence.*;

@Entity
@Table(name= "astronauta" )

public class Astronauta extends Trabajador {
    private String cargo;

    public Astronauta(){}

    public Astronauta(String cargo){
        this.cargo = cargo;
    }

    public String getCargo(){
        return cargo;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

}