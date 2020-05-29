package java8.lesson4_method_references.lesson;

public class A_6_High_OrderFunction {

    public static void main(String[] args) {
        //a_1_simpleMethods();
        //  a_2_simpleMethods();

        doTry(() -> {
            int i = 1;
            System.out.println(i / 0);
        });

        doTry(() -> {
            String s = null;
            s.length();
        });

        System.out.println(measure(()-> Thread.sleep(2000)));
    }

    private static long measure(Bodiable r) {
        long old = System.currentTimeMillis();
        try {
            r.invoke();
        }catch (Throwable e){
            e.printStackTrace();
        }
        long cur = System.currentTimeMillis();
        return cur - old;
    }

    private static void a_1_simpleMethods() {
        try {
            int i = 1;
            System.out.println(i / 0);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        try {
            String s = null;
            s.length();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static void a_2_simpleMethods() {
        a_2_simpleMethod_1();
        a_2_simpleMethod_2();
        System.out.println("End");
    }

    private static void a_2_simpleMethod_1() {
        try {
            int i = 1;
            System.out.println(i / 0);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println("This is finally");
            System.gc();
        }
    }

    private static void a_2_simpleMethod_2() {
        try {
            String s = null;
            s.length();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println("This is finally");
            System.gc();
        }
    }

    private static <T> void doTry(Bodiable body) {
        try {
            body.invoke();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println("This is finally");
            System.gc();
        }
    }

    interface Bodiable {
        void invoke() throws Throwable;
    }
}
