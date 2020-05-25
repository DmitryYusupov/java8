package java8.lesson2_prebuild_functional_intefaces;

import java.util.function.Supplier;

public class A_3_Supplier {

    private static class Person {
        boolean vegetarian;

        public Person(boolean vegetarian) {
            this.vegetarian = vegetarian;
        }

        public void eat(Dish dish) {
            String description = vegetarian ? "vegetarian" : "meater";
            System.out.println(description + " eating " + dish.name);
        }
    }

    static class Dish {
        private String name;

        public Dish(String name) {
            System.out.println("Prepare food " + name);
            this.name = name;
        }

        public void prepareFood() {
            System.out.println("Warm '" + name + "'");
        }
    }

    private static void birthDay(Person person, Dish meat, Dish vegetables) {
        if (person.vegetarian) {
            person.eat(vegetables);
        } else {
            person.eat(vegetables);
            person.eat(meat);
        }
    }

    private static void birthDay(Person person, Supplier<Dish> meat, Supplier<Dish> vegetables) {
        if (person.vegetarian) {
            person.eat(vegetables.get());
        } else {
            person.eat(vegetables.get());
            person.eat(meat.get());
        }
    }


    private static void birthDay22(Person person, PrepareFood meat, PrepareFood vegetables) {
        if (person.vegetarian) {
            person.eat(vegetables.prepare());
        } else {
            person.eat(vegetables.prepare());
            person.eat(meat.prepare());
        }
    }

    interface PrepareFood {
        Dish prepare();
    }


    public static void main(String[] args) {
        //a_1_prepareToResourceEffectiveBirthday();
        a_3_prepareToResourceEffectiveBirthday();
    }

    private static void a_1_prepareToResourceEffectiveBirthday() {
        Supplier<Dish> shaverma = () -> {
            var dish = new Dish("Shaverma");
            dish.prepareFood();
            return dish;
        };

        Supplier<Dish> salat = () -> {
            var dish = new Dish("Vitaminniy salat");
            dish.prepareFood();
            return dish;
        };

        System.out.println("--- John -------");
        var john = new Person(true);
        birthDay(john, shaverma, salat);
    }

    private static void a_2_prepareToNotResourceEffectiveBirthday() {
        var shaverma = new Dish("Shaverma");
        shaverma.prepareFood();

        var salat = new Dish("Vitaminniy salat");
        salat.prepareFood();

        System.out.println("--- John -------");
        var john = new Person(true);
        birthDay(john, shaverma, salat);
    }

    private static void a_3_prepareToResourceEffectiveBirthday() {
        System.out.println("--- John -------");
        var john = new Person(true);
        birthDay22(john, new PrepareFood() {
            @Override
            public Dish prepare() {
                var dish = new Dish("Shaverma");
                dish.prepareFood();
                return dish;
            }
        }, new PrepareFood() {
            @Override
            public Dish prepare() {
                var dish = new Dish("Vitaminniy salat");
                dish.prepareFood();
                return dish;
            }
        });
    }


}
