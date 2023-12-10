package RegisterAnimals.presenter;

import RegisterAnimals.model.HumanFriends.PackAnimal;
import RegisterAnimals.model.HumanFriends.Pet;
import RegisterAnimals.model.Service;
import RegisterAnimals.view.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    // Счетчик животных
    //Создать механизм, который позволяет вывести на экран общее количество
    // созданных животных любого типа (Как домашних, так и вьючных),
    // то есть при создании каждого нового животного счетчик увеличивается на “1”.
    public int countAnimals(){
        return service.countAnimals();
    }

    //Вывести список информации о животных, отсортированный по дате рождения
    public String getInfoAnimalsSortedByAge(){
        return service.getInfoAnimalsSortedByAge();
    }

    //добавить животное
    public void addAnimal(String name, String type, LocalDate dateBirth, ArrayList<String> commands,
                        boolean isPackAnimal){
        service.addAnimal(name,type,dateBirth,commands,isPackAnimal);
    }

    //Добавить возможность обучать животных новым командам
    //return false, если задан неверный id животного
    public boolean addCommand(int id, String command){
        return service.addCommand(id, command);
    }

    //Вывести список команд, которые может выполнять добавленное животное (например, "сидеть", "лежать")
    public List<String> getCommandsAnimalById(int id){
        return service.getCommandsAnimalById(id);
    }
}
