package view.commands.mainMenu;

import view.ConsoleUI;
import view.commands.Command;

public class AddAnimal extends Command {
    public AddAnimal(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить животное.";
    }

    @Override
    public void execute() {
        consoleUI.addAnimal();
    }

}