package workbook;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex7_StreamPipeline {
    public static void main(String[] args) {
        // O listă brută, venită dintr-un raport
        List<String> moduleResults = Arrays.asList(
                "Cart:PASSED", "Login:FAILED", "Checkout:FAILED", "Search:PASSED", "Profile:FAILED"
        );

        // Procesare Declarativă
        List<String> failedModules = moduleResults.stream()
                // 1. Filtrăm: vrem DOAR elementele care conțin "FAILED"
                .filter(item -> item.contains("FAILED"))
                // 2. Mapăm (transformăm): tăiem string-ul și păstrăm doar numele modulului
                .map(item -> item.split(":")[0])
                // 3. Mapăm din nou: transformăm în majuscule
                .map(String::toUpperCase)
                // 4. Colectăm: adunăm rezultatul final într-o Listă reală Java
                .collect(Collectors.toList());

        System.out.println("Echipa de dev trebuie să repare următoarele module:");
        System.out.println(failedModules);
        // Așteptat: [LOGIN, CHECKOUT, PROFILE]
    }
}