package view.commands.chooseAnimalMenu;

import view.ConsoleUI;
import view.commands.Command;

public class AddDonkey extends Command {
    public AddDonkey(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Осёл";
    }

    @Override
    public void execute() {
        consoleUI.AddDonkey();
    }

}
