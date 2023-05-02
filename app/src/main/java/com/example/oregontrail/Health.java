
package com.example.oregontrail;

public class Health {
    //Variables
    private double Party;                    //General Party Health
    private int NumSick;                     //Total number of sick individuals
    private int Death;                       //Handles game over if party health too bad
    private String Rations;                  //How much food is being consumed (selected by player)
    private double FreezeStarveFactor;       //Variable that affects health
    String update;                           //Used for returning string of health status
    int death;                               //Used for days to death

    //Constructors
    //Default Constructor

    public Health() {this.Death = 0; this.NumSick = 0; this.Party = 0; this.Rations = "Filling"; this.FreezeStarveFactor = 0; this.death = 0; this.update="";} //Default Constructor

    //Getters
    public double getParty() {return Party;}
    public String getRations() {return Rations;}


    //Setters
    public void setParty(double party) {Party = party;}
    public void setRations(String rations) {Rations = rations;}

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

    public double PartyUpdate(Weather weather, Inventory inventory, Map map, boolean isRest) {

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
        if (Rations == "Filling") {
            //Does nothing to Party
        }
        if (Rations == "Meager") {
            Party = Party + 2;
        } else if (Rations == "Bare Bones") {
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

        return Party;
    }// end of party

    public String HealthString(){

        if (Party <= 34){
            update = "Good Health";
        }
        else if (Party <= 65){
            update = "Fair Health";
        }
        else if (Party <= 104){
            update = "Poor Health";
        }
        else if (Party <= 139){
            update = "Very Poor Health";
        }
        else if (Party > 139) {
            update = "Death Imminent";
            death = death + 1;
            if(death > 4) {
                update = "Death";
            }
        }
        return update;
    }
}