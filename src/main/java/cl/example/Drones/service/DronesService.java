package cl.example.Drones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.example.Drones.dto.DronesDTO;
import cl.example.Drones.modelo.Drones;
import cl.example.Drones.repository.DronesRepositorio;

@Service
public class DronesService {

    @Autowired
    private DronesRepositorio repository;

    public List<Drones> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Drones> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Drones guardarDrone(DronesDTO dto) {
        Drones drone = new Drones();
        // Pasamos los nuevos datos del DTO al Modelo
        drone.setNumeroRegistro(dto.getNumeroRegistro());
        drone.setPeso(dto.getPeso());
        drone.setIdTipo(dto.getIdTipo());
        drone.setFechaVencimientoSeguro(dto.getFechaVencimientoSeguro());
        
        return repository.save(drone);
    }

    public Drones actualizarDrone(Long id, DronesDTO dto) {
        Optional<Drones> existente = repository.findById(id);
        if (existente.isPresent()) {
            Drones drone = existente.get();
            // Actualizamos con los nuevos campos del diagrama
            drone.setNumeroRegistro(dto.getNumeroRegistro());
            drone.setPeso(dto.getPeso());
            drone.setIdTipo(dto.getIdTipo());
            drone.setFechaVencimientoSeguro(dto.getFechaVencimientoSeguro());
            
            return repository.save(drone);
        }
        return null;
    }

    public void eliminarDrone(Long id) {
        repository.deleteById(id);
    }
}