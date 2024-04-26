package view.commands;

import view.ConsoleUI;

public abstract class Command {
    protected String description;
    protected ConsoleUI consoleUI;

    public String getDescription() { return description;}
    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public abstract void execute();

}
