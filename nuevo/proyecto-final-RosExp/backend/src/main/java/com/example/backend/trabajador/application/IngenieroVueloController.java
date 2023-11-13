package com.example.backend.trabajador.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backend.trabajador.domain.IngenieroVueloRepository;
import com.example.backend.trabajador.domain.IngenieroVuelo;
import java.util.List;
import java.util.Optional;

@RestController("IngenieroVueloController")
@RequestMapping("/ingenierovuelo")
public class IngenieroVueloController {

    @Autowired
    private IngenieroVueloRepository ingenieroVueloRepository;

    @GetMapping
    public ResponseEntity<List<IngenieroVuelo>> ingenierovuelos() {
        List<IngenieroVuelo> ingenierovuelos = ingenieroVueloRepository.findAll();
        return new ResponseEntity<>(ingenierovuelos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> ingenieroVuelo(@RequestBody IngenieroVuelo ingenierovuelo) {
        ingenieroVueloRepository.save(ingenierovuelo);
        return ResponseEntity.status(201).body("Created");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateIngenieroVuelo(@PathVariable Long id, @RequestBody IngenieroVuelo ingenieroVuelo){
        Optional<IngenieroVuelo> optionalIngenieroVuelo = ingenieroVueloRepository.findById(id);
        if (optionalIngenieroVuelo.isPresent()){
            IngenieroVuelo existingIngenieroVuelo = optionalIngenieroVuelo.get();
            existingIngenieroVuelo.setDni(ingenieroVuelo.getDni());
            existingIngenieroVuelo.setApellidoPaterno(ingenieroVuelo.getApellidoPaterno());
            existingIngenieroVuelo.setApellidoMaterno(ingenieroVuelo.getApellidoMaterno());
            existingIngenieroVuelo.setNombrePila(ingenieroVuelo.getNombrePila());
            existingIngenieroVuelo.setImagen(ingenieroVuelo.getImagen());
            existingIngenieroVuelo.setGenero(ingenieroVuelo.getGenero());
            existingIngenieroVuelo.setFechaNacimiento(ingenieroVuelo.getFechaNacimiento());
            existingIngenieroVuelo.setEdad(ingenieroVuelo.getEdad());
            existingIngenieroVuelo.setCampoTrabajo(ingenieroVuelo.getCampoTrabajo());
            ingenieroVueloRepository.save(existingIngenieroVuelo);

            return ResponseEntity.status(200).body("Updated");}

        else {
            return ResponseEntity.status(404).body("Not Found");}

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIngenieroVuelo(@PathVariable Long id) {
        Optional<IngenieroVuelo> optionalIngenieroVuelo = ingenieroVueloRepository.findById(id);
        if(optionalIngenieroVuelo.isPresent()) {
            ingenieroVueloRepository.deleteById(id);
            return ResponseEntity.status(200).body("Deleted");
        } else {
            return ResponseEntity.status(404).body("Not Found");
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> patchIngenieroVuelo(@PathVariable Long id, @RequestBody IngenieroVuelo editedIngenieroVuelo) {
        Optional<IngenieroVuelo> ingenieroVuelo = ingenieroVueloRepository.findById(id);
        if (ingenieroVuelo.isPresent()) {
            IngenieroVuelo oldIngenieroVuelo = ingenieroVuelo.get();
             
            if (editedIngenieroVuelo.getDni() != null) {
                oldIngenieroVuelo.setDni(editedIngenieroVuelo.getDni());
            }

            if (editedIngenieroVuelo.getApellidoPaterno() != null) {
               oldIngenieroVuelo.setApellidoPaterno(editedIngenieroVuelo.getApellidoPaterno());
            }

            if (editedIngenieroVuelo.getApellidoMaterno() != null) {
                oldIngenieroVuelo.setApellidoMaterno(editedIngenieroVuelo.getApellidoMaterno());
            }
            if (editedIngenieroVuelo.getNombrePila() != null) {
                oldIngenieroVuelo.setNombrePila(editedIngenieroVuelo.getNombrePila());
            }
            if (editedIngenieroVuelo.getImagen() != null) {
                oldIngenieroVuelo.setImagen(editedIngenieroVuelo.getImagen());
            }
            if (editedIngenieroVuelo.getGenero()!= null){
                oldIngenieroVuelo.setGenero(editedIngenieroVuelo.getGenero());
            }

            if (editedIngenieroVuelo.getFechaNacimiento() != null){
                oldIngenieroVuelo.setFechaNacimiento(editedIngenieroVuelo.getFechaNacimiento());
            }

            if (editedIngenieroVuelo.getEdad() != null){
                oldIngenieroVuelo.setEdad(editedIngenieroVuelo.getEdad());
            }

            if (editedIngenieroVuelo.getCampoTrabajo() != null){
                oldIngenieroVuelo.setCampoTrabajo(editedIngenieroVuelo.getCampoTrabajo());
            }

            ingenieroVueloRepository.save(oldIngenieroVuelo);
            
            return ResponseEntity.status(200).body("Updated Partially");
        } else {
            return ResponseEntity.status(404).body("Not found");
        }
    }




}
