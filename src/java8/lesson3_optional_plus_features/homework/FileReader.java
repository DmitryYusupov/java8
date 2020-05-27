package java8.lesson3_optional_plus_features.homework;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileReader {

    @FunctionalInterface
    interface LineHandler {
        void onNext(String line);
    }

    @FunctionalInterface
    interface CompleteHandler {
        void onComplete();
    }

    @FunctionalInterface
    interface OnErrorHandler {
        void onError(Exception e);
    }

    private FileReader() {
    }

    public static void doWithFile(File file,
                                  LineHandler lineHandler,
                                  CompleteHandler completeHandler,
                                  OnErrorHandler errorHandler) {
        verifyFile(file);
        try (var reader = Files.newBufferedReader(Path.of(file.getAbsolutePath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineHandler.onNext(line);
            }
            completeHandler.onComplete();
        } catch (Exception e) {
            errorHandler.onError(e);
        }
    }

    private static void verifyFile(File file) {
        if (!file.isFile()) {
            throw new RuntimeException("'" + file.getName() + "' is not a file");
        }
    }
}
