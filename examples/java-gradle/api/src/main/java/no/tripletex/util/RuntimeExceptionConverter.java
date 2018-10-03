package no.tripletex.util;

import java.util.function.Supplier;

/**
 * Just a wrapper to avoid exception handling. Only for simplifying example code, DON'T use in production.
 *
 * @param <T> Type of the return.
 *
 * @author tellef
 * @date 03.10.2018
 */
public interface RuntimeExceptionConverter<T> extends Supplier<T> {

    @Override
    default T get() {
        try {
            return getCanThrowException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    T getCanThrowException() throws Exception;
}
