package com.example.oregontrail;

// Map class: Handles player progression and other checks
// Author: Billy

public class Map {

    private int zone;
    private int location;
    private int pace = 20;
    private int paceType;

    // Distance to Forts
    private int fortKearney = 200;
    private int fortLaramie = 400;
    private int fortBridger = 600;
    private int fortHall = 800;
    private int fortBoise = 1000;
    private int fortWallaWalla = 1200;

    // Distance to Rivers
    private int kansasRiver = 60;
    private int bigBlueRiver = 100;
    private int greenRiver;
    private int snakeRiver;

    // Number of Forts and Rivers
    private int numRivers = 4;
    private int numForts = 6;

    // Location of forts
    private final int[] fortsLoc = { fortKearney, fortLaramie, fortBridger, fortHall, fortBoise, fortWallaWalla };
    private final int[] riversLoc = { kansasRiver, bigBlueRiver, greenRiver, snakeRiver };

    public Map()
    {
        this.zone = 1;
        this.location = 0;
        this.paceType = 2;
    }

    // Method getLocation returns location
    // @return location the location of the player
    public int getLocation() {
        return location;
    }

    // Method getPaceType gets the type of pace the user wants to use
    // @return paceType returns chosen pace type from user
    public int getPaceType() {
        return paceType;
    }

    // Method updateLocation updates location as a function of pace
    public void updateLocation() {
        location += pace;
    }

    // Method isRiver checks if the location is an ID for a river
    // @return boolean returns true if it is a river, false if not
    public boolean isRiver() {
        for (int i = 0; i < numRivers; i++) {
            if (riversLoc[i] == location) { return true; }
        }
        return false;
    }

    // Method isFort checks if the location is an ID for a Fort
    // @return boolean returns true if it is a Fort, false if not
    public boolean isFort() {
        for (int i = 0; i < numForts; i++) {
            if (fortsLoc[i] == location) { return true; }
        }
        return false;
    }

}
