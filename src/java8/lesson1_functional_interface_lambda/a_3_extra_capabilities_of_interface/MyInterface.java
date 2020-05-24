package java8.lesson1_functional_interface_lambda.a_3_extra_capabilities_of_interface;

//@FunctionalInterface
public interface MyInterface {
    void test();

    default void defaultTest() {
        System.out.println("Default test");
    }

}
