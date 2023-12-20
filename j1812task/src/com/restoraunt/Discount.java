package com.restoraunt;

import java.util.List;
import java.util.Scanner;

public class Discount {

    private static boolean megaDiscountApplied = false;
    private static boolean mealDiscountApplied = false;
    private static double discountAmount = 0.0;

    public static void applyDiscount(List<Menu> choices, int totalPrice, Scanner scanner) {
        System.out.println("Do you have a discount?");
        System.out.println("1. Mega discount coupon (valid for the entire check)");
        System.out.println("2. Discount coupon (valid for one meal)");
        System.out.println("3. No discount");

        int discountOption = scanner.nextInt();

        switch (discountOption) {
            case 1:
                applyMegaDiscount(totalPrice);
                break;
            case 2:
                applyMealDiscount(choices);
                break;
            case 3:
                System.out.println("No discount applied.");
                break;
            default:
                System.out.println("Invalid option. No discount applied.");
        }
    }

    private static void applyMegaDiscount(int totalPrice) {
        double discountPercentage = 0.2;
        discountAmount = totalPrice * discountPercentage;
        megaDiscountApplied = true;
        double discountedPrice = totalPrice - discountAmount;
        System.out.println("Mega Discount Applied: -" + discountAmount + "$");
        System.out.println("Discounted Price: " + discountedPrice + "$");
    }

    private static void applyMealDiscount(List<Menu> choices) {
        System.out.println("Select the meal to apply the discount to:");

        for (Menu choice : choices) {
            System.out.println(choice);
        }

        Scanner scanner = new Scanner(System.in);
        String discountedMeal = scanner.next();

        Menu discountedMenu = Menu.GetMenuByName(discountedMeal);
        if (discountedMenu != null && choices.contains(discountedMenu)) {
            double discountPercentage = 0.1;
            discountAmount = discountedMenu.getValue() * discountPercentage;
            mealDiscountApplied = true;
            System.out.println("Discount Applied to " + discountedMenu + ": -" + discountAmount + "$");
        } else {
            System.out.println("Invalid meal selection. No discount applied.");
        }
    }

    public static boolean isMegaDiscountApplied() {
        return megaDiscountApplied;
    }

    public static boolean isMealDiscountApplied() {
        return mealDiscountApplied;
    }

    public static double getDiscountAmount() {
        return discountAmount;
    }

    public static int calculateDiscountedPrice(int totalPrice) {
        return totalPrice;
    }
}
