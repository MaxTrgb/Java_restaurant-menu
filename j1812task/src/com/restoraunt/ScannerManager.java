package com.restoraunt;

import java.util.Scanner;

public class ScannerManager {
    private static Scanner scanner;

    private ScannerManager() {}

    public static Scanner getInstance(){
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
