package com.example.oregontrail;

import android.media.MediaCas;
import android.view.ViewDebug;
import java.util.LinkedList;


/**
 * This classes purpose is store the inventory values throughout the game
 * its allows you to add remove and view any value in the inventory with random access
 */

public class Inventory {

    private LinkedList<String[]> inventory;
    private String[] Food;
    private String[] Clothes;
    private String[] Rifle;
    private String[] Shotgun;
    private String[] Shots;
    private String[] Oxen;
    private String[] SpareWagonWheels;
    private String[] SpareWagonAxel;
    private String [] SpareWagonTongues;
    private String[] MedicalSupplyBox;
    private String[] SewingKit;
    private String[] FireStartingKit;
    private String[] KidsToys;
    private String[] FamilyKeepsakes;
    private String[] SeedPackages;
    private String[] Shovels;
    private String[] CookingItems;


    //default constructor
    public Inventory () {

        //creates an instance of the linked list that we are using for the array
        inventory = new LinkedList<String[]>();

        //creates all the array values that are in the linked list
        //then the line following add the value to the linked list inventory
        Food = new String[]{"Food", "2000"}; inventory.add(Food);
        Clothes = new String[]{"Clothes", "8"}; inventory.add(Clothes);
        Rifle = new String[]{"Riffles", "1"}; inventory.add(Rifle);
        Shotgun = new String[]{"Shotgun", "1"}; inventory.add(Shotgun);
        Shots = new String[]{"Shots", "20"}; inventory.add(Shots);
        Oxen = new String[] {"Oxen", "6"}; inventory.add(Oxen);
        SpareWagonWheels = new String [] {"SpareWagonWheels", "3"}; inventory.add(SpareWagonWheels);
        SpareWagonAxel = new String[] {"SpareWagonAxel", "3"}; inventory.add(SpareWagonAxel);
        SpareWagonTongues = new String[] {"SpareWagonTongues", "3"}; inventory.add(SpareWagonTongues);
        MedicalSupplyBox = new String[] {"MedicalSupplyBox", "1"}; inventory.add(MedicalSupplyBox);
        SewingKit = new String[] {"SewingKit", "1"}; inventory.add(SewingKit);
        FireStartingKit = new String[] {"FireStartingKit", "2"}; inventory.add(FireStartingKit);
        KidsToys = new String[] {"KidsToys", "3"}; inventory.add(KidsToys);
        FamilyKeepsakes = new String[] {"FamilyKeepsakes", "1"}; inventory.add (FamilyKeepsakes);
        SeedPackages = new String[] {"SeedPackages", "10"}; inventory.add(SeedPackages);
        Shovels = new String[] {"Shovels", "5"}; inventory.add(Shovels);
        CookingItems = new String[] {"CookingItems", "1"}; inventory.add(CookingItems);
    }

    /**
     * @param type the item that you would like to add to inventory
     * @param Value the integer value that you are adding to the inventory
     * @return void
     */

    public void addInventory (String type, int Value){
        int tempValue = 0;
        //switch statement that checks the value that were input as 'Value'
        switch (type){
            case "Food" :
                tempValue = Integer.parseInt(Food[1]) + Value; // converts from string to an int than adds the value
                Food[1] = Integer.toString(tempValue); //converts back to a string and stores it in the array
                break;
            case "Clothes" :
                tempValue = Integer.parseInt (Clothes[1]) + Value;
                Clothes[1] = Integer.toString(tempValue);
                break;
            case "Rifle":
                tempValue = Integer.parseInt (Rifle[1]) + Value;
                Rifle[1] = Integer.toString(tempValue);
                break;
            case "Shotgun":
                tempValue = Integer.parseInt (Shotgun[1]) + Value;
                Shotgun[1] = Integer.toString(tempValue);
                break;
            case "Shots":
                tempValue = Integer.parseInt (Shots[1]) + Value;
                Shots[1] = Integer.toString(tempValue);
                break;
            case "Oxen":
                tempValue = Integer.parseInt (Oxen[1]) + Value;
                Oxen[1] = Integer.toString(tempValue);
                break;
            case "SpareWagonWheels":
                tempValue = Integer.parseInt (SpareWagonWheels[1]) + Value;
                SpareWagonWheels[1] = Integer.toString(tempValue);
                break;
            case "SpareWagonAxel":
                tempValue = Integer.parseInt (SpareWagonAxel[1]) + Value;
                SpareWagonAxel[1] = Integer.toString(tempValue);
                break;
            case "SpareWagonTongues":
                tempValue = Integer.parseInt (SpareWagonTongues[1]) + Value;
                SpareWagonTongues[1] = Integer.toString(tempValue);
                break;
            case "MedicalSupplyBox":
                tempValue = Integer.parseInt (MedicalSupplyBox[1]) + Value;
                MedicalSupplyBox[1] = Integer.toString(tempValue);
                break;
            case "SewingKit":
                tempValue = Integer.parseInt (SewingKit[1]) + Value;
                SewingKit[1] = Integer.toString(tempValue);
                break;
            case "FireStartingKit":
                tempValue = Integer.parseInt (FireStartingKit[1]) + Value;
                FireStartingKit[1] = Integer.toString(tempValue);
                break;
            case "KidsToys":
                tempValue = Integer.parseInt (KidsToys[1]) + Value;
                KidsToys[1] = Integer.toString(tempValue);
                break;
            case "FamilyKeepsakes":
                tempValue = Integer.parseInt (FamilyKeepsakes[1]) + Value;
                FamilyKeepsakes[1] = Integer.toString(tempValue);
                break;
            case "SeedPackages":
                tempValue = Integer.parseInt (SeedPackages[1]) + Value;
                SeedPackages[1] = Integer.toString(tempValue);
                break;
            case "Shovels":
                tempValue = Integer.parseInt (Shovels[1]) + Value;
                Shovels[1] = Integer.toString(tempValue);
                break;
            case "CookingItems":
                tempValue = Integer.parseInt (CookingItems[1]) + Value;
                CookingItems[1] = Integer.toString(tempValue);
                break;

        }
    }

    /**
     * @param type the type of item in inventory which you wish to remove
     * @param Value the quantity that you wish to remove
     * @return void
     */
    public void removeInventory (String type, int Value){
        int tempValue = 0;
        //switch statement that checks the value that were input as 'Value'
        switch (type){
            case "Food" :
                tempValue = Integer.parseInt(Food[1]) ;// converts from string to an int than adds the value
                if (tempValue < Value){
                    tempValue = tempValue - Value;
                }
                else {
                    tempValue = 0;
                }
                Food[1] = Integer.toString(tempValue); //converts back to a string and stores it in the array
                break;
            case "Clothes" :
                tempValue = Integer.parseInt (Clothes[1]);
                if (tempValue < Value){
                    tempValue = tempValue - Value;
                }
                else {
                    tempValue = 0;
                }
                Clothes[1] = Integer.toString(tempValue);
                break;
            case "Rifle":
                tempValue = Integer.parseInt (Rifle[1]) ;
                if (tempValue < Value){
                    tempValue = tempValue - Value;
                }
                else {
                    tempValue = 0;
                }
                Rifle[1] = Integer.toString(tempValue);
                break;
            case "Shotgun":
                tempValue = Integer.parseInt (Shotgun[1]) ;
                if (tempValue < Value){
                    tempValue = tempValue - Value;
                }
                else {
                    tempValue = 0;
                }
                Shotgun[1] = Integer.toString(tempValue);
                break;
            case "Shots":
                tempValue = Integer.parseInt (Shots[1]) ;
                if (tempValue < Value){
                    tempValue = tempValue - Value;
                }
                else {
                    tempValue = 0;
                }
                Shots[1] = Integer.toString(tempValue);
                break;
            case "Oxen":
                tempValue = Integer.parseInt (Oxen[1]);
                if (tempValue < Value){
                    tempValue = tempValue - Value;
                }
                else {
                    tempValue = 0;
                }
                Oxen[1] = Integer.toString(tempValue);
                break;
            case "SpareWagonWheels":
                tempValue = Integer.parseInt (SpareWagonWheels[1]);
                if (tempValue < Value){
                    tempValue = tempValue - Value;
                }
                else {
                    tempValue = 0;
                }
                SpareWagonWheels[1] = Integer.toString(tempValue);
                break;
            case "SpareWagonAxel":
                tempValue = Integer.parseInt (SpareWagonAxel[1]);
                if (tempValue < Value){
                    tempValue = tempValue - Value;
                }
                else {
                    tempValue = 0;
                }
                SpareWagonAxel[1] = Integer.toString(tempValue);
                break;
            case "SpareWagonTongues":
                tempValue = Integer.parseInt (SpareWagonTongues[1]) ;
                if (tempValue < Value){
                    tempValue = tempValue - Value;
                }
                else {
                    tempValue = 0;
                }
                SpareWagonTongues[1] = Integer.toString(tempValue);
                break;
            case "MedicalSupplyBox":
                tempValue = Integer.parseInt (MedicalSupplyBox[1]);
                if (tempValue < Value){
                    tempValue = tempValue - Value;
                }
                else {
                    tempValue = 0;
                }
                MedicalSupplyBox[1] = Integer.toString(tempValue);
                break;
            case "SewingKit":
                tempValue = Integer.parseInt (SewingKit[1]);
                if (tempValue < Value){
                    tempValue = tempValue - Value;
                }
                else {
                    tempValue = 0;
                }
                SewingKit[1] = Integer.toString(tempValue);
                break;
            case "FireStartingKit":
                tempValue = Integer.parseInt (FireStartingKit[1]);
                if (tempValue < Value){
                    tempValue = tempValue - Value;
                }
                else {
                    tempValue = 0;
                }
                FireStartingKit[1] = Integer.toString(tempValue);
                break;
            case "KidsToys":
                tempValue = Integer.parseInt (KidsToys[1]);
                if (tempValue < Value){
                    tempValue = tempValue - Value;
                }
                else {
                    tempValue = 0;
                }
                KidsToys[1] = Integer.toString(tempValue);
                break;
            case "FamilyKeepsakes":
                tempValue = Integer.parseInt (FamilyKeepsakes[1]);
                if (tempValue < Value){
                    tempValue = tempValue - Value;
                }
                else {
                    tempValue = 0;
                }
                FamilyKeepsakes[1] = Integer.toString(tempValue);
                break;
            case "SeedPackages":
                tempValue = Integer.parseInt (SeedPackages[1]);
                if (tempValue > Value){
                    tempValue = tempValue - Value;
                }
                else {
                    tempValue = 0;
                }
                SeedPackages[1] = Integer.toString(tempValue);
                break;
            case "Shovels":
                tempValue = Integer.parseInt (Shovels[1]);
                if (tempValue > Value){
                    tempValue = tempValue - Value;
                }
                else {
                    tempValue = 0;
                }
                Shovels[1] = Integer.toString(tempValue);
                break;
            case "CookingItems":

                tempValue = Integer.parseInt (CookingItems[1]);
                if (tempValue > Value) {
                    tempValue = tempValue - Value;
                }
                else{
                    tempValue = 0;
                }
                CookingItems[1] = Integer.toString(tempValue);
                break;

        }
    }


    /**
     * @param type the item name that you wish to get from inventory
     * @return the integer value of that item
     */

    public int getInventoryValue (String type) {
        String[] tempArr = {};
        int value = -1; //sets the default value to '-1' so we can detect if the code did not work

        switch (type){
            case "Clothes" :
                tempArr = inventory.get(1);
                value = Integer.parseInt(tempArr[1]); // convert the values from string to ints for calcs
                break;
            case "Food" :
                tempArr = inventory.get(0);
                value = Integer.parseInt(tempArr[1]);
                break;
            case "Rifle" :
                tempArr = inventory.get(2);
                value = Integer.parseInt(tempArr[1]);
                break;
            case "Shotgun" :
                tempArr = inventory.get(3);
                value = Integer.parseInt(tempArr[1]);
                break;
            case "Shots" :
                tempArr = inventory.get(4);
                value = Integer.parseInt(tempArr[1]);
                break;
            case "Oxen" :
                tempArr = inventory.get(5);
                value = Integer.parseInt(tempArr[1]);
                break;
            case "SpareWagonWheels" :
                tempArr = inventory.get(6);
                value = Integer.parseInt(tempArr[1]);
                break;
            case "SpareWagonAxel" :
                tempArr = inventory.get(7);
                value = Integer.parseInt(tempArr[1]);
                break;
            case "SpareWagonTongues" :
                tempArr = inventory.get(8);
                value = Integer.parseInt(tempArr[1]);
                break;
            case "MedicalSupplyBox" :
                tempArr = inventory.get(9);
                value = Integer.parseInt(tempArr[1]);
                break;
            case "SewingKit" :
                tempArr = inventory.get(10);
                value = Integer.parseInt(tempArr[1]);
                break;
            case "FireStartingKit" :
                tempArr = inventory.get(11);
                value = Integer.parseInt(tempArr[1]);
                break;
            case "KidsToys" :
                tempArr = inventory.get(12);
                value = Integer.parseInt(tempArr[1]);
                break;
            case "FamilyKeepsakes" :
                tempArr = inventory.get(13);
                value = Integer.parseInt(tempArr[1]);
                break;
            case "SeedPackages" :
                tempArr = inventory.get(14);
                value = Integer.parseInt(tempArr[1]);
                break;
            case "Shovels" :
                tempArr = inventory.get(15);
                value = Integer.parseInt(tempArr[1]);
                break;
            case "CookingItems" :
                tempArr = inventory.get(16);
                value = Integer.parseInt(tempArr[1]);
                break;
        }

        return value;
    }

    /**
     *
     * @return returns the entire inventory for display purposes
     */
    public LinkedList<String[]> getInventory () {
        return inventory;
    }

}