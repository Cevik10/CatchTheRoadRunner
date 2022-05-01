package com.ibrahimcakir.catchtheroadrunner;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;

import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class GameScreen extends AppCompatActivity {

    ProgressBar mProgressBar;
    TextView timeText;
    CountDownTimer mCountDownTimer;
    Dialog myDialog;
    ImageButton showPopup_button;


    boolean isOn;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        isOn = true;

        showPopup_button = findViewById(R.id.showPopup_button);
        myDialog = new Dialog(this);

        final int[] i = {0};
        timeText =findViewById(R.id.timeText);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mProgressBar.setProgress(i[0]);

        mCountDownTimer = new CountDownTimer(10000, 1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long millisUntilFinished) {
                Log.v("Log_tag", "Tick of Progress" + i[0] + millisUntilFinished);
                i[0]++;
                mProgressBar.setProgress(i[0] * 100 / (10000 / 1000));
                timeText.setText("Seconds remaining: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                //Do what you want
                i[0]++;
                mProgressBar.setProgress(100);
            }
        };
        mCountDownTimer.start();


    }



    public void showPopup(View view) {

        TextView textClose;
        ImageButton musicButton;
        ImageButton backButton;

        myDialog.setContentView(R.layout.popupwindow);

        textClose = myDialog.findViewById(R.id.textClose);
        musicButton = myDialog.findViewById(R.id.musicButton);
        backButton = myDialog.findViewById(R.id.backButton);



        textClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });



        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOn) {

                    isOn = false;
                    musicButton.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.music_icon));

                }

                else{

                    isOn = true;
                    musicButton.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.musicoff_icon));
                }



            }
        });



        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameScreen.this,MainActivity.class);
                startActivity(intent);
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }



}













