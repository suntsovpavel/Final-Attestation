package RegisterAnimals.view;

import RegisterAnimals.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void print(String txt) {
        System.out.println(txt);
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    private void hello(){
        System.out.println("Здравствуйте!");
    }
    public void finish() {
        System.out.println("До свидания!");
        work = false;
    }
    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    // Счетчик животных
    //Создать механизм, который позволяет вывести на экран общее количество
    // созданных животных любого типа (Как домашних, так и вьючных),
    // то есть при создании каждого нового животного счетчик увеличивается на “1”.
    public void countAnimals(){
        System.out.println(presenter.countAnimals());
    }

    //Вывести список информации о животных, отсортированный по дате рождения
    public void ShowInfoAnimalsSortedByAge(){
        System.out.println(presenter.getInfoAnimalsSortedByAge());
    }

    public boolean addAnimal(){
        System.out.println("Введите вид животного (например, кошка): ");
        String type = scanner.nextLine().trim();
        if(type.length() == 0)return false;

        System.out.println("Введите имя животного: ");
        String name = scanner.nextLine().trim();
        if(name.length() == 0)return false;

        System.out.println("Введите дату рождения в формате \"2018-12-27\": ");
        LocalDate dateBirth;
        try{
            dateBirth = LocalDate.parse(scanner.nextLine());
        }
        catch (DateTimeParseException e){
            return false;
        }

        System.out.println("Введите список команд, разделенных запятыми:");
        String commandsStr = scanner.nextLine();
        String[] splitted = commandsStr.split(",");
        ArrayList<String> commands = new ArrayList<>();
        for(String one : splitted){
            String trimmed = one.trim();
            if(trimmed.length()>0)
                commands.add(trimmed);
        }
        System.out.println("Вьючное животное? Y/N: ");
        String packAnimalStr = scanner.nextLine().toLowerCase().trim();
        boolean isPackAnimal = (packAnimalStr.equals("y"));

        presenter.addAnimal(name, type, dateBirth, commands, isPackAnimal);
        return true;
    }

    //Добавить возможность обучать животных новым командам
    //return false, если задан неверный id животного либо пустая команда
    public boolean addCommand()
    {
        System.out.println("Введите команду: ");
        String command = scanner.nextLine().trim();
        if(command.length() == 0)return false;

        System.out.println("Введите id животного: ");
        String idStr = scanner.nextLine().trim();
        int id;
        try{
            id = Integer.parseInt(idStr);
        }
        catch(NumberFormatException e){
            return false;
        }
        return presenter.addCommand(id, command);
    }

    //Вывести список команд, которые может выполнять добавленное животное (например, "сидеть", "лежать")
    public boolean getCommandsAnimalById(){
        System.out.println("Введите id животного: ");
        String idStr = scanner.nextLine().trim();
        int id;
        try{
            id = Integer.parseInt(idStr);
        }
        catch(NumberFormatException e){
            return false;
        }
        System.out.println(presenter.getCommandsAnimalById(id));
        return true;
    }
}
