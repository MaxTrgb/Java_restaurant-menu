package com.restoraunt;

import java.util.List;
import java.util.Random;

public final class MenuManager {
    private MenuManager() {}

    public static int countPrice(List<Menu> choices) {
        int totPrice = 0;
        for (Menu choice : choices) {
            totPrice += choice.isPromotion() ? choice.getValue() / 2 : choice.getValue();
        }
        return totPrice;
    }
    public static void setRandomPromotion() {
        Menu[] values = Menu.values();
        int randomIndex = new Random().nextInt(values.length);
        Menu menuToPromote = values[randomIndex];
        menuToPromote.setPromotion(true);
    }

}
