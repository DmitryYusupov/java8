package java8.lesson2_prebuild_functional_intefaces;

import java.util.List;
import java.util.function.Consumer;

public class A_4_Consumer {

    public static void main(String[] args) {
        var list = List.of(1, 2, 3, 4, 5);

        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

}
