package Chapter3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Implementare pentru Product din JSON
class JsonProductReader implements DataReader<Product> {
    @Override
    public List<Product> readData(String jsonPath) throws IOException {
        System.out.println("Citire și parsare Product din JSON: " + jsonPath);
        // ... logică specifică JSON (ex: cu Jackson/Gson) ...
        List<Product> products = new ArrayList<>(); // Placeholder
        // products.add(new Product(...));
        return products;
    }
}

