package view.commands.chooseAnimalMenu;

import view.ConsoleUI;
import view.commands.Command;

public class AddDog extends Command {
    public AddDog(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Собака";
    }

    @Override
    public void execute() {
        consoleUI.AddDog();
    }

}
