package com.restoraunt;

import java.util.Scanner;

import static com.restoraunt.Intro.printIntro;
import static com.restoraunt.PrintMenu.printMenu;

public class Main {
    public static void main(String[] args) {

        printIntro();
        printMenu();

        HandleChoice menu = new HandleChoice();
        Scanner scanner = new Scanner(System.in);

        menu.addChoice(scanner);

        int totalPrice = Menu.countPrice(menu.getChoices());

        Discount.applyDiscount(menu.getChoices(), totalPrice, scanner);

        Receipt receipt = new Receipt(menu.getChoices(), totalPrice, Discount.isMegaDiscountApplied(), Discount.isMealDiscountApplied(), Discount.getDiscountAmount());
        receipt.printReceipt();
    }
}
