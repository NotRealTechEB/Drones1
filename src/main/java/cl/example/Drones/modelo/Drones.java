package cl.example.Drones.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "drones")
public class Drones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDrone;

    @Column(nullable = false, unique = true, length = 50)
    private String numeroRegistro;

    @Column(nullable = false)
    private Double peso;

    @Column(name = "id_tipo", nullable = false)
    private Long idTipo;

    @Column(name = "f_vencimiento_seguro", nullable = false)
    private LocalDate fechaVencimientoSeguro;

    public Long getIdDrone() {
        return idDrone;
    }

    public void setIdDrone(Long idDrone) {
        this.idDrone = idDrone;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public LocalDate getFechaVencimientoSeguro() {
        return fechaVencimientoSeguro;
    }

    public void setFechaVencimientoSeguro(LocalDate fechaVencimientoSeguro) {
        this.fechaVencimientoSeguro = fechaVencimientoSeguro;
    }

    
}