package com.example.oregontrail;

/*   generalStore class:
 *   Provides general store functionality for the Oregon Trail Game. All functions use the following
 *   information in their interfaces. Designed to be easy to use with simple
 *   Important Information:
 *     Item ID:        Item:           Price(base before modifier: $):
 *        0           Coffee                   0.10
 *        1           Flour                    0.02
 *        2           Bacon                    0.05
 *        3           Clothing                 1.50    : Made up value, As per instructed
 *        4           Rifle                   20.00
 *        5           Shotgun                 10.00
 *        6           Shots                    5.00
 *        7           Oxen                    50.00
 *        8           Wagon Wheel              8.00
 *        9           Wagon Axel               3.00
 *       10           Wagon Tongue             3.00
 *       11           Medical Supply Box       1.50
 *       12           Sewing Kit               0.50
 *       13           Fire Start Kit           0.25
 *       14           Kids Toys                0.05
 *       15           Seed Packages            0.01
 *       16           Shovels, ect.            2.50
 *       17           Coffee Mill              1.00
 *       18           Frying pan               1.50
 *       19           Pan                      0.25
 *
 *   To access the desired product, use the Item ID in the desired method to return what you are expecting
 *
 *   Location IDs             Location Name:
 *        0           -        Matt's Store
 *        1           -        Fort Kearney
 *        2           -        Fort Laramie
 *        3           -        Fort Bridger
 *        4           -        Fort Hall
 *        5           -        Fort Boise
 *        6           -        Fort Walla Walla
 *
 *   Author: Alex Pomesky
 */

public class GeneralStore {

    // Percent increase in price
    final double[] percentAbove = {0.0, .25, .5, .75, 1.0, 1.25, .45};

    // Product Prices: Easier to reference back to variables than counting numbers in an array
    final double coffee = 0.10;       // ID =  0
    final double flour = 0.02;        // ID =  1
    final double bacon = 0.05;        // ID =  2
    final double clothing = 1.50;     // ID =  3
    final int rifle = 20;             // ID =  4
    final int shotgun = 10;           // ID =  5
    final int shots = 5;              // ID =  6
    final int oxen = 50;              // ID =  7
    final int wagWheel = 8;           // ID =  8
    final int wagAxel = 3;            // ID =  9
    final int wagTongue = 3;          // ID = 10
    final double medSupp = 1.50;      // ID = 11
    final double sewKit = .50;        // ID = 12
    final double fireStart = .25;     // ID = 13
    final double kidToys = 0.50;      // ID = 14
    final double seeds = 0.01;        // ID = 15
    final double shovels = 2.50;      // ID = 16
    final int coffeeMill = 1;         // ID = 17
    final double fryPan = 1.50;       // ID = 18
    final double pan = 0.25;          // ID = 19

    // Product Price array
    private final double[] StorePrice = {coffee,flour,bacon,clothing,rifle,shotgun,shots, oxen,wagWheel,wagAxel,
            wagTongue,medSupp,sewKit,fireStart,kidToys,seeds,shovels,coffeeMill,fryPan,pan};

    // Customer variables Quantity & prices for the location and total cost
    private final int[] quantity = new int[20];

    /*   Constructor generalStore(int location):
     *   Where location is a number that correlates to a location of a place to buy supplies
     *   0 = Matt's Store, 1 = Fort Kearney, 2 = Fort Laramie, 3 = Fort Bridger, 4 = Fort Hall,
     *   5 = Fort Boise, and 6 = Fort Walla Walla
     *   @param:  int location
     */
    public GeneralStore(int location){
        double storePricePercent = percentAbove[location] + 1;
        for (int i = 0; i <= 19; i++){
            StorePrice[i] *= storePricePercent;
        }
    }

    /*   addItem(int ItemID, int Quantity)
     *   Give ItemID, and Quantity, it will add items to Quantity
     *   @param:  int ItemID
     *            int Quantity
     */
    public void addItem(int ItemID, int Quantity){
        quantity[ItemID] = quantity[ItemID] + Quantity;
    }

    /*   getTotal()
     *   when invoked, It will calculate the total order cost
     *   @return: double total
     */
    public double getTotal(){
        double total = 0;

        for(int i = 0; i <= 19; i++){
            total = total + (StorePrice[i] * quantity[i]);
        }
        return total;
    }

    /*   removeItem(int ItemID, int Quantity)
     *   when invoked with an ItemID number and the quantity, it will add that to the quantity of that ID number
     *   @param:  int ItemID
     *            int Quantity
     */
    public void removeItem(int ItemID, int Quantity){
        quantity[ItemID] = quantity[ItemID] - Quantity;
    }

    /*   getPrice(int ItemID)
     *   Given the Input of ItemID, this method will return the
     *   @param:  int ItemID
     *   @return: double Item Price
     */
    public double getPrice(int ItemID){
        return StorePrice[ItemID];
    }

    /*   getProdName(int ItemID)
     *   Given the Input of the ItemID, this method will return the name of the Item
     *   @paramINPUT:  Int ItemID
     *   @paramOUTPUT: String Name
     */
    public String getProdName(int ItemID){
        String name;
        switch (ItemID){
            case 0:  name = "Coffee"; break;
            case 1:  name = "Flour"; break;
            case 2:  name = "Bacon"; break;
            case 3:  name = "Clothing"; break;
            case 4:  name = "Rifle"; break;
            case 5:  name = "Shotgun"; break;
            case 6:  name = "Shots"; break;
            case 7:  name = "Oxen"; break;
            case 8:  name = "Wagon Wheels"; break;
            case 9:  name = "Wagon Axel"; break;
            case 10: name = "Wagon Tongue"; break;
            case 11: name = "Medical Supply Box"; break;
            case 12: name = "Sewing Kit"; break;
            case 13: name = "Fire Starting Kit"; break;
            case 14: name = "Kids Toys"; break;
            case 15: name = "Seed Packages"; break;
            case 16: name = "Shovels, ect"; break;
            case 17: name = "Coffee Mill"; break;
            case 18: name = "Frying pan"; break;
            case 19: name = "pan"; break;
            default: name = ""; break;
        }
        return name;
    }

    /*   resetQty():
     *   when invoked, reset quantity to 0
     */
    public void resetQty(){
        for (int i = 0; i <= 19; i++){
            quantity[i] = 0;
        }
    }
}

