package ir.maktabsharif.util;


import lombok.Getter;

import java.util.function.Function;

@Getter
public class ResultWrapper<T> {
    private final T value;
    private final String err;

    private ResultWrapper(T value, String err) {
        this.value = value;
        this.err = err;
    }

    public static <T> ResultWrapper<T> ok(T value) {
        return new ResultWrapper<>(value, null);
    }

    public static <T> ResultWrapper<T> err(String message) {
        return new ResultWrapper<>(null, message);
    }

    public boolean isSuccess() {
        return value != null && err == null;
    }

    public <U> ResultWrapper<U> map(Function<? super T, ? extends U> mapper) {
        if (this.isSuccess()) {
            return ResultWrapper.ok(mapper.apply(getValue()));
        }
        return ResultWrapper.err(getErr());
    }

    @Override
    public String toString() {
        return "ResultWrapper{" +
                "value=" + value +
                ", err='" + err + '\'' +
                '}';
    }
}

