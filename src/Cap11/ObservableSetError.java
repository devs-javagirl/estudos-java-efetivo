package Cap11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ObservableSetError<E> {
    private final Set<E> set = new HashSet<>();
    private final List<SetObserverError<E>> observers = new ArrayList<>();

    public synchronized void addObserver(SetObserverError<E> observer) {
        observers.add(observer);
    }

    public synchronized void removeObserver(SetObserverError<E> observer) {
        observers.remove(observer);
    }

    public synchronized boolean add(E element) {
        boolean added = set.add(element);
        if (added) notifyElementAdded(element);
        return added;
    }

    private void notifyElementAdded(E element) {
        for (SetObserverError<E> observer : observers) {
            observer.added(this, element);
        }
    }

    private static void populateWithRemove(ObservableSetError<Integer> set) {
        set.addObserver(new SetObserverError<>() {
            public void added(ObservableSetError<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23) {
                    System.out.println("removing item 23");
                    s.removeObserver(this);
                }
            }
        });

        for (int i = 0; i < 100; i++)
            set.add(i);
    }

    public static void main(String[] args) {
        ObservableSetError<Integer> set = new ObservableSetError<>();
        populateWithRemove(set);
    }

}
