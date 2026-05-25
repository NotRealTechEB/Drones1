package cl.example.Drones.modelo;

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
    private String numeroSerie;

    @Column(nullable = false, length = 100)
    private String modeloDrone;

    public Long getIdDrone() {
        return idDrone;
    }

    public void setIdDrone(Long idDrone) {
        this.idDrone = idDrone;
    }

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