package com.example.backend.planeta.domain;
import jakarta.persistence.*;


@Entity
@Table(name = "planeta")
public class Planeta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;


    private String nombrePlaneta;

    private Double gravedadPlaneta;

    private Integer cantidadDia;
    
    private Double distancia;

    private Boolean habitado;


    public Planeta() {}

    public Planeta( Long id, String nombrePlaneta, Double gravedadPlaneta, Integer cantidadDia, Double distancia, Boolean habitado) {
        this.id = id;
        this.nombrePlaneta = nombrePlaneta;
        this.gravedadPlaneta = gravedadPlaneta;
        this.cantidadDia = cantidadDia;
        this.distancia = distancia;
        this.habitado = habitado;
    }


    // Getters y setters
    public Long getId(){
        return id;
    }
    public String getNombrePlaneta() {
        return nombrePlaneta;
    }

    public Double getGravedadPlaneta() {
        return gravedadPlaneta;
    }

    public Integer getCantidadDia() {
        return cantidadDia;
    }

    public Double getDistancia() {
        return distancia;
    }

    public Boolean getHabitado() {
        return habitado;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setNombrePlaneta(String nombrePlaneta) {
        this.nombrePlaneta= nombrePlaneta;
    }

    public void setGravedadPlaneta(Double gravedadPlaneta) {
        this.gravedadPlaneta = gravedadPlaneta;
    }

    public void setCantidadDia(Integer cantidadDia) {
        this.cantidadDia = cantidadDia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public void setHabitado(Boolean habitado) {
        this.habitado = habitado;
    }

}
