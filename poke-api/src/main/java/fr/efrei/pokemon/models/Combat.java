package fr.efrei.pokemon.models;

import jakarta.persistence.*;

@Entity
public class Combat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // AUTO INCREMENT
    private String id;

    @ManyToOne
    @JoinColumn(name = "trainer1_id")
    private Trainer trainer1;

    @ManyToOne
    @JoinColumn(name = "trainer2_id")
    private Trainer trainer2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
