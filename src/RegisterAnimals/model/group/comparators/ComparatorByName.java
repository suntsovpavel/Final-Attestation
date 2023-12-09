package RegisterAnimals.model.group.comparators;

import RegisterAnimals.model.HumanFriends.Named;

import java.util.Comparator;

public class ComparatorByName<E extends Named> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
