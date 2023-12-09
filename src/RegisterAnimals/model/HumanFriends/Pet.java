package RegisterAnimals.model.HumanFriends;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Date;

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
}
