package java8.lesson4_method_references.lesson;

import java.util.function.Function;

public class A_3_MathUtils_Method_reference_static {

    enum HOW_TO_MODIFY {
        SQUARE,
        SQRT
    }

    public static double sqrtAndGet(Number number) {
        return Math.sqrt(number.doubleValue());
    }

    public static double squareAndGet(Number number) {
        return Math.pow(number.doubleValue(), 2);
    }

    public static double modifyAndGet(Number number, HOW_TO_MODIFY howToModify) {
        double result;
        System.out.println("Begin");
        if (HOW_TO_MODIFY.SQRT.equals(howToModify)) {
            result = sqrtAndGet(number);
        } else {
            result = squareAndGet(number);
        }
        System.out.println("End");
        return result;
    }

    public static double modifyAndGet(Number number, Function<Number, Double> function) {
        double result;
        System.out.println("Begin");
        result = function.apply(number);
        System.out.println("End");
        return result;
    }

    public static void main(String[] args) {
       // var result = modifyAndGet(3, number -> number.doubleValue() * 100d);

      /*  var result = modifyAndGet(2, number -> {
            return squareAndGet(number);
        });
        */
        var result = modifyAndGet(2, A_3_MathUtils_Method_reference_static::squareAndGet);
        result = modifyAndGet(2, A_3_MathUtils_Method_reference_static::sqrtAndGet);

        System.out.println(result);
    }

    private static void a_1_simpleNumberModifier() {
        System.out.println(sqrtAndGet(2));
        System.out.println(squareAndGet(3));
        System.out.println("--------------------------");
        System.out.println(modifyAndGet(2, HOW_TO_MODIFY.SQRT));
        System.out.println(modifyAndGet(3, HOW_TO_MODIFY.SQUARE));
    }
}
