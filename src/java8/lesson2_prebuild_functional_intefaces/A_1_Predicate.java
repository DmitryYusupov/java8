package java8.lesson2_prebuild_functional_intefaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class A_1_Predicate {


    private static class Plane {
        private String name;
        private int weight;

        public Plane(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return name;
        }
    }


    public static void main(String[] args) {
        List<Plane> planes = new ArrayList<>();
        planes.add(new Plane("B 747", 10));
        planes.add(new Plane("Il 86", 20));

        planes = Arrays.asList(
                new Plane("B 747", 10),
                new Plane("Il 86", 20)
        );

        planes = List.of(
                new Plane("B 747", 10),
                new Plane("IL 86", 20),
                new Plane("IL 96", 30)
        );


        /*
        //before anonymous class
        var ilPlanes = getIlushinPlanes(planes);
        System.out.println(ilPlanes);

        var boeingPlanes = getBoeingPlanes(planes);
        System.out.println(boeingPlanes);

        var heavyPlanes = getHeavyPlanes(planes);
        System.out.println(heavyPlanes);
         */

        ////with anonymous class
        /*var ilPlanes = getPlanes(planes, new PlaneChecker() {
            @Override
            public boolean check(Plane plane) {
                return plane.name.contains("IL");
            }
        });
        System.out.println(ilPlanes);

        var boeingPlanes = getPlanes(planes, new PlaneChecker() {
            @Override
            public boolean check(Plane plane) {
                return plane.name.contains("B");
            }
        });
        System.out.println(boeingPlanes);
        */


        /*
        //refactor with lambda
        var ilPlanes = getPlanes(planes, (Plane p) -> {
            return p.name.contains("IL");
        });
        System.out.println(ilPlanes);

        var boeingPlanes = getPlanes(planes, it -> it.name.contains("B"));
        System.out.println(boeingPlanes);
         */


        //refactor with predicate
        var ilPlanes = getPlanes(planes, (Plane p) -> {
            return p.name.contains("IL");
        });
        System.out.println(ilPlanes);

        var boeingPlanes = getPlanes(planes, it -> {
                    try {
                        if (true) throw new Exception("Parent exception");
                        //if (true) throw new IllegalStateException();
                        return it.name.contains("B");
                    } catch (Exception e) {
                        RuntimeException runtimeException = new RuntimeException("ERROR");
                        runtimeException.initCause(e);
                        throw runtimeException;
                    }
                }
        );
        System.out.println(boeingPlanes);
    }

    /**
     * AAA -> onNext(String s){ }
     *        onComplete()
     *        onError()
     * BBB
     * CCC
     * @param allPlanes
     * @return
     */
    private static List<Plane> getIlushinPlanes(List<Plane> allPlanes) {
        List<Plane> result = new ArrayList<>();
        for (Plane p : allPlanes) {
            if (p.name.contains("IL")) {
                result.add(p);
            }
        }
        return result;
    }

    private static List<Plane> getBoeingPlanes(List<Plane> allPlanes) {
        List<Plane> result = new ArrayList<>();
        for (Plane p : allPlanes) {
            if (p.name.contains("B")) {
                result.add(p);
            }
        }
        return result;
    }

    private static List<Plane> getHeavyPlanes(List<Plane> allPlanes) {
        List<Plane> result = new ArrayList<>();
        for (Plane p : allPlanes) {
            if (p.weight >= 20) {
                result.add(p);
            }
        }
        return result;
    }

    /* private static List<Plane> getPlanes(List<Plane> allPlanes, PlaneChecker planeChecker) {
         List<Plane> result = new ArrayList<>();
         for (Plane p : allPlanes) {
             if (planeChecker.check(p)) {
                 result.add(p);
             }
         }
         return result;
     }

     @FunctionalInterface
     interface PlaneChecker {
         boolean check(Plane plane);
     }
 */
    private static List<Plane> getPlanes(List<Plane> allPlanes, Predicate<Plane> planeChecker) {
        List<Plane> result = new ArrayList<>();
        for (Plane p : allPlanes) {
            if (planeChecker.test(p)) {
                result.add(p);
            }
        }
        return result;
    }


}
