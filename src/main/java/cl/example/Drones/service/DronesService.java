package cl.example.Drones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import cl.example.Drones.dto.DronesDTO;
import cl.example.Drones.modelo.Drones;
import cl.example.Drones.repository.DronesRepositorio;

@Service
public class DronesService {

    @Autowired
    private DronesRepositorio repository;

    @Autowired
    private RestTemplate restTemplate; 

    public List<Drones> obtenerTodos() {
        return repository.findAll();
    }

    public Drones obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el Dron con el ID: " + id));
    }


    private void validarTipoTrabajo(Long idTipo) {
        try {
            
            String url = "http://localhost:8082/api/tipotrabajos/" + idTipo;
            
            
            restTemplate.getForObject(url, Object.class);
            
        } catch (HttpClientErrorException.NotFound e) {
           
            throw new RuntimeException("Error: El Tipo de Trabajo con ID " + idTipo + " no existe en la base de datos.");
        } catch (Exception e) {
           
            throw new RuntimeException("Error al comunicarse con el microservicio de Tipo de Trabajo. ¿Está encendido?");
        }
    }
    

    public Drones guardarDrone(DronesDTO dto) {

        validarTipoTrabajo(dto.getIdTipo());

        Drones drone = new Drones();
        drone.setNumeroRegistro(dto.getNumeroRegistro());
        drone.setPeso(dto.getPeso());
        drone.setIdTipo(dto.getIdTipo());
        drone.setFechaVencimientoSeguro(dto.getFechaVencimientoSeguro());
        
        return repository.save(drone);
    }

    public Drones actualizarDrone(Long id, DronesDTO dto) {

        Drones droneExistente = obtenerPorId(id);
        

        validarTipoTrabajo(dto.getIdTipo());

        droneExistente.setNumeroRegistro(dto.getNumeroRegistro());
        droneExistente.setPeso(dto.getPeso());
        droneExistente.setIdTipo(dto.getIdTipo());
        droneExistente.setFechaVencimientoSeguro(dto.getFechaVencimientoSeguro());
        
        return repository.save(droneExistente);
    }

    public void eliminarDrone(Long id) {
        Drones droneExistente = obtenerPorId(id);
        repository.delete(droneExistente);
    }
}