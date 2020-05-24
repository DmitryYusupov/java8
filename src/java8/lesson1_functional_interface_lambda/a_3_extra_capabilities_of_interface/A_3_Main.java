package java8.lesson1_functional_interface_lambda.a_3_extra_capabilities_of_interface;

public class A_3_Main {


    public static void main(String[] args) {
        var s = StringUtils.toUpperCase("aaa");
        System.out.println(s);

        test(new StringUtils() {
        });
    }


    private static void test(StringUtils stringUtils){

    }

}
