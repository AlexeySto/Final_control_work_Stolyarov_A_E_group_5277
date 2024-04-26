package model.animals.pets;

import java.time.LocalDate;

public class Dog extends Pets{
    public Dog(String name, LocalDate birthData, String commands) {
        super(name, birthData, commands);
    }

    @Override
    public String toString() {
        return getName() + " - собака";
    }
}
