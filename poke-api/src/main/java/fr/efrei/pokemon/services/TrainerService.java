package fr.efrei.pokemon.services;

import fr.efrei.pokemon.dto.CreateTrainer;
import fr.efrei.pokemon.dto.UpdateTrainer;
import fr.efrei.pokemon.models.Pokemon;
import fr.efrei.pokemon.models.Trainer;
import fr.efrei.pokemon.repositories.TrainerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {

	private final TrainerRepository repository;
	private final PokemonService pokemonService;

	@Autowired
	public TrainerService(TrainerRepository repository, PokemonService pokemonService) {
		this.repository = repository;
		this.pokemonService = pokemonService;
	}

	public List<Trainer> findAll() {
		return repository.findAll();
	}

	public Trainer findById(String id) {
		return repository.findById(id).orElse(null);
	}

	public void save(CreateTrainer trainerBody) {
		Trainer trainer = new Trainer();
		trainer.setName(trainerBody.getName());
		List<String> pokemonIds = trainerBody.getTeam();
		List<Pokemon> pokemonAAjouter = new ArrayList<>();
		for (String idPokemon: pokemonIds) {
			Pokemon pokemon = pokemonService.findById(idPokemon);
			if(pokemon != null) {
				pokemonAAjouter.add(pokemon);
			}
		}

		trainer.setTeam(pokemonAAjouter);
		repository.save(trainer);
	}

	@Transactional
	public void update(String id, UpdateTrainer trainerBody) {
		Trainer trainer = findById(id);
		if (trainerBody.getName() != null) {
			trainer.setName(trainerBody.getName());
		}
		if(trainerBody.getTeam() != null && !trainerBody.getTeam().isEmpty()) {
			List<Pokemon> pokemonList = new ArrayList<>();
			List<String> pokemonIds = trainerBody.getTeam();
			for(String idPokemon: pokemonIds) {
				Pokemon pokemon = pokemonService.findById(idPokemon);
				if(pokemon != null) {
					pokemonList.add(pokemon);
				}
			}
			pokemonList.addAll(trainer.getTeam());
			trainer.setTeam(pokemonList);
		}
		repository.save(trainer);
	}

	public void delete(String id) {
		repository.deleteById(id);
	}
}
