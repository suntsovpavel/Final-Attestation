package RegisterAnimals.model.HumanFriends;

import RegisterAnimals.model.group.Group;
import saveload.LoadFrom;
import saveload.SaveTo;

import java.util.Date;

public class Pet {
    private String name;
    private String type;
    private Date dateBirth;
    public Pet(String name, String type, ){

        this.name = name;
        this.type = type;
        this.loader = loader;
        this.informerHuman = new ReportablePrize();
        this.errorMessage = null;
    }
}
