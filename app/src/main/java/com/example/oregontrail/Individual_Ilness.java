//Not solid code yet, do not impliment

package com.example.myapplication;

public class Individual_Ilness {
    //Individual Illness

    boolean sickcheck = false;
    int daytodie = 0;

        if (Party <= 34){
        //0% chance of getting sick
    }
        else if (Party <= 65){
        //15% chance
        double chance = .15;
        if(Math.random() < chance){
            sickcheck = true;
        }
    }
        else if (Party <= 104){
        //30% chance
        double chance = .30;
        if(Math.random() < chance){
            sickcheck = true;
        }
    }
        else if (Party <= 139){
        //40% Chance
        double chance = .40;
        if(Math.random() < chance){
            sickcheck = true;
        }
    }
        else if (Party > 139){
        daytodie = daytodie + 1;
    }

    //Tidy up/final checks
    //sick checks
            if(sickcheck == true){
        if (Kid3 < 2){
            Kid3 = Kid3 + 1;
        }
        else if(Kid2 < 2){
            Kid2 = Kid2 + 1;
        }
        else if(Kid1 < 2){
            Kid1 = Kid1 + 1;
        }
        else if(Husband < 2){
            Husband = Husband + 1;
        }
        else if(Hattie < 2){
            Hattie = Hattie + 2;
        }
    }
}
