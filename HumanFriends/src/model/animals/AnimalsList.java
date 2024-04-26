package model.animals;

import model.comparators.ComparatorByAge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AnimalsList implements Serializable {
    List<Animal> animalsList;
    int indexAnimal;

    public AnimalsList() {
        animalsList = new ArrayList<>();
    }

    public boolean addAnimal(Animal animal) {
        return animalsList.add(animal);
    }

    public String getAnimalsList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < animalsList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(animalsList.get(i).toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String getAnimal() {
        return animalsList.get(indexAnimal).toString() +", дата рождения: " + animalsList.get(indexAnimal).getBirthData();
    }

    public boolean getAnimal(int numAnimal) {
        if(numAnimal-1 < animalsList.size() && numAnimal > 0) {
            indexAnimal =numAnimal - 1;
            return true;
        }
        else return false;
    }

    public String getAnimalCommandsList() {
        return "Список команд: " + animalsList.get(indexAnimal).getCommands() + "\n";
    }

    public boolean addAnimalCommand(String command) {
        return animalsList.get(indexAnimal).addCommands(command);
    }

    public void sortByAge() {
        animalsList.sort(new ComparatorByAge<>());
    }

}
