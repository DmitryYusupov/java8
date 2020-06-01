package java8.lesson5_date_time_collections.collections;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public class A_2_Collection_New_Features {

    public static void main(String[] args) {
        List<String> ss = List.of("a", "b", "c");

        workWithCollectionOldWay(ss, System.out::println);
        workWithCollectionOldWay(ss, s -> System.out.println(s.toUpperCase()));

        //--New feature---
        ss.forEach(t -> {
            System.out.println("ss");
            System.out.println(t);
        });


    }

    private static void deleteRecord_1(List<String> list, String itemToDelete) {
        var iter = list.iterator();
        while (iter.hasNext()) {
            if (iter.next().equals(itemToDelete)) {
                iter.remove();
            }
        }
    }

    private static void deleteRecord_2(List<String> list, String itemToDelete) {
        list.removeIf(s -> s.equals(itemToDelete));
    }

    private static <T> void workWithCollectionOldWay(Collection<T> collection,
                                                     Consumer<T> consumer) {
        for (T obj : collection) {
            consumer.accept(obj);
        }
    }


}
