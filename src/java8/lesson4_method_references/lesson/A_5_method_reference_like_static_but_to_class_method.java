package java8.lesson4_method_references.lesson;

import java.util.stream.Stream;

public class A_5_method_reference_like_static_but_to_class_method {

    public static void main(String[] args) {
        Stream.of("abc", "a")
                //.map(it->it.length())
                .map(String::length)
                .forEach(System.out::println);

        //(arg, rest) -> arg.method(rest)
        //AnyClass::method

    }
}
