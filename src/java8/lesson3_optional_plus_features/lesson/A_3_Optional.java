package java8.lesson3_optional_plus_features.lesson;

import java.util.Optional;

public class A_3_Optional {

    private static Integer a_1_valueOf(String s) {
        return Integer.valueOf(s);
    }

    private static Integer a_2_valueOf(String s) {
        try {
            return Integer.valueOf(s);
        } catch (Exception e) {
            return null;
        }
    }

    private static Optional<Integer> a_3_valueOf(String s) {
        try {
            Integer result = Integer.valueOf(s);
            return Optional.of(result);
        } catch (Exception e) {
            //return Optional.ofNullable(null);
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        //int k = a_1_valueOf("Ivan");
        //System.out.println(k);

        /*
        var result = a_2_valueOf("Ivan");
        if (result == null) {
            System.out.println("Bad number");
        }*/


        /*
        try {
            Integer.valueOf("Ivan");
        } catch (Exception e) {
            System.out.println("Bad number");
        }
       */

        //  demoOptionalMethods();

        Optional<Integer> result = a_3_valueOf("Ivan");
        if (result.isPresent()) {
            System.out.println("Continue work");
        } else {
            System.out.println("Bad number!!!");
        }
    }

    private static void demoOptionalMethods() {
        Optional<String> optionalS = Optional.of("SSS");
        Optional<String> optionalS2 = Optional.ofNullable("SSS");

        if (optionalS.isPresent()) {
            optionalS.get();
        } else {

        }
        //Optional.of(null);
        var opt = Optional.ofNullable(null);
        if (opt.isPresent()) {
            opt.get();
        }
    }

}
