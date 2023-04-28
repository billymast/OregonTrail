package com.example.oregontrail;
import java.util.Random;

/**
 * Class file to keep track of the wagon's health from events
 * Weather - Blizzard, Hail, Thunder
 * River
 * Ox wanders off
 * fire in the wagon
 */

public class Wagon {

    private int health;

    public Wagon() {
        this.health = 100;
    }

    public int getHealth() {
        return health;
    }

    // method to update wagon's health based on random weather event
    public void updateHealth(Weather weather) {
        int damage = 0;
        Random rand = new Random();
        int weatherEvent = rand.nextInt(3); // generates a random integer between 0 and 2

        switch (weatherEvent) {
            case 0: // Blizzard - 20-30% damage
                damage = rand.nextInt(11) + 20;
                break;
            case 1: // Hail - 10-20% damage
                damage = rand.nextInt(11) + 10;
                break;
            case 2: // Thunder - 5-15% damage
                damage = rand.nextInt(11) + 5;
                break;
        }

        int currentHealth = this.health;
        currentHealth -= (currentHealth * damage) / 100; // update the health based on the damage percentage
        this.health = currentHealth;
    }

    public void updateHealth(River river, Time time, Weather weather, Health partyHealth) {
        int currentHealth = this.health;
        int riverOutcome = river.riverFord(time, weather, partyHealth);

        int suppliesLost = 0;

        switch (riverOutcome) {
            case 1: // Smooth crossing - no damage
                break;
            case 2: // Stuck in mud - 5-15% damage
                int damage = (new Random()).nextInt(11) + 5;
                currentHealth -= (currentHealth * damage) / 100;
                this.health = currentHealth;
                break;
            case 3: // Muddy crossing - no damage
                break;
            case 4: // Overturned wagon - 10-40% supplies lost, 10% chance of injury, random parts break
                suppliesLost = (new Random()).nextInt(31) + 10;
                // TODO: decrease supplies based on the percentage lost
                // TODO: implement injury system
                // TODO: implement random parts breaking system
                break;
            case 5: // Rocky crossing - no damage
                break;
            case 6: // Wagon swamps - 50-90% supplies lost, 30% chance of oxen drowning
                suppliesLost = (new Random()).nextInt(41) + 50;
                // TODO: decrease supplies based on the percentage lost
                // TODO: implement oxen drowning system
                break;
            case 7: // Wagon and oxen swept away - 30% chance of each person drowning
                // TODO: implement wagon and oxen swept away system
                // TODO: implement drowning system
                break;
            default:
                break;
        }

        // Decrease supplies based on the percentage lost
        // TODO: decrease supplies based on the percentage lost
    }

}

