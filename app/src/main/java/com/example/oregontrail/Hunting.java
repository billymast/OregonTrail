package com.example.oregontrail;

import java.util.Scanner;

public class Hunting {

    int distance;
    int location;

    int[][] map = new int[9][3];

    public void Hunting(){
        distance = (int) Math.random() * 3;
        location = (int) Math.random() * 10;
        map[location][distance] = 1;
    }

    public String distance () {
        int Distance = distance;
        switch (Distance){
            case 0:
                return "The distance is 10-20 yards";
            case 1:
                return "The distance is 30-40 yards";
            case 2:
                return "The distance is 50-60 yards";
            default: return "There is no prey nearby";
        }
    }

    public boolean takeShot (Inventory inventory, String type, int guess){
        double value = Math.random();
        switch (type) {
            case "Riffle":
                if (inventory.getInventoryValue("Riffle") != 0){
                    if (inventory.getInventoryValue("Shots") != 0) {
                        if (guess == location) {
                            switch (distance) {
                                case 0:
                                    if (value < 0.50) {
                                        return true;
                                    }
                                    break;
                                case 1:
                                    if (value < 0.25) {
                                        return true;
                                    }
                                    break;
                                case 2:
                                    if (value < 0.10) {
                                        return true;
                                    }
                                    break;
                                default:
                                    return false;
                            }
                        }
                    }
                }
                break;
            case "Shotgun":
                if (inventory.getInventoryValue("Shotgun") != 0){
                    if (inventory.getInventoryValue("Shots") != 0){
                        switch (distance){
                            case 0:
                                if (guess == location){
                                    if(value < 0.50){
                                        return true;
                                    }
                                }
                                break;
                            case 1:
                                if (guess == location){
                                    if (value < 0.25){
                                        return true;
                                    }
                                }
                                break;
                            case 2:
                                if (guess == location){
                                    if (value < 0.10){
                                        return true;
                                    }
                                }
                            default: return false;
                        }
                    }
                }


        }
        return false;
    }

}
