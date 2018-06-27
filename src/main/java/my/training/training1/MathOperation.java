package my.training.training1;

/**
 * Created by Emilio on 14/06/2018.
 */
public interface MathOperation {

    MathOperation operation(double a, double b);

    default MathOperation combine(MathOperation m){
        return (a, b) -> {
            return m.operation(a,b);
        };
    };

}
