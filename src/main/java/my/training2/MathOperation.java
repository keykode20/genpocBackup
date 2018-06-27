package my.training2;

/**
 * Created by Emilio on 17/06/2018.
 */
public interface MathOperation<T> {

    Operation calculate(double... a);

    default ViewOperation show(T t){
        return () -> System.out.println(t);
    }

}
