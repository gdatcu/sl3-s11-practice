package chapter2;

import org.testng.annotations.*; // Exemplu cu TestNG

public class LoginTestSuite {

    @BeforeSuite
    public void globalSetup() {
        System.out.println("=== SETUP SUITE: Inițializare globală (o singură dată) ===");
        // Ex: Pornire Selenium Grid, citire configurare globală
    }

    @BeforeClass
    public void classSetup() {
        System.out.println("--- SETUP CLASĂ: Pregătire pentru testele de Login ---");
        // Ex: Creare utilizator de test în baza de date
    }

    @BeforeMethod
    public void testSetup() {
        System.out.println("   - SETUP TEST: Deschidere browser, navigare la pagina de login");
        // Ex: WebDriver driver = new ChromeDriver(); driver.get(loginUrl);
    }

    @Test(priority = 1, description = "Verifică login cu credențiale valide")
    public void testLoginSuccess() {
        System.out.println("      >> EXECUTING: testLoginSuccess");
        // ... logică test: introduce username, password, click login, assert welcome message ...
        assert true; // Placeholder
    }

    @Test(priority = 2, description = "Verifică login cu parolă greșită")
    public void testLoginFailureInvalidPassword() {
        System.out.println("      >> EXECUTING: testLoginFailureInvalidPassword");
        // ... logică test: introduce user valid, pass greșit, click login, assert error message ...
        assert true; // Placeholder
    }

    @AfterMethod
    public void testTeardown() {
        System.out.println("   - TEARDOWN TEST: Închidere browser, ștergere cookies");
        // Ex: driver.quit();
    }

    @AfterClass
    public void classTeardown() {
        System.out.println("--- TEARDOWN CLASĂ: Curățare după testele de Login ---");
        // Ex: Ștergere utilizator de test din baza de date
    }

    @AfterSuite
    public void globalTeardown() {
        System.out.println("=== TEARDOWN SUITE: Finalizare globală (o singură dată) ===");
        // Ex: Oprire Selenium Grid, generare raport final
    }
}
