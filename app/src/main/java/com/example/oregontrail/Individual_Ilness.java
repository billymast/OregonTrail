package com.example.oregontrail;


public class Individual_Ilness {
    //Variables
    private int Hattie;                               //Logic checker for Hattie. 0 if healthy, 1 if sick, 2 -> 5 if dead. Goes to 5 so no more calculations are performed.
    private int Husband;                              //""
    private int Kid1;                                 //""
    private int Kid2;                                 //""
    private int Kid3;                                 //""
    private int sickcheck;                            //Logic checker to randomly see if someone will get sick or get healthy. 1 is for sick, 2 for healthy.
    private int daytodie = 0;                         //If general party health becomes too poor, the entire party dies in 5 days.
    private String Output;                            //Output to user based on who is sick or died.
    private int PeopleAlive;                          //Used for food removal at end of class. Used for main declutter.
	private boolean GameOver;

    private String name1;                     //Always Hattie.
    private String name2;                     //Stores user inputted value for character name. Corresponds to Kid2.
    private String name3;                     //Corresponds to Kid3
    private String name4;                     //Corresponds to Kid1
    private String name5;                     //Corresponds to Husband

    //Default Constructor
    public Individual_Ilness() {
        this.Hattie = 0;
        this.Husband = 0;
        this.Kid1 = 0;
        this.Kid2 = 0;
        this.Kid3 = 0;
        this.sickcheck = 0;
        this.daytodie = 0;
        this.Output = "";
        this.PeopleAlive = 5;
        this.name1 = "Hattie";
        this.name2 = "";
        this.name3 = "";
        this.name4 = "";
        this.name5 = "";
		this.GameOver = false;
    }

   
    //Outputs a message to the player informing them about individual illnesses, deaths, and becoming healthy.
    public String OutputIndividualIllness(Health health, Inventory inventory) {

		//Resetting Output
		Output = " ";		

        //Need general health stat from Health
        double Party = health.getParty();

        //Getting sick or getting healthy
        if (Party <= 34) {
            daytodie = 0;
            //0% chance of getting sick
        } else if (Party <= 65) {
            daytodie = 0;
            //15% chance
            double chance = .15;
            if (Math.random() < chance) {
                sickcheck = 1;
            }
        } else if (Party <= 104) {
            daytodie = 0;
            //30% chance
            double chance = .30;
            if (Math.random() < chance) {
                sickcheck = 1;
            }
        } else if (Party <= 139) {
            daytodie = 0;
            //40% Chance
            double chance = .40;
            if (Math.random() < chance) {
                sickcheck = 1;
            }
        } else if (Party > 139) {
            daytodie = daytodie + 1;
        }
        if (sickcheck != 1){
            if (Math.random() < .5){
				sickcheck = 2;
            }
        }

        //sick checks
        if (sickcheck == 1) {
            if (Kid3 < 2) {
                Kid3 = Kid3 + 1;
            } else if (Kid2 < 2) {
                Kid2 = Kid2 + 1;
            } else if (Kid1 < 2) {
                Kid1 = Kid1 + 1;
            } else if (Husband < 2) {
                Husband = Husband + 1;
            } else if (Hattie < 2) {
                Hattie = Hattie + 1;
            }
        }
		else if (sickcheck == 2) {
            if (Kid3 == 1) {
                Kid3 = 0;
            } else if (Kid2 == 1) {
                Kid2 = 0;
            } else if (Kid1 == 1) {
                Kid1 = 0;
            } else if (Husband == 1) {
                Husband = 0;
            } else if (Hattie == 1) {
                Hattie = 0;
            }
        }


        String sickness = "";
        double random = Math.random();
        if (random <= .33) {
            sickness = "typhoid fever";
        }
        else if (random <= .66 && random > .33){
            sickness = "chlorea";
        }
        else if (random > .66){
            sickness = "dysentery";
        }
        
		//Outputs based on health value
        if(daytodie < 5) {

	    //Kid3
            if (Kid3 == 1) {
                Output = name3 + " is sick with " + sickness + ".";
                Kid3 = 5; }
            if (Kid3 == 2) {
                Output = name3 + " has died from " + sickness + ".";
                Kid3 = 5;
                PeopleAlive = PeopleAlive - 1; } 

			//Kid2
            if (Kid2 == 1) {
                Output = name2 + " is sick with " + sickness + ".";
                Kid2 = 5; }
            if (Kid2 == 2) {
                Output = name2 + " has died from " + sickness + ".";
                Kid2 = 5;
                PeopleAlive = PeopleAlive - 1; }

			//Hattie
			if (Hattie == 1) {
                Output = "Hattie is sick with " + sickness + ".";
                }
            if (Hattie == 2) {
                Output = "Hattie has died from " + sickness + ". Game over.";
                Hattie = 5;
                GameOver = true;
                PeopleAlive = PeopleAlive - 1; }

			//Kid1
			if (Kid1 == 1) {
                Output = name4 + " is sick with " + sickness + ".";
                Kid1 = 5; }
            if (Kid3 == 2) {
                Output = name4 + " has died from " + sickness + ".";
                Kid1 = 5;
                PeopleAlive = PeopleAlive - 1; }

			//Husband
			if (Husband == 1) {
                Output = name5 + " is sick with " + sickness + ".";
                Husband = 5; }
            if (Husband == 2) {
                Output = name5 + " has died from " + sickness + ".";
                Husband = 5;
                PeopleAlive = PeopleAlive - 1; }
        }
        else {
            Output = "The party health has been too poor for too long. Your adventure is over.";
            GameOver = true;
        }

        // Declutter Main Inventory Update
        if(health.getRations() == "Filling"){
            inventory.removeInventory("Food",(3*PeopleAlive));
        }
        if(health.getRations() == "Meager"){
            inventory.removeInventory("Food",(2*PeopleAlive));
        }
        if(health.getRations() == "Bare Bones"){
            inventory.removeInventory("Food",(PeopleAlive));
        }

        //Logic reset
        sickcheck = 0;
        return Output;
    }

    // Getters and Setters
    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }

    public String getName5() {
        return name5;
    }

    public void setName5(String name5) {
        this.name5 = name5;
    }

    public boolean isGameOver() {
        return GameOver;
    }

    public int getPeopleAlive() {
        return PeopleAlive;
    }
}
