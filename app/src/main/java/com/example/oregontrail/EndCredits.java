package com.example.oregontrail;

public class EndCredits {


    public static int calcFinalScore(Inventory inventory, int peopleAlive, String modeSelected) {

        double totalScore = 0;

        final double scorePerFood = 0.20;
        final double scorePerClothes = 0.75;
        final double scorePerRifle = 10.00;
        final double scorePerShots = 2.50;
        final double scorePerWheels = 4.00;
        final double scorePerAxles = 1.50;
        final double scorePerTongues = 1.50;
        final double scorePerOxen = 25.00;
        final double scorePerMoney = 1.00;

        // Takes into account everything in the inventory
        totalScore += inventory.getInventoryValue("Food") * scorePerFood;
        totalScore += inventory.getInventoryValue("Clothes") * scorePerClothes;
        totalScore += inventory.getInventoryValue("Rifle") * scorePerRifle;
        totalScore += inventory.getInventoryValue("Shots") * scorePerShots;
        totalScore += inventory.getInventoryValue("SpareWagonWheels") * scorePerWheels;
        totalScore += inventory.getInventoryValue("SpareWagonAxel") * scorePerAxles;
        totalScore += inventory.getInventoryValue("SpareWagonTongues") * scorePerTongues;
        totalScore += inventory.getInventoryValue("Oxen") * scorePerOxen;
        totalScore += inventory.moneyAmount() * scorePerMoney;

        // Takes into account mode differences in starting money

        final double hardCashDiff = 1000;
        final double normalCashDiff = 500;

        if (modeSelected.equals("Hard")) {
            totalScore += hardCashDiff;
        }
        if (modeSelected.equals("Normal")) {
            totalScore += normalCashDiff;
        }

        // Takes into account number of people left alive
        final int scorePerPersonAlive = 1000;
        totalScore += peopleAlive * scorePerPersonAlive;

        // Difficulty Multiplier

        final int hardModeMultiplier = 3;
        final int normalModeMultiplier = 2;

        if (modeSelected.equals("Hard")) {
            totalScore *= hardModeMultiplier;
        }
        if (modeSelected.equals("Normal")) {
            totalScore *= normalModeMultiplier;
        }

        return (int) Math.round(totalScore);

    }

}
