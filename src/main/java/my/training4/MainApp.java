package my.training4;

/**
 * Created by Emilio on 17/06/2018.
 */
public class MainApp {
    public static void main(String... arg){
        Person p = new Person();
        p.age = 14;
        p.name = "emilio";
        System.out.println(p.age);
        System.out.println(p.name);
        p.name = "sticazzi";
        System.out.println(p.name);
                
    }
}
