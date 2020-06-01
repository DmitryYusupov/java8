package java8.lesson5_date_time_collections.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class A_3_List_New_Features {

    static class Plane {
        int maxSpeed;

        public Plane(int maxSpeed) {
            this.maxSpeed = maxSpeed;
        }

        public int getMaxSpeed() {
            return maxSpeed;
        }
    }

    public static void main(String[] args) {
        var planes = new ArrayList<>(List.of(
                new Plane(10),
                new Plane(3),
                new Plane(7)
        ));

        planes.sort(Comparator.comparing(Plane::getMaxSpeed));
        //(arg, rest) -> arg.method(rest)
        planes.forEach(p -> System.out.println(p.getMaxSpeed()));
    }
}
