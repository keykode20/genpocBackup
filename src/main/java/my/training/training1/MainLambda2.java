package my.training.training1;

/**
 * Created by Emilio on 10/06/2018.
 */
public class MainLambda2 {
    public static void main(String... args) {
        String s1 = "firsttttttttttttt string";
        String s2 = "second string";
        String s = MainLambda2.betterString(s1, s2, (a, b) -> {
            return a.length() > b.length();
        });
        System.out.println(s);
    }
    public static String betterString(String s1, String s2, TwoStringPredicate t){
        return t.betterString(s1,s2) ? s1 : s2;
    }
}
