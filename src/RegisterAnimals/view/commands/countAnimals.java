package RegisterAnimals.view.commands;

import RegisterAnimals.view.ConsoleUI;

//возвращаем информацию о игрушках в списке разыгрываемых:
public class countAnimals extends Command{
    public countAnimals(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести количество животных в реестре";
    }
    public void execute(){
        consoleUI.countAnimals();
    }
}
