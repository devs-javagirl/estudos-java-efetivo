package Cap5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser<T> {

    private final List<T> choiceList;

    public Chooser(Collection<T> choiceList) {
        this.choiceList = new ArrayList<>(choiceList);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }

    public void addChoice(T choice) {
        choiceList.add(choice);
    }

    @Override
    public String toString() {
        return "Chooser{" +
                "choiceList=" + choiceList +
                '}';
    }
}
