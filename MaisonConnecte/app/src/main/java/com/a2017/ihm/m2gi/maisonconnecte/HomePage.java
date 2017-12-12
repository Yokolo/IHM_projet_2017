package com.a2017.ihm.m2gi.maisonconnecte;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Locale;

public class HomePage extends AppCompatActivity {

    private FloatingActionButton speakButton;
    private String Action_String;
    private final int REQ_CODE_SPEECH_INPUT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        final Button boutonLumiere = findViewById(R.id.bouttonLumiere);
        final Switch switchLumiereCourante = findViewById(R.id.switchLumiereCourante);
        final Switch switchLumiereGenerale = findViewById(R.id.switchLumiereGenerale);
        Intent intent = new Intent(this, LumiereActivity.class);

        speakButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        speakButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("ta click !!!!!","salut");
                askSpeechInput();
            }
        });
    }
    private void askSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Hi speak something");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {

        }
    }

    // Receiving speech input

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    Action_String = (result.get(0));
                    Log.d("ce que vous avez dit:", Action_String);
                    Intent intent;
                    switch (Action_String){
                        case "éteindre la lumière" :
                            LumiereActivity.isLumiereCouranteOn = false;
                            intent = new Intent(this, LumiereActivity.class);
                            startActivity(intent);
                            break;
                        case "allumer la lumière" :
                            LumiereActivity.isLumiereCouranteOn = true;
                            intent = new Intent(this, LumiereActivity.class);
                            startActivity(intent);
                            break;
                        case "éteindre toutes les lumières" :
                            LumiereActivity.isLumiereGeneraleOn = false;
                            intent = new Intent(this, LumiereActivity.class);
                            startActivity(intent);
                            break;
                        case "allumer toutes les lumières" :
                            LumiereActivity.isLumiereGeneraleOn = true;
                            intent = new Intent(this, LumiereActivity.class);
                            startActivity(intent);
                            break;
                    }
                }
                break;
            }

        }
    }
    public void lumiereLayout(View view) {
        Intent intent = new Intent(this, LumiereActivity.class);
        startActivity(intent);
    }
    public void storeLayout(View view) {
        Intent intent = new Intent(this, StoreActivity.class);
        startActivity(intent);
    }

    public void chauffageLayout(View view) {
        Intent intent = new Intent(this, chauffageActivity.class);
        startActivity(intent);
    }

    public void reconnaissanceGesteLayout(View view) {
        Intent intent = new Intent(this, ReconnaissanceGesteActivity.class);
        startActivity(intent);
    }

}
