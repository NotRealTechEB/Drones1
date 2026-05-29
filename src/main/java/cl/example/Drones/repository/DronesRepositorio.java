package cl.example.Drones.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.example.Drones.modelo.Drones;

@Repository
public interface DronesRepositorio extends JpaRepository<Drones, Long> {
    
    Optional<Drones> findByNumeroRegistro(String numeroSerie);
}