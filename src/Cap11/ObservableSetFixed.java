package Cap11;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObservableSetFixed<E> {
    private final Set<E> set = new HashSet<>();
    private final CopyOnWriteArrayList<SetObserverFixed<E>> observers = new CopyOnWriteArrayList<>();

    public void addObserver(SetObserverFixed<E> observer) {
        observers.add(observer);
    }

    public void removeObserver(SetObserverFixed<E> observer) {
        observers.remove(observer);
    }

    public boolean add(E element) {
        boolean added = set.add(element);
        if (added) notifyElementAdded(element);
        return added;
    }

    private void notifyElementAdded(E element) {
        for (SetObserverFixed<E> observer : observers) {
            observer.added(this, element);
        }
    }

    public static void main(String[] args) {
        ObservableSetError<Integer> set = new ObservableSetError<>();
        populateWithRemove(set);
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
}
