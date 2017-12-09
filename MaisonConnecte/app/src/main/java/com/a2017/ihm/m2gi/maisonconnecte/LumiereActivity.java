package com.a2017.ihm.m2gi.maisonconnecte;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Locale;

public class LumiereActivity extends AppCompatActivity {

    private FloatingActionButton speakButton;
    private String Action_String;
    private final int REQ_CODE_SPEECH_INPUT = 100;

    public static boolean isLumiereCouranteOn = false;
    public static boolean isLumiereGeneraleOn = false;

    private Switch switchLumiereCourante;
    private Switch switchLumiereGenerale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lumiere);

        switchLumiereCourante = findViewById(R.id.switchLumiereCourante);
        switchLumiereCourante.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isLumiereCouranteOn = b;
            }
        });

        switchLumiereGenerale = findViewById(R.id.switchLumiereGenerale);
        switchLumiereGenerale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isLumiereGeneraleOn = b;
            }
        });
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
                }
                break;
            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        switchLumiereCourante.setChecked(isLumiereCouranteOn);
        switchLumiereGenerale.setChecked(isLumiereGeneraleOn);
    }
}
