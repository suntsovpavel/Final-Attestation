package RegisterAnimals.view.commands;

import RegisterAnimals.view.ConsoleUI;

public class ShowInfoAnimalsSortedByAge extends Command {
    public ShowInfoAnimalsSortedByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список информации о животных, отсортированный по дате рождения";
    }
    public void execute(){
        consoleUI.ShowInfoAnimalsSortedByAge();
    }
}
