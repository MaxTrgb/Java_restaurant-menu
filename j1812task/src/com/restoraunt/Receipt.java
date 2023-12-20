package com.restoraunt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Receipt {

    private final List<Menu> items;
    private final double totalCost;
    private final boolean megaDiscountApplied;
    private final boolean mealDiscountApplied;
    private final double discountAmount;

    public Receipt(List<Menu> items, double totalCost, boolean megaDiscountApplied, boolean mealDiscountApplied, double discountAmount) {
        this.items = items;
        this.totalCost = totalCost;
        this.megaDiscountApplied = megaDiscountApplied;
        this.mealDiscountApplied = mealDiscountApplied;
        this.discountAmount = discountAmount;
    }

    public void printReceipt() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(new Date());

        System.out.println("\nReceipt generated at: " + formattedDate);
        System.out.println("Items Purchased:");

        for (Menu item : items) {
            System.out.println(item);
        }

        if (megaDiscountApplied) {
            System.out.println("Mega Discount Applied: -20%");
        }

        if (mealDiscountApplied) {
            System.out.println("Meal Discount Applied: -10% on selected item");
        }

        System.out.println("Total Cost: " + totalCost + "$");
    }
}
