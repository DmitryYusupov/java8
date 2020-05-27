package java8.lesson3_optional_plus_features.lesson;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

public class A1_NewFeatures {

    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A1_NewFeatures that = (A1_NewFeatures) o;
        return age == that.age &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static void main(String[] args) {
        /*Integer i = new Integer(1);
        Integer.valueOf(1);
        demoStringEquals();
         */
      //  demoCompareArrays();
    }

    private static void demoStringEquals() {
        String s1 = "s";
        String s2 = "s2";

        System.out.println(Objects.equals(s1, s2));
    }

    private static void demoCompareArrays() {
        int[] a1 = new int[]{1, 2, 3};
        int a2[] = new int[]{1, 2, 3};

        System.out.println(a1.equals(a2));
        System.out.println(Objects.equals(a1, a2));
        System.out.println(Arrays.equals(a1, a2));
    }

    private static void demoPath(){
        Path.of("file.getAbsolutePath())");
        Paths.get("asdasd");
    }
}
