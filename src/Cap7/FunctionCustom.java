package Cap7;

@FunctionalInterface
public interface FunctionCustom<T, R> {
    R apply(T t);
}
