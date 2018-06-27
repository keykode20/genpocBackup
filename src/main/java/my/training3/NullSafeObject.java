package my.training3;

import java.util.function.Supplier;

/**
 * Created by Emilio on 17/06/2018.
 */
public class NullSafeObject {
    public static <T> T nullSafe(T t, Supplier<T> s){
        return t != null ? t : s.get();
    }
}
