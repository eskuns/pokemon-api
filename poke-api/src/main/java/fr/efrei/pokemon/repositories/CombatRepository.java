package fr.efrei.pokemon.repositories;

import fr.efrei.pokemon.models.Combat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombatRepository extends JpaRepository<Combat, String> { }
