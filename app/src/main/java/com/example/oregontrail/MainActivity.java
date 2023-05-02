package com.example.oregontrail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import org.w3c.dom.Text;

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
    GeneralStore generalStoreMatt = new GeneralStore(0);
    GeneralStore generalStoreKearney = new GeneralStore(1);
    GeneralStore generalStoreLaramie = new GeneralStore(2);
    GeneralStore generalStoreBridger = new GeneralStore(3);
    GeneralStore generalStoreHall = new GeneralStore(4);
    GeneralStore generalStoreBoise = new GeneralStore(5);
    GeneralStore generalStoreWalla = new GeneralStore(6);

    River kansasRiver = new River(2,10,10,"Smooth");
    River bigBlueRiver = new River(5,20,10,"Smooth");
    River greenRiver = new River(3,15,10,"Smooth");
    River snakeRiver = new River(10,35,10,"Smooth");

    Queue<River> riverQueue = new LinkedList<>();

    GeneralStore currentStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buttons to Take To Other Screens
        configurehuntYesButton();

        // Elements for Main Game Screen
        final TextView gamePlayText = findViewById(R.id.gamePlayText);
        final TextView dateTextChange = findViewById(R.id.dateTextChange);
        final TextView weatherTempText = findViewById(R.id.weatherTempText);
        final TextView weatherConditionText = findViewById(R.id.weatherConditionText);
        final TextView distanceLandmarkText = findViewById(R.id.distanceLandmarkText);
        final TextView distanceTraveledText = findViewById(R.id.distanceTraveledText);
        final TextView paceText = findViewById(R.id.paceText);
        final TextView rationsText = findViewById(R.id.rationsText);
        final TextView healthText = findViewById(R.id.healthText);
        final TextView foodText = findViewById(R.id.foodText);
        final Button nextDayButton = findViewById(R.id.nextDay);
        final TextView locationText = findViewById(R.id.locationText);

        final ImageView imageView = (ImageView) findViewById (R.id.HattieCampbell);
        imageView.setImageResource(R.drawable.hattie_normal);

        // Options Buttons
        final Button mapButton = findViewById(R.id.mapButton);
        final Button statusButton = findViewById(R.id.statusButton);
        final Button rationsButton = findViewById(R.id.rationsButton);
        final Button buyButton = findViewById(R.id.buyButton);
        final Button tradeButton = findViewById(R.id.tradeButton);
        final Button talkButton = findViewById(R.id.talkButton);
        final Button restButton = findViewById(R.id.restButton);
        final Button paceButton = findViewById(R.id.paceButton);
        final Button huntButton = findViewById(R.id.huntButton);

        // Background for Different Options Screens
        final Button exitOptionsButton = findViewById(R.id.exitOptionsButton);
        final ImageView optionsBackground = findViewById(R.id.optionsBackground2);

        // General Store Screen
        final TextView storeLabel1 = findViewById(R.id.storeLabel1);
        final TextView storeLabel2 = findViewById(R.id.storeLabel2);
        final TextView storeLabel3 = findViewById(R.id.storeLabel3);
        final TextView storeLabel4 = findViewById(R.id.storeLabel4);
        final TextView storeTotalCost = findViewById(R.id.storeTotalCost);
        final TextView storeYourMoney = findViewById(R.id.storeYourMoney);
        final Button storeBuyButton = findViewById(R.id.storeBuyButton);
        final TextView storeFoodText = findViewById(R.id.storeFoodText);
        final TextView storeClothesText = findViewById(R.id.storeClothesText);
        final TextView storeRifleText = findViewById(R.id.storeRifleText);
        final TextView storeShotsText = findViewById(R.id.storeShotsText);
        final TextView storeWheelsText = findViewById(R.id.storeWheelsText);
        final TextView storeAxlesText = findViewById(R.id.storeAxlesText);
        final TextView storeTonguesText = findViewById(R.id.storeTonguesText);
        final TextView storeOxenText = findViewById(R.id.storeOxenText);
        final TextView storeFoodAmount = findViewById(R.id.storeFoodAmount);
        final TextView storeClothesAmount = findViewById(R.id.storeClothesAmount);
        final TextView storeRifleAmount = findViewById(R.id.storeRifleAmount);
        final TextView storeShotsAmount = findViewById(R.id.storeShotsAmount);
        final TextView storeWheelsAmount = findViewById(R.id.storeWheelsAmount);
        final TextView storeAxlesAmount = findViewById(R.id.storeAxlesAmount);
        final TextView storeTonguesAmount = findViewById(R.id.storeTonguesAmount);
        final TextView storeOxenAmount = findViewById(R.id.storeOxenAmount);
        final Button storeDecrementFood = findViewById(R.id.storeDecrementFood);
        final Button storeDecrementClothes = findViewById(R.id.storeDecrementClothes);
        final Button storeDecrementRifle = findViewById(R.id.storeDecrementRifle);
        final Button storeDecrementShots = findViewById(R.id.storeDecrementShots);
        final Button storeDecrementWheels = findViewById(R.id.storeDecrementWheels);
        final Button storeDecrementAxles = findViewById(R.id.storeDecrementAxles);
        final Button storeDecrementTongues = findViewById(R.id.storeDecrementTongues);
        final Button storeDecrementOxen = findViewById(R.id.storeDecrementOxen);
        final Button storeIncrementFood = findViewById(R.id.storeIncrementFood);
        final Button storeIncrementClothes = findViewById(R.id.storeIncrementClothes);
        final Button storeIncrementRifle = findViewById(R.id.storeIncrementRifle);
        final Button storeIncrementShots = findViewById(R.id.storeIncrementShots);
        final Button storeIncrementWheels = findViewById(R.id.storeIncrementWheels);
        final Button storeIncrementAxles = findViewById(R.id.storeIncrementAxles);
        final Button storeIncrementTongues = findViewById(R.id.storeIncrementTongues);
        final Button storeIncrementOxen = findViewById(R.id.storeIncrementOxen);
        final TextView storeFoodCost = findViewById(R.id.storeFoodCost);
        final TextView storeClothesCost = findViewById(R.id.storeClothesCost);
        final TextView storeRifleCost = findViewById(R.id.storeRifleCost);
        final TextView storeShotsCost = findViewById(R.id.storeShotsCost);
        final TextView storeWheelsCost = findViewById(R.id.storeWheelsCost);
        final TextView storeAxlesCost = findViewById(R.id.storeAxlesCost);
        final TextView storeTonguesCost = findViewById(R.id.storeTonguesCost);
        final TextView storeOxenCost = findViewById(R.id.storeOxenCost);
        final TextView storeYourFood = findViewById(R.id.storeYourFood);
        final TextView storeYourClothes = findViewById(R.id.storeYourClothes);
        final TextView storeYourRifle = findViewById(R.id.storeYourRifle);
        final TextView storeYourShots = findViewById(R.id.storeYourShots);
        final TextView storeYourWheels = findViewById(R.id.storeYourWheels);
        final TextView storeYourAxles = findViewById(R.id.storeYourAxles);
        final TextView storeYourTongues = findViewById(R.id.storeYourTongues);
        final TextView storeYourOxen = findViewById(R.id.storeYourOxen);

        // River Event Elements
        final TextView riverDepth = findViewById(R.id.riverDepth);
        final TextView riverWidth = findViewById(R.id.riverWidth);
        final Button riverFordButton = findViewById(R.id.riverFordButton);
        final Button riverFloatButton = findViewById(R.id.riverFloatButton);
        final Button riverFerryButton = findViewById(R.id.riverFerryButton);
        final Button riverWaitButton = findViewById(R.id.riverWaitButton);

        // Status Elements
        final TextView inventoryFood = findViewById(R.id.inventoryFood);
        final TextView inventoryClothes = findViewById(R.id.inventoryClothes);
        final TextView inventoryRifle = findViewById(R.id.inventoryRifle);
        final TextView inventoryShots = findViewById(R.id.inventoryShots);
        final TextView inventoryOxen = findViewById(R.id.inventoryOxen);
        final TextView inventoryWagonWheels = findViewById(R.id.inventoryWagonWheels);
        final TextView inventoryWagonAxels = findViewById(R.id.inventoryWagonAxels);
        final TextView inventoryWagonTongues = findViewById(R.id.inventoryWagonTongues);
        final TextView inventoryMoney = findViewById(R.id.inventoryMoney);

        // Pace Buttons
        final Button normalPaceButton = findViewById(R.id.normalPaceButton);
        final Button strenuousPaceButton = findViewById(R.id.strenuousPaceButton);
        final Button gruelingPaceButton = findViewById(R.id.gruelingPaceButton);

        // Rations Buttons
        final Button fillingRationsButton = findViewById(R.id.fillingRationsButton);
        final Button meagerRationsButton = findViewById(R.id.meagerRationsButton);
        final Button bareBonesRationsButton = findViewById(R.id.bareBonesRationsButton);

        // Hunt Button Elements
        final TextView huntText = findViewById(R.id.huntText);
        final Button huntYesButton = findViewById(R.id.huntYesButton);


        // When next day button is clicked
        nextDayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String hattiePicValue = health.HealthString();

                switch (hattiePicValue) {
                    case "Good Health":
                        imageView.setImageResource(R.drawable.hattie_happy);
                        break;
                    case "Fair Health":
                        imageView.setImageResource(R.drawable.hattie_normal);
                        break;
                    case "Poor Health":
                        imageView.setImageResource(R.drawable.hattie_sad);
                        break;
                    case "Very Poor Health":
                        imageView.setImageResource(R.drawable.hattie_sad);
                        break;
                    case "Death Imminent":
                        imageView.setImageResource(R.drawable.hattie_injured);
                        break;
                    default:  imageView.setImageResource(R.drawable.hattie_normal);
                }


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
                    health.PartyUpdate(weather, inventory, map, false);
                    healthText.setText("Health: " + health.HealthString());

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
                    dateTextChange.setText(time.outputDate());
                    time.updateDay(1);
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
                storeClothesText.setVisibility(View.GONE);
                storeRifleText.setVisibility(View.GONE);
                storeShotsText.setVisibility(View.GONE);
                storeWheelsText.setVisibility(View.GONE);
                storeAxlesText.setVisibility(View.GONE);
                storeTonguesText.setVisibility(View.GONE);
                storeOxenText.setVisibility(View.GONE);
                storeDecrementFood.setVisibility(View.GONE);
                storeDecrementClothes.setVisibility(View.GONE);
                storeDecrementRifle.setVisibility(View.GONE);
                storeDecrementShots.setVisibility(View.GONE);
                storeDecrementWheels.setVisibility(View.GONE);
                storeDecrementAxles.setVisibility(View.GONE);
                storeDecrementTongues.setVisibility(View.GONE);
                storeDecrementOxen.setVisibility(View.GONE);
                storeIncrementFood.setVisibility(View.GONE);
                storeIncrementClothes.setVisibility(View.GONE);
                storeIncrementRifle.setVisibility(View.GONE);
                storeIncrementShots.setVisibility(View.GONE);
                storeIncrementWheels.setVisibility(View.GONE);
                storeIncrementAxles.setVisibility(View.GONE);
                storeIncrementTongues.setVisibility(View.GONE);
                storeIncrementOxen.setVisibility(View.GONE);
                storeFoodAmount.setVisibility(View.GONE);
                storeClothesAmount.setVisibility(View.GONE);
                storeRifleAmount.setVisibility(View.GONE);
                storeShotsAmount.setVisibility(View.GONE);
                storeWheelsAmount.setVisibility(View.GONE);
                storeAxlesAmount.setVisibility(View.GONE);
                storeTonguesAmount.setVisibility(View.GONE);
                storeOxenAmount.setVisibility(View.GONE);
                storeFoodCost.setVisibility(View.GONE);
                storeClothesCost.setVisibility(View.GONE);
                storeRifleCost.setVisibility(View.GONE);
                storeShotsCost.setVisibility(View.GONE);
                storeWheelsCost.setVisibility(View.GONE);
                storeAxlesCost.setVisibility(View.GONE);
                storeTonguesCost.setVisibility(View.GONE);
                storeOxenCost.setVisibility(View.GONE);
                storeYourFood.setVisibility(View.GONE);
                storeYourClothes.setVisibility(View.GONE);
                storeYourRifle.setVisibility(View.GONE);
                storeYourShots.setVisibility(View.GONE);
                storeYourWheels.setVisibility(View.GONE);
                storeYourAxles.setVisibility(View.GONE);
                storeYourTongues.setVisibility(View.GONE);
                storeYourOxen.setVisibility(View.GONE);
                // Status Elements
                inventoryFood.setVisibility(View.GONE);
                inventoryClothes.setVisibility(View.GONE);
                inventoryRifle.setVisibility(View.GONE);
                inventoryShots.setVisibility(View.GONE);
                inventoryOxen.setVisibility(View.GONE);
                inventoryWagonWheels.setVisibility(View.GONE);
                inventoryWagonAxels.setVisibility(View.GONE);
                inventoryWagonTongues.setVisibility(View.GONE);
                inventoryMoney.setVisibility(View.GONE);
                // Ration Button Elements
                fillingRationsButton.setVisibility(View.GONE);
                meagerRationsButton.setVisibility(View.GONE);
                bareBonesRationsButton.setVisibility(View.GONE);
                // Pace Button Elements
                normalPaceButton.setVisibility(View.GONE);
                strenuousPaceButton.setVisibility(View.GONE);
                gruelingPaceButton.setVisibility(View.GONE);
                // Hunt Button Elements
                huntText.setVisibility(View.GONE);
                huntYesButton.setVisibility(View.GONE);
            }
        });

        // When Buy Options Button is Clicked
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
                storeClothesText.setVisibility(View.VISIBLE);
                storeRifleText.setVisibility(View.VISIBLE);
                storeShotsText.setVisibility(View.VISIBLE);
                storeWheelsText.setVisibility(View.VISIBLE);
                storeAxlesText.setVisibility(View.VISIBLE);
                storeTonguesText.setVisibility(View.VISIBLE);
                storeOxenText.setVisibility(View.VISIBLE);
                storeDecrementFood.setVisibility(View.VISIBLE);
                storeDecrementClothes.setVisibility(View.VISIBLE);
                storeDecrementRifle.setVisibility(View.VISIBLE);
                storeDecrementShots.setVisibility(View.VISIBLE);
                storeDecrementWheels.setVisibility(View.VISIBLE);
                storeDecrementAxles.setVisibility(View.VISIBLE);
                storeDecrementTongues.setVisibility(View.VISIBLE);
                storeDecrementOxen.setVisibility(View.VISIBLE);
                storeIncrementFood.setVisibility(View.VISIBLE);
                storeIncrementClothes.setVisibility(View.VISIBLE);
                storeIncrementRifle.setVisibility(View.VISIBLE);
                storeIncrementShots.setVisibility(View.VISIBLE);
                storeIncrementWheels.setVisibility(View.VISIBLE);
                storeIncrementAxles.setVisibility(View.VISIBLE);
                storeIncrementTongues.setVisibility(View.VISIBLE);
                storeIncrementOxen.setVisibility(View.VISIBLE);
                storeFoodAmount.setVisibility(View.VISIBLE);
                storeClothesAmount.setVisibility(View.VISIBLE);
                storeRifleAmount.setVisibility(View.VISIBLE);
                storeShotsAmount.setVisibility(View.VISIBLE);
                storeWheelsAmount.setVisibility(View.VISIBLE);
                storeAxlesAmount.setVisibility(View.VISIBLE);
                storeTonguesAmount.setVisibility(View.VISIBLE);
                storeOxenAmount.setVisibility(View.VISIBLE);
                storeFoodCost.setVisibility(View.VISIBLE);
                storeClothesCost.setVisibility(View.VISIBLE);
                storeRifleCost.setVisibility(View.VISIBLE);
                storeShotsCost.setVisibility(View.VISIBLE);
                storeWheelsCost.setVisibility(View.VISIBLE);
                storeAxlesCost.setVisibility(View.VISIBLE);
                storeTonguesCost.setVisibility(View.VISIBLE);
                storeOxenCost.setVisibility(View.VISIBLE);
                storeYourFood.setVisibility(View.VISIBLE);
                storeYourClothes.setVisibility(View.VISIBLE);
                storeYourRifle.setVisibility(View.VISIBLE);
                storeYourShots.setVisibility(View.VISIBLE);
                storeYourWheels.setVisibility(View.VISIBLE);
                storeYourAxles.setVisibility(View.VISIBLE);
                storeYourTongues.setVisibility(View.VISIBLE);
                storeYourOxen.setVisibility(View.VISIBLE);

                String currentLocation = map.getCurrentLandmark();
                switch (currentLocation){
                    case "Fort Kearney":
                        currentStore = generalStoreKearney;
                        break;
                    case "Fort Laramie":
                        currentStore = generalStoreLaramie;
                        break;
                    case "Fort Bridger":
                        currentStore = generalStoreBridger;
                        break;
                    case "Fort Hall":
                        currentStore = generalStoreHall;
                        break;
                    case "Fort Boise":
                        currentStore = generalStoreBoise;
                        break;
                    case "Fort Walla Walla":
                        currentStore = generalStoreWalla;
                        break;
                    default:
                        currentStore = generalStoreMatt;
                        break;
                }

                // Updates Variables (Also contains text for Max Amount)
                storeFoodText.setText("Food  /  $" + String.valueOf(currentStore.getPrice(0)));
                storeClothesText.setText("Clothes  /  $" + String.valueOf(currentStore.getPrice(1)));
                storeRifleText.setText("Rifle  /  $" + String.valueOf(currentStore.getPrice(2)));
                storeShotsText.setText("Shots  /  $" + String.valueOf(currentStore.getPrice(4)));
                storeWheelsText.setText("Wheels  /  $" + String.valueOf(currentStore.getPrice(6)));
                storeAxlesText.setText("Axles  /  $" + String.valueOf(currentStore.getPrice(7)));
                storeTonguesText.setText("Tongues  /  $" + String.valueOf(currentStore.getPrice(8)));
                storeOxenText.setText("Oxen  /  $" + String.valueOf(currentStore.getPrice(5)));
                storeYourFood.setText(String.valueOf(inventory.getInventoryValue("Food")) + "   /   None");
                storeYourClothes.setText(String.valueOf(inventory.getInventoryValue("Clothes")) + "   /   None");
                storeYourRifle.setText(String.valueOf(inventory.getInventoryValue("Rifle")) + "   /   1");
                storeYourShots.setText(String.valueOf(inventory.getInventoryValue("Shots")) + "   /   None");
                storeYourWheels.setText(String.valueOf(inventory.getInventoryValue("SpareWagonWheels")) + "   /   3");
                storeYourAxles.setText(String.valueOf(inventory.getInventoryValue("SpareWagonAxel"))  + "   /   3");
                storeYourTongues.setText(String.valueOf(inventory.getInventoryValue("SpareWagonTongues")) + "   /   3");
                storeYourOxen.setText(String.valueOf(inventory.getInventoryValue("Oxen")) + "   /   16");
                storeYourMoney.setText("Your Money: $" + String.valueOf(inventory.moneyAmount()));
            }
        });

        // When Store Buy Button is Clicked

        storeBuyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.finishTransaction(inventory);
                storeFoodAmount.setText("0");
                storeClothesAmount.setText("0");
                storeRifleAmount.setText("0");
                storeShotsAmount.setText("0");
                storeWheelsAmount.setText("0");
                storeAxlesAmount.setText("0");
                storeTonguesAmount.setText("0");
                storeOxenAmount.setText("0");
                storeFoodCost.setText("$0.00");
                storeClothesCost.setText("$0.00");
                storeRifleCost.setText("$0.00");
                storeShotsCost.setText("$0.00");
                storeWheelsCost.setText("$0.00");
                storeAxlesCost.setText("$0.00");
                storeTonguesCost.setText("$0.00");
                storeOxenCost.setText("$0.00");
                storeYourFood.setText(inventory.getInventoryValue("Food") + "   /   None");
                storeYourClothes.setText(inventory.getInventoryValue("Clothes") + "   /   None");
                storeYourRifle.setText(inventory.getInventoryValue("Rifle") + "   /   1");
                storeYourShots.setText(inventory.getInventoryValue("Shots") + "   /   None");
                storeYourWheels.setText(inventory.getInventoryValue("SpareWagonWheels") + "   /   3");
                storeYourAxles.setText(inventory.getInventoryValue("SpareWagonAxel") + "   /   3");
                storeYourTongues.setText(inventory.getInventoryValue("SpareWagonTongues") + "   /   3");
                storeYourOxen.setText(inventory.getInventoryValue("Oxen") + "   /   16");
                foodText.setText("Food Left: " + inventory.getInventoryValue("Food"));
                storeYourMoney.setText("Your Money: $" + String.valueOf(inventory.moneyAmount()));
                storeTotalCost.setText("Total Cost: $" + String.valueOf(currentStore.getTotal()));
            }
        });

        // General Store Decrement Buttons

        storeDecrementFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.removeItemQuantity(0,25);
                storeFoodAmount.setText(String.valueOf(currentStore.getQuantity(0)));
                storeFoodCost.setText("$" + currentStore.getQuantity(0) * currentStore.getPrice(0));
                storeTotalCost.setText("Total Cost: $" + currentStore.getTotal());
            }
        });
        storeDecrementClothes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.removeItemQuantity(1,1);
                storeClothesAmount.setText(String.valueOf(currentStore.getQuantity(1)));
                storeClothesCost.setText("$" + currentStore.getQuantity(1) * currentStore.getPrice(1));
                storeTotalCost.setText("Total Cost: $" + currentStore.getTotal());
            }
        });
        storeDecrementRifle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.removeItemQuantity(2,1);
                storeRifleAmount.setText(String.valueOf(currentStore.getQuantity(2)));
                storeRifleCost.setText("$" + currentStore.getQuantity(2) * currentStore.getPrice(2));
                storeTotalCost.setText("Total Cost: $" + currentStore.getTotal());
            }
        });
        storeDecrementShots.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.removeItemQuantity(4,5);
                storeShotsAmount.setText(String.valueOf(currentStore.getQuantity(4)));
                storeShotsCost.setText("$" + currentStore.getQuantity(4) * currentStore.getPrice(4));
                storeTotalCost.setText("Total Cost: $" + currentStore.getTotal());
            }
        });
        storeDecrementWheels.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.removeItemQuantity(6,1);
                storeWheelsAmount.setText(String.valueOf(currentStore.getQuantity(6)));
                storeWheelsCost.setText("$" + currentStore.getQuantity(6) * currentStore.getPrice(6));
                storeTotalCost.setText("Total Cost: $" + currentStore.getTotal());
            }
        });
        storeDecrementAxles.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.removeItemQuantity(7,1);
                storeAxlesAmount.setText(String.valueOf(currentStore.getQuantity(7)));
                storeAxlesCost.setText("$" + currentStore.getQuantity(7) * currentStore.getPrice(7));
                storeTotalCost.setText("Total Cost: $" + currentStore.getTotal());
            }
        });
        storeDecrementTongues.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.removeItemQuantity(8,1);
                storeTonguesAmount.setText(String.valueOf(currentStore.getQuantity(8)));
                storeTonguesCost.setText("$" + currentStore.getQuantity(8) * currentStore.getPrice(8));
                storeTotalCost.setText("Total Cost: $" + currentStore.getTotal());
            }
        });
        storeDecrementOxen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.removeItemQuantity(5,2);
                storeOxenAmount.setText(String.valueOf(currentStore.getQuantity(5)));
                storeOxenCost.setText("$" + currentStore.getQuantity(5) * currentStore.getPrice(5));
                storeTotalCost.setText("Total Cost: $" + currentStore.getTotal());
            }
        });

        // General Store Increment Buttons

        storeIncrementFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.addItem(0,25);
                storeFoodAmount.setText(String.valueOf(currentStore.getQuantity(0)));
                storeFoodCost.setText("$" + currentStore.getQuantity(0) * currentStore.getPrice(0));
                storeTotalCost.setText("Total Cost: $" + currentStore.getTotal());
            }
        });
        storeIncrementClothes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.addItem(1,1);
                storeClothesAmount.setText(String.valueOf(currentStore.getQuantity(1)));
                storeClothesCost.setText("$" + currentStore.getQuantity(1) * currentStore.getPrice(1));
                storeTotalCost.setText("Total Cost: $" + currentStore.getTotal());
            }
        });
        storeIncrementRifle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.addItem(2,1);
                storeRifleAmount.setText(String.valueOf(currentStore.getQuantity(2)));
                storeRifleCost.setText("$" + currentStore.getQuantity(2) * currentStore.getPrice(2));
                storeTotalCost.setText("Total Cost: $" + currentStore.getTotal());
            }
        });
        storeIncrementShots.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.addItem(4,5);
                storeShotsAmount.setText(String.valueOf(currentStore.getQuantity(4)));
                storeShotsCost.setText("$" + currentStore.getQuantity(4) * currentStore.getPrice(4));
                storeTotalCost.setText("Total Cost: $" + currentStore.getTotal());
            }
        });
        storeIncrementWheels.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.addItem(6,1);
                storeWheelsAmount.setText(String.valueOf(currentStore.getQuantity(6)));
                storeWheelsCost.setText("$" + currentStore.getQuantity(6) * currentStore.getPrice(6));
                storeTotalCost.setText("Total Cost: $" + currentStore.getTotal());
            }
        });
        storeIncrementAxles.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.addItem(7,1);
                storeAxlesAmount.setText(String.valueOf(currentStore.getQuantity(7)));
                storeAxlesCost.setText("$" + currentStore.getQuantity(7) * currentStore.getPrice(7));
                storeTotalCost.setText("Total Cost: $" + currentStore.getTotal());
            }
        });
        storeIncrementTongues.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.addItem(8,1);
                storeTonguesAmount.setText(String.valueOf(currentStore.getQuantity(8)));
                storeTonguesCost.setText("$" + currentStore.getQuantity(8) * currentStore.getPrice(8));
                storeTotalCost.setText("Total Cost: $" + currentStore.getTotal());
            }
        });
        storeIncrementOxen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.addItem(5,2);
                storeOxenAmount.setText(String.valueOf(currentStore.getQuantity(5)));
                storeOxenCost.setText("$" + currentStore.getQuantity(5) * currentStore.getPrice(5));
                storeTotalCost.setText("Total Cost: $" + currentStore.getTotal());
            }
        });

        // Buttons For River Event

        riverFordButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                nextDayButton.setVisibility(View.VISIBLE);
                optionsBackground.setVisibility(View.GONE);
                riverDepth.setVisibility(View.GONE);
                riverWidth.setVisibility(View.GONE);
                riverFordButton.setVisibility(View.GONE);
                riverFloatButton.setVisibility(View.GONE);
                riverFerryButton.setVisibility(View.GONE);
                riverWaitButton.setVisibility(View.GONE);
            }
        });

        riverFloatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                nextDayButton.setVisibility(View.VISIBLE);
                optionsBackground.setVisibility(View.GONE);
                riverDepth.setVisibility(View.GONE);
                riverWidth.setVisibility(View.GONE);
                riverFordButton.setVisibility(View.GONE);
                riverFloatButton.setVisibility(View.GONE);
                riverFerryButton.setVisibility(View.GONE);
                riverWaitButton.setVisibility(View.GONE);
            }
        });

        riverFerryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                nextDayButton.setVisibility(View.VISIBLE);
                optionsBackground.setVisibility(View.GONE);
                riverDepth.setVisibility(View.GONE);
                riverWidth.setVisibility(View.GONE);
                riverFordButton.setVisibility(View.GONE);
                riverFloatButton.setVisibility(View.GONE);
                riverFerryButton.setVisibility(View.GONE);
                riverWaitButton.setVisibility(View.GONE);
            }
        });

        riverWaitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Updates and displays changes to weather
                weather.dailyWeather(time);
                weatherConditionText.setText(weather.weatherTypeString());
                weatherTempText.setText(weather.getTempType());

                // Updates and displays changes to party's health
                health.PartyUpdate(weather, inventory, map, true);
                healthText.setText("Health: " + health.getParty());

                // Updates and displays food count
                inventory.removeInventory("Food", 20);
                foodText.setText("Food: " + Integer.toString(inventory.getInventoryValue("Food")));

                // Update and Display the new date
                dateTextChange.setText(time.outputDate());
                time.updateDay(1);
            }
        });

        // When Status Button is Clicked
        statusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Updates Inventory Value
                inventoryFood.setText("Food: " + Integer.toString(inventory.getInventoryValue("Food")));
                inventoryClothes.setText("Clothes: " + Integer.toString(inventory.getInventoryValue("Clothes")));
                inventoryRifle.setText("Rifle: " + Integer.toString(inventory.getInventoryValue("Rifle")));
                inventoryShots.setText("Shots: " + Integer.toString(inventory.getInventoryValue("Shots")));
                inventoryOxen.setText("Oxen: " + Integer.toString(inventory.getInventoryValue("Oxen")));
                inventoryWagonWheels.setText("Wagon Wheels: " + Integer.toString(inventory.getInventoryValue("SpareWagonWheels")));
                inventoryWagonAxels.setText("Wagon Axels: " + Integer.toString(inventory.getInventoryValue("SpareWagonAxel")));
                inventoryWagonTongues.setText("Wagone Tongues: " + Integer.toString(inventory.getInventoryValue("SpareWagonTongues")));
                inventoryMoney.setText("Money: " + Integer.toString(inventory.getInventoryValue("Money")));

                // Makes Inventory Visible
                nextDayButton.setVisibility(View.GONE);
                optionsBackground.setVisibility(View.VISIBLE);
                exitOptionsButton.setVisibility(View.VISIBLE);
                inventoryFood.setVisibility(View.VISIBLE);
                inventoryClothes.setVisibility(View.VISIBLE);
                inventoryRifle.setVisibility(View.VISIBLE);
                inventoryShots.setVisibility(View.VISIBLE);
                inventoryOxen.setVisibility(View.VISIBLE);
                inventoryWagonWheels.setVisibility(View.VISIBLE);
                inventoryWagonAxels.setVisibility(View.VISIBLE);
                inventoryWagonTongues.setVisibility(View.VISIBLE);
                inventoryMoney.setVisibility(View.VISIBLE);
            }
        });

        // When the Rations Button is Clicked
        rationsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nextDayButton.setVisibility(View.GONE);
                optionsBackground.setVisibility(View.VISIBLE);
                fillingRationsButton.setVisibility(View.VISIBLE);
                meagerRationsButton.setVisibility(View.VISIBLE);
                bareBonesRationsButton.setVisibility(View.VISIBLE);
                exitOptionsButton.setVisibility(View.VISIBLE);
            }
        });

        fillingRationsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                health.setRations("Filling");
                rationsText.setText("Rations: Filling");
            }
        });

        meagerRationsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                health.setRations("Meager");
                rationsText.setText("Rations: Meager");
            }
        });

        bareBonesRationsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                health.setRations("Bare Bones");
                rationsText.setText("Rations: Bare Bones");
            }
        });

        // When the Rest Button is Clicked
        restButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Updates and displays changes to weather
                weather.dailyWeather(time);
                weatherConditionText.setText(weather.weatherTypeString());
                weatherTempText.setText(weather.getTempType());

                // Updates and displays changes to party's health
                health.PartyUpdate(weather, inventory, map, true);
                healthText.setText("Health: " + health.HealthString());

                // Updates and displays food count
                inventory.removeInventory("Food", 20);
                foodText.setText("Food: " + Integer.toString(inventory.getInventoryValue("Food")));

                // Update and Display the new date
                dateTextChange.setText(time.outputDate());
                time.updateDay(1);
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

        // When Hunt Button is Clicked
        huntButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nextDayButton.setVisibility(View.GONE);
                optionsBackground.setVisibility(View.VISIBLE);
                huntText.setVisibility(View.VISIBLE);
                huntYesButton.setVisibility(View.VISIBLE);
                exitOptionsButton.setVisibility(View.VISIBLE);
            }
        });

        // Buttons for Hunt Menu

    }


    private void configurehuntYesButton(){

        Button huntYesButton = (Button) findViewById(R.id.huntYesButton);

        final Button nextDayButton = findViewById(R.id.nextDay);
        final ImageView optionsBackground = findViewById(R.id.optionsBackground2);
        final TextView huntText = findViewById(R.id.huntText);
        final Button exitOptionsButton = findViewById(R.id.exitOptionsButton);
        final TextView weatherConditionText = findViewById(R.id.weatherConditionText);
        final TextView weatherTempText = findViewById(R.id.weatherTempText);
        final TextView healthText = findViewById(R.id.healthText);
        final TextView foodText = findViewById(R.id.foodText);
        final TextView dateTextChange = findViewById(R.id.dateTextChange);

        huntYesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, HuntActivity.class));

                nextDayButton.setVisibility(View.VISIBLE);
                optionsBackground.setVisibility(View.GONE);
                huntText.setVisibility(View.GONE);
                huntYesButton.setVisibility(View.GONE);
                exitOptionsButton.setVisibility(View.GONE);

                // Updates and displays changes to weather
                weather.dailyWeather(time);
                weatherConditionText.setText(weather.weatherTypeString());
                weatherTempText.setText(weather.getTempType());

                // Updates and displays changes to party's health
                health.PartyUpdate(weather, inventory, map, true);
                healthText.setText("Health: " + health.HealthString());

                // Updates and displays food count
                inventory.removeInventory("Food", 20);
                foodText.setText("Food: " + Integer.toString(inventory.getInventoryValue("Food")));

                // Update and Display the new date
                dateTextChange.setText(time.outputDate());
                time.updateDay(1);
            }
        });
    }

}