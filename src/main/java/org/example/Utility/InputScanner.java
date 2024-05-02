package org.example.Utility;

import java.util.Scanner;

public class InputScanner {
    private static Scanner scanner;

    public static Scanner useScanner(){
        scanner = new Scanner(System.in);
        return scanner;
    }
}
