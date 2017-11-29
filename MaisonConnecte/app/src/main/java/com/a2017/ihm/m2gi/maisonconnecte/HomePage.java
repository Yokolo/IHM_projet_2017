package com.a2017.ihm.m2gi.maisonconnecte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        final Button boutonLumiere = findViewById(R.id.bouttonLumiere);

        final Switch switchLumiereCourante = findViewById(R.id.switchLumiereCourante);
        final Switch switchLumiereGenerale = findViewById(R.id.switchLumiereGenerale);
        Intent intent = new Intent(this, LumiereActivity.class);
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, LumiereActivity.class);
        startActivity(intent);
    }
    public void storeLayout(View view) {
        Intent intent = new Intent(this, StoreActivity.class);
        startActivity(intent);
    }
}