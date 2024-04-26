package view.commands.mainMenu;

import view.ConsoleUI;
import view.commands.Command;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Закончить работу";
    }

    public void execute(){
        consoleUI.finish();
    }

}
