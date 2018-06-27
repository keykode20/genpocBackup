package my.training.training1;

/**
 * Created by Emilio on 10/06/2018.
 */
public class MainLambda3 {
    public static void main(String... args){
        String s1 = "ciao";
        String s2 = "bella ci";
        String s = MainLambda3.betterElement(s1, s2, (a, b) -> a.length() > b.length());
        System.out.println(s);
    }
    public static <T> T betterElement(T s1, T s2, TwoElementPredicate<T> twoStringPredicate){
        boolean better = twoStringPredicate.isBetter(s1, s2);
        return better ? s1 : s2;
    }
}
