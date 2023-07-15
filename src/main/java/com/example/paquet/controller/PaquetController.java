package com.example.paquet.controller;

import com.example.paquet.model.Paquet;
import com.example.paquet.repository.PaquetRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PaquetController {

    @Autowired
    PaquetRepository paquetRepository;

    @GetMapping("/paquet")
    public List<Paquet> getAllPaquets() {
        try {
            return paquetRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return null;
    }

    @PostMapping("/paquet/create")
    public Paquet createPaquet(@Valid @RequestBody Paquet paquet) {
        try {
            return paquetRepository.save(paquet);
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return null;
    }

    @GetMapping("/paquet/byId/{id}")
    public Optional<Paquet> getPaquetById(@PathVariable(value = "id") Long paquetId) {
        try {
            return paquetRepository.findById(paquetId);
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return null;
    }

    @PutMapping("/paquet/update/{id}")
    public Paquet updatePaquet(@PathVariable(value = "id") Long paquetId,
                                 @Valid @RequestBody Paquet paquetDetails) {
        try {
            Paquet paquet = paquetRepository.findById(paquetId);
            return updatedCatalog;
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return null;
    }

    @DeleteMapping("/paquet/delete/{id}")
    public ResponseEntity<?> deletePaquet(@PathVariable(value = "id") Long paquetId) {
        try {
            Optional<Paquet> paquet = paquetRepository.findById(paquetId);
                   // .orElseThrow(() -> new ResourceNotFoundException("Catalog", "id", catalogId));
            paquetRepository.delete(paquet);

            return ResponseEntity.ok().build();
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return null;
    }
}
