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

    public boolean fireInTheWagon (Inventory inventory){
        double value = randomValue();
        if (value < 0.02){
            return true;
        }
        else{
            return false;
        }
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


    public boolean FoundWagon () {
        double value = randomValue();
        if (value < 0.02){
            return true;
        }
        return false;
    }

    public boolean FireInWagon () {
        double value = randomValue();
        if (randomValue() < 0.02){
            return true;
        }
        else {
            return false;
        }
    }




    /**
     *
     * @return a string value indicating which random event happens or none
     */

    public String Event (Inventory inventory, Weather weather, Time time) {

        if (SnakeBite()){
            return "There was a snake bite. Some health has been removed.";
        }
        if (LoseTrail()){
            return "You have lost the trail. A day has passed.";
        }
        if (WrongTrail()) {
            return "You are on the wrong trail. A day has passed.";
        }
        if (RoughTrail()){
            return "The trail is very rough. You pace is slowed.";
        }
        if (NativesHelp(inventory)){
            return "The Natives have help to find food. Food has been added to inventory.";
        }
        if (SevereBlizzard(weather)){
            return "The weather has turned into a severe blizzard. Your pace has slowed.";
        }
        if (findWildFruit(time)){
            return "You and you party found wild fruit! Food has been added to inventory.";
        }
        if (FireInWagon()){
            FireWagon(inventory);
            return "There was a fire in your wagon, some supplies are lost";
        }
        return "no random event";
    }





    public void FireWagon(Inventory inventory) {

        String[] arr = {" ", " ", " "};

        for (int i = 0; i < 3; i++){

            int min = 0;
            int max = 17;
            int numRemoved = (int) (Math.random() * (max - min + 1)) + min;

            switch (numRemoved){
                case 0:
                    arr[i] = "Food";
                    break;
                case 1:
                    arr[i] = "Clothes";
                    break;
                case 2:
                    arr[i] = "Rifle";
                    break;
                case 3:
                    arr[i] = "Shotgun";
                    break;
                case 4:
                    arr[i] = "Shots";
                    break;
                case 5:
                    arr[i] = "Oxen";
                    break;
                case 6:
                    arr[i] = "SpareWagonWheels";
                    break;
                case 7:
                    arr[i] = "SpareWagonAxel";
                    break;
                case 8:
                    arr[i] = "SpareWagonTongues";
                    break;
                case 9:
                    arr[i] = "MedicalSupplyBox";
                    break;
                case 10:
                    arr[i] = "SawingKit";
                    break;
                case 11:
                    arr[i] = "FireStartingKit";
                    break;
                case 12:
                    arr[i] = "KidsToys";
                    break;
                case 13:
                    arr[i] = "FamilyKeepsakes";
                    break;
                case 14:
                    arr[i] = "SeedPackages";
                    break;
                case 15:
                    arr[i] = "Shovels";
                    break;
                case 16:
                    arr[i] = "CookingItems";
                    break;
                case 17:
                    arr[i] = "Money";
                    break;
            }
        }

        double maxValueRemoved = .25;

        double value = randomValue();

        if (value < 0.25) {

            double newVal = randomValue();

            double min = 0;
            double max = 0.15;
            double ammountRemoved = (Math.random() * (max - min + 1)) + min;


            for (int i = 0; i < 3; i++){
                int num = 0;
                switch (arr[i]) {
                    case "Food":
                        num = (int) ammountRemoved * 2000;
                        inventory.removeInventory("Food",num);
                        break;
                    case "Clothes":
                        num = (int) ammountRemoved * 8;
                        inventory.removeInventory("Clothes", num);
                        break;
                    case "Rifle":
                        num = (int) ammountRemoved * 1;
                        inventory.removeInventory("Rifle", num);
                        break;
                    case "Shotgun":
                        num = (int) ammountRemoved * 1;
                        inventory.removeInventory("Shotgun", num);
                        break;
                    case "Shots":
                        num = (int) ammountRemoved * 20;
                        inventory.removeInventory("Shots", num);
                        break;
                    case "SpareWagonAxel":
                        num = (int) ammountRemoved * 6;
                        inventory.removeInventory("SpareWagonAxel", num);
                }
            }

        }
    }

}
