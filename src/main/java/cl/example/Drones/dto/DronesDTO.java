package cl.example.Drones.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DronesDTO {

    @NotBlank(message = "El número de serie no puede estar vacío")
    @Size(min = 5, max = 50, message = "El número de serie debe tener entre 5 y 50 caracteres")
    private String numeroSerie;

    @NotBlank(message = "El modelo no puede estar vacío")
    private String modeloDrone;

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getModeloDrone() {
        return modeloDrone;
    }

    public void setModeloDrone(String modeloDrone) {
        this.modeloDrone = modeloDrone;
    }

 
}