package Day10;

@FunctionalInterface
public interface Validator<T> {

    boolean validate(T value);

    // A default method is allowed: it doesn't count as the "one abstract method"
    default Validator<T> and(Validator<T> other) {
        return value -> validate(value) && other.validate(value);
    }
}