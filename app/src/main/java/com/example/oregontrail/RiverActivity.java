package com.example.oregontrail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

public class RiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_river);

        // River Event Elements
        final ImageView mainScreen = findViewById(R.id.mainScreenImage);
        final Button backButton = findViewById(R.id.backButton);
        final TextView riverDepthText = findViewById(R.id.riverDepthText);
        final TextView riverWidthText = findViewById(R.id.riverWidthText);
        final Button riverFordButton = findViewById(R.id.riverFordButton);
        final Button riverFloatButton = findViewById(R.id.riverFloatButton);
        final Button riverFerryButton = findViewById(R.id.riverFerryButton);
        final Button riverWaitButton = findViewById(R.id.riverWaitButton);

        River currentRiver = getIntent().getExtras().getParcelable("currentRiver");

        configurebackButton();

        riverDepthText.setText("River Depth: " + currentRiver.getDepth());
        riverWidthText.setText("River Width: " + currentRiver.getWidth());

        // Buttons For River Event

        riverFordButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                backButton.performClick();
            }
        });

        riverFloatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                backButton.performClick();
            }
        });

        riverFerryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                backButton.performClick();
            }
        });

        riverWaitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                backButton.performClick();
            }
        });
    }

    private void configurebackButton(){
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}