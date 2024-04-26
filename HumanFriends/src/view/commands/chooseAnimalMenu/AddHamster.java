package view.commands.chooseAnimalMenu;

import view.ConsoleUI;
import view.commands.Command;

public class AddHamster extends Command {
    public AddHamster(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Хомяк";
    }

    @Override
    public void execute() {
        consoleUI.AddHamster();
    }

}
