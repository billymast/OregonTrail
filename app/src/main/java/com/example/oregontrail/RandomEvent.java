package com.example.oregontrail;

/**
 * this class is used to determine whether a random events takes place
 */

public class RandomEvent {

    private boolean isBlizzard;
    private boolean isHeavyFog;
    private boolean isHailStorm;
    private boolean isInjuredOx;
    private boolean isInjuredPartyMember;
    private boolean isSnakeBite;
    private boolean isLoseTrail;
    private boolean isThief;
    private boolean isBadWater;
    private boolean isVeryLittleWater;
    private boolean isInadequateGrass;
    private boolean isIllness;
    private boolean isIndiansHelpFindFood;
    private boolean isServeThunderstorm;
    private boolean isWrongTrail;
    private boolean isRoughTrail;
    private boolean isImpassibleTrail;
    private boolean isFindingWildFruit;
    private boolean isFireInTheWagon;
    private boolean isLostPartyMemeber;
    private boolean isOxWondersOff;
    private boolean isFindingAbandonedWagon;

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

    /**
     *
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

    /**
     *
     * @return a string value indicating which random event happens or none
     */

    public String Event () {
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
        return "no random event";
    }

}
