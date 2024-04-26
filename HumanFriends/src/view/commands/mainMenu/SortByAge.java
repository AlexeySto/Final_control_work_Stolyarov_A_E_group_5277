package view.commands.mainMenu;

import view.ConsoleUI;
import view.commands.Command;

public class SortByAge extends Command {
    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировать список животных по возрасту.";
    }

    @Override
    public void execute() {
        consoleUI.sortByAge();
    }

}
