package RegisterAnimals.view.commands;

import RegisterAnimals.view.ConsoleUI;

public class addCommand extends Command {
    public addCommand(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить команду животному в реестре";
    }
    public void execute(){
        consoleUI.addCommand();
    }
}
