package utils;

import java.util.Scanner;

public class ScannerUtils {

    private static Scanner scanner;

    static{
        scanner = new Scanner(System.in);
    }

    public static Scanner getScanner() {
        return scanner;
    }
}
