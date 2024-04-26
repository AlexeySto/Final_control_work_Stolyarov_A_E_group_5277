package view.commands.chooseAnimalMenu;

import view.ConsoleUI;
import view.commands.Command;

public class AddCat extends Command {
    public AddCat(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Кошка";
    }

    @Override
    public void execute() {
        consoleUI.addCat();
    }

}
