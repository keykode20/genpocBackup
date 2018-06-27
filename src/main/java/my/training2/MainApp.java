package my.training2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Emilio on 17/06/2018.
 */
public class MainApp {
    public static void main(String... args){

        MathOperation sum = a -> {
            double result = 0;
            for (double v : a) {
                result = v + result;
            }
            double finalResult = result;
            return () -> System.out.println(finalResult);
        };

        sum.calculate(10,20,10,20).show();
        // System.out.println(calculate);

    }
}
