package view.commands.animalMenu;

import view.ConsoleUI;
import view.commands.Command;

public class ReturnInMainMenu extends Command {
    public ReturnInMainMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вернуться в главное меню.";
    }

    @Override
    public void execute() {
        consoleUI.returnInMainMenu();
    }

}
