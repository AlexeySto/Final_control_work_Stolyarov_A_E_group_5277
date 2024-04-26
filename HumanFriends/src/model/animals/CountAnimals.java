package model.animals;

import java.io.Serializable;

public class CountAnimals implements Serializable {
    private int countAnimals;

    public CountAnimals() {
        countAnimals = 0;
    }

    public int getCountAnimals(){
        return countAnimals;
    }

    public void increaseCountAnimals() {
        countAnimals++;
    }
}
