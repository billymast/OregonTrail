// health class
// Calculates health of the party and executes actions according to values
// Author: Gabe Virosteck

package com.example.oregontrail;

public class Health {
    //Variables
    private double Hattie;                   //Value 0-2 with 0 healthy, 1 injured/sick, 2 dead
    private double Husband;
    private double Kid1;
    private double Kid2;
    private double Kid3;
    private int NumSick;                     //Total number of sick individuals
    private int Death;                       //Handles game over if party health too bad
    private double Party;                    //Party Health Value
    private String Rations;                  //How much food is being consumed (selected by player)
    private double FreezeStarveFactor;       //Was in the document not really sure its 1:28am

    //Constructors
    //Default Constructor

    public Health() {this.Death = 0; this.Hattie = 0; this.Husband = 0; this.Kid1 = 0; this.Kid2 = 0; this.Kid3 = 0; this.NumSick = 0; this.Party = 0; this.Rations = "Filling"; this.FreezeStarveFactor = 0;} //Default Constructor

    //Getters
    public double getParty() {return Party;}



    //Setters
    public void setParty(double party) {Party = party;}

    //Methods

    //Rations
    // @param inventory passes inventory class to get value for food
    // @return Rations

    public String Rations(Inventory inventory){
        // Gets value for pace from map class
        // If food is 0 sets to no food and unable to change
        int Food = inventory.getInventoryValue("Food");
        return Rations;
    }

    //PartyUpdate
    // @param weather passes weather class to get values for weather type
    // @param inventory passes weather class to get values for food remaining
    // @param map passes map class to get pace for health reduction
    // @return Party returns daily party health value

    public double PartyUpdate(Weather weather, Inventory inventory, Map map) {

        //Required Daily Update
        Party = Party * 0.9;

        // Getting all Values
        String Type = weather.getTempType();
        int Clothes = inventory.getInventoryValue("Clothes");
        int Food = inventory.getInventoryValue("Food");

        //Weather
        if (Type == "very hot") {
            Party = Party + 2;
        }
        else if (Type == "hot") {
            Party = Party + 1;
        }
        else if (Type == "cold") {
            if (Clothes == 1) {
                Party = Party + 1;
            } else if (Clothes == 0) {
                Party = Party + 2;
            }
        }
        else if (Type == "very cold") {
            if (Clothes == 3) {
                Party = Party + 1;
            } else if (Clothes == 2) {
                Party = Party + 2;
            } else if (Clothes == 1) {
                Party = Party + 3;
            } else if (Clothes == 0) {
                Party = Party + 4;
            }
        }

        // Food
        if (Rations == "Meager") {
            Party = Party + 2;
        } else if (Rations == "Bare bones") {
            Party = Party + 4;
        } else if (Rations == "Out of food") {
            Party = Party + 6;
        }

        // Freeze/Starve Factor
        //Logic Checkers
        int FoodCheck = 0;
        int FreezeCheck = 0;

        //Food Part
        if (Food <= 0){
            FreezeStarveFactor = FreezeStarveFactor + .8;
            FoodCheck = 1;
        }
        else {
            FoodCheck = 0;
        }
        //Clothes Part
        if (Type == "cold") {
            if (Clothes <= 1) {
                FreezeStarveFactor = FreezeStarveFactor + .8;
                FreezeCheck = 1;
            }
        }
        else if (Type == "very cold") {
            if (Clothes <= 3) {
                FreezeStarveFactor = FreezeStarveFactor + .8;
                FreezeCheck = 1;
            }
        }
        else {
            FreezeCheck = 0;
        }
        //All Okay, lower freeze/starve factor
        if(FoodCheck == 0 && FreezeCheck == 0){
            FreezeStarveFactor = FreezeStarveFactor / 2;
        }
        Party = Party + FreezeStarveFactor;

        String Pace = map.getPaceType();
        if (Pace.equals("Normal")){
            Party = Party + 2;
        }
        if (Pace.equals("Strenuous")){
            Party = Party + 4;
        }
    	if (Pace.equals("Grueling")){
            Party = Party + 6;
        }

        //Individual Illness
        if (Party <= 34){
            //0% chance of getting sick (Impliment for Final)
        }
        else if (Party <= 65){
            //15% chance (Impliment for Final)
        }
        else if (Party <= 104){
            //30% chance (Impliment for Final)
        }
        else if (Party <= 139){
            //40% Chance (Impliment for Final)
        }
        else if (Party > 139){
            //Everyone dies in 5 days (Implimenting for final)
        }

        //Random Events (Will need to call from class - could be implimented for final)


        return Party;
    }// end of party
}
