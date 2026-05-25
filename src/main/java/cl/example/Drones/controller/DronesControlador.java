package cl.example.Drones.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.example.Drones.dto.DronesDTO;
import cl.example.Drones.modelo.Drones;
import cl.example.Drones.service.DronesService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/drones")
public class DronesControlador {

    @Autowired
    private DronesService service;

    @GetMapping
    public List<Drones> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drones> obtenerPorId(@PathVariable Long id) {
        Optional<Drones> drone = service.obtenerPorId(id);
        return drone.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Drones guardarDrone(@Valid @RequestBody DronesDTO dto) {
        return service.guardarDrone(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drones> actualizarDrone(@PathVariable Long id, @Valid @RequestBody DronesDTO dto) {
        Drones actualizado = service.actualizarDrone(id, dto);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDrone(@PathVariable Long id) {
        service.eliminarDrone(id);
        return ResponseEntity.noContent().build();
    }
}