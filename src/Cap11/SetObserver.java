package Cap11;

@FunctionalInterface
public interface SetObserver<E> {
    void added(ObservableSet<E> set, E element);

}
