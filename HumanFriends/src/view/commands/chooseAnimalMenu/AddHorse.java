package view.commands.chooseAnimalMenu;

import view.ConsoleUI;
import view.commands.Command;

public class AddHorse extends Command {
    public AddHorse(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Лошадь";
    }

    @Override
    public void execute() {
        consoleUI.AddHorse();
    }

}
