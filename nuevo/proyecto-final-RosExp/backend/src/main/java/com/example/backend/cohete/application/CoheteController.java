package com.example.backend.cohete.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backend.cohete.domain.Cohete;
import com.example.backend.cohete.domain.CoheteRepository;
import java.util.List;
import java.util.Optional;

@RestController("Controller")
@RequestMapping("/cohete")
public class CoheteController {

    @Autowired
    private CoheteRepository coheteRepository;

    @GetMapping
    public ResponseEntity<List<Cohete>> cohetes() {
        List<Cohete> cohetes = coheteRepository.findAll();
        return new ResponseEntity<>(cohetes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> cohete(@RequestBody Cohete cohete) {
        coheteRepository.save(cohete);
        return ResponseEntity.status(201).body("Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCohete(@PathVariable Long id, @RequestBody Cohete cohete) {
        Optional<Cohete> optionalCohete = coheteRepository.findById(id);
        if(optionalCohete.isPresent()) {
            Cohete existingCohete = optionalCohete.get();
            existingCohete.setNombreCohete(cohete.getNombreCohete());
            existingCohete.setEmpujeCohete(cohete.getEmpujeCohete());
            existingCohete.setPesoDespegue(cohete.getPesoDespegue());
            existingCohete.setMotor(cohete.getMotor());
            existingCohete.setDiametro(cohete.getDiametro());
            existingCohete.setDiametro(cohete.getDiametro());
            existingCohete.setVelocidadMaxima(cohete.getVelocidadMaxima());
            existingCohete.setCantidadEtapa(cohete.getCantidadEtapa());
            existingCohete.setPropulsor(cohete.getPropulsor());
            existingCohete.setAleta(cohete.getAleta());
            coheteRepository.save(existingCohete);
            return ResponseEntity.status(200).body("Updated");
        } else {
            return ResponseEntity.status(404).body("Not Found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCohete(@PathVariable Long id) {
        Optional<Cohete> optionalCohete = coheteRepository.findById(id);
        if(optionalCohete.isPresent()) {
            coheteRepository.deleteById(id);
            return ResponseEntity.status(200).body("Deleted");
        } else {
            return ResponseEntity.status(404).body("Not Found");
        }
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<String> patchCohete(@PathVariable Long id, @RequestBody Cohete editedCohete) {
        Optional<Cohete> cohete = coheteRepository.findById(id);
        if (cohete.isPresent()) {
            Cohete oldCohete = cohete.get();
            if (editedCohete.getNombreCohete() != null) {
                oldCohete.setNombreCohete(editedCohete.getNombreCohete());
            }
            if (editedCohete.getEmpujeCohete() != null) {
                oldCohete.setEmpujeCohete(editedCohete.getEmpujeCohete());
            }
            if (editedCohete.getLongitudCohete() != null) {
                oldCohete.setLongitudCohete(editedCohete.getLongitudCohete());
            }
            if (editedCohete.getPesoDespegue() != null) {
                oldCohete.setPesoDespegue(editedCohete.getPesoDespegue());
            }
            if (editedCohete.getMotor() != null) {
                oldCohete.setMotor(editedCohete.getMotor());
            }
            if (editedCohete.getDiametro() != null) {
                oldCohete.setDiametro(editedCohete.getDiametro());
            }
            
            if (editedCohete.getVelocidadMaxima() != null){
                oldCohete.setVelocidadMaxima(editedCohete.getVelocidadMaxima());
            }

            if (editedCohete.getCantidadEtapa() != null){
                oldCohete.setCantidadEtapa(editedCohete.getCantidadEtapa());
            }

            if (editedCohete.getPropulsor() != null){
                oldCohete.setPropulsor(editedCohete.getPropulsor());
            }

            if (editedCohete.getAleta() != null){
                oldCohete.setAleta(editedCohete.getAleta());
            }

            coheteRepository.save(oldCohete);
            return ResponseEntity.status(200).body("Updated Partially");
        } else {
            return ResponseEntity.status(404).body("Not found");
        }
    }

}