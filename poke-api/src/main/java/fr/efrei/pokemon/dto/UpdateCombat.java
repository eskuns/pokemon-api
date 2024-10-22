package fr.efrei.pokemon.dto;

import fr.efrei.pokemon.models.Trainer;

public class UpdateCombat {

    private Trainer trainer1;
    private Trainer trainer2;

    public Trainer getTrainer1() {
        return trainer1;
    }

    public void setTrainer1(Trainer trainer1) {
        this.trainer1 = trainer1;
    }

    public Trainer getTrainer2() {
        return trainer2;
    }

    public void setTrainer2(Trainer trainer2) {
        this.trainer2 = trainer2;
    }
}
