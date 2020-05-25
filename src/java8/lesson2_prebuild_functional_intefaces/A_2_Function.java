package java8.lesson2_prebuild_functional_intefaces;

import java.util.function.Function;

public class A_2_Function {

    interface Converter<FROM, TO> {
        TO convert(FROM from);
    }

    static class Hobby {
        private String name;

        public Hobby(String name) {
            this.name = name;
        }
    }

    static class Person {
        private Hobby hobby;

        public Person(Hobby hobby) {
            this.hobby = hobby;
        }
    }

    public static void main(String[] args) {
        Person person = new Person(new Hobby("football"));

        /*var hobby = getHobby(person);
        var hobyName = getHobbyName(hobby);
        var sizeOfHobbyNameString = getHobbyNameLength(hobyName);
        System.out.println(sizeOfHobbyNameString);
*/

        Function<Person, Hobby> func = (p) -> {
            System.out.println("Retrieve hobby");
            return p.hobby;
        };

        var result = func.andThen(h -> {
            System.out.println("Retrieve hobby name");
            return h.name;
        }).andThen(name -> {
            System.out.println("Retrieve hobby name string length");
            return name.length();
        }).apply(new Person(new Hobby("123")));

        System.out.println(result);
    }

    private static Hobby getHobby(Person person) {
        System.out.println("Retrieve hobby");
        return person.hobby;
    }

    private static String getHobbyName(Hobby hobby) {
        System.out.println("Retrieve hobby name");
        return hobby.name;
    }

    private static int getHobbyNameLength(String hobbyName) {
        System.out.println("Retrieve hobby name string length");
        return hobbyName.length();
    }

    private static void a_1_demoCustomFunction_with_prebuilt_one() {
        Converter<Integer, String> converter = (Integer i) -> {
            return i.toString();
        };
        System.out.println(converter.convert(200).length());

        Function<Integer, String> function = (Integer i) -> {
            return i.toString();
        };
        System.out.println(function.apply(200).length());
    }
}
