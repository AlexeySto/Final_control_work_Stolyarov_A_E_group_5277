package model.animals.pets;

import model.animals.Animal;

import java.time.LocalDate;

public abstract class Pets extends Animal<Animal> {
    public Pets(String name, LocalDate birthData, String commands) {
        super(name, birthData, commands);
    }
}
