package java8.lesson3_optional_plus_features.lesson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class A_4_Optional {
    /*____
    CODE     | TIME
    gr4__404 |17.10.2001
     */
    enum ErrorCode {
        E404("gr4__404"),
        E401("gr4__401"),
        E500("gr5__500");

        static Map<String, ErrorCode> errorCodeByDbField = new HashMap<>();

        static {
            for (ErrorCode e : ErrorCode.values()) {
                errorCodeByDbField.put(e.dbField, e);
            }
        }


        private String dbField;

        ErrorCode(String dbField) {
            this.dbField = dbField;
        }

        public static ErrorCode getErrorCodeByDbData(String dbData) {
            for (ErrorCode e : ErrorCode.values()) {
                if (e.dbField.equals(dbData)) {
                    return e;
                }
            }

            return null;
        }

        public static Optional<ErrorCode> getErrorCodeByDbData2(String dbData) {
            for (ErrorCode e : ErrorCode.values()) {
                if (e.dbField.equals(dbData)) {
                    return Optional.of(e);
                }
            }

            return Optional.empty();
        }

        public static Optional<ErrorCode> getErrorCodeByDbData3(String dbData) {
            return Optional.ofNullable(errorCodeByDbField.get(dbData));
        }
    }

    public static void main(String[] args) {
        //a_1_exampleWithNpe();
        //a_2_exampleNoNpe();
        // a_3_exampleNoNpe();
        // a_4_exampleNoNpe();
      //  a_5_exampleNoNpe();
        a_6_exampleNoNpe();
    }

    private static void a_1_exampleWithNpe() {
        List<String> errorsFromDb = List.of("gr4__404", "gr4__403");

        errorsFromDb.forEach(error -> {
            var errorCodeEnum = ErrorCode.getErrorCodeByDbData(error);
            deleteErrorsByCode(errorCodeEnum);
        });
    }

    private static void a_2_exampleNoNpe() {
        List<String> errorsFromDb = List.of("gr4__404", "gr4__403");

        errorsFromDb.forEach(error -> {
            Optional<ErrorCode> optionalErrorCode = ErrorCode.getErrorCodeByDbData2(error);
            if (optionalErrorCode.isPresent()) {
                deleteErrorsByCode(optionalErrorCode.get());
            }
        });
    }

    private static void a_3_exampleNoNpe() {
        List<String> errorsFromDb = List.of("gr4__404", "gr4__403");

        errorsFromDb.forEach(errorStrFromDb -> {
            Optional<ErrorCode> optionalErrorCode = ErrorCode.getErrorCodeByDbData3(errorStrFromDb);
            if (optionalErrorCode.isPresent()) {
                deleteErrorsByCode(optionalErrorCode.get());
            } else {
                System.out.println("Unknown error: " + errorStrFromDb);
            }
        });
    }

    private static void a_4_exampleNoNpe() {
        List<String> errorsFromDb = List.of("gr4__404", "gr4__403");

        errorsFromDb.forEach(errorStrFromDb -> {
            Optional<ErrorCode> optionalErrorCode = ErrorCode.getErrorCodeByDbData3(errorStrFromDb);
            optionalErrorCode.ifPresent(errorEnum -> {
                deleteErrorsByCode(errorEnum);
            });
        });
    }

    private static void a_5_exampleNoNpe() {
        List<String> errorsFromDb = List.of("gr4__404", "gr4__403");

        errorsFromDb.forEach(errorStrFromDb -> {
            Optional<ErrorCode> optionalErrorCode = ErrorCode.getErrorCodeByDbData3(errorStrFromDb);
            boolean deleteResult = optionalErrorCode.map(errorEnum -> {
                return deleteErrorsByCode(errorEnum);
            }).orElse(false);
        });
    }

    private static void a_6_exampleNoNpe() {
        List<String> errorsFromDb = List.of("gr4__404", "gr4__403");

        errorsFromDb.forEach(errorStrFromDb -> {
            Optional<ErrorCode> optionalErrorCode = ErrorCode.getErrorCodeByDbData3(errorStrFromDb);

            optionalErrorCode.ifPresentOrElse(
                    (ErrorCode errorCode) -> deleteErrorsByCode(errorCode),
                    () -> System.out.println("Unknown error: " + errorStrFromDb)
            );
        });
    }

    private static boolean deleteErrorsByCode(ErrorCode errorCode) {
        System.out.println("delete errors for " + errorCode.toString());
        return true;
    }
}
