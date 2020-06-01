package java8.lesson5_date_time_collections.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

public class A_4_Map_New_Features {

    public static void main(String[] args) {
        //a_1_mapCreation();
        //  a_2_putIfAbsent();
        //  a_4_demo_computeIfAbsent();
        //  a_4_demo_computeIfPresent();
        a_5_demoMerge();
    }

    static class Key implements Comparable<Key> {
        private String value;

        public Key(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(value, key.value);
        }

        @Override
        public int hashCode() {
            return 0;
        }

        public static void main(String[] args) {
            var key = new Key("aa");
            System.out.println(key.hashCode());
            System.out.println(System.identityHashCode(key));
        }

        @Override
        public int compareTo(Key o) {
            return 0;
        }
    }

    private static void a_1_mapCreation() {
        Map<Key, String> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(new Key(i + ""), i + "");
        }
        System.out.println(map);
    }

    private static void a_2_putIfAbsent() {
        Map<String, Integer> map = new HashMap<>();
        map.putIfAbsent("1", 1);
        map.putIfAbsent("1", 2);
        System.out.println(map);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

        }
    }

    private static void a_3_demo_workWithKeyValue() {
        Map<String, Integer> map = new HashMap<>();
        map.putIfAbsent("1", 1);
        //old
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
        }

        map.forEach((k, v) -> {
            System.out.println();
        });
    }

    private static void a_4_demo_computeIfAbsent() {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.computeIfAbsent("2", (key) -> key.length() + 1);
        System.out.println(map);
    }

    private static void a_4_demo_computeIfPresent() {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.computeIfPresent("1", (key, oldValue) -> oldValue + 99);
        System.out.println(map);
    }

    private static void a_5_demoMerge() {
        Map<String, Integer> map = new HashMap<>();
        var defaultValue = map.getOrDefault("9999", -1);
        map.put("1", 1);
        map.merge("200", 100, (oldV, newValue) -> {
            return oldV + newValue;
        });
        map.merge("1", 100, (oldV, newValue) -> {
            return oldV + newValue;
        });
        System.out.println(map);
        map.merge("1", 100, (oldV, newValue) -> {
            return null;
        });
        System.out.println(map);
    }

    private static void a_6_demoCustomMerge(String key, int i, BiFunction<Integer, Integer, Integer> biFunction) {
        Map<String, Integer> map = new HashMap<>();

        boolean mapHasntNewKey = !map.containsKey(key);
        if (mapHasntNewKey) {
            map.put(key, i);
        } else {
            Integer prevValue = map.get(key);
            Integer newValue = i;
            Integer newValueForKey = biFunction.apply(prevValue, newValue);

            map.put(key, newValueForKey);
        }
    }

}
