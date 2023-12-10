package RegisterAnimals.model;

import RegisterAnimals.model.HumanFriends.PackAnimal;
import RegisterAnimals.model.HumanFriends.Pet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import RegisterAnimals.model.group.comparators.ComparatorByName;
import RegisterAnimals.model.group.comparators.ComparatorByAge;

public class Service {
    private int idPet = 0;
    private List<Pet> animals;

    public Service(){
        this.animals = new ArrayList<Pet>();
    }

    // Счетчик животных
    //Создать механизм, который позволяет вывести на экран общее количество
    // созданных животных любого типа (Как домашних, так и вьючных),
    // то есть при создании каждого нового животного счетчик увеличивается на “1”.
    public int countAnimals(){
        return animals.size();
    }

    public void sortByName(){
        animals.sort(new ComparatorByName<>());
    }

    public void sortByAge(){
        animals.sort(new ComparatorByAge<>());
    }

    //Вывести список информации о животных по дате рождения
    public String getInfoAnimalsSortedByAge(){
        sortByAge();
        List<String> listInfo = new ArrayList<>();
        for(Pet one : animals){
            listInfo.add(one.getInfo());
        }
        return String.format("(%s)", String.join(",", listInfo));
    }

    //добавить животное
    public void addAnimal(String name, String type, LocalDate dateBirth, ArrayList<String> commands,
                        boolean isPackAnimal){
        if(isPackAnimal)
            animals.add(new PackAnimal(idPet++, name, type, dateBirth, commands));
        else
            animals.add(new Pet(idPet++, name, type, dateBirth, commands));
    }

    //Добавить возможность обучать животных новым командам
    //return false, если задан неверный id
    public boolean addCommand(int id, String command){
        if(id >= countAnimals()) return false;
        animals.get(id).addCommand(command);
        return true;
    }

    //Вывести список команд, которые может выполнять добавленное животное (например, "сидеть", "лежать")
    public List<String> getCommandsAnimalById(int id){
        if(id >= countAnimals()) return null;
        return animals.get(id).getCommands();
    }
}
