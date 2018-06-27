package my.training3;

import cucumber.deps.com.thoughtworks.xstream.mapper.Mapper;

/**
 * Created by Emilio on 17/06/2018.
 */
public class MainApp {
    public static void main(String... args){
        String a = null;
        String s = NullSafeObject.nullSafe(a, () -> "b");

        SomeService someService= null;

        Employee sassucci = NullSafeObject.nullSafe(someService, () -> new SomeService() {
            @Override
            public Employee getEmployee() {
                Employee a = new Employee();
                a.setName("sassucci");
                return a;
            }
        }).getEmployee();

        System.out.print(sassucci.getName());
    }
}
