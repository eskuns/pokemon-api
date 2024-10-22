package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Combat;
import fr.efrei.pokemon.services.CombatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/combats")
public class CombatController {

    private final CombatService combatService;

    @Autowired
    public CombatController(CombatService combatService) {
        this.combatService = combatService;
    }

    @GetMapping
    public ResponseEntity<List<Combat>> findAll() {
        return new ResponseEntity<>(combatService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Combat>> findById(@PathVariable String id) {
        Optional<Combat> combat = combatService.findById(id);
        if (combat == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(combat, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Combat> create(@RequestBody Combat combat) {
        try {
            Combat createdCombat = combatService.save(combat);
            return new ResponseEntity<>(createdCombat, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        combatService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
