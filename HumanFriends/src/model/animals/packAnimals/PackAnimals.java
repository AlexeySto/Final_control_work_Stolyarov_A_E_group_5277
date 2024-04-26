package model.animals.packAnimals;

import model.animals.Animal;

import java.time.LocalDate;

public abstract class PackAnimals extends Animal<Animal> {
    public PackAnimals(String name, LocalDate birthData, String commands) {
        super(name, birthData, commands);
    }
}
