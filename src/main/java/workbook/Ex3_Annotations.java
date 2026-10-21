package workbook;

public class Ex3_Annotations {
    // Îi spunem compilatorului să nu ne mai streseze cu warning-uri pentru cod depreciat
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        TestDataGenerator gen = new TestDataGenerator();

        // În IDE, această metodă va apărea tăiată cu o linie (strikethrough)
        String oldData = gen.generateUserLegacy();
        System.out.println("Date vechi: " + oldData);

        String newData = gen.generateUserSecure();
        System.out.println("Date sigure: " + newData);
    }
}