package fr.efrei.pokemon.repositories;

import fr.efrei.pokemon.models.Argent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArgentRepository extends JpaRepository<Argent, String> {
}
