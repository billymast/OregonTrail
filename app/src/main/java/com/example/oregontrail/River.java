package com.example.oregontrail;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;


// River Class: Object for Rivers which contain depth, width, river current swiftness, and floor type of river
// Also contains functions involving outcomes that occur when crossing river under different circumstances
// Author: Billy Mast

public class River implements Parcelable {

    private int depth;
    private int width;
    private int swiftness;

    // Either Smooth, Muddy, or Rocky
    private String riverFloorType;

    private double[] managedinv = new double[16];

    private double money;

    public River() {
        this.depth = 0;
        this.width = 0;
        this.swiftness = 0;
        this.riverFloorType = "Smooth";
    }
    public River(int depth, int width, int swiftness, String riverFloorType) {
        this.depth = depth;
        this.width = width;
        this.swiftness = swiftness;
        this.riverFloorType = riverFloorType;
    }

    protected River(Parcel in) {
        depth = in.readInt();
        width = in.readInt();
        swiftness = in.readInt();
        riverFloorType = in.readString();
    }

    public static final Creator<River> CREATOR = new Creator<River>() {
        @Override
        public River createFromParcel(Parcel in) {
            return new River(in);
        }

        @Override
        public River[] newArray(int size) {
            return new River[size];
        }
    };

    public int getDepth() {
        return depth;
    }

    public int getWidth() {
        return width;
    }

    public int getSwiftness() {
        return swiftness;
    }

    // Fording the River

    public int riverFord(Time time, Weather weather, Health health) {

        // Depths less than 2.5
        if (this.depth < 2.5){
            // No problem crossing
            if (this.riverFloorType == "Smooth") { return 1; }
            if (this.riverFloorType == "Muddy") {
                //40% chance of getting stuck in mud
                if(Math.random() < 0.4) {
                    time.updateDay(1);
                    // If cold health affected
                    if (weather.getTempType() == "cold" || weather.getTempType() == "very cold") {
                        /** Health class needs way to increase */
                        /** Health class needs way to increase */
                        double modifiedHealth = health.getParty();

                        // The worse the current health the harder the party is hit
                        // ie. if you're sick and end up in a freezing cold river you are much
                        // worse off than if you weren't sick to begin with
                        modifiedHealth *= 1.5;

                        // Return the modified value to the health class
                        health.setParty(modifiedHealth);

                    }
                    // Stuck in mud, Lose a day
                    return 2;
                }
                // Muddy crossing, but you did not get stuck
                else { return 3; }
            }
            if (this.riverFloorType == "Rocky") {
                // 16% chance of overturning
                if (Math.random() < 0.16) {
                    /** 10-40% of supplies lost, each person has 10% chance of injury, and random parts break */

                    // Losing supplies
                    double suppliesLost = Math.random() / (1/.3) + .1;

                    for (int i = 0; i <= 15; i++){
                        if (i != 5){
                            managedinv[i] *= 1-suppliesLost;
                        }
                    }

                    // For injury



                    return 4;
                }
                // Rough crossing, but you did not overturn
                else { return 5; }
            }
        }

        // Depths between 2.5 and 5
        // Wagon swamps
        else if (this.depth < 5) {
            /** 50-90% of supplies is lost, each ox has a 30% chance of drowning - Could use a binomial dist for that */
            double suppliesLost = Math.random() / 2.5 + .5;
            int oxboi = 0;

            for (int i = 0; i <= 15; i++){
                if (i != 5){
                    managedinv[i] *= 1-suppliesLost;
                } else {
                    // Ox chance of death
                    for (int z = 1; z <= managedinv[5]; z++){
                        if (Math.random() <= .7){
                            oxboi++;
                        }
                    }
                    managedinv[5] = oxboi;
                }
            }


            return 6;
        }

        // Depths greater than 5
        else { /** Wagon and oxen are swept away, each person has 30% of drowning */ return 7; }
        return 8;
    }

    // Float Across the River
    public int riverFloat() {
        // Slow current - No problem floating across the river
        if (this.swiftness < 2.5) { return 1; }
        else if (this.swiftness < 5) { /** 50-90% of supplies swept away */ return 2; }
        else { /** Wagon and oxen are swept away, high chance of each person drowning */ return 3; }
    }

    // Take Ferry Across the River

    public void riverFerry(Time time) {
        /** Take away $5  */
        time.updateDay(3);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(depth);
        parcel.writeInt(width);
        parcel.writeInt(swiftness);
        parcel.writeString(riverFloorType);
    }
}
