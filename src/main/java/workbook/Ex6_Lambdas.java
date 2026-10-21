package workbook;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ex6_Lambdas {
    public static void main(String[] args) {

        // 1. Predicate: Evaluează o condiție și returnează true/false
        // Numele testului conține "API"?
        Predicate<String> isApiTest = testName -> testName.contains("API");

        System.out.println("Este 'Login_UI' un test de API? " + isApiTest.test("Login_UI"));
        System.out.println("Este 'Get_Users_API' un test de API? " + isApiTest.test("Get_Users_API"));

        // 2. Consumer: Primește un argument și execută ceva cu el (fără return)
        Consumer<String> reportError = errorMsg -> System.err.println("ALARMĂ BUG: " + errorMsg.toUpperCase());

        reportError.accept("elementul buton_salvare nu este vizibil!");
    }
}
