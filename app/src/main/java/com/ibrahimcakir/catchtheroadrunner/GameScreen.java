package com.ibrahimcakir.catchtheroadrunner;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameScreen extends AppCompatActivity {

    Dialog myDialog;
    Button showPopup_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        showPopup_button = findViewById(R.id.showPopup_button);
        myDialog = new Dialog(this);


    }

    public void showPopup(View view){
        TextView textclose;

        myDialog.setContentView(R.layout.popupwindow);

        textclose = myDialog.findViewById(R.id.textclose);
        textclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


    }








}
