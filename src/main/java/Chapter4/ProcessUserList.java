package Chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessUserList {

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alice", 25),
                new User("Bob", 35),
                new User("Charlie", 40),
                new User("Diana", 29)
        );

        System.out.println("Original users: " + users);

        // Procesare cu Stream API
        List<String> namesOfUsersOver30 = users.stream() // Obține stream
                .filter(user -> user.getAge() > 30) // Filtrează după vârstă
                .map(User::getName) // Extrage numele (method reference)
                // Echivalent cu: .map(user -> user.getName())
                .collect(Collectors.toList()); // Colectează rezultatele într-o listă

        System.out.println("\nNames of users over 30: " + namesOfUsersOver30);
    }
}
