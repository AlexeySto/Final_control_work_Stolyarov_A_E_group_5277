package model.animals;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Animal<E extends Animal> implements Serializable {
    String name;
    LocalDate birthData;
    List<String> commands;

    public Animal(String name, LocalDate birthData, String commands) {
        this.name = name;
        this.birthData = birthData;
        this.commands = new ArrayList<String>(Arrays.asList(commands.split(", ")));
    }
    public String getName() {
        return name;
    }
    public LocalDate getBirthData() {
        return birthData;
    }
    public String getCommands() {
        return commands.toString();
    }

    public boolean addCommands(String newCommand) {
        commands.add(newCommand);
        return true;
    }
}
