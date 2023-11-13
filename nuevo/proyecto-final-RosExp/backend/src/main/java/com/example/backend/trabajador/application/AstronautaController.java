package com.example.backend.trabajador.application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backend.trabajador.domain.AstronautaRepository;
import com.example.backend.trabajador.domain.Astronauta;
import java.util.List;
import java.util.Optional;

@RestController("AstronautaController")
@RequestMapping("/astronauta")
public class AstronautaController {

    @Autowired
    private AstronautaRepository astronautaRepository;

    @GetMapping
    public ResponseEntity<List<Astronauta>> astronautas() {
        List<Astronauta> astronautas = astronautaRepository.findAll();
        return new ResponseEntity<>(astronautas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> astronauta(@RequestBody Astronauta astronauta) {
        astronautaRepository.save(astronauta);
        return ResponseEntity.status(201).body("Created");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAstronauta(@PathVariable Long id, @RequestBody Astronauta astronauta) {
        Optional<Astronauta> optionalAstronauta = astronautaRepository.findById(id);
        if(optionalAstronauta.isPresent()) {
            Astronauta existingAstronauta = optionalAstronauta.get();
            existingAstronauta.setDni(astronauta.getDni());
            existingAstronauta.setApellidoPaterno(astronauta.getApellidoPaterno());
            existingAstronauta.setApellidoMaterno(astronauta.getApellidoMaterno());
            existingAstronauta.setNombrePila(astronauta.getNombrePila());
            existingAstronauta.setImagen(astronauta.getImagen());
            existingAstronauta.setGenero(astronauta.getGenero());
            existingAstronauta.setFechaNacimiento(astronauta.getFechaNacimiento());
            existingAstronauta.setEdad(astronauta.getEdad());
            existingAstronauta.setCargo(astronauta.getCargo());
            existingAstronauta.setCargo(astronauta.getPassword());
            astronautaRepository.save(existingAstronauta);

            return ResponseEntity.status(200).body("Updated");
        } else {
            return ResponseEntity.status(404).body("Not Found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAstronauta(@PathVariable Long id) {
        Optional<Astronauta> optionalAstronauta = astronautaRepository.findById(id);
        if(optionalAstronauta.isPresent()) {
            astronautaRepository.deleteById(id);
            return ResponseEntity.status(200).body("Deleted");
        } else {
            return ResponseEntity.status(404).body("Not Found");
        }
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<String> patchAstronauta(@PathVariable Long id, @RequestBody Astronauta editedAstronauta) {
        Optional<Astronauta> astronauta = astronautaRepository.findById(id);
        if (astronauta.isPresent()) {
            Astronauta oldAstronauta = astronauta.get();
             
            if (editedAstronauta.getDni() != null) {
                oldAstronauta.setDni(editedAstronauta.getDni());}

            if (editedAstronauta.getApellidoPaterno() != null) {
                oldAstronauta.setApellidoPaterno(editedAstronauta.getApellidoPaterno());
            }
            if (editedAstronauta.getApellidoMaterno() != null) {
                oldAstronauta.setApellidoMaterno(editedAstronauta.getApellidoMaterno());
            }
            if (editedAstronauta.getNombrePila() != null) {
                oldAstronauta.setNombrePila(editedAstronauta.getNombrePila());
            }
            if (editedAstronauta.getImagen() != null) {
                oldAstronauta.setImagen(editedAstronauta.getImagen());
            }
            if (editedAstronauta.getGenero()!= null){
                oldAstronauta.setGenero(editedAstronauta.getGenero());
            }

            if (editedAstronauta.getFechaNacimiento() != null){
                oldAstronauta.setFechaNacimiento(editedAstronauta.getFechaNacimiento());
            }

            if (editedAstronauta.getEdad() != null){
                oldAstronauta.setEdad(editedAstronauta.getEdad());
            }

            if (editedAstronauta.getCargo() != null){
                oldAstronauta.setCargo(editedAstronauta.getCargo());
            }
            if (editedAstronauta.getPassword() != null){
                oldAstronauta.setPassword(editedAstronauta.getPassword());
            }

            astronautaRepository.save(oldAstronauta);
            return ResponseEntity.status(200).body("Updated Partially");
        } else {
            return ResponseEntity.status(404).body("Not found");
        }
    }


    }

