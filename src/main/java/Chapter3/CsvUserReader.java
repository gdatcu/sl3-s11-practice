package Chapter3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Implementare pentru User din CSV
class CsvUserReader implements DataReader<User> {
    @Override
    public List<User> readData(String csvPath) throws IOException {
        System.out.println("Citire și parsare User din CSV: " + csvPath);
        // ... logică specifică CSV ...
        List<User> users = new ArrayList<>(); // Placeholder
        // users.add(new User(...));
        return users;
    }
}