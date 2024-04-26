package model.animals.packAnimals;

import java.time.LocalDate;

public class Horse extends PackAnimals{
    public Horse(String name, LocalDate birthData, String commands) {
        super(name, birthData, commands);
    }

    @Override
    public String toString() {
        return getName() + " - лошадь";
    }
}
