package RegisterAnimals.model.HumanFriends;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

//класс вьючного животного
public class PackAnimal extends Pet {
    private List<String> packingCommands;   //добавляем опционные команды нагрузить - разгрузить

    public PackAnimal(int id, String name, String type, LocalDate dateBirth, ArrayList<String> commands) {
        super(id, name, type, dateBirth, commands);
        packingCommands = new ArrayList<>();
        packingCommands.add("load"); //добавляем 2 команды "нагрузить - разгрузить"
        packingCommands.add("unload");
    }

    public List<String> getPackingCommands(){
        return packingCommands;
    }

    @Override
    //Возвращаем команды с учетом дополнительных: packingCommands
    public List<String> getCommands() {
        List<String> list =super.getCommands();
        for (String one : packingCommands)
            list.add(one);
        return list;
    }
}
