package view.commands.animalMenu;

import view.ConsoleUI;
import view.commands.Command;

public class AddAnimalCommand extends Command {
    public AddAnimalCommand(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить команду.";
    }

    @Override
    public void execute() {
        consoleUI.addAnimalCommand();
    }

}
