package com.restoraunt;

public class PrintMenu {
    public static void printMenu() {
        Menu.setRandomPromotion();
        for (Menu menu : Menu.values()) {
            String itemName;
            if (menu.isPromotion()) {
                itemName = menu.toString() + " (Promotion)";
            } else {
                itemName = menu.toString();
            }

            int itemPrice;
            if (menu.isPromotion()) {
                itemPrice = menu.getValue() / 2;
            } else {
                itemPrice = menu.getValue();
            }

            System.out.println(itemName + " -- " + itemPrice + "$");
        }

    }
}
