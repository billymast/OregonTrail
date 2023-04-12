package com.example.oregontrail;

/**
 * this class is used to determine whether a random events takes place
 */

public class RandomEvent {


    public void RandomEvent () {}

    /**
     * @return a random value that is used later in the class
     */
    public double randomValue (){ return Math.random();}

    /**
     *
     * @return a boolean that either says weather the random event happens
     */
    public boolean SnakeBite (){
        double value = randomValue();
        if (value < 0.07){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     *
     * @return a boolean that either says weather the random event happens
     */

    public  boolean LoseTrail(){
        double value = randomValue();
        if (value < 0.2){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean NativesHelp (Inventory inventory) {
       int foodValue = inventory.getInventoryValue("food");
        double value = randomValue();
       if (foodValue == 0){
           if (value < 0.05){
               inventory.addInventory("Food", 30);
               return true;
           }
       }
       return false;
    }


    /**

     * @return a boolean that either says weather the random event happens
     */
    public boolean RoughTrail () {
        double value = randomValue();
        if (value < 0.025){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     *
     * @return a boolean that either says weather the random event happens
     */
    public boolean WrongTrail () {
        double value = randomValue();
        if (value < .1){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean SevereBlizzard (Weather weather){
        String currentWeather = weather.getTempType();
        double value = randomValue();
        if (currentWeather == "cold" || currentWeather == "very cold"){
            if (value < .15){
                return true;
            }
        }
        return false;
    }

    public boolean findWildFruit (Time time){
        int month = time.getMonth();
        double value = randomValue();
        if (month >= 5 && month <= 9 ){
            if (value < 0.04){
                return true;
            }
        }
        return false;
    }



    /**
     *
     * @return a string value indicating which random event happens or none
     */

    public String Event (Inventory inventory, Weather weather, Time time) {
        if (SnakeBite()){
            return "Snake Bite";
        }
        if (LoseTrail()){
            return "Lost Trail";
        }
        if (WrongTrail()) {
            return "Wrong Trail";
        }
        if (RoughTrail()){
            return "Rough Trail";
        }
        if (NativesHelp(inventory)){
            return "Natives help find food";
        }
        if (SevereBlizzard(weather)){
            return "Severe Blizzard";
        }
        if (findWildFruit(time)){
            return "You found wild fruit";
        }
        return "no random event";
    }

}
