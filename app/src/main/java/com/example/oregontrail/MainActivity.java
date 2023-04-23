package com.example.oregontrail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    // All Objects used in game
    Health health = new Health();
    Inventory inventory = new Inventory();
    Map map = new Map();
    Time time = new Time();
    Weather weather = new Weather();
    RandomEvent randomEvent = new RandomEvent();

    River kansasRiver = new River(2,10,10,"Smooth");
    River bigBlueRiver = new River(5,20,10,"Smooth");
    River greenRiver = new River(3,15,10,"Smooth");
    River snakeRiver = new River(10,35,10,"Smooth");

    Queue<River> riverQueue = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // All objects of text boxes, images, or buttons
        final TextView gamePlayText = findViewById(R.id.gamePlayText);
        final TextView dateTextChange = findViewById(R.id.dateTextChange);
        final TextView weatherTempText = findViewById(R.id.weatherTempText);
        final TextView weatherConditionText = findViewById(R.id.weatherConditionText);
        final TextView distanceLandmarkText = findViewById(R.id.distanceLandmarkText);
        final TextView distanceTraveledText = findViewById(R.id.distanceTraveledText);
        final TextView paceText = findViewById(R.id.paceText);
        final TextView healthText = findViewById(R.id.healthText);
        final TextView foodText = findViewById(R.id.foodText);
        final Button nextDayButton = findViewById(R.id.nextDay);
        final TextView locationText = findViewById(R.id.locationText);
        final Button paceButton = findViewById(R.id.paceButton);
        final Button normalPaceButton = findViewById(R.id.normalPaceButton);
        final Button strenuousPaceButton = findViewById(R.id.strenuousPaceButton);
        final Button gruelingPaceButton = findViewById(R.id.gruelingPaceButton);
        final Button exitOptionsButton = findViewById(R.id.exitOptionsButton);
        final ImageView optionsBackground = findViewById(R.id.optionsBackground2);

        // Options Buttons
        final Button buyButton = findViewById(R.id.buyButton);


        // General Store Screen
        final TextView storeLabel1 = findViewById(R.id.storeLabel1);
        final TextView storeLabel2 = findViewById(R.id.storeLabel2);
        final TextView storeLabel3 = findViewById(R.id.storeLabel3);
        final TextView storeLabel4 = findViewById(R.id.storeLabel4);
        final TextView storeTotalCost = findViewById(R.id.storeTotalCost);
        final TextView storeYourMoney = findViewById(R.id.storeYourMoney);
        final Button storeBuyButton = findViewById(R.id.storeBuyButton);
        final TextView storeFoodText = findViewById(R.id.storeFoodText);
        final TextView storeFoodAmount = findViewById(R.id.storeFoodAmount);
        final Button storeDecrementFood = findViewById(R.id.storeDecrementFood);
        final Button storeIncrementFood = findViewById(R.id.storeIncrementFood);
        final TextView storeFoodCost = findViewById(R.id.storeFoodCost);
        final TextView storeYourFood = findViewById(R.id.storeYourFood);

        // River Event Elements
        final TextView riverDepth = findViewById(R.id.riverDepth);
        final TextView riverWidth = findViewById(R.id.riverWidth);
        final Button riverFordButton = findViewById(R.id.riverFordButton);
        final Button riverFloatButton = findViewById(R.id.riverFloatButton);
        final Button riverFerryButton = findViewById(R.id.riverFerryButton);
        final Button riverWaitButton = findViewById(R.id.riverWaitButton);


        // When next day button is clicked
        nextDayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (map.isRiver()) {
                    nextDayButton.setVisibility(View.GONE);
                    optionsBackground.setVisibility(View.VISIBLE);
                    riverDepth.setVisibility(View.VISIBLE);
                    riverWidth.setVisibility(View.VISIBLE);
                    riverFordButton.setVisibility(View.VISIBLE);
                    riverFloatButton.setVisibility(View.VISIBLE);
                    riverFerryButton.setVisibility(View.VISIBLE);
                    riverWaitButton.setVisibility(View.VISIBLE);

                    // Displays River Depth and Width Depending on Which River
                    String currentLandmark = map.getCurrentLandmark();
                    if (currentLandmark == "Kansas River"){
                        String depth = Integer.toString(kansasRiver.getDepth());
                        String width = Integer.toString(kansasRiver.getWidth());
                        riverDepth.setText("River Depth: " + depth);
                        riverWidth.setText("River Width: " + width);
                    }
                    else if (currentLandmark == "Big Blue River"){
                        String depth = Integer.toString(bigBlueRiver.getDepth());
                        String width = Integer.toString(bigBlueRiver.getWidth());
                        riverDepth.setText("River Depth: " + depth);
                        riverWidth.setText("River Width: " + width);
                    }
                    else if (currentLandmark == "Snake River"){
                        String depth = Integer.toString(snakeRiver.getDepth());
                        String width = Integer.toString(snakeRiver.getWidth());
                        riverDepth.setText("River Depth: " + depth);
                        riverWidth.setText("River Width: " + width);
                    }
                    else {
                        String depth = Integer.toString(greenRiver.getDepth());
                        String width = Integer.toString(greenRiver.getWidth());
                        riverDepth.setText("River Depth: " + depth);
                        riverWidth.setText("River Width: " + width);
                    }

                    map.updateLocation(20);
                }
                else {
                    String dailyOutput = time.outputDate() + "\n";

                    // Updates and displays changes to weather
                    weather.dailyWeather(time);
                    weatherConditionText.setText(weather.weatherTypeString());
                    weatherTempText.setText(weather.getTempType());

                    // Updates and displays changes to party's health
                    health.PartyUpdate(weather, inventory, map);
                    healthText.setText("Health: " + health.getParty());

                    // Updates and displays location
                    if(map.updateLocation(map.getPace())){
                        locationText.setText(map.getCurrentLandmark());
                    }
                    distanceTraveledText.setText("Traveled: " + map.getLocation());
                    distanceLandmarkText.setText("To Landmark: " + map.distanceToNextLandmark());

                    // Updates and displays food count
                    inventory.removeInventory("Food", 20);
                    foodText.setText("Food: " + Integer.toString(inventory.getInventoryValue("Food")));

                    // Checks whether a fort is reached
                    if (map.isFort()){
                        dailyOutput = dailyOutput + "You have reached " + map.getCurrentLandmark() + ".\n";
                    }
                    // Checks whether a river is reached
                    else if (map.isRiver()) {
                        dailyOutput = dailyOutput + "You have reached " + map.getCurrentLandmark() + ".\n";
                    }
                    // Otherwise check for any random events that may occur
                    else {
                        dailyOutput = dailyOutput + "Random Event: " + randomEvent.Event(inventory, weather, time) + ".\n";
                    }

                    // Displays Text explaining what happened during the day
                    gamePlayText.setText(dailyOutput);

                    // Update and Display the new date
                    time.updateDay(1);
                    dateTextChange.setText(time.outputDate());
                }
            }

        });

        // When Exit button is clicked in the options menu
        exitOptionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nextDayButton.setVisibility(View.VISIBLE);
                optionsBackground.setVisibility(View.GONE);
                exitOptionsButton.setVisibility(View.GONE);
                // General Store Items (Buy Button)
                storeLabel1.setVisibility(View.GONE);
                storeLabel2.setVisibility(View.GONE);
                storeLabel3.setVisibility(View.GONE);
                storeLabel4.setVisibility(View.GONE);
                storeTotalCost.setVisibility(View.GONE);
                storeYourMoney.setVisibility(View.GONE);
                storeBuyButton.setVisibility(View.GONE);
                storeFoodText.setVisibility(View.GONE);
                storeDecrementFood.setVisibility(View.GONE);
                storeIncrementFood.setVisibility(View.GONE);
                storeFoodAmount.setVisibility(View.GONE);
                storeFoodCost.setVisibility(View.GONE);
                storeYourFood.setVisibility(View.GONE);
                // Pace Button Items
                normalPaceButton.setVisibility(View.GONE);
                strenuousPaceButton.setVisibility(View.GONE);
                gruelingPaceButton.setVisibility(View.GONE);
            }
        });

        // Buttons for General Store

        // When Buy Button is Clicked
        buyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Displays Store Screen
                nextDayButton.setVisibility(View.GONE);
                optionsBackground.setVisibility(View.VISIBLE);
                exitOptionsButton.setVisibility(View.VISIBLE);
                storeLabel1.setVisibility(View.VISIBLE);
                storeLabel2.setVisibility(View.VISIBLE);
                storeLabel3.setVisibility(View.VISIBLE);
                storeLabel4.setVisibility(View.VISIBLE);
                storeTotalCost.setVisibility(View.VISIBLE);
                storeYourMoney.setVisibility(View.VISIBLE);
                storeBuyButton.setVisibility(View.VISIBLE);
                storeFoodText.setVisibility(View.VISIBLE);
                storeDecrementFood.setVisibility(View.VISIBLE);
                storeIncrementFood.setVisibility(View.VISIBLE);
                storeFoodAmount.setVisibility(View.VISIBLE);
                storeFoodCost.setVisibility(View.VISIBLE);
                storeYourFood.setVisibility(View.VISIBLE);

                // Updates Variables (Also contains text for Max Amount)
                storeYourFood.setText(Integer.toString(inventory.getInventoryValue("Food")) + "   /   None");
            }
        });

        storeDecrementFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final int changeInQuant = 25;
                double foodPrice = 1.00;
                int orig_Value = Integer.parseInt(storeFoodAmount.getText().toString());
                if (orig_Value > 0) {
                    storeFoodAmount.setText(Integer.toString(orig_Value - changeInQuant));
                    storeFoodCost.setText(String.valueOf(Integer.parseInt(storeFoodAmount.getText().toString()) * foodPrice));
                }
            }
        });

        storeIncrementFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final int changeInQuant = 25;
                double foodPrice = 1.00;
                int orig_Value = Integer.parseInt(storeFoodAmount.getText().toString());
                storeFoodAmount.setText(Integer.toString(orig_Value + changeInQuant));
                storeFoodCost.setText(String.valueOf(Integer.parseInt(storeFoodAmount.getText().toString()) * foodPrice));
            }
        });

        // Buttons For River Event

        riverFordButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        riverFloatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        riverFerryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        riverWaitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        // When the Pace button is clicked
        paceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nextDayButton.setVisibility(View.GONE);
                optionsBackground.setVisibility(View.VISIBLE);
                normalPaceButton.setVisibility(View.VISIBLE);
                strenuousPaceButton.setVisibility(View.VISIBLE);
                gruelingPaceButton.setVisibility(View.VISIBLE);
                exitOptionsButton.setVisibility(View.VISIBLE);
            }
        });

        // Buttons for Pace Menu
        normalPaceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                map.setPaceType("Normal");
                paceText.setText("Pace: Normal");
            }
        });

        strenuousPaceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                map.setPaceType("Strenuous");
                paceText.setText("Pace: Strenuous");
            }
        });

        gruelingPaceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                map.setPaceType("Grueling");
                paceText.setText("Pace: Grueling");
            }
        });

    }



}