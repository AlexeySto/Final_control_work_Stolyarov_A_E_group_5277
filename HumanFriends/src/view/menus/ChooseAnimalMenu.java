package view.menus;

import view.ConsoleUI;
import view.commands.animalMenu.ReturnInMainMenu;
import view.commands.chooseAnimalMenu.*;

public class ChooseAnimalMenu extends Menu {
    public ChooseAnimalMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new AddCat(consoleUI));
        commandList.add(new AddDog(consoleUI));
        commandList.add(new AddHamster(consoleUI));
        commandList.add(new AddHorse(consoleUI));
        commandList.add(new AddCamel(consoleUI));
        commandList.add(new AddDonkey(consoleUI));
        commandList.add(new ReturnInMainMenu(consoleUI));
    }

}
