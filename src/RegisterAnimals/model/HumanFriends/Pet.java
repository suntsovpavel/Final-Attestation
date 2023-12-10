package RegisterAnimals.model.HumanFriends;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Pet implements Aged, Named {
    private int id;
    private String name;
    private String type;
    private LocalDate dateBirth;
    private List<String> commands;

    public Pet(int id, String name, String type, LocalDate dateBirth, List<String> commands){
        this.id = id;
        this.name = name;
        this.type = type;
        this.dateBirth = dateBirth;
        this.commands = commands;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return Period.between(dateBirth, LocalDate.now()).getYears(); //из гугла
    }

    public String getType() {
        return type;
    }

    public List<String> getCommands() {
        return commands;
    }

    //Добавить возможность обучать животных новым командам
    public void addCommand(String command){
        if(!commands.contains(command))
            commands.add(command);
    }

    public String getInfo(){
        StringBuilder result = new  StringBuilder();
        result.append("{");
        result.append(String.format("id: %d, ", id));
        result.append(String.format("Имя: %s, ", name));
        result.append(String.format("Вид: %s, ", type));
        result.append(String.format("Дата рождения: %s, ", dateBirth.toString()));
        if(commands.size() > 0){
            List<String> commandsStr = new ArrayList<>();
            for(String one : commands){
                commandsStr.add(one);
            }
            result.append(String.format("Список команд: %s", String.join(",", commandsStr)));
        }
        result.append("}");
        return result.toString();
    }
}
