package model.animals.pets;

import java.time.LocalDate;

public class Hamster extends Pets{
    public Hamster(String name, LocalDate birthData, String commands) {
        super(name, birthData, commands);
    }

    @Override
    public String toString() {
        return getName() + " - хомяк";
    }
}
