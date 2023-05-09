package com.example.oregontrail;

// Map class: Handles player progression and other checks
// Author: Billy

import java.util.LinkedList;
import java.util.Queue;

public class Map {

    private int zone;
    private int location;
    private int pace = 20;
    private String paceType;

    // Distance to Forts
    private int fortKearney = 302;
    private int fortLaramie = 638;
    private int fortBridger = 1055;
    private int fortHall = 1274;
    private int fortBoise = 1569;
    private int fortWallaWalla = 1784;

    // Distance to Rivers
    private int kansasRiver = 102;
    private int bigBlueRiver = 184;
    private int greenRiver = 100000000;
    private int snakeRiver = 1456;

    // Other Landmarks
    private int chimneyRock = 552;
    private int independenceRock = 828;
    private int southPass = 930;
    private int sodaSprings = 1217;
    private int blueMountains = 1729;
    private int theDalles = 1904;
    private int willametteValley = 2004;

    private Queue<Integer> distanceToLandmark = new LinkedList<>();
    private Queue<String> currentLandmarkQueue = new LinkedList<>();

    private String currentLandmark;

    /**
     * Other landmarks Used:
     * Chimney Rock: 552
     * Independence Rock: 828
     * South Pass: 930 - Later can include option to go straight to Soda Springs, but must cross Green River
     * Soda Springs: 1217
     * Blue Mountains: 1729 - Later can include option to go through The Dalles
     * The Dalles: 1904 - Gives option to take Barlow Road for $9.50 or float down a river
     * Willamette Valley: 2004 - Final Destination
     *
     */

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
        this.paceType = "Normal";

        // Distance to Landmarks Queue
        this.distanceToLandmark.add(kansasRiver);
        this.distanceToLandmark.add(bigBlueRiver);
        this.distanceToLandmark.add(fortKearney);
        this.distanceToLandmark.add(chimneyRock);
        this.distanceToLandmark.add(fortLaramie);
        this.distanceToLandmark.add(independenceRock);
        this.distanceToLandmark.add(southPass);
        this.distanceToLandmark.add(fortBridger);
        this.distanceToLandmark.add(sodaSprings);
        this.distanceToLandmark.add(fortHall);
        this.distanceToLandmark.add(snakeRiver);
        this.distanceToLandmark.add(fortBoise);
        this.distanceToLandmark.add(blueMountains);
        this.distanceToLandmark.add(fortWallaWalla);
        this.distanceToLandmark.add(theDalles);
        this.distanceToLandmark.add(willametteValley);

        // Landmark Names Queue
        this.currentLandmarkQueue.add("Kansas River");
        this.currentLandmarkQueue.add("Big Blue River");
        this.currentLandmarkQueue.add("Fort Kearney");
        this.currentLandmarkQueue.add("Chimney Rock");
        this.currentLandmarkQueue.add("Fort Laramie");
        this.currentLandmarkQueue.add("Independence Rock");
        this.currentLandmarkQueue.add("South Pass");
        this.currentLandmarkQueue.add("Fort Bridger");
        this.currentLandmarkQueue.add("Soda Springs");
        this.currentLandmarkQueue.add("Fort Hall");
        this.currentLandmarkQueue.add("Snake River");
        this.currentLandmarkQueue.add("Fort Boise");
        this.currentLandmarkQueue.add("Blue Mountains");
        this.currentLandmarkQueue.add("Fort Walla Walla");
        this.currentLandmarkQueue.add("The Dalles");
        this.currentLandmarkQueue.add("Willamette Valley");

        this.currentLandmark = "Matt's Store";
    }

    // Method getLocation returns location
    // @return location the location of the player
    public int getLocation() {
        return location;
    }

    public String getCurrentLandmark() {
        return currentLandmark;
    }

    public int getPace() {
        return pace;
    }

    // Method updateLocation updates location as a function of pace
    // @return boolean returns true if at a landmark
    public boolean updateLocation(int pace) {
        location += pace;
        if (location >= distanceToLandmark.peek()){
            location = distanceToLandmark.remove();
            currentLandmark = currentLandmarkQueue.remove();
            this.updateZone();
            return true;
        }
        return false;
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

    public int distanceToNextLandmark(){
        return distanceToLandmark.peek() - this.location;
    }

    // Pace Functions

    // Method getPaceType gets the type of pace the user wants to use
    // @return paceType returns chosen pace type from user
    public String getPaceType() {
        return paceType;
    }

    public void setPaceType(String paceType) {
        if (this.paceType == "Strenuous") { this.pace /= 1.5; }
        if (this.paceType == "Grueling") { this.pace /= 2; }
        this.paceType = paceType;
        if (paceType == "Strenuous") { this.pace *= 1.5; }
        if (paceType == "Grueling") { this.pace *= 2; }
    }

    public void updateZone() {
        if (this.currentLandmark.equals("Fort Laramie")) { this.zone = 2; }
        if (this.currentLandmark.equals("Fort Bridger")) { this.zone = 3; }
        if (this.currentLandmark.equals("Fort Boise")) { this.zone = 4; }
     }

    public int getZone() {
        return zone;
    }
}
