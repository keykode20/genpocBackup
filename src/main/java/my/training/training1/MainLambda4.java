package my.training.training1;

import java.util.Arrays;

/**
 * Created by Emilio on 11/06/2018.
 */
public class MainLambda4 {
    public static void main(String... args){
        String[] texts = new String[]{
                "Carminati","Liboni","Sassucci"
        };
        String test = MainLambda4.someMethod("Sassucci", texts);
        System.out.println(test);
    }
    public static String someMethod(String stringToFind,String[] strings){
        return Arrays.asList(strings).contains(stringToFind) ? stringToFind : "";
    }
}
