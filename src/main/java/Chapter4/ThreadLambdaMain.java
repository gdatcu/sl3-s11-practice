package Chapter4;

public class ThreadLambdaMain {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("--- Start Program pe thread-ul: " + Thread.currentThread().getName());

        // 1. STILUL VECHI (Clasă anonimă)
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running on another thread (old way) - Nume: " + Thread.currentThread().getName());
            }
        }).start();

        // 2. STILUL NOU (Cu Lambda)
        new Thread(() -> {
            System.out.println("Running on another thread (lambda way) - Nume: " + Thread.currentThread().getName());
        }).start();

        // Lăsăm thread-ul principal să aștepte o secundă pentru ca thread-urile de mai sus să își termine execuția
        Thread.sleep(1000);

        System.out.println("--- Sfârșit Program ---");
    }
}
