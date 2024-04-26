package view.menus;

import view.ConsoleUI;
import view.commands.animalMenu.AddAnimalCommand;
import view.commands.animalMenu.GetAnimalCommandsList;
import view.commands.animalMenu.ReturnInMainMenu;

public class AnimalMenu extends Menu{
    public AnimalMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new GetAnimalCommandsList(consoleUI));
        commandList.add(new AddAnimalCommand(consoleUI));
        commandList.add(new ReturnInMainMenu(consoleUI));
    }

}
