package view.commands.animalMenu;

import view.ConsoleUI;
import view.commands.Command;

public class GetAnimalCommandsList extends Command {
    public GetAnimalCommandsList(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список команд.";
    }

    @Override
    public void execute() {
        consoleUI.getAnimalCommandsList();
    }

}
