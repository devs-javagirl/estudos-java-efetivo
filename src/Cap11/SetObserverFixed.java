package Cap11;

@FunctionalInterface
public interface SetObserverFixed<E> {
    void added(ObservableSetFixed<E> eObservableSet, E element);
}
