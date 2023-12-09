package RegisterAnimals.model.HumanFriends;

import java.util.List;
import java.util.Date;

public class Pet {
    private String name;
    private String type;
    private Date dateBirth;
    private List<String> commands;

    public Pet(String name, String type, Date dateBirth, List<String> commands){
        this.name = name;
        this.type = type;
        this.dateBirth = dateBirth;
        this.commands = commands;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public String getName() {
        return name;
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
}
