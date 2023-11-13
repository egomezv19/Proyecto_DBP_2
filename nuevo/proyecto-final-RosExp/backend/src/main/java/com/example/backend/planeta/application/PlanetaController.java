package com.example.backend.planeta.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backend.planeta.domain.Planeta;
import com.example.backend.planeta.domain.PlanetaRepository;
import java.util.List;
import java.util.Optional;

@RestController("PlanetaController")
@RequestMapping("/planeta")
public class PlanetaController {

    @Autowired
    private PlanetaRepository planetaRepository;

    @GetMapping
    public ResponseEntity<List<Planeta>> planetas() {
        List<Planeta> planetas = planetaRepository.findAll();
        return new ResponseEntity<>(planetas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> planeta(@RequestBody Planeta planeta) {
        planetaRepository.save(planeta);
        return ResponseEntity.status(201).body("Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlaneta(@PathVariable Long id, @RequestBody Planeta planeta) {
        Optional<Planeta> optionalPlaneta = planetaRepository.findById(id);
        if(optionalPlaneta.isPresent()) {
            Planeta existingPlaneta = optionalPlaneta.get();
            existingPlaneta.setNombrePlaneta(planeta.getNombrePlaneta());
            existingPlaneta.setGravedadPlaneta(planeta.getGravedadPlaneta());
            existingPlaneta.setCantidadDia(planeta.getCantidadDia());
            existingPlaneta.setDistancia(planeta.getDistancia());
            existingPlaneta.setHabitado(planeta.getHabitado());
            planetaRepository.save(existingPlaneta);
            return ResponseEntity.status(200).body("Updated");
        } else {
            return ResponseEntity.status(404).body("Not Found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlaneta(@PathVariable Long id) {
        Optional<Planeta> optionalPlaneta = planetaRepository.findById(id);
        if(optionalPlaneta.isPresent()) {
            planetaRepository.deleteById(id);
            return ResponseEntity.status(200).body("Deleted");
        } else {
            return ResponseEntity.status(404).body("Not Found");
        }
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<String> patchPlaneta(@PathVariable Long id, @RequestBody Planeta editedPlaneta) {
        Optional<Planeta> planeta = planetaRepository.findById(id);
        if (planeta.isPresent()) {
            Planeta oldPlaneta = planeta.get();
            if (editedPlaneta.getNombrePlaneta() != null) {
                oldPlaneta.setNombrePlaneta(editedPlaneta.getNombrePlaneta());
            }
            if (editedPlaneta.getGravedadPlaneta() != null) {
                oldPlaneta.setGravedadPlaneta(editedPlaneta.getGravedadPlaneta());
            }
            if (editedPlaneta.getCantidadDia() != null) {
                oldPlaneta.setCantidadDia(editedPlaneta.getCantidadDia());
            }
            if (editedPlaneta.getDistancia() != null) {
                oldPlaneta.setDistancia(editedPlaneta.getDistancia());
            }
            if (editedPlaneta.getHabitado() != null) {
                oldPlaneta.setHabitado(editedPlaneta.getHabitado());
            }
            planetaRepository.save(oldPlaneta);
            return ResponseEntity.status(200).body("Updated Partially");
        } else {
            return ResponseEntity.status(404).body("Not found");
        }
    }

}