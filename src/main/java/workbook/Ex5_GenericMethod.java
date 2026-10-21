package workbook;

public class Ex5_GenericMethod {

    // Metodă generică: <E> declară că folosim un tip E în semnătura metodei
    public static <E> E extractFirst(E[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return null;
        }
        return inputArray[0];
    }

    public static void main(String[] args) {
        String[] browsers = {"Chrome", "Firefox", "Edge"};
        Integer[] ports = {8080, 443, 21};

        // Compilatorul înțelege automat din context ce tip să folosească!
        String firstBrowser = extractFirst(browsers);
        Integer firstPort = extractFirst(ports);

        System.out.println("Browser principal: " + firstBrowser);
        System.out.println("Port principal: " + firstPort);
    }
}