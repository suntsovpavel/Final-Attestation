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
        packingCommands.add("нагрузить");
        packingCommands.add("разгрузить");
    }

    public List<String> getPackingCommands() {
        return packingCommands;
    }

    public String getInfo() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append(String.format("id: %d; ", super.getId()));
        result.append(String.format("Имя: %s; ", super.getName()));
        result.append(String.format("Вид: %s; ", super.getType()));
        result.append(String.format("Дата рождения: %s; ", super.getDateBirth().toString()));
        List<String> commands = super.getCommands();
        if (commands.size() > 0) {
            List<String> commandsStr = new ArrayList<>();
            for (String one : commands) {
                commandsStr.add(one);
            }
            result.append(String.format("Список команд: %s; ", String.join(",", commandsStr)));
        }
        {
            List<String> commandsStr = new ArrayList<>();
            for (String one : packingCommands) {
                commandsStr.add(one);
            }
            result.append(String.format("Список операций: %s", String.join(",", commandsStr)));
        }
        result.append("}");
        return result.toString();
    }
}


