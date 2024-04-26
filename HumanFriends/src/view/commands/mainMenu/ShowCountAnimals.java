package view.commands.mainMenu;

import view.ConsoleUI;
import view.commands.Command;

public class ShowCountAnimals extends Command {
    public ShowCountAnimals(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать счетчик животных.";
    }

    @Override
    public void execute() {
        consoleUI.showCountAnimals();
    }

}
