package RegisterAnimals.model;

import RegisterAnimals.model.HumanFriends.PackAnimal;
import RegisterAnimals.model.HumanFriends.Pet;
import RegisterAnimals.model.group.Group;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedWriter;
import java.io.FileWriter;

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

    //Вывести список животных по дате рождения
    public List<Pet> getAnimalsSortedByAge(){
        sortByAge();
        return animals;
    }

    public void addItem(String name, String type, LocalDate dateBirth, ArrayList<String> commands,
                        boolean isPackAnimal){
        if(isPackAnimal)
            animals.add(new PackAnimal(idPet++, name, type, dateBirth, commands));
        else
            animals.add(new Pet(idPet++, name, type, dateBirth, commands));
    }
}
