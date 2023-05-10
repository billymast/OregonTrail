package com.example.oregontrail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    // All Objects used in game
    Health health = new Health();
    Individual_Ilness Illness = new Individual_Ilness();
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

    GeneralStore currentStore;

    River currentRiver;

    String modeSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buttons to Take To Other Screens
        configurehuntYesButton();
        configuregoToRiverEventButton();

        // Start of Game Elements
        final ImageView startBackground1 = findViewById(R.id.startBackground1);

        // Phase 1 (Choose Mode)
        final ImageView startTitle = findViewById(R.id.startTitle);
        final ImageView startBackground11 = findViewById(R.id.startBackground11);
        final Button startEasyButton = findViewById(R.id.startEasyButton);
        final Button startNormalButton = findViewById(R.id.startNormalButton);
        final Button startHardButton = findViewById(R.id.startHardButton);

        // Phase 2 (Choose Start Month)
        final TextView chooseMonthText = findViewById(R.id.chooseMonthText);
        final Button januaryButton = findViewById(R.id.januaryButton);
        final Button februaryButton = findViewById(R.id.februaryButton);
        final Button marchButton = findViewById(R.id.marchButton);
        final Button aprilButton = findViewById(R.id.aprilButton);
        final Button mayButton = findViewById(R.id.mayButton);
        final Button juneButton = findViewById(R.id.juneButton);
        final Button julyButton = findViewById(R.id.julyButton);
        final Button augustButton = findViewById(R.id.augustButton);
        final Button septemberButton = findViewById(R.id.septemberButton);
        final Button octoberButton = findViewById(R.id.octoberButton);
        final Button novemberButton = findViewById(R.id.novemberButton);
        final Button decemberButton = findViewById(R.id.decemberButton);

        // Phase 3 (Choose Names of Members)
        final ImageView namingTextImage = findViewById(R.id.namingTextImage);
        final TextView person2Text = findViewById(R.id.person2Text);
        final TextView person3Text = findViewById(R.id.person3Text);
        final TextView person4Text = findViewById(R.id.person4Text);
        final TextView person5Text = findViewById(R.id.person5Text);
        final EditText person2Enter = findViewById(R.id.person2Enter);
        final EditText person3Enter = findViewById(R.id.person3Enter);
        final EditText person4Enter = findViewById(R.id.person4Enter);
        final EditText person5Enter = findViewById(R.id.person5Enter);
        final Button namesContinueButton = findViewById(R.id.namesContinueButton);


        // Elements for Main Game Screen
        final ImageView statsBackground2 = findViewById(R.id.StatsBackground2);
        final ImageView mainScreenImage = findViewById(R.id.mainScreenImage);
        final TextView gamePlayText = findViewById(R.id.gamePlayText);
        final TextView dateTextChange = findViewById(R.id.dateTextChange);
        final TextView weatherText = findViewById(R.id.weatherText);
        final TextView weatherTempText = findViewById(R.id.weatherTempText);
        final TextView distanceText = findViewById(R.id.distanceText);
        final TextView weatherConditionText = findViewById(R.id.weatherConditionText);
        final TextView distanceLandmarkText = findViewById(R.id.distanceLandmarkText);
        final TextView distanceTraveledText = findViewById(R.id.distanceTraveledText);
        final TextView paceText = findViewById(R.id.paceText);
        final TextView rationsText = findViewById(R.id.rationsText);
        final TextView healthText = findViewById(R.id.healthText);
        final TextView foodText = findViewById(R.id.foodText);
        final Button nextDayButton = findViewById(R.id.nextDay);
        final TextView locationText = findViewById(R.id.locationText);
        final TextView dataText = findViewById(R.id.dateText);
        final TextView wagonText = findViewById(R.id.wagonText);

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
        final Button goToRiverEventButton = findViewById(R.id.goToRiverEventButton);

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

        // Start of Game Elements

        // Phase 1 (Chooses Difficulty)

        startEasyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                modeSelected = "Easy";
                inventory.addInventory("Money", 2000);
                startTitle.setVisibility(View.GONE);
                startBackground11.setVisibility(View.GONE);
                startEasyButton.setVisibility(View.GONE);
                startNormalButton.setVisibility(View.GONE);
                startHardButton.setVisibility(View.GONE);
                chooseMonthText.setVisibility(View.VISIBLE);
                januaryButton.setVisibility(View.VISIBLE);
                februaryButton.setVisibility(View.VISIBLE);
                marchButton.setVisibility(View.VISIBLE);
                aprilButton.setVisibility(View.VISIBLE);
                mayButton.setVisibility(View.VISIBLE);
                juneButton.setVisibility(View.VISIBLE);
                julyButton.setVisibility(View.VISIBLE);
                augustButton.setVisibility(View.VISIBLE);
                septemberButton.setVisibility(View.VISIBLE);
                octoberButton.setVisibility(View.VISIBLE);
                novemberButton.setVisibility(View.VISIBLE);
                decemberButton.setVisibility(View.VISIBLE);
            }
        });
        startNormalButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                modeSelected = "Normal";
                inventory.addInventory("Money", 1500);
                startTitle.setVisibility(View.GONE);
                startBackground11.setVisibility(View.GONE);
                startEasyButton.setVisibility(View.GONE);
                startNormalButton.setVisibility(View.GONE);
                startHardButton.setVisibility(View.GONE);
                chooseMonthText.setVisibility(View.VISIBLE);
                januaryButton.setVisibility(View.VISIBLE);
                februaryButton.setVisibility(View.VISIBLE);
                marchButton.setVisibility(View.VISIBLE);
                aprilButton.setVisibility(View.VISIBLE);
                mayButton.setVisibility(View.VISIBLE);
                juneButton.setVisibility(View.VISIBLE);
                julyButton.setVisibility(View.VISIBLE);
                augustButton.setVisibility(View.VISIBLE);
                septemberButton.setVisibility(View.VISIBLE);
                octoberButton.setVisibility(View.VISIBLE);
                novemberButton.setVisibility(View.VISIBLE);
                decemberButton.setVisibility(View.VISIBLE);
            }
        });
        startHardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                modeSelected = "Hard";
                inventory.addInventory("Money", 1000);
                startTitle.setVisibility(View.GONE);
                startBackground11.setVisibility(View.GONE);
                startEasyButton.setVisibility(View.GONE);
                startNormalButton.setVisibility(View.GONE);
                startHardButton.setVisibility(View.GONE);
                chooseMonthText.setVisibility(View.VISIBLE);
                januaryButton.setVisibility(View.VISIBLE);
                februaryButton.setVisibility(View.VISIBLE);
                marchButton.setVisibility(View.VISIBLE);
                aprilButton.setVisibility(View.VISIBLE);
                mayButton.setVisibility(View.VISIBLE);
                juneButton.setVisibility(View.VISIBLE);
                julyButton.setVisibility(View.VISIBLE);
                augustButton.setVisibility(View.VISIBLE);
                septemberButton.setVisibility(View.VISIBLE);
                octoberButton.setVisibility(View.VISIBLE);
                novemberButton.setVisibility(View.VISIBLE);
                decemberButton.setVisibility(View.VISIBLE);
            }
        });

        // Phase 2 (Chooses Start Month)

        januaryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                time.setMonth(1);
                dateTextChange.setText(time.outputDate());

                // Phase 2 Disappears
                chooseMonthText.setVisibility(View.GONE);
                januaryButton.setVisibility(View.GONE);
                februaryButton.setVisibility(View.GONE);
                marchButton.setVisibility(View.GONE);
                aprilButton.setVisibility(View.GONE);
                mayButton.setVisibility(View.GONE);
                juneButton.setVisibility(View.GONE);
                julyButton.setVisibility(View.GONE);
                augustButton.setVisibility(View.GONE);
                septemberButton.setVisibility(View.GONE);
                octoberButton.setVisibility(View.GONE);
                novemberButton.setVisibility(View.GONE);
                decemberButton.setVisibility(View.GONE);

                // Phase 3 Appears
                namingTextImage.setVisibility(View.VISIBLE);
                person2Text.setVisibility(View.VISIBLE);
                person3Text.setVisibility(View.VISIBLE);
                person4Text.setVisibility(View.VISIBLE);
                person5Text.setVisibility(View.VISIBLE);
                person2Enter.setVisibility(View.VISIBLE);
                person3Enter.setVisibility(View.VISIBLE);
                person4Enter.setVisibility(View.VISIBLE);
                person5Enter.setVisibility(View.VISIBLE);
                namesContinueButton.setVisibility(View.VISIBLE);

            }
        });
        februaryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                time.setMonth(2);
                dateTextChange.setText(time.outputDate());

                // Phase 2 Disappears
                chooseMonthText.setVisibility(View.GONE);
                januaryButton.setVisibility(View.GONE);
                februaryButton.setVisibility(View.GONE);
                marchButton.setVisibility(View.GONE);
                aprilButton.setVisibility(View.GONE);
                mayButton.setVisibility(View.GONE);
                juneButton.setVisibility(View.GONE);
                julyButton.setVisibility(View.GONE);
                augustButton.setVisibility(View.GONE);
                septemberButton.setVisibility(View.GONE);
                octoberButton.setVisibility(View.GONE);
                novemberButton.setVisibility(View.GONE);
                decemberButton.setVisibility(View.GONE);

                // Phase 3 Appears
                namingTextImage.setVisibility(View.VISIBLE);
                person2Text.setVisibility(View.VISIBLE);
                person3Text.setVisibility(View.VISIBLE);
                person4Text.setVisibility(View.VISIBLE);
                person5Text.setVisibility(View.VISIBLE);
                person2Enter.setVisibility(View.VISIBLE);
                person3Enter.setVisibility(View.VISIBLE);
                person4Enter.setVisibility(View.VISIBLE);
                person5Enter.setVisibility(View.VISIBLE);
                namesContinueButton.setVisibility(View.VISIBLE);
            }
        });
        marchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                time.setMonth(3);
                dateTextChange.setText(time.outputDate());

                // Phase 2 Disappears
                chooseMonthText.setVisibility(View.GONE);
                januaryButton.setVisibility(View.GONE);
                februaryButton.setVisibility(View.GONE);
                marchButton.setVisibility(View.GONE);
                aprilButton.setVisibility(View.GONE);
                mayButton.setVisibility(View.GONE);
                juneButton.setVisibility(View.GONE);
                julyButton.setVisibility(View.GONE);
                augustButton.setVisibility(View.GONE);
                septemberButton.setVisibility(View.GONE);
                octoberButton.setVisibility(View.GONE);
                novemberButton.setVisibility(View.GONE);
                decemberButton.setVisibility(View.GONE);

                // Phase 3 Appears
                namingTextImage.setVisibility(View.VISIBLE);
                person2Text.setVisibility(View.VISIBLE);
                person3Text.setVisibility(View.VISIBLE);
                person4Text.setVisibility(View.VISIBLE);
                person5Text.setVisibility(View.VISIBLE);
                person2Enter.setVisibility(View.VISIBLE);
                person3Enter.setVisibility(View.VISIBLE);
                person4Enter.setVisibility(View.VISIBLE);
                person5Enter.setVisibility(View.VISIBLE);
                namesContinueButton.setVisibility(View.VISIBLE);
            }
        });
        aprilButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                time.setMonth(4);
                dateTextChange.setText(time.outputDate());

                // Phase 2 Disappears
                chooseMonthText.setVisibility(View.GONE);
                januaryButton.setVisibility(View.GONE);
                februaryButton.setVisibility(View.GONE);
                marchButton.setVisibility(View.GONE);
                aprilButton.setVisibility(View.GONE);
                mayButton.setVisibility(View.GONE);
                juneButton.setVisibility(View.GONE);
                julyButton.setVisibility(View.GONE);
                augustButton.setVisibility(View.GONE);
                septemberButton.setVisibility(View.GONE);
                octoberButton.setVisibility(View.GONE);
                novemberButton.setVisibility(View.GONE);
                decemberButton.setVisibility(View.GONE);

                // Phase 3 Appears
                namingTextImage.setVisibility(View.VISIBLE);
                person2Text.setVisibility(View.VISIBLE);
                person3Text.setVisibility(View.VISIBLE);
                person4Text.setVisibility(View.VISIBLE);
                person5Text.setVisibility(View.VISIBLE);
                person2Enter.setVisibility(View.VISIBLE);
                person3Enter.setVisibility(View.VISIBLE);
                person4Enter.setVisibility(View.VISIBLE);
                person5Enter.setVisibility(View.VISIBLE);
                namesContinueButton.setVisibility(View.VISIBLE);
            }
        });
        mayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                time.setMonth(5);
                dateTextChange.setText(time.outputDate());

                // Phase 2 Disappears
                chooseMonthText.setVisibility(View.GONE);
                januaryButton.setVisibility(View.GONE);
                februaryButton.setVisibility(View.GONE);
                marchButton.setVisibility(View.GONE);
                aprilButton.setVisibility(View.GONE);
                mayButton.setVisibility(View.GONE);
                juneButton.setVisibility(View.GONE);
                julyButton.setVisibility(View.GONE);
                augustButton.setVisibility(View.GONE);
                septemberButton.setVisibility(View.GONE);
                octoberButton.setVisibility(View.GONE);
                novemberButton.setVisibility(View.GONE);
                decemberButton.setVisibility(View.GONE);

                // Phase 3 Appears
                namingTextImage.setVisibility(View.VISIBLE);
                person2Text.setVisibility(View.VISIBLE);
                person3Text.setVisibility(View.VISIBLE);
                person4Text.setVisibility(View.VISIBLE);
                person5Text.setVisibility(View.VISIBLE);
                person2Enter.setVisibility(View.VISIBLE);
                person3Enter.setVisibility(View.VISIBLE);
                person4Enter.setVisibility(View.VISIBLE);
                person5Enter.setVisibility(View.VISIBLE);
                namesContinueButton.setVisibility(View.VISIBLE);
            }
        });
        juneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                time.setMonth(6);
                dateTextChange.setText(time.outputDate());

                // Phase 2 Disappears
                chooseMonthText.setVisibility(View.GONE);
                januaryButton.setVisibility(View.GONE);
                februaryButton.setVisibility(View.GONE);
                marchButton.setVisibility(View.GONE);
                aprilButton.setVisibility(View.GONE);
                mayButton.setVisibility(View.GONE);
                juneButton.setVisibility(View.GONE);
                julyButton.setVisibility(View.GONE);
                augustButton.setVisibility(View.GONE);
                septemberButton.setVisibility(View.GONE);
                octoberButton.setVisibility(View.GONE);
                novemberButton.setVisibility(View.GONE);
                decemberButton.setVisibility(View.GONE);

                // Phase 3 Appears
                namingTextImage.setVisibility(View.VISIBLE);
                person2Text.setVisibility(View.VISIBLE);
                person3Text.setVisibility(View.VISIBLE);
                person4Text.setVisibility(View.VISIBLE);
                person5Text.setVisibility(View.VISIBLE);
                person2Enter.setVisibility(View.VISIBLE);
                person3Enter.setVisibility(View.VISIBLE);
                person4Enter.setVisibility(View.VISIBLE);
                person5Enter.setVisibility(View.VISIBLE);
                namesContinueButton.setVisibility(View.VISIBLE);
            }
        });
        julyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                time.setMonth(7);
                dateTextChange.setText(time.outputDate());

                // Phase 2 Disappears
                chooseMonthText.setVisibility(View.GONE);
                januaryButton.setVisibility(View.GONE);
                februaryButton.setVisibility(View.GONE);
                marchButton.setVisibility(View.GONE);
                aprilButton.setVisibility(View.GONE);
                mayButton.setVisibility(View.GONE);
                juneButton.setVisibility(View.GONE);
                julyButton.setVisibility(View.GONE);
                augustButton.setVisibility(View.GONE);
                septemberButton.setVisibility(View.GONE);
                octoberButton.setVisibility(View.GONE);
                novemberButton.setVisibility(View.GONE);
                decemberButton.setVisibility(View.GONE);

                // Phase 3 Appears
                namingTextImage.setVisibility(View.VISIBLE);
                person2Text.setVisibility(View.VISIBLE);
                person3Text.setVisibility(View.VISIBLE);
                person4Text.setVisibility(View.VISIBLE);
                person5Text.setVisibility(View.VISIBLE);
                person2Enter.setVisibility(View.VISIBLE);
                person3Enter.setVisibility(View.VISIBLE);
                person4Enter.setVisibility(View.VISIBLE);
                person5Enter.setVisibility(View.VISIBLE);
                namesContinueButton.setVisibility(View.VISIBLE);
            }
        });
        augustButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                time.setMonth(8);
                dateTextChange.setText(time.outputDate());

                // Phase 2 Disappears
                chooseMonthText.setVisibility(View.GONE);
                januaryButton.setVisibility(View.GONE);
                februaryButton.setVisibility(View.GONE);
                marchButton.setVisibility(View.GONE);
                aprilButton.setVisibility(View.GONE);
                mayButton.setVisibility(View.GONE);
                juneButton.setVisibility(View.GONE);
                julyButton.setVisibility(View.GONE);
                augustButton.setVisibility(View.GONE);
                septemberButton.setVisibility(View.GONE);
                octoberButton.setVisibility(View.GONE);
                novemberButton.setVisibility(View.GONE);
                decemberButton.setVisibility(View.GONE);

                // Phase 3 Appears
                namingTextImage.setVisibility(View.VISIBLE);
                person2Text.setVisibility(View.VISIBLE);
                person3Text.setVisibility(View.VISIBLE);
                person4Text.setVisibility(View.VISIBLE);
                person5Text.setVisibility(View.VISIBLE);
                person2Enter.setVisibility(View.VISIBLE);
                person3Enter.setVisibility(View.VISIBLE);
                person4Enter.setVisibility(View.VISIBLE);
                person5Enter.setVisibility(View.VISIBLE);
                namesContinueButton.setVisibility(View.VISIBLE);
            }
        });
        septemberButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                time.setMonth(9);
                dateTextChange.setText(time.outputDate());

                // Phase 2 Disappears
                chooseMonthText.setVisibility(View.GONE);
                januaryButton.setVisibility(View.GONE);
                februaryButton.setVisibility(View.GONE);
                marchButton.setVisibility(View.GONE);
                aprilButton.setVisibility(View.GONE);
                mayButton.setVisibility(View.GONE);
                juneButton.setVisibility(View.GONE);
                julyButton.setVisibility(View.GONE);
                augustButton.setVisibility(View.GONE);
                septemberButton.setVisibility(View.GONE);
                octoberButton.setVisibility(View.GONE);
                novemberButton.setVisibility(View.GONE);
                decemberButton.setVisibility(View.GONE);

                // Phase 3 Appears
                namingTextImage.setVisibility(View.VISIBLE);
                person2Text.setVisibility(View.VISIBLE);
                person3Text.setVisibility(View.VISIBLE);
                person4Text.setVisibility(View.VISIBLE);
                person5Text.setVisibility(View.VISIBLE);
                person2Enter.setVisibility(View.VISIBLE);
                person3Enter.setVisibility(View.VISIBLE);
                person4Enter.setVisibility(View.VISIBLE);
                person5Enter.setVisibility(View.VISIBLE);
                namesContinueButton.setVisibility(View.VISIBLE);
            }
        });
        octoberButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                time.setMonth(10);
                dateTextChange.setText(time.outputDate());

                // Phase 2 Disappears
                chooseMonthText.setVisibility(View.GONE);
                januaryButton.setVisibility(View.GONE);
                februaryButton.setVisibility(View.GONE);
                marchButton.setVisibility(View.GONE);
                aprilButton.setVisibility(View.GONE);
                mayButton.setVisibility(View.GONE);
                juneButton.setVisibility(View.GONE);
                julyButton.setVisibility(View.GONE);
                augustButton.setVisibility(View.GONE);
                septemberButton.setVisibility(View.GONE);
                octoberButton.setVisibility(View.GONE);
                novemberButton.setVisibility(View.GONE);
                decemberButton.setVisibility(View.GONE);

                // Phase 3 Appears
                namingTextImage.setVisibility(View.VISIBLE);
                person2Text.setVisibility(View.VISIBLE);
                person3Text.setVisibility(View.VISIBLE);
                person4Text.setVisibility(View.VISIBLE);
                person5Text.setVisibility(View.VISIBLE);
                person2Enter.setVisibility(View.VISIBLE);
                person3Enter.setVisibility(View.VISIBLE);
                person4Enter.setVisibility(View.VISIBLE);
                person5Enter.setVisibility(View.VISIBLE);
                namesContinueButton.setVisibility(View.VISIBLE);
            }
        });
        novemberButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                time.setMonth(11);
                dateTextChange.setText(time.outputDate());

                // Phase 2 Disappears
                chooseMonthText.setVisibility(View.GONE);
                januaryButton.setVisibility(View.GONE);
                februaryButton.setVisibility(View.GONE);
                marchButton.setVisibility(View.GONE);
                aprilButton.setVisibility(View.GONE);
                mayButton.setVisibility(View.GONE);
                juneButton.setVisibility(View.GONE);
                julyButton.setVisibility(View.GONE);
                augustButton.setVisibility(View.GONE);
                septemberButton.setVisibility(View.GONE);
                octoberButton.setVisibility(View.GONE);
                novemberButton.setVisibility(View.GONE);
                decemberButton.setVisibility(View.GONE);

                // Phase 3 Appears
                namingTextImage.setVisibility(View.VISIBLE);
                person2Text.setVisibility(View.VISIBLE);
                person3Text.setVisibility(View.VISIBLE);
                person4Text.setVisibility(View.VISIBLE);
                person5Text.setVisibility(View.VISIBLE);
                person2Enter.setVisibility(View.VISIBLE);
                person3Enter.setVisibility(View.VISIBLE);
                person4Enter.setVisibility(View.VISIBLE);
                person5Enter.setVisibility(View.VISIBLE);
                namesContinueButton.setVisibility(View.VISIBLE);
            }
        });
        decemberButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                time.setMonth(12);
                dateTextChange.setText(time.outputDate());

                // Phase 2 Disappears
                chooseMonthText.setVisibility(View.GONE);
                januaryButton.setVisibility(View.GONE);
                februaryButton.setVisibility(View.GONE);
                marchButton.setVisibility(View.GONE);
                aprilButton.setVisibility(View.GONE);
                mayButton.setVisibility(View.GONE);
                juneButton.setVisibility(View.GONE);
                julyButton.setVisibility(View.GONE);
                augustButton.setVisibility(View.GONE);
                septemberButton.setVisibility(View.GONE);
                octoberButton.setVisibility(View.GONE);
                novemberButton.setVisibility(View.GONE);
                decemberButton.setVisibility(View.GONE);

                // Phase 3 Appears
                namingTextImage.setVisibility(View.VISIBLE);
                person2Text.setVisibility(View.VISIBLE);
                person3Text.setVisibility(View.VISIBLE);
                person4Text.setVisibility(View.VISIBLE);
                person5Text.setVisibility(View.VISIBLE);
                person2Enter.setVisibility(View.VISIBLE);
                person3Enter.setVisibility(View.VISIBLE);
                person4Enter.setVisibility(View.VISIBLE);
                person5Enter.setVisibility(View.VISIBLE);
                namesContinueButton.setVisibility(View.VISIBLE);
            }
        });

        // Phase 3 (Chooses Names of Members)
        namesContinueButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String autoNameUsed = "(Names were given to family members who were not given a name).";
                boolean isAutoNameUsed = false;

                String name2 = person2Enter.getText().toString();
                if (name2.equals("") || name2.equals("Enter Name")) {
                    name2 = "Jeff";
                    isAutoNameUsed = true;
                }
                String name3 = person3Enter.getText().toString();
                if (name3.equals("") || name3.equals("Enter Name")) {
                    name3 = "Forest";
                    isAutoNameUsed = true;
                }
                String name4 = person4Enter.getText().toString();
                if (name4.equals("") || name4.equals("Enter Name")) {
                    name4 = "Jenny";
                    isAutoNameUsed = true;
                }
                String name5 = person5Enter.getText().toString();
                if (name5.equals("") || name5.equals("Enter Name")) {
                    name5 = "Sally";
                    isAutoNameUsed = true;
                }

                // Sets all names in the health class
                Illness.setName2(name2);
                Illness.setName3(name3);
                Illness.setName4(name4);
                Illness.setName5(name5);

                String beginningText;

                if (isAutoNameUsed) {
                    beginningText = "Hattie Campbell and her family, " + name2 + ", " + name3 + ", " + name4 + ", and " + name5 + ", are ready to set off on the Oregon Trail " + autoNameUsed + " Make sure to stock up on supplies at Matt's Store by hitting the Buy Button to stock up before setting off on your adventure. You will only be able to access the store when at Forts along the trail.";
                }
                else {
                    beginningText = "Hattie Campbell and her family, " + name2 + ", " + name3 + ", " + name4 + ", and " + name5 + ", are ready to set off on the Oregon Trail. Make sure to stock up on supplies at Matt's Store by hitting the Buy Button to stock up before setting off on your adventure. You will only be able to access the store when at Forts along the trail.";
                }

                gamePlayText.setText(beginningText);

                // Phase 3 Disappears
                startBackground1.setVisibility(View.GONE);
                namingTextImage.setVisibility(View.GONE);
                person2Text.setVisibility(View.GONE);
                person3Text.setVisibility(View.GONE);
                person4Text.setVisibility(View.GONE);
                person5Text.setVisibility(View.GONE);
                person2Enter.setVisibility(View.GONE);
                person3Enter.setVisibility(View.GONE);
                person4Enter.setVisibility(View.GONE);
                person5Enter.setVisibility(View.GONE);
                namesContinueButton.setVisibility(View.GONE);

                // Continues to Main Screen
                statsBackground2.setVisibility(View.VISIBLE);
                mainScreenImage.setVisibility(View.VISIBLE);
                gamePlayText.setVisibility(View.VISIBLE);
                dateTextChange.setVisibility(View.VISIBLE);
                weatherText.setVisibility(View.VISIBLE);
                weatherTempText.setVisibility(View.VISIBLE);
                distanceText.setVisibility(View.VISIBLE);
                weatherConditionText.setVisibility(View.VISIBLE);
                distanceLandmarkText.setVisibility(View.VISIBLE);
                distanceTraveledText.setVisibility(View.VISIBLE);
                paceText.setVisibility(View.VISIBLE);
                rationsText.setVisibility(View.VISIBLE);
                healthText.setVisibility(View.VISIBLE);
                foodText.setVisibility(View.VISIBLE);
                nextDayButton.setVisibility(View.VISIBLE);
                locationText.setVisibility(View.VISIBLE);
                dataText.setVisibility(View.VISIBLE);
                wagonText.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
                mapButton.setVisibility(View.VISIBLE);
                statusButton.setVisibility(View.VISIBLE);
                rationsButton.setVisibility(View.VISIBLE);
                buyButton.setVisibility(View.VISIBLE);
                tradeButton.setVisibility(View.VISIBLE);
                talkButton.setVisibility(View.VISIBLE);
                restButton.setVisibility(View.VISIBLE);
                paceButton.setVisibility(View.VISIBLE);
                huntButton.setVisibility(View.VISIBLE);
            }
        });


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

                String dailyOutput = time.outputDate() + "\n";

                // Updates and displays changes to weather
                weather.dailyWeather(time, map);
                weatherConditionText.setText(weather.weatherTypeString());

                // Makes Temp Type start with Uppercase letter
                String weatherText1 = weather.getTempType();
                String weatherText2 = weatherText1.substring(0,1).toUpperCase();

                weatherTempText.setText(weatherText2 + weatherText1.substring(1));

                // Updates and displays changes to party's health
                String dailyIllnessOutput = Illness.OutputIndividualIllness(health, inventory);
                if (!dailyIllnessOutput.equals(" ")) {
                    dailyOutput = dailyOutput + dailyIllnessOutput + "\n";
                }
                health.PartyUpdate(weather, inventory, map, false);
                healthText.setText("Health: " + health.HealthString());

                // Updates and displays location
                if(map.updateLocation(map.getPace())){
                    locationText.setText(map.getCurrentLandmark());
                }
                else {
                    locationText.setText("On the Trail");
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
                    String randomEventText = randomEvent.Event(inventory, weather, time, mainScreenImage);
                    if (!randomEventText.equals("")) {
                        dailyOutput = dailyOutput + randomEventText + ".\n";
                    }
                }

                // Displays Text explaining what happened during the day
                if(dailyOutput.equals(time.outputDate() + "\n")) {
                    dailyOutput = time.outputDate() + "\nAnother long, boring day on the trail.";
                }
                gamePlayText.setText(dailyOutput);

                // Update and Display the new date
                dateTextChange.setText(time.outputDate());
                time.updateDay(1);

                if (map.isRiver()) {
                    goToRiverEventButton.setVisibility(View.VISIBLE);
                    nextDayButton.setVisibility(View.GONE);
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

                exitOptionsButton.performClick();

                if (map.isFort() || map.getCurrentLandmark().equals("Matt's Store")) {

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
                    String foodPrice = String.format("%.2f", currentStore.getPrice(0));
                    storeFoodText.setText("Food  /  $" + foodPrice);
                    String clothesPrice = String.format("%.2f", currentStore.getPrice(1));
                    storeClothesText.setText("Clothes  /  $" + clothesPrice);
                    String riflePrice = String.format("%.2f", currentStore.getPrice(2));
                    storeRifleText.setText("Rifle  /  $" + riflePrice);
                    String shotsPrice = String.format("%.2f", currentStore.getPrice(4));
                    storeShotsText.setText("Shots  /  $" + shotsPrice);
                    String wheelsPrice = String.format("%.2f", currentStore.getPrice(6));
                    storeWheelsText.setText("Wheels  /  $" + wheelsPrice);
                    String axlesPrice = String.format("%.2f", currentStore.getPrice(7));
                    storeAxlesText.setText("Axles  /  $" + axlesPrice);
                    String tonguesPrice = String.format("%.2f", currentStore.getPrice(8));
                    storeTonguesText.setText("Tongues  /  $" + tonguesPrice);
                    String oxenPrice = String.format("%.2f", currentStore.getPrice(5));
                    storeOxenText.setText("Oxen  /  $" + oxenPrice);
                    storeYourFood.setText(inventory.getInventoryValue("Food") + "   /   None");
                    storeYourClothes.setText(inventory.getInventoryValue("Clothes") + "   /   None");
                    storeYourRifle.setText(inventory.getInventoryValue("Rifle") + "   /   1");
                    storeYourShots.setText(inventory.getInventoryValue("Shots") + "   /   None");
                    storeYourWheels.setText(inventory.getInventoryValue("SpareWagonWheels") + "   /   3");
                    storeYourAxles.setText(inventory.getInventoryValue("SpareWagonAxel")  + "   /   3");
                    storeYourTongues.setText(inventory.getInventoryValue("SpareWagonTongues") + "   /   3");
                    storeYourOxen.setText(inventory.getInventoryValue("Oxen") + "   /   16");

                    String moneyAmount = String.format("%.2f", inventory.moneyAmount());
                    storeYourMoney.setText("Your Money: $" + moneyAmount);

                }
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

                String moneyAmount = String.format("%.2f", inventory.moneyAmount());
                storeYourMoney.setText("Your Money: $" + moneyAmount);

                storeTotalCost.setText("Total Cost: $0.00");
            }
        });

        // General Store Decrement Buttons

        storeDecrementFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.removeItemQuantity(0,25);
                storeFoodAmount.setText(String.valueOf(currentStore.getQuantity(0)));

                String currentCost = String.format("%.2f", currentStore.getQuantity(0) * currentStore.getPrice(0));
                storeFoodCost.setText("$" + currentCost);

                String totalCost = String.format("%.2f",currentStore.getTotal());
                storeTotalCost.setText("Total Cost: $" + totalCost);
            }
        });
        storeDecrementClothes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.removeItemQuantity(1,1);
                storeClothesAmount.setText(String.valueOf(currentStore.getQuantity(1)));

                String currentCost = String.format("%.2f", currentStore.getQuantity(1) * currentStore.getPrice(1));
                storeClothesCost.setText("$" + currentCost);

                String totalCost = String.format("%.2f",currentStore.getTotal());
                storeTotalCost.setText("Total Cost: $" + totalCost);
            }
        });
        storeDecrementRifle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.removeItemQuantity(2,1);
                storeRifleAmount.setText(String.valueOf(currentStore.getQuantity(2)));

                String currentCost = String.format("%.2f", currentStore.getQuantity(2) * currentStore.getPrice(2));
                storeRifleCost.setText("$" + currentCost);

                String totalCost = String.format("%.2f",currentStore.getTotal());
                storeTotalCost.setText("Total Cost: $" + totalCost);
            }
        });
        storeDecrementShots.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.removeItemQuantity(4,5);
                storeShotsAmount.setText(String.valueOf(currentStore.getQuantity(4)));

                String currentCost = String.format("%.2f", currentStore.getQuantity(4) * currentStore.getPrice(4));
                storeShotsCost.setText("$" + currentCost);

                String totalCost = String.format("%.2f",currentStore.getTotal());
                storeTotalCost.setText("Total Cost: $" + totalCost);            }
        });
        storeDecrementWheels.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.removeItemQuantity(6,1);
                storeWheelsAmount.setText(String.valueOf(currentStore.getQuantity(6)));

                String currentCost = String.format("%.2f", currentStore.getQuantity(6) * currentStore.getPrice(6));
                storeWheelsCost.setText("$" + currentCost);

                String totalCost = String.format("%.2f",currentStore.getTotal());
                storeTotalCost.setText("Total Cost: $" + totalCost);            }
        });
        storeDecrementAxles.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.removeItemQuantity(7,1);
                storeAxlesAmount.setText(String.valueOf(currentStore.getQuantity(7)));

                String currentCost = String.format("%.2f", currentStore.getQuantity(7) * currentStore.getPrice(7));
                storeAxlesCost.setText("$" + currentCost);

                String totalCost = String.format("%.2f",currentStore.getTotal());
                storeTotalCost.setText("Total Cost: $" + totalCost);            }
        });
        storeDecrementTongues.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.removeItemQuantity(8,1);
                storeTonguesAmount.setText(String.valueOf(currentStore.getQuantity(8)));

                String currentCost = String.format("%.2f", currentStore.getQuantity(8) * currentStore.getPrice(8));
                storeTonguesCost.setText("$" + currentCost);

                String totalCost = String.format("%.2f",currentStore.getTotal());
                storeTotalCost.setText("Total Cost: $" + totalCost);            }
        });
        storeDecrementOxen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.removeItemQuantity(5,2);
                storeOxenAmount.setText(String.valueOf(currentStore.getQuantity(5)));

                String currentCost = String.format("%.2f", currentStore.getQuantity(5) * currentStore.getPrice(5));
                storeOxenCost.setText("$" + currentCost);

                String totalCost = String.format("%.2f",currentStore.getTotal());
                storeTotalCost.setText("Total Cost: $" + totalCost);            }
        });

        // General Store Increment Buttons

        storeIncrementFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.addItem(0,25);
                storeFoodAmount.setText(String.valueOf(currentStore.getQuantity(0)));

                String currentCost = String.format("%.2f", currentStore.getQuantity(0) * currentStore.getPrice(0));
                storeFoodCost.setText("$" + currentCost);

                String totalCost = String.format("%.2f",currentStore.getTotal());
                storeTotalCost.setText("Total Cost: $" + totalCost);            }
        });
        storeIncrementClothes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.addItem(1,1);
                storeClothesAmount.setText(String.valueOf(currentStore.getQuantity(1)));

                String currentCost = String.format("%.2f", currentStore.getQuantity(1) * currentStore.getPrice(1));
                storeClothesCost.setText("$" + currentCost);

                String totalCost = String.format("%.2f",currentStore.getTotal());
                storeTotalCost.setText("Total Cost: $" + totalCost);            }
        });
        storeIncrementRifle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.addItem(2,1);
                storeRifleAmount.setText(String.valueOf(currentStore.getQuantity(2)));

                String currentCost = String.format("%.2f", currentStore.getQuantity(2) * currentStore.getPrice(2));
                storeRifleCost.setText("$" + currentCost);

                String totalCost = String.format("%.2f",currentStore.getTotal());
                storeTotalCost.setText("Total Cost: $" + totalCost);            }
        });
        storeIncrementShots.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.addItem(4,5);
                storeShotsAmount.setText(String.valueOf(currentStore.getQuantity(4)));

                String currentCost = String.format("%.2f", currentStore.getQuantity(4) * currentStore.getPrice(4));
                storeShotsCost.setText("$" + currentCost);

                String totalCost = String.format("%.2f",currentStore.getTotal());
                storeTotalCost.setText("Total Cost: $" + totalCost);            }
        });
        storeIncrementWheels.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.addItem(6,1);
                storeWheelsAmount.setText(String.valueOf(currentStore.getQuantity(6)));

                String currentCost = String.format("%.2f", currentStore.getQuantity(6) * currentStore.getPrice(6));
                storeWheelsCost.setText("$" + currentCost);

                String totalCost = String.format("%.2f",currentStore.getTotal());
                storeTotalCost.setText("Total Cost: $" + totalCost);            }
        });
        storeIncrementAxles.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.addItem(7,1);
                storeAxlesAmount.setText(String.valueOf(currentStore.getQuantity(7)));

                String currentCost = String.format("%.2f", currentStore.getQuantity(7) * currentStore.getPrice(7));
                storeAxlesCost.setText("$" + currentCost);

                String totalCost = String.format("%.2f",currentStore.getTotal());
                storeTotalCost.setText("Total Cost: $" + totalCost);            }
        });
        storeIncrementTongues.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.addItem(8,1);
                storeTonguesAmount.setText(String.valueOf(currentStore.getQuantity(8)));

                String currentCost = String.format("%.2f", currentStore.getQuantity(8) * currentStore.getPrice(8));
                storeTonguesCost.setText("$" + currentCost);

                String totalCost = String.format("%.2f",currentStore.getTotal());
                storeTotalCost.setText("Total Cost: $" + totalCost);            }
        });
        storeIncrementOxen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentStore.addItem(5,2);
                storeOxenAmount.setText(String.valueOf(currentStore.getQuantity(5)));

                String currentCost = String.format("%.2f", currentStore.getQuantity(5) * currentStore.getPrice(5));
                storeOxenCost.setText("$" + currentCost);

                String totalCost = String.format("%.2f",currentStore.getTotal());
                storeTotalCost.setText("Total Cost: $" + totalCost);            }
        });

        // When Status Button is Clicked
        statusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                exitOptionsButton.performClick();

                // Updates Inventory Value
                inventoryFood.setText("Food: " + Integer.toString(inventory.getInventoryValue("Food")));
                inventoryClothes.setText("Clothes: " + Integer.toString(inventory.getInventoryValue("Clothes")));
                inventoryRifle.setText("Rifle: " + Integer.toString(inventory.getInventoryValue("Rifle")));
                inventoryShots.setText("Shots: " + Integer.toString(inventory.getInventoryValue("Shots")));
                inventoryOxen.setText("Oxen: " + Integer.toString(inventory.getInventoryValue("Oxen")));
                inventoryWagonWheels.setText("Wagon Wheels: " + Integer.toString(inventory.getInventoryValue("SpareWagonWheels")));
                inventoryWagonAxels.setText("Wagon Axles: " + Integer.toString(inventory.getInventoryValue("SpareWagonAxel")));
                inventoryWagonTongues.setText("Wagon Tongues: " + Integer.toString(inventory.getInventoryValue("SpareWagonTongues")));
                inventoryMoney.setText("Money: " + inventory.moneyAmount());

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

                exitOptionsButton.performClick();

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

                exitOptionsButton.performClick();

                // Updates and displays changes to weather
                weather.dailyWeather(time, map);
                weatherConditionText.setText(weather.weatherTypeString());

                // Makes Temp Type start with Uppercase letter
                String weatherText1 = weather.getTempType();
                String weatherText2 = weatherText1.substring(0,1).toUpperCase();

                weatherTempText.setText(weatherText2 + weatherText1.substring(1));

                // Updates and displays changes to party's health
                health.PartyUpdate(weather, inventory, map, true);
                healthText.setText("Health: " + health.HealthString());

                // Updates and displays food count
                inventory.removeInventory("Food", 20);
                foodText.setText("Food: " + Integer.toString(inventory.getInventoryValue("Food")));

                // Daily Output
                String dailyOutput = time.outputDate() + "\nSpent the day lying around.";
                gamePlayText.setText(dailyOutput);

                // Update and Display the new date
                dateTextChange.setText(time.outputDate());
                time.updateDay(1);
            }
        });

        // When the Pace button is clicked
        paceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                exitOptionsButton.performClick();

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

                exitOptionsButton.performClick();

                nextDayButton.setVisibility(View.GONE);
                optionsBackground.setVisibility(View.VISIBLE);
                huntText.setVisibility(View.VISIBLE);
                huntYesButton.setVisibility(View.VISIBLE);
                exitOptionsButton.setVisibility(View.VISIBLE);
            }
        });

        // Buttons for Hunt Menu

    }


    private void configurehuntYesButton() {

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

        huntYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int shotValue = 0;
                shotValue = inventory.getInventoryValue("Shots");

                Intent intent = new Intent(MainActivity.this, HuntActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("shot", shotValue);
                intent.putExtras(bundle);
                startActivity(intent);

                if (inventory.getInventoryValue("Shots") != 0) {
                    inventory.removeInventory("Shots", 1);
                }
                nextDayButton.setVisibility(View.VISIBLE);
                optionsBackground.setVisibility(View.GONE);
                huntText.setVisibility(View.GONE);
                huntYesButton.setVisibility(View.GONE);
                exitOptionsButton.setVisibility(View.GONE);

                // Updates and displays changes to weather
                weather.dailyWeather(time, map);
                weatherConditionText.setText(weather.weatherTypeString());

                // Makes Temp Type start with Uppercase letter
                String weatherText1 = weather.getTempType();
                String weatherText2 = weatherText1.substring(0,1).toUpperCase();

                weatherTempText.setText(weatherText2 + weatherText1.substring(1));

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

    private void configuregoToRiverEventButton() {

        Button goToRiverEventButton = (Button) findViewById(R.id.goToRiverEventButton);

        final Button nextDay = findViewById(R.id.nextDay);

        goToRiverEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String currentLocation = map.getCurrentLandmark();
                switch (currentLocation){
                    case "Kansas River":
                        currentRiver = kansasRiver;
                        break;
                    case "Big Blue River":
                        currentRiver = bigBlueRiver;
                        break;
                    case "Snake River":
                        currentRiver = snakeRiver;
                        break;
                    case "Green River":
                        currentRiver = greenRiver;
                        break;
                    default:
                        currentRiver = null;
                        break;
                }

                // Pass River Class to River Activity
                Intent intent = new Intent(MainActivity.this,RiverActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("currentRiver", currentRiver);
                intent.putExtras(bundle);

                startActivity(intent);

                nextDay.setVisibility(View.VISIBLE);
                goToRiverEventButton.setVisibility(View.GONE);
                map.updateLocation(20);
            }
        });
    }
}