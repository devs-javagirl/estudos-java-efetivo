package Cap11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ObservableSet<E> extends FowardingSet<E> {
    public ObservableSet(Set<E> set) {
        super(set);
    }

    private final List<SetObserver<E>> collection = new ArrayList<>();

    public void addObserver(SetObserver<E> observer) {
        synchronized(collection) {
            collection.add(observer);
        }
    }

    public boolean removeObserver(SetObserver<E> observer) {
        synchronized(collection) {
            return collection.remove(observer);
        }
    }

    private void notifyElementAdded(E element) {
        synchronized(collection) {
            for (SetObserver<E> observer: collection)
                observer.added(this, element);
        }
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added)
            notifyElementAdded(element);
        return added;

    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element: c)
            result |= add(element); // Chama a notifyElementAdded

        return result;
    }

}
