package model.animals.pets;

import java.time.LocalDate;

public class Cat extends Pets{
    public Cat(String name, LocalDate birthData, String commands) {
        super(name, birthData, commands);
    }

    @Override
    public String toString() {
        return getName() + " - кошка";
    }
}
