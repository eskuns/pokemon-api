package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Argent;
import fr.efrei.pokemon.repositories.ArgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArgentService {

    private final ArgentRepository argentRepository;

    @Autowired
    public ArgentService(ArgentRepository argentRepository) {
        this.argentRepository = argentRepository;
    }

    public List<Argent> findAll() {
        return argentRepository.findAll();
    }

    public Argent findById(String id) {
        return argentRepository.findById(id).orElse(null);
    }

    public void save(Argent argent) {
        argentRepository.save(argent);
    }

    public void delete(String id) {
        argentRepository.deleteById(id);
    }

    public void update(String id, Argent argentBody) {
        Argent argentAModifier = findById(id);
        argentAModifier.setTotal(argentBody.getTotal());
        argentAModifier.setTrainerId(argentBody.getTrainerId());
        argentRepository.save(argentAModifier);
    }

    public void partialUpdate(String id, Argent argentBody) {
        Argent argentAModifier = findById(id);
        if (argentBody.getTotal() != 0) {
            argentAModifier.setTotal(argentBody.getTotal());
        }
        if (argentBody.getTrainerId() != null) {
            argentAModifier.setTrainerId(argentBody.getTrainerId());
        }
        argentRepository.save(argentAModifier);
    }
}
