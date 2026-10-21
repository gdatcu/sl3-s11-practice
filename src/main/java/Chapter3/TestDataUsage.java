package Chapter3;

import java.io.IOException;
import java.util.List;

public class TestDataUsage {
    public static void main(String[] args) throws IOException { // Simplificat pt exemplu
        // Reader specific pentru User
        DataReader<User> userReader = new CsvUserReader();
        List<User> testUsers = userReader.readData("test-data/users.csv");
        System.out.println("Utilizatori citiți: " + testUsers.size());

        System.out.println();

        // Reader specific pentru Product
        DataReader<Product> productReader = new JsonProductReader();
        List<Product> testProducts = productReader.readData("test-data/products.json");
        System.out.println("Produse citite: " + testProducts.size());

        // Același framework poate gestiona diferite tipuri de date și surse
    }
}

