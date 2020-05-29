package java8.lesson4_method_references.lesson;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class A_2_Constructor_Reference {

    static class Person {
        private int age;
        private String name;

        public Person() {
            System.out.println("Default constructor");
        }

        public Person(int age) {
            System.out.println("Constructor with age");
        }

        public Person(int age, String name) {
            System.out.println("Constructor with age + name");
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private static class Context {
        boolean logInfoWhenPersonCreated;
        boolean shouldInitAge;
        int age;
        boolean shouldInitName;
        String name;
    }

    public static Person createPerson(boolean shouldInitAge, int age,
                                      boolean shouldInitName) {
        return null;
    }

    public static Person createPerson(Context context) {
        System.out.println("Init person begin");
        Person result;
        if (context.logInfoWhenPersonCreated) {
            System.out.println("Pog person creation");
            result = new Person();
        } else if (context.shouldInitAge) {
            System.out.println("Init age");
            result = new Person();
            result.setAge(context.age);
        } else if (context.shouldInitName) {
            System.out.println("Init name");
            result = new Person();
            result.setName(context.name);
        } else {
            result = new Person();
        }
        System.out.println("Init person end");
        return result;
    }

    public static Person createPerson2(Context context, Function<Context, Person> function) {
        System.out.println("Init person begin");
        Person result = function.apply(context);
        System.out.println("Init person end");
        return result;
    }

    public static Person createPerson3(Supplier<Person> supplier) {
        System.out.println("Init person begin");
        Person result = supplier.get();
        System.out.println("Init person end");
        return result;
    }

    public static Person createPerson4(Supplier<Person> supplier, Function<Integer, Person> function) {
        supplier.get();
        function.apply(1);
        return null;
    }

    public static Person createPerson5(Supplier<Person> supplier,
                                       Function<Integer, Person> function,
                                       BiFunction<Integer, String, Person> biFunction) {

        supplier.get();
        function.apply(1);
        biFunction.apply(1, "sadsdf");
        return null;
    }

    public static void main(String[] args) {
        //a_2_afterLambda();
        // a_3_afterLambda();
        // createPerson4(Person::new, Person::new);
        createPerson5(Person::new, Person::new, Person::new);

        // Stream.of(1).map(Person::new).collect(Collectors.toList());
    }

    private static void a_3_afterLambda() {
        createPerson3(Person::new);

        int j = 10;
        createPerson3(() -> {
            var person = new Person();
            if (j == 10) {
                person.age = 100;
            }
            return person;
        });
    }

    private static void a_2_afterLambda() {
        var context = new Context();
        var p = createPerson2(context, (ctx) -> {
            return new Person();
        });
        System.out.println(p);
        System.out.println("------------------------");

        p = createPerson2(context, (ctx) -> new Person());
        System.out.println(p);
        System.out.println("------------------------");

        context = new Context();
        context.shouldInitAge = true;
        context.age = 11;
        p = createPerson2(context, (ctx) -> {
            System.out.println("Init age");
            var result = new Person();
            result.setAge(ctx.age);
            return result;
        });
        System.out.println(p);

        System.out.println("------------------------");
        context = new Context();
        context.shouldInitName = true;
        context.name = "Dmitry";
        p = createPerson2(context, (ctx) -> {
            System.out.println("Init name");
            var result = new Person();
            result.setName(ctx.name);
            return result;
        });
        System.out.println(p);
    }

    private static void a_1_beforeLambda() {
        var context = new Context();
        var p = createPerson(context);
        System.out.println(p);

        System.out.println("------------------------");
        context = new Context();
        context.shouldInitAge = true;
        context.age = 11;
        p = createPerson(context);
        System.out.println(p);

        System.out.println("------------------------");
        context = new Context();
        context.shouldInitName = true;
        context.name = "Dmitry";
        p = createPerson(context);
        System.out.println(p);
    }
}
