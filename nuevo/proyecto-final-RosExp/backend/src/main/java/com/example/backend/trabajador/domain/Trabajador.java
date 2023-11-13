package com.example.backend.trabajador.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "trabajador")
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
	private String dni;

    public String apellidoPaterno;

    private String apellidoMaterno;

    private String nombrePila;

    private String imagen;

    private String genero;

    private Date fechaNacimiento;

    private Integer edad;

    @Column(name="password", length = 255)
    private String password;

    public Trabajador() {}

    public Trabajador(String password, Long id, String dni, String apellidoPaterno, String apellidoMaterno, String nombrePila, String imagen, String genero, Date fechaNacimiento, Integer edad) {
        this.id = id;
        this.dni = dni;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombrePila = nombrePila;
        this.imagen = imagen;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public Long getId(){
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getNombrePila() {
        return nombrePila;
    }

    public String getImagen() {
        return imagen;
    }

    public String getGenero() {
        return genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setId(Long id){
        this.id  = id;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setNombrePila(String nombrePila) {
        this.nombrePila = nombrePila;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
