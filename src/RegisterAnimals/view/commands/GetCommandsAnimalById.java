package RegisterAnimals.view.commands;
import RegisterAnimals.view.ConsoleUI;

//Вывести список команд, которые может выполнять добавленное животное (например, "сидеть", "лежать")
public class GetCommandsAnimalById extends Command {
    public GetCommandsAnimalById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список команд, которые может выполнять добавленное животное";
    }
    public void execute(){
        consoleUI.getCommandsAnimalById();
    }
}
