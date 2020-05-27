package java8.lesson3_optional_plus_features.lesson;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class A2_Comparator {

    private static class Book {
        private String name;
        private int pages;

        public Book(String name, int pages) {
            Objects.requireNonNull(name, "Book should have name");
            this.name = name;
            this.pages = pages;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", pages=" + pages +
                    '}';
        }
    }


    static class BooksComparator implements Comparator<Book> {
        enum Order {
            ASC, DESC
        }

        private Order order;

        public BooksComparator() {
            this.order = Order.ASC;
        }

        public BooksComparator(Order order) {
            this.order = order;
        }

        @Override
        public int compare(Book b1, Book b2) {
            var tempResult = compareInternal(b1, b2);
            return Order.DESC.equals(order) ? -1 * tempResult : tempResult;
        }

        private int compareInternal(Book b1, Book b2) {
            var compareByName = b1.name.compareTo(b2.name);
            if (compareByName == 0) {
                return b1.pages - b2.pages;
            } else {
                return compareByName;
            }
        }

    }

    public static void main(String[] args) {
        var books = List.of(
                new Book("Z", 1000),
                new Book("A", 100),
                new Book("Z", 100)
        );

        var sorted = new TreeSet<Book>(new BooksComparator());
        sorted.addAll(books);
        System.out.println(sorted);

        sorted = new TreeSet<Book>(new BooksComparator(BooksComparator.Order.DESC));
        sorted.addAll(books);
        System.out.println(sorted);

        Comparator<Book> compareByName = (b1, b2) -> b1.name.compareTo(b2.name);
        Comparator<Book> compareByPage = (b1, b2)-> b1.pages - b2.pages;


        var finalComparator = compareByName
                              .thenComparing(compareByPage);

        sorted = new TreeSet<>(finalComparator);
        sorted.addAll(books);
        System.out.println(sorted);

        sorted = new TreeSet<>(finalComparator.reversed());
        sorted.addAll(books);
        System.out.println(sorted);

    }
}
