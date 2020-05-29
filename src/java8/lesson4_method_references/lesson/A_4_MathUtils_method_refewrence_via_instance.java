package java8.lesson4_method_references.lesson;

import java.util.function.Function;

public class A_4_MathUtils_method_refewrence_via_instance {

    public double sqrtAndGet(Number number) {
        return Math.sqrt(number.doubleValue());
    }

    public double squareAndGet(Number number) {
        return Math.pow(number.doubleValue(), 2);
    }

    public double modifyAndGet(Number number, Function<Number, Double> function) {
        double result;
        System.out.println("Begin");
        result = function.apply(number);
        System.out.println("End");
        return result;
    }

    public double modifyAndGet() {
        this.modifyAndGet(2, this::sqrtAndGet);
        return 1;
    }

    public static void main(String[] args) {
        A_4_MathUtils_method_refewrence_via_instance mathUtils = new A_4_MathUtils_method_refewrence_via_instance();
        var result = mathUtils.modifyAndGet(2, it -> it.doubleValue() * 200d);

        result = mathUtils.modifyAndGet(2, it -> {
            A_4_MathUtils_method_refewrence_via_instance a4MathUtils = new A_4_MathUtils_method_refewrence_via_instance();
            return a4MathUtils.sqrtAndGet(it);
        });

        result = mathUtils.modifyAndGet(2, it -> {
            return mathUtils.sqrtAndGet(it);
        });

        result = mathUtils.modifyAndGet(2, mathUtils::sqrtAndGet);
        System.out.println(result);
    }

}
