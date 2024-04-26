package view.commands.chooseAnimalMenu;

import view.ConsoleUI;
import view.commands.Command;

public class AddCamel extends Command {
    public AddCamel(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Верблюд";
    }

    @Override
    public void execute() {
        consoleUI.AddCamel();
    }

}
