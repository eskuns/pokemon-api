package fr.efrei.pokemon.models;

import jakarta.persistence.*;

@Entity
public class Argent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String trainerId;

    private int total;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
