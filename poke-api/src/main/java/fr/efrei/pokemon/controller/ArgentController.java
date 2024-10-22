package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Argent;
import fr.efrei.pokemon.services.ArgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/argents")
public class ArgentController {

    private final ArgentService service;

    @Autowired
    public ArgentController(ArgentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Argent>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Argent> findById(@PathVariable String id) {
        Argent argent = service.findById(id);
        if (argent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(argent, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Argent argent) {
        service.save(argent);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Argent argent) {
        Argent argentAModifier = service.findById(id);
        if (argentAModifier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.update(id, argent);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Argent argent = service.findById(id);
        if (argent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdate(@PathVariable String id, @RequestBody Argent argentBody) {
        Argent argent = service.findById(id);
        if (argent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.partialUpdate(id, argentBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
