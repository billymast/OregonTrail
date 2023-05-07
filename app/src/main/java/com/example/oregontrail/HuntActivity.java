package com.example.oregontrail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;


public class HuntActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        int shots = getIntent().getExtras().getInt("shot");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hunt);

        final Button shootOne = findViewById(R.id.button);
        final Button shootTwo = findViewById(R.id.button2);
        final Button shootThree = findViewById(R.id.button3);
        final Button shootFour = findViewById(R.id.button4);
        final TextView isShot = findViewById(R.id.isHit);


        final ImageView imageView2 = (ImageView) findViewById (R.id.imageView2);
        imageView2.setImageResource(R.drawable.deerhiding);
        final ImageView imageView3 = (ImageView) findViewById (R.id.imageView3);
        imageView3.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
        final ImageView imageView4 = (ImageView) findViewById (R.id.imageView4);
        imageView4.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
        final ImageView imageView5 = (ImageView) findViewById (R.id.imageView5);
        imageView5.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.hunting);


        final TextView shotCount = findViewById(R.id.textView);

        shotCount.setText("Shots remaining: " + shots);

        int location = (int) (Math.random() * 5) + 1;

        int shotCounts = 0;

        shootOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (location) {
                    case 1:
                        imageView2.setImageResource(R.drawable.deerhiding);
                        imageView3.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView4.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView5.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        break;
                    case 2:
                        imageView3.setImageResource(R.drawable.deerhiding);
                        imageView2.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView4.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView5.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        break;
                    case 3:
                        imageView4.setImageResource(R.drawable.deerhiding);
                        imageView3.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView2.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView5.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        break;
                    case 4:
                        imageView5.setImageResource(R.drawable.deerhiding);
                        imageView3.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView4.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView2.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        break;
                }


                if (location == 1){
                    isShot.setText("HIT");
                    //inventory.addInventory("Food", 25);
                    //inventory.removeInventory("Shot", 1);

                }
                else{
                    isShot.setText("MISS");
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isShot.setText(""); // clear the text after a delay
                        finish(); // finish the activity after a delay
                    }
                }, 2000); // delay for 5 seconds
            }
        });
        shootTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (location) {
                    case 1:
                        imageView2.setImageResource(R.drawable.deerhiding);
                        imageView3.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView4.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView5.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        break;
                    case 2:
                        imageView3.setImageResource(R.drawable.deerhiding);
                        imageView2.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView4.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView5.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        break;
                    case 3:
                        imageView4.setImageResource(R.drawable.deerhiding);
                        imageView3.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView2.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView5.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        break;
                    case 4:
                        imageView5.setImageResource(R.drawable.deerhiding);
                        imageView3.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView4.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView2.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        break;
                }
                if (location == 2){
                    isShot.setText("HIT");
                    //inventory.addInventory("Food", 25);
                    //inventory.removeInventory("Shot", 1);
                }
                else{
                    isShot.setText("MISS");
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isShot.setText(""); // clear the text after a delay
                        finish(); // finish the activity after a delay
                    }
                }, 2000); // delay for 5 seconds
            }
        });
        shootThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (location) {
                    case 1:
                        imageView2.setImageResource(R.drawable.deerhiding);
                        imageView3.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView4.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView5.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        break;
                    case 2:
                        imageView3.setImageResource(R.drawable.deerhiding);
                        imageView2.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView4.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView5.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        break;
                    case 3:
                        imageView4.setImageResource(R.drawable.deerhiding);
                        imageView3.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView2.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView5.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        break;
                    case 4:
                        imageView5.setImageResource(R.drawable.deerhiding);
                        imageView3.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView4.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        imageView2.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                        break;
                }
                if (location == 3){
                    isShot.setText("HIT");
                    //inventory.addInventory("Food", 25);
                    //inventory.removeInventory("Shot", 1);
                }
                else{
                    isShot.setText("MISS");
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isShot.setText(""); // clear the text after a delay
                        finish(); // finish the activity after a delay
                    }
                }, 2000); // delay for 5 seconds
            }
        });
        shootFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (location == 4){
                    switch (location) {
                        case 1:
                            imageView2.setImageResource(R.drawable.deerhiding);
                            imageView3.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                            imageView4.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                            imageView5.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                            break;
                        case 2:
                            imageView3.setImageResource(R.drawable.deerhiding);
                            imageView2.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                            imageView4.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                            imageView5.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                            break;
                        case 3:
                            imageView4.setImageResource(R.drawable.deerhiding);
                            imageView3.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                            imageView2.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                            imageView5.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                            break;
                        case 4:
                            imageView5.setImageResource(R.drawable.deerhiding);
                            imageView3.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                            imageView4.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                            imageView2.setImageResource(R.drawable.craiyon_153058_bushes_and_woods);
                            break;
                    }
                    isShot.setText("HIT");
                    //inventory.addInventory("Food", 25);
                    //inventory.removeInventory("Shot", 1);
                }
                else{
                    isShot.setText("MISS");
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isShot.setText(""); // clear the text after a delay
                        finish(); // finish the activity after a delay
                    }
                }, 2000); // delay for 5 seconds
            }
        });
    }


}