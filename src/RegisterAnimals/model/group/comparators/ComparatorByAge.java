package RegisterAnimals.model.group.comparators;

import RegisterAnimals.model.HumanFriends.Aged;

import java.util.Comparator;

public class ComparatorByAge<E extends Aged> implements Comparator<E> {
    @Override
    public int compare(E e1, E e2) {
        return e1.getAge() - e2.getAge();     //Integer.compare(h1.getAge(), h2.getAge());
    }
}
