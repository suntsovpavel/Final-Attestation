package RegisterAnimals.view.commands;
import RegisterAnimals.view.ConsoleUI;

//возвращаем информацию о игрушках в списке разыгрываемых:
public class addAnimal extends Command{
    public addAnimal(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "добавить животное в реестр";
    }
    public void execute(){
        consoleUI.addAnimal();
    }
}
