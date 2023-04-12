package com.example.oregontrail;

// River Class: Object for Rivers which contain depth, width, river current swiftness, and floor type of river
// Also contains functions involving outcomes that occur when crossing river under different circumstances
// Author: Billy Mast

public class River {

    private int depth;
    private int width;
    private int swiftness;

    // Either Smooth, Muddy, or Rocky
    private String riverFloorType;

    public River(int depth, int width, int swiftness, String riverFloorType) {
        this.depth = depth;
        this.width = width;
        this.swiftness = swiftness;
        this.riverFloorType = riverFloorType;
    }




    // Fording the River

    public int riverFord(Time time, Weather weather, Health health){

        // Depths less than 2.5
        if (this.depth < 2.5){
            // No problem crossing
            if (this.riverFloorType == "Smooth") { return 1; }
            if (this.riverFloorType == "Muddy") {
                //40% chance of getting stuck in mud
                if(Math.random() < 0.4) {
                    time.updateDay();
                    // If cold health affected
                    if (weather.getTempType() == "cold" || weather.getTempType() == "very cold") { health. /* Health class needs way to increase */ }
                    // Stuck in mud, Lose a day
                    return 2;
                }
                // Muddy crossing, but you did not get stuck
                else { return 3; }
            }
            if (this.riverFloorType == "Rocky") {
                // 16% chance of overturning
                if (Math.random() < 0.16) {
                    /* 10-40% of supplies lost, each person has 10% chance of injury, and random parts break */ return 4;
                }
                // Rough crossing, but you did not overturn
                else { return 5; }
            }
        }

        // Depths between 2.5 and 5
        // Wagon swamps
        else if (this.depth < 5) { /* 50-90% of supplies is lost, each ox has a 30% chance of drowning - Could use a binomial dist for that */ return 6;}

        // Depths greater than 5
        else { /* Wagon and oxen are swept away, each person has 30% of drowning */ return 7;}
    }

    // Float Across the River

    // Take Ferry Across the River



}
