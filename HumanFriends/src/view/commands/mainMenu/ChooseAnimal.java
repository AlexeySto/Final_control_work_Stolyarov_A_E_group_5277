package view.commands.mainMenu;

import view.ConsoleUI;
import view.commands.Command;

public class ChooseAnimal extends Command {
    public ChooseAnimal(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выбрать животное.";
    }

    @Override
    public void execute() {
        consoleUI.chooseAnimal();
    }

}
