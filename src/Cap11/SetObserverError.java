package Cap11;

@FunctionalInterface
public interface SetObserverError<E> {
    void added(ObservableSetError<E> eObservableSetError, E element);
}
