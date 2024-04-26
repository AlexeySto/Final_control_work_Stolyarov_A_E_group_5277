package view.menus;

import view.ConsoleUI;
import view.commands.mainMenu.*;

public class MainMenu extends Menu {
    public MainMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new AddAnimal(consoleUI));
        commandList.add(new ChooseAnimal(consoleUI));
        commandList.add(new ShowCountAnimals(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

}
