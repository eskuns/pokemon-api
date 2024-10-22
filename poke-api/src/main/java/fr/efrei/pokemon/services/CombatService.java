package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Combat;
import fr.efrei.pokemon.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CombatService {

    private final CombatRepository combatRepository;
    private final TrainerRepository trainerRepository;

    @Autowired
    public CombatService(CombatRepository combatRepository, TrainerRepository trainerRepository) {
        this.combatRepository = combatRepository;
        this.trainerRepository = trainerRepository;
    }

    public List<Combat> findAll() {
        return combatRepository.findAll();
    }


    public Optional<Combat> findById(String id) {
        return combatRepository.findById(id);
    }

    public Combat save(Combat combat) {
        return combatRepository.save(combat);
    }

    public void delete(String id) {
        combatRepository.deleteById(id);
    }
}