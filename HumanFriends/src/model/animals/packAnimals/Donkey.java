package model.animals.packAnimals;

import java.time.LocalDate;

public class Donkey extends PackAnimals{
    public Donkey(String name, LocalDate birthData, String commands) {
        super(name, birthData, commands);
    }

    @Override
    public String toString() {
        return getName() + " - осёл";
    }
}
