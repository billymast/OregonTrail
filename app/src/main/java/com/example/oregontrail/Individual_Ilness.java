package com.example.oregontrail;

public class IndividualIlness {
    //Variables
    int Hattie;
    int Husband;
    int Kid1;
    int Kid2;
    int Kid3;
    boolean sickcheck;
    int daytodie = 0;
    String Who;

    public IndividualIlness() {
        this.Hattie = 0;
        this.Husband = 0;
        this.Kid1 = 0;
        this.Kid2 = 0;
        this.Kid3 = 0;
        this.sickcheck = false;
        this.daytodie = 0;
        this.Who = "";
    }

    //Get Value From Health

    public String Thing(Health health) {

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
            } else if (Kid2 == 2) {
                Who = "Kid2";
            } else if (Kid1 == 2) {
                Who = "Kid1";
            } else if (Husband == 2) {
                Who = "Husband";
            } else if (Hattie == 2) {
                Who = "Hattie";
            }
        }
        else {
            Who = "Death";
        }

        sickcheck = false;
        return Who;
    }
}
