package com.example.backend.mision.application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backend.mision.domain.Mision;
import com.example.backend.mision.domain.MisionRepository;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@RestController("MisionController")
@RequestMapping("/mision")
public class MisionController {

    @Autowired MisionRepository misionRepository;


    @GetMapping
    public ResponseEntity<List<Mision>> misiones(){
        List<Mision> misiones = misionRepository.findAll();
        return new ResponseEntity<>(misiones, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> mision(@RequestBody Mision mision) {
        misionRepository.save(mision);
        return ResponseEntity.status(201).body("Created");
    }




    @PutMapping("/id")
    public ResponseEntity<String> updateMision(@PathVariable Long id, @RequestBody Mision mision){
        Optional<Mision> optionalMision = misionRepository.findById(id);
        if (optionalMision.isPresent()){
            Mision existingMision = optionalMision.get();
            existingMision.setDisponible(mision.getDisponible());
            existingMision.setCantidadPresupuesto(mision.getCantidadPresupuesto());
            existingMision.setNombreMision(mision.getNombreMision());
            existingMision.setInicioMision(mision.getInicioMision());
            existingMision.setFinMision(mision.getFinMision());
            existingMision.setTiempoDuracion(mision.getTiempoDuracion());
            misionRepository.save(existingMision);
            return ResponseEntity.status(200).body("Updated");
        } else {
            return ResponseEntity.status(404).body("Not Found");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMision(@PathVariable Long id) {
        Optional<Mision> optionalMision = misionRepository.findById(id);
        if(optionalMision.isPresent()) {
            misionRepository.deleteById(id);
            return ResponseEntity.status(200).body("Deleted");
        } else {
            return ResponseEntity.status(404).body("Not Found");
        }
        }

    @PatchMapping("/{id}")
    public ResponseEntity<String> patchMision(@PathVariable Long id, @RequestBody Mision editedMision) {
        Optional<Mision> mision = misionRepository.findById(id);
        if (mision.isPresent()) {
            Mision oldMision = mision.get();

            if (editedMision.getNombreMision() != null) {
                oldMision.setNombreMision(editedMision.getNombreMision());
            }
            if (editedMision.getInicioMision() != null) {
                oldMision.setInicioMision(editedMision.getInicioMision());
            }
            if (editedMision.getFinMision() != null) {
                oldMision.setFinMision(editedMision.getFinMision());
            }
            if (editedMision.getDisponible() != null) {
                oldMision.setDisponible(editedMision.getDisponible());
            }
            if (editedMision.getCantidadPresupuesto() != null) {
                oldMision.setCantidadPresupuesto(editedMision.getCantidadPresupuesto());
            }
            if (editedMision.getTiempoDuracion() != null) {
                oldMision.setTiempoDuracion(editedMision.getTiempoDuracion());
            }

            misionRepository.save(oldMision);
            return ResponseEntity.status(200).body("Updated Partially");
        } else {
            return ResponseEntity.status(404).body("Not found");
        }
    }
}
