package model.animals.packAnimals;

import java.time.LocalDate;

public class Camel extends PackAnimals{

    public Camel(String name, LocalDate birthData, String commands) {
        super(name, birthData, commands);
    }

    @Override
    public String toString() {
        return getName() + " - верблюд";
    }
}
