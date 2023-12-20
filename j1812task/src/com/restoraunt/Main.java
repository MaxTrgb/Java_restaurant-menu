package com.restoraunt;


public class Main {
    public static void main(String[] args) {

        PrintManager.printIntro();
        PrintManager.printMenu();

        HandleManager menu = new HandleManager();

        menu.addChoice();

        int totalPrice = MenuManager.countPrice(menu.getChoices());

        Discount discount = new Discount();
        discount.applyDiscount(menu.getChoices(), totalPrice);

        Receipt receipt = new Receipt(discount, menu.getChoices(), totalPrice);

        PrintManager.printReceipt(receipt);
    }
}
