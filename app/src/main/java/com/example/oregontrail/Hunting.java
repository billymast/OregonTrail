package com.example.oregontrail;

import java.util.Scanner;

public class Hunting {

    public void Hunting (){};

    public boolean Hunt (Inventory inventory, int guess){

        int shots = inventory.getInventoryValue("Shots");

        int location = (int) (Math.random() * 5) + 1;

        if (shots != 0){
            if (guess == location) {
                inventory.removeInventory("Shots", 1);
                return true;
            }else {return false;}
        }
        return false;
    }

}
