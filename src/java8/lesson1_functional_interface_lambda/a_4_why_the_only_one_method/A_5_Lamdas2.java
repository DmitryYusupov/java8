package java8.lesson1_functional_interface_lambda.a_4_why_the_only_one_method;

public class A_5_Lamdas2 {
/*
    interface Db {
        open();
        close();
    }
  */
    interface Test {
        void method(int a, int b);
        void method2(int a, int b, int c);
    }

    private static void method(Test t) {
        t.method(1, 2);
    }

    public static void main(String[] args) {
        method(new Test() {
            int k;
            {

            }

            @Override
            public void method(int a, int b) {
                System.out.println(k);
            }

            @Override
            public void method2(int a, int b, int c) {

            }
        });
        /*
        method((int x, int y) -> {
            System.out.println(x);
        });*/
    }
}
