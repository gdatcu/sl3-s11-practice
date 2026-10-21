package chapter4;

import org.testng.annotations.Test;

public class ThreadLambdaTest {

    @Test
    public void testThreadOldWay() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("TestNG [Old Way]: Rulat pe " + Thread.currentThread().getName());
            }
        }).start();

        Thread.sleep(100); // Scurtă pauză pentru a prinde output-ul în consolă
    }

    @Test
    public void testThreadLambdaWay() throws InterruptedException {
        new Thread(() -> {
            System.out.println("TestNG [Lambda Way]: Rulat pe " + Thread.currentThread().getName());
        }).start();

        Thread.sleep(100);
    }
}
