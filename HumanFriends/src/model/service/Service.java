package model.service;

import model.animals.AnimalsList;
import model.animals.CountAnimals;
import model.animals.packAnimals.Camel;
import model.animals.packAnimals.Donkey;
import model.animals.pets.Cat;
import model.animals.pets.Dog;
import model.animals.pets.Hamster;
import model.writer.FileHandler;
import model.animals.packAnimals.Horse;

import java.time.LocalDate;

public class Service {
    private final AnimalsList animalsList;
    private final CountAnimals countAnimals;
    private final FileHandler fileHandler;
    private static final String FILE_NAME_ANIMALS_LIST_SAVE = "animalsList.out";
    private static final String FILE_NAME_COUNT_ANIMALS_SAVE = "countAnimals.out";
    public Service() {
        fileHandler = new FileHandler();
        animalsList = loadAnimalsList();
        countAnimals = loadCountAnimals();
    }
    public boolean addCat(String name, LocalDate birthData, String commands) {
        countAnimals.increaseCountAnimals();
        return animalsList.addAnimal(new Cat(name, birthData, commands));
    }
    public boolean addDog(String name, LocalDate birthData, String commands) {
        countAnimals.increaseCountAnimals();
        return animalsList.addAnimal(new Dog(name, birthData, commands));
    }
    public boolean addHamster(String name, LocalDate birthData, String commands) {
        countAnimals.increaseCountAnimals();
        return animalsList.addAnimal(new Hamster(name, birthData, commands));
    }
    public boolean addHorse(String name, LocalDate birthData, String commands) {
        countAnimals.increaseCountAnimals();
        return animalsList.addAnimal(new Horse(name, birthData, commands));
    }
    public boolean addCamel(String name, LocalDate birthData, String commands) {
        countAnimals.increaseCountAnimals();
        return animalsList.addAnimal(new Camel(name, birthData, commands));
    }
    public boolean addDonkey(String name, LocalDate birthData, String commands) {
        countAnimals.increaseCountAnimals();
        return animalsList.addAnimal(new Donkey(name, birthData, commands));
    }

    public String getAnimalsList() {
        return animalsList.getAnimalsList();
    }

    public String getAnimal() {
        return animalsList.getAnimal();
    }
    public boolean getAnimal(int numAnimal) {
        return animalsList.getAnimal(numAnimal);
    }

    public String getAnimalCommandsList() {
        return animalsList.getAnimalCommandsList();
    }

    public boolean addAnimalCommand(String command) {
        return animalsList.addAnimalCommand(command);
    }

    public String showCountAnimals() {
        return Integer.toString(countAnimals.getCountAnimals());
    }

    public void sortByAge() {
        animalsList.sortByAge();
    }

    public boolean saveAnimalsList() {
        return fileHandler.save(animalsList, FILE_NAME_ANIMALS_LIST_SAVE);
    }
    public boolean saveCountAnimals() {
        return fileHandler.save(countAnimals, FILE_NAME_COUNT_ANIMALS_SAVE);
    }

    private AnimalsList loadAnimalsList() {
        AnimalsList animalsList;
        try {
            animalsList = (AnimalsList) fileHandler.load(FILE_NAME_ANIMALS_LIST_SAVE);
        }
        catch (Exception e) {
            animalsList = new AnimalsList();
        }
        return animalsList;
    }
    private CountAnimals loadCountAnimals() {
        CountAnimals countAnimals;
        try {
            countAnimals = (CountAnimals) fileHandler.load(FILE_NAME_COUNT_ANIMALS_SAVE);
        }
        catch (Exception e) {
            countAnimals = new CountAnimals();
        }
        return countAnimals;
    }

}
