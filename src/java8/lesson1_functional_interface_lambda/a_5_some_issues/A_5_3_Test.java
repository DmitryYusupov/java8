package java8.lesson1_functional_interface_lambda.a_5_some_issues;

public class A_5_3_Test {

    static class Wrapper {
        int k;

        public Wrapper(int k) {
            this.k = k;
        }
    }

    interface SuperFunctional {
        void test();
    }

    static void method(SuperFunctional superFunctional) {

    }

    public static void main(String[] args) {
    }


    private static void test34() {
        final var wrapper = new Wrapper(10);
        method(() -> {
            wrapper.k++;
            System.out.println(wrapper);
        });
        wrapper.k = 900;
        System.out.println(wrapper.k);
    }

    private static void test33() {
        int k = 33;
        method(() -> {
            System.out.println(k);
        });
        System.out.println(k);
        //System.out.println(k++);
    }
}
