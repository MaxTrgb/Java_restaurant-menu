package com.restoraunt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static com.restoraunt.Menu.GetMenuByName;

public class HandleChoice {
   List<Menu> choices = new ArrayList<>();

   public void addChoice(Scanner scanner) {
       String choice = scanner.next();
       while (!Objects.equals(choice, "confirm")) {
           Menu men = Menu.GetMenuByName(choice);
           if (men != null){
               choices.add(men);
           }

           choice = scanner.next();
       }
       int totalPrice = Menu.countPrice(choices);
       System.out.println("Total: " + totalPrice);
       for (Menu s : choices) {

           System.out.println(GetMenuByName(s.getName()));

       }

   }

    public List<Menu> getChoices() {
        return choices;
    }
}
