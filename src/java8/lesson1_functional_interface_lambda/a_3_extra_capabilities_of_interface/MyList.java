package java8.lesson1_functional_interface_lambda.a_3_extra_capabilities_of_interface;

@FunctionalInterface
public interface MyList {
    public static final int k =44;

    int size();

    default int maxCapacity() {
        if (true) {
            test();
        }
        return 0;
    }

    private void test() {
        System.out.println("ss");
    }

    static void test2() {
        System.out.println("Test");
    }
}
