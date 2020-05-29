package java8.lesson4_method_references.lesson;

import static java.util.Optional.ofNullable;

public class A_1_Bank_Optional_flatMap {

    private Storage storage;

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    static class Storage {
        Place place;
    }

    static class Place {
        Integer amount;
    }

    public int getAmount() {
        return storage.place.amount;
    }

    public int getAmount2() {
        if (storage != null) {
            if (storage.place != null) {
                if (storage.place.amount != null)
                    return storage.place.amount;
            }
        }
        return 0;
    }

    public int getAmount3() {
      /*  Optional.ofNullable(storage).map(s->{
            Optional.ofNullable(s.place).map(place -> {
                Optional.ofNullable(place.amount)
            })
        })*/

      /*
        Optional.ofNullable(storage).flatMap(storage -> {
            return Optional.ofNullable(storage.place);
        }).flatMap(place-> {
            return Optional.ofNullable(place.amount);
        }).map(Function.identity()).orElse(0);
*/

      // return storage?.place?.amount ?: 0
        return ofNullable(storage)
                .flatMap(storage -> ofNullable(storage.place))
                .flatMap(place -> ofNullable(place.amount))
                .orElse(0);
    }

    public static void main(String[] args) {
        A_1_Bank_Optional_flatMap bank = new A_1_Bank_Optional_flatMap();
        Storage storage = new Storage();
        storage.place = new Place();
        storage.place.amount = 900;
        bank.setStorage(storage);

        //System.out.println(getBankAmount(bank));
        //System.out.println(bank.getAmount2());
        System.out.println(bank.getAmount3());
    }

    private static int getBankAmount(A_1_Bank_Optional_flatMap bank) {
        return bank.getAmount();
    }
}
