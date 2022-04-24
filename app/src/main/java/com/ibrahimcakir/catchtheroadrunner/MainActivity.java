package com.ibrahimcakir.catchtheroadrunner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button start_button;
    Button freeMod_button;
    Button arcadeMod_button;
    boolean isOpen;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isOpen = true;

        // Locate the buttons in your xml
        start_button = (Button) findViewById(R.id.Start_button);
        freeMod_button = (Button) findViewById(R.id.FreeMod_button);
        arcadeMod_button = (Button) findViewById(R.id.ArcadeMod_button);

        //set listener on button1
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make button2 visible when button1 is pressed
                if (isOpen) {
                    arcadeMod_button.setVisibility(View.VISIBLE);
                    freeMod_button.setVisibility(View.VISIBLE);
                    isOpen = false;
                } else {
                    arcadeMod_button.setVisibility(View.INVISIBLE);
                    freeMod_button.setVisibility(View.INVISIBLE);
                    isOpen = true;

                }

            }
        });
    }

    public void freeModeClick(View view) {
        Intent intent = new Intent(MainActivity.this, GameScreen.class);
        startActivity(intent);

    }


}








