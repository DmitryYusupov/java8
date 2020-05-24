package java8.lesson1_functional_interface_lambda.a_2_functional_interface_in_action;

@FunctionalInterface
public interface Listener {
    void onEvent(String event);
}
