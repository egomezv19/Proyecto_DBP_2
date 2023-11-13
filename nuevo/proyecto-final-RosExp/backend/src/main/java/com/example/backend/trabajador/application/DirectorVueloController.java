package com.example.backend.trabajador.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backend.trabajador.domain.DirectorVueloRepository;
import com.example.backend.trabajador.domain.DirectorVuelo;
import java.util.List;
import java.util.Optional;

@RestController("DirectorVueloController")
@RequestMapping("/directorvuelo")
public class DirectorVueloController {

    @Autowired
    private DirectorVueloRepository directorVueloRepository;

    @GetMapping
    public ResponseEntity<List<DirectorVuelo>> directorvuelos() {
        List<DirectorVuelo> directorvuelos = directorVueloRepository.findAll();
        return new ResponseEntity<>(directorvuelos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> directorVuelo(@RequestBody DirectorVuelo directorvuelo) {
        directorVueloRepository.save(directorvuelo);
        return ResponseEntity.status(201).body("Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDirectorVuelo(@PathVariable Long id, @RequestBody DirectorVuelo directorVuelo){
        Optional<DirectorVuelo> optionalDirectorVuelo = directorVueloRepository.findById(id);
        if (optionalDirectorVuelo.isPresent()){
            DirectorVuelo existingDirectorVuelo = optionalDirectorVuelo.get();
            existingDirectorVuelo.setDni(directorVuelo.getDni());
            existingDirectorVuelo.setApellidoPaterno(directorVuelo.getApellidoPaterno());
            existingDirectorVuelo.setApellidoMaterno(directorVuelo.getApellidoMaterno());
            existingDirectorVuelo.setNombrePila(directorVuelo.getNombrePila());
            existingDirectorVuelo.setImagen(directorVuelo.getImagen());
            existingDirectorVuelo.setGenero(directorVuelo.getGenero());
            existingDirectorVuelo.setFechaNacimiento(directorVuelo.getFechaNacimiento());
            existingDirectorVuelo.setEdad(directorVuelo.getEdad());
            existingDirectorVuelo.setPassword(directorVuelo.getPassword());
            directorVueloRepository.save(existingDirectorVuelo);

            return ResponseEntity.status(200).body("Updated");}

        else {
            return ResponseEntity.status(404).body("Not Found");}

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDirectorVuelo(@PathVariable Long id) {
        Optional<DirectorVuelo> optionalDirectorVuelo = directorVueloRepository.findById(id);
        if(optionalDirectorVuelo.isPresent()) {
            directorVueloRepository.deleteById(id);
            return ResponseEntity.status(200).body("Deleted");
        } else {
            return ResponseEntity.status(404).body("Not Found");
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> patchDirectorVuelo(@PathVariable Long id, @RequestBody DirectorVuelo editedDirectorVuelo) {
        Optional<DirectorVuelo> directorVuelo = directorVueloRepository.findById(id);
        if (directorVuelo.isPresent()) {
            DirectorVuelo oldDirectorVuelo = directorVuelo.get();
             
            if (editedDirectorVuelo.getDni() != null) {
                oldDirectorVuelo.setDni(editedDirectorVuelo.getDni());
            }
            if (editedDirectorVuelo.getApellidoPaterno() != null) {
               oldDirectorVuelo.setApellidoPaterno(editedDirectorVuelo.getApellidoPaterno());
            }

            if (editedDirectorVuelo.getApellidoMaterno() != null) {
                oldDirectorVuelo.setApellidoMaterno(editedDirectorVuelo.getApellidoMaterno());
            }
            if (editedDirectorVuelo.getNombrePila() != null) {
                oldDirectorVuelo.setNombrePila(editedDirectorVuelo.getNombrePila());
            }
            if (editedDirectorVuelo.getImagen() != null) {
                oldDirectorVuelo.setImagen(editedDirectorVuelo.getImagen());
            }
            if (editedDirectorVuelo.getGenero()!= null){
                oldDirectorVuelo.setGenero(editedDirectorVuelo.getGenero());
            }

            if (editedDirectorVuelo.getFechaNacimiento() != null){
                oldDirectorVuelo.setFechaNacimiento(editedDirectorVuelo.getFechaNacimiento());
            }

            if (editedDirectorVuelo.getEdad() != null){
                oldDirectorVuelo.setEdad(editedDirectorVuelo.getEdad());
            }

            if (editedDirectorVuelo.getPassword() != null){
                oldDirectorVuelo.setPassword(editedDirectorVuelo.getPassword());
            }

            directorVueloRepository.save(oldDirectorVuelo);
            
            return ResponseEntity.status(200).body("Updated Partially");
        } else {
            return ResponseEntity.status(404).body("Not found");
        }
    }


}
