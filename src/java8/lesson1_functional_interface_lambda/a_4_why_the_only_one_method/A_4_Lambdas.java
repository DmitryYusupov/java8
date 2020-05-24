package java8.lesson1_functional_interface_lambda.a_4_why_the_only_one_method;

public class A_4_Lambdas {

    @FunctionalInterface
    interface Lambda {
        int test(int a, int b);
    }


    @FunctionalInterface
    interface Lambda2 {
        int test(int a);
    }


    private static void method_1(Lambda lambda) {
        lambda.test(1, 2);
    }

    private static void method_2(Lambda2 lambda) {
        lambda.test(1);
    }

    public static void main(String[] args) {
        method_1(new Lambda() {
            @Override
            public int test(int a, int b) {
                return 0;
            }
        });

        method_1((int a, int b) -> {
            System.out.println(a + b);
            return a + b;
        });
        method_1((int a, int b) -> {
            return a + b;
        });

        //method_1((int a, int b) -> return a + b;);
        //method_1((int a, int b) -> return a + b);
        method_1((int a, int b) -> a + b);

        method_1((int a, int b) -> {
            System.out.println("Some extra actions");
            return a + b;
        });

        method_1((a, b) -> a + b);

        method_1((a, b) -> {
            System.out.println("Some extra actions");
            return a + b;
        });

        method_2(a -> a);
        method_1((int a, int b) -> {
            return 0;
        });
    }
}
