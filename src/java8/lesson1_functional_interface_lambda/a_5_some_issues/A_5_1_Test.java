package java8.lesson1_functional_interface_lambda.a_5_some_issues;

public class A_5_1_Test {

    interface A_5 {
        void method(int a);
    }

    interface A_5_New {
        void khkhkhkhkh(int a);
    }

    private void test_1(A_5 a_5) {
        System.out.println("This is A_5");
    }

    private void test_1(A_5_New a_5_new) {
        System.out.println("This is A_5_New");
    }

    public static void main(String[] args) {
        A_5_1_Test obj = new A_5_1_Test();
        A_5 a_5 = (int a) -> System.out.println(a);
        obj.test_1(a_5);
        obj.test_1((A_5_New) (int a) -> System.out.println(a));
    }

}
