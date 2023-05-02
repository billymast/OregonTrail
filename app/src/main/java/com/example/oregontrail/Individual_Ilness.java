package com.example.oregontrail;

public class Individual_Ilness {
    //Variables
    int Hattie;
    int Husband;
    int Kid1;
    int Kid2;
    int Kid3;
    boolean sickcheck;
    int daytodie = 0;
    String Who;
    int PeopleAlive;

    public Individual_Ilness() {
        this.Hattie = 0;
        this.Husband = 0;
        this.Kid1 = 0;
        this.Kid2 = 0;
        this.Kid3 = 0;
        this.sickcheck = false;
        this.daytodie = 0;
        this.Who = "";
        this.PeopleAlive = 5;
    }

    //Get Value From Health

    public String Thing(Health health, Inventory inventory) {

        double Party = health.getParty();

        if (Party <= 34) {
            daytodie = 0;
            //0% chance of getting sick
        } else if (Party <= 65) {
            daytodie = 0;
            //15% chance
            double chance = .15;
            if (Math.random() < chance) {
                sickcheck = true;
            }
        } else if (Party <= 104) {
            daytodie = 0;
            //30% chance
            double chance = .30;
            if (Math.random() < chance) {
                sickcheck = true;
            }
        } else if (Party <= 139) {
            daytodie = 0;
            //40% Chance
            double chance = .40;
            if (Math.random() < chance) {
                sickcheck = true;
            }
        } else if (Party > 139) {
            daytodie = daytodie + 1;
        }

        //sick checks
        if (sickcheck == true) {
            if (Kid3 < 2) {
                Kid3 = Kid3 + 1;
            } else if (Kid2 < 2) {
                Kid2 = Kid2 + 1;
            } else if (Kid1 < 2) {
                Kid1 = Kid1 + 1;
            } else if (Husband < 2) {
                Husband = Husband + 1;
            } else if (Hattie < 2) {
                Hattie = Hattie + 2;
            }
        }

        if(daytodie < 5) {
            if (Kid3 == 2) {
                Who = "Kid3";
                Kid3 = 5;
                PeopleAlive = PeopleAlive - 1;
            } else if (Kid2 == 2) {
                Who = "Kid2";
                Kid2 = 5;
                PeopleAlive = PeopleAlive - 1;
            } else if (Kid1 == 2) {
                Who = "Kid1";
                Kid1 = 5;
                PeopleAlive = PeopleAlive - 1;
            } else if (Husband == 2) {
                Who = "Husband";
                Husband = 5;
                PeopleAlive = PeopleAlive - 1;
            } else if (Hattie == 2) {
                Who = "Death";
            }
        }
        else {
            Who = "Death";
        }

        if(health.getRations() == "Filling"){
            inventory.removeInventory("Food",(3*PeopleAlive));
        }
        if(health.getRations() == "Meager"){
            inventory.removeInventory("Food",(2*PeopleAlive));
        }
        if(health.getRations() == "Bare Bones"){
            inventory.removeInventory("Food",(PeopleAlive));
        }
        if(health.getRations() == "Out of Food"){

        }


        sickcheck = false;
        return Who;
    }
}
