package chapter2;

class Dog extends Animal {
    @Override // Corect! Verifică dacă metoda există în Animal
    void makeSound() { System.out.println("Woof!"); }

    // @Override // GREȘIT! Ar genera eroare de compilare
    // void makeNoize() { } // Numele metodei e diferit
}