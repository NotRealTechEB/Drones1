package cl.example.Drones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<Drones>> obtenerTodos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drones> obtenerPorId(@PathVariable Long id) {
        
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Drones> guardarDrone(@Valid @RequestBody DronesDTO dto) {
        
        return new ResponseEntity<>(service.guardarDrone(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drones> actualizarDrone(@PathVariable Long id, @Valid @RequestBody DronesDTO dto) {
       
        return ResponseEntity.ok(service.actualizarDrone(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDrone(@PathVariable Long id) {
        service.eliminarDrone(id);
        return ResponseEntity.noContent().build();
    }
}