package java8.lesson3_optional_plus_features.homework;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileReaderDemo {
    public static void main(String[] args) {

        List<String> fileLines = new ArrayList<>();

        FileReader.doWithFile(new File("C:\\Users\\Dmitry_Yusupov\\Desktop\\java8\\java8\\src\\java8\\lesson3\\homework\\FileReaderDemo.java"),
                (s) -> fileLines.add(s),
                () -> {
                    fileLines.forEach(it -> System.out.println(it));
                },
                (ex) -> ex.printStackTrace()
        );
    }
}
