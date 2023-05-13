package com.example.oregontrail;

/*   generalStore class:
 *   Provides general store functionality for the Oregon Trail Game. All functions use the following
 *   information in their interfaces. Designed to be easy to use with simple
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
    final double[] percentAbove = {0.0, .25, .5, .75, 1.0, 1.25, 1.45};

    // Product Prices: Easier to reference back to variables than counting numbers in an array
    final double Food = 0.40;              // ID =  0   Made up value
    final double Clothes =  1.50;          // ID =  1   Made up value
    final double Rifle = 20.00;            // ID =  2
    final double Shotgun = 10.00;          // ID =  3
    final double Shots = 5.00;             // ID =  4
    final double Oxen = 50.00;             // ID =  5
    final double SpareWagonWheels = 8.00;   // ID =  6
    final double SpareWagonAxel = 3.00;    // ID =  7
    final double SpareWagonTongues = 3.00;  // ID =  8
    final double MedicalSupplyBox = 1.50;  // ID =  9
    final double SewingKit = 0.50;         // ID = 10
    final double FireStartKit = 0.25;      // ID = 11
    final double KidsToys = 0.50;          // ID = 12
    final double SeedPacks = 0.01;         // ID = 13
    final double Shovels = 2.50;           // ID = 14
    final double CookWare = 2.75;          // ID = 15   Made up value

    // Product Price array
    private final double[] StorePrice = {
            Food,
            Clothes,
            Rifle,
            Shotgun,
            Shots,
            Oxen,
            SpareWagonWheels,
            SpareWagonAxel,
            SpareWagonTongues,
            MedicalSupplyBox,
            SewingKit,
            FireStartKit,
            KidsToys,
            SeedPacks,
            Shovels,
            CookWare};

    // Customer variables Quantity & prices for the location and total cost
    private final int[] quantity = new int[20];

    /**   Constructor generalStore(int location):
     *   Where location is a number that correlates to a location of a place to buy supplies
     *   0 = Matt's Store, 1 = Fort Kearney, 2 = Fort Laramie, 3 = Fort Bridger, 4 = Fort Hall,
     *   5 = Fort Boise, and 6 = Fort Walla Walla
     *   @param:  int location
     */
    public GeneralStore(int location){
        double storePricePercent = percentAbove[location] + 1;
        for (int i = 0; i <= 15; i++){
            StorePrice[i] *= storePricePercent;
        }
    }

    /**   addItem(int ItemID, int Quantity)
     *   Give ItemID, and Quantity, it will add items to Quantity
     *   @param:  int ItemID
     *            int Quantity
     */
    public void addItem(int ItemID, int Quantity){
        //quantity[ItemID] = quantity[ItemID] + Quantity;
        switch (ItemID) {
            case 0:
            case 3:
            case 1:
                quantity[ItemID] = quantity[ItemID] + Quantity;
                break;
            case 2:
                if (Quantity >= 1) {
                    Quantity = 1;
                }
                quantity[ItemID] = quantity[ItemID] + Quantity;
                break;
            case 4:
                if (Quantity >= 3) {
                    Quantity = 3;
                }
                quantity[ItemID] = quantity[ItemID] + Quantity;
                break;
            case 5:
                if (Quantity >= 16) {
                    Quantity = 16;
                }
                quantity[ItemID] = quantity[ItemID] + Quantity;
                break;
            case 6:
                if (Quantity >= 3){
                    Quantity = 3;
                }
                quantity[ItemID] = quantity[ItemID] + Quantity;
                break;
            case 7:
                if (Quantity >= 3){
                    Quantity = 3;
                }
                quantity[ItemID] = quantity[ItemID] + Quantity;
                break;
            case 8:
                if (Quantity >= 3) {
                    Quantity = 3;
                }
                quantity[ItemID] = quantity[ItemID] + Quantity;

        }
    }

    /**   getTotal()
     *   when invoked, It will calculate the total order cost
     *   @return: double total
     */
    public double getTotal(){
        double total = 0;

        for(int i = 0; i <= 15; i++){
            total = total + (StorePrice[i] * quantity[i]);
        }
        return total;
    }

    /**   getPrice(int ItemID)
     *   Given the Input of ItemID, this method will return the
     *   @param ItemID
     *   @return StorePrice[]
     */
    public double getPrice(int ItemID){
        return StorePrice[ItemID];
    }

    /*   getquantity(int ItemID)
     *   Given the Input of the ItemID, This method will return the current quantity of the Item
     *   @paramInput:  int ItemID
     *   @paramOutput: int Quantity
     */
    public int getQuantity(int ItemID){
        return quantity[ItemID];
    }

    /*   getProdName(int ItemID)
     *   Given the Input of the ItemID, this method will return the name of the Item
     *   @paramINPUT:  Int ItemID
     *   @paramOUTPUT: String Name
     */
    public String getProdName(int ItemID){
        String name;
        switch (ItemID){
            case  0:  name = "Food"; break;
            case  1:  name = "Clothes"; break;
            case  2:  name = "Rifle"; break;
            case  3:  name = "Shotgun"; break;
            case  4:  name = "Shots"; break;
            case  5:  name = "Oxen"; break;
            case  6:  name = "SpareWagonWheels"; break;
            case  7:  name = "SpareWagonAxel"; break;
            case  8:  name = "SpareWagonTongues"; break;
            case  9:  name = "MedicalSupplyKit"; break;
            case 10:  name = "SewingKit"; break;
            case 11:  name = "FireStartKit"; break;
            case 12:  name = "KidsToy"; break;
            case 13:  name = "SeedPacks"; break;
            case 14:  name = "Shovel"; break;
            case 15:  name = "CookWare"; break;
            default:  name = ""; break;
        }
        return name;
    }

    /**   removeItem(int ItemID, int Quantity)
     *   when invoked with an ItemID number and the quantity, it will add that to the quantity of that ID number
     *   @param ItemID
     *   @param Quantity
     */
    public void removeItemQuantity(int ItemID, int Quantity){
        quantity[ItemID] = quantity[ItemID] - Quantity;
    }

    /**   finishTransaction(Inventory inventory)
     *   when invoked, removes money from players inventory, adds purchased items to players inventory
     *   reset quantity to 0 for each item purchasable.
     *   @param inventory
     */
    public void finishTransaction(Inventory inventory){
        double temp = getTotal();

        inventory.removeInventory("Money", temp);

        for (int i = 0; i <= 15; i++){
            inventory.addInventory(getProdName(i), quantity[i]);
            quantity[i] = 0;
        }
    }
}
