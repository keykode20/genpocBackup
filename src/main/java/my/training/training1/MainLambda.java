package my.training.training1;

import java.util.Arrays;

/**
 * Created by Emilio on 10/06/2018.
 */
public class MainLambda {
    public static void main(String... args){
        String[] strings = new String[]{
            "a22","a111111","a3","4"
        };

        Arrays.sort(strings,(o1, o2) -> o1.length() - o2.length());
        for (String string : strings) {
            System.out.println("length dal piu corto al piu lungo");
            System.out.println(string);
        }

        Arrays.sort(strings,(o1, o2) -> o2.length() - o1.length());
        for (String string : strings) {
            System.out.println("length dal piu lungo al piu corto");
            System.out.println(string);
        }

        System.out.println("-----------------------------------");

        String[] text = new String[]{
                "h",
                "section includes",
                "exercises and exercise ",
                "solutions, this can also be viewed",
                "as a self-paced Java 8 training course. ",
                "the key to learning is not merely reading, ",
                "but doing the exercises. After you do ",
                "each set of exe"
        };
        Arrays.sort(text,(o1, o2) -> o1.charAt(0) - o2.charAt(0));
        for (String s : text) {
            System.out.println(s);
        }

        System.out.println("-----------------------------------");

        Arrays.sort(text,(o1, o2) -> {
              if(o1.charAt(0) == 'e') return -1;
              else return 1;
          }
        );

        for (String s : text) {
            System.out.println(s);
        }


        System.out.println("quello con utils");
      //  Arrays.sort(text,(o1, o2) -> Utils.e_First(o1,o2));
        Arrays.sort(text,Utils::e_First);
        for (String s : text) {
            System.out.println(s);
        }



    }
}
class Utils{
    public static int e_First(String s1,String s2){
        return s1.charAt(0) == 'e' ? -1 : 1;
    }
}