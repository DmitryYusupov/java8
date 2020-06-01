package java8.lesson5_date_time_collections.collections;

import java.util.*;

public class A_1_Creation {

    public static void main(String[] args) {
        // System.out.println(b_2_createSet());
     //   System.out.println(c_1_createMap());
    //    System.out.println(c_2_createMap());
    }

    private static List<String> a_1_createList() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("aa");
        list.add("aa");
        list.add("aa");

        return list;
    }

    private static List<String> a_2_createList() {
        List<String> list = Arrays.asList("a", "b", "c");
        //list.add("e"); //uncomment to throw exception
        return list;
    }

    private static List<String> a_3_createList() {
        var list = List.of("a", "b", "c");
        list.add("d");
        return list;
    }

    private static Set<String> b_1_createSet() {
        return Set.of("a", "b", "c");
    }

    private static Set<String> b_2_createSet() {
        return Set.of("a", "b", "c", "c");
    }

    private static Map<String, Integer> c_1_createMap() {
        return Map.of("One", 1, "Two", 2);
    }

    private static Map<String, Integer> c_2_createMap() {
        return Map.of("One", 1, "Two", 2, "One", 3);
    }
}
