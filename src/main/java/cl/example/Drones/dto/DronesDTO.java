package cl.example.Drones.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DronesDTO {

    @NotBlank(message = "El número de registro no puede estar vacío")
    private String numeroRegistro;

    @NotNull(message = "El peso no puede estar vacío")
    private Double peso;

    @NotNull(message = "El ID del tipo de trabajo no puede estar vacío")
    private Long idTipo;

    @NotNull(message = "La fecha de vencimiento del seguro no puede estar vacía")
    private LocalDate fechaVencimientoSeguro;

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