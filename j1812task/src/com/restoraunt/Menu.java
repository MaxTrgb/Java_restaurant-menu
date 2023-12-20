package com.restoraunt;

import java.util.List;
import java.util.Random;

public enum Menu {
    PIZZA(13, false),
    BURGER(10, false),
    PASTA(18, false),
    CHICKEN(11, false),
    SALAD(9, false),
    SOUP(7, false),
    POTATO(5, false);

    private int value;
    private boolean isPromotion;

    public int getValue() {
        return value;
    }

    public boolean isPromotion() {
        return isPromotion;
    }

    Menu(int value, boolean isPromotion) {
        this.value = value;
        this.isPromotion = isPromotion;
    }

    public static Menu GetMenuByName(String value) {
        String temp = value.toUpperCase();
        for (Menu menu : Menu.values()) {
            if (menu.name().equals(temp)) {
                return menu;
            }
        }
        return null;
    }

    public static int countPrice(List<Menu> choices) {
        int totPrice = 0;
        for (Menu choice : choices) {
            totPrice += choice.isPromotion() ? choice.value / 2 : choice.value;
        }
        return totPrice;
    }

    public String getName() {
        return name();
    }

    public static void setRandomPromotion() {
        Menu[] values = Menu.values();
        int randomIndex = new Random().nextInt(values.length);
        Menu menuToPromote = values[randomIndex];
        menuToPromote.isPromotion = true;
    }
}
