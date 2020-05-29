package java8.lesson4_method_references.lesson;

import java.util.function.Supplier;

public class A_7_ArrayHelper_Supplier_Demo {

    /*T[] createArray(int size) {
        return new T[size];
    }*/

    /*
        public static <T> T[] increaseArray(T[] arr) {
            T[] newArr = new T[arr.length * 2];

            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            return newArr;
        }
    */
    public static <T> T[] increaseArray(T[] arr, Supplier<T[]> arrayCreator) {
        boolean hasEnoughMemory = false;
        if (hasEnoughMemory) {

            T[] newArr = arrayCreator.get();
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            return newArr;

        } else {
            System.out.println("Not enough memory");
            return arr;
        }
    }


    public static <T> T[] increaseArray(T[] arr, T[] newArr) {
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3};
        var increasedArray = A_7_ArrayHelper_Supplier_Demo.increaseArray(arr, () -> new Integer[arr.length * 2]);
        System.out.println(increasedArray);

        increaseArray(arr, new Integer[arr.length * 2]);
    }

}
