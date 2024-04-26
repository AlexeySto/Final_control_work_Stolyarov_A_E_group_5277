package presenter;

import model.service.Service;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public boolean addCat(String name, LocalDate birthData, String commands) {
        return service.addCat(name, birthData, commands);
    }
    public boolean addDog(String name, LocalDate birthData, String commands) {
        return service.addDog(name, birthData, commands);
    }
    public boolean addHamster(String name, LocalDate birthData, String commands) {
        return service.addHamster(name, birthData, commands);
    }
    public boolean addHorse(String name, LocalDate birthData, String commands) {
        return service.addHorse(name, birthData, commands);
    }
    public boolean addCamel(String name, LocalDate birthData, String commands) {
        return service.addCamel(name, birthData, commands);
    }
    public boolean addDonkey(String name, LocalDate birthData, String commands) {
        return service.addDonkey(name, birthData, commands);
    }

    public String getAnimalsList() {
        return service.getAnimalsList();
    }

    public void getAnimal() {
        view.printAnswer(service.getAnimal());
    }
    public boolean getAnimal(int numAnimal) {
        return service.getAnimal(numAnimal);
    }

    public void getAnimalCommandsList() {
        view.printAnswer(service.getAnimalCommandsList());
    }

    public boolean addAnimalCommand(String command) {
        return service.addAnimalCommand(command);
    }

    public void showCountAnimals() {
        view.printAnswer(service.showCountAnimals());
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public boolean saveAnimalsList() {
        return service.saveAnimalsList();
    }
    public boolean saveCountAnimals() {
        return service.saveCountAnimals();
    }

}
