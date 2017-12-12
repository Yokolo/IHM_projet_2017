package com.a2017.ihm.m2gi.maisonconnecte;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Locale;

public class TimePickerActivity extends AppCompatActivity {

    private FloatingActionButton speakButton;
    private String Action_String;
    private final int REQ_CODE_SPEECH_INPUT = 100;


    static String plageJourneeDe = "";
    static String plageJourneeA = "";
    static String plageSoireeDe = "";
    static String plageSoireeA = "";
    static String plageNuitDe = "";
    static String plageNuitA = "";

    static String tempJournee = "";
    static String tempSoiree = "";
    static String tempNuit = "";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText txtJourneeDe = (EditText) findViewById(R.id.chauffageJourneeDe);
        final EditText txtJourneeA = (EditText) findViewById(R.id.chauffageJourneeA);
        final EditText txtSoireeDe = (EditText) findViewById(R.id.chauffageSoireeDe);
        final EditText txtSoireeA = (EditText) findViewById(R.id.chauffageSoireeA);
        final EditText txtNuitDe = (EditText) findViewById(R.id.chauffageNuitDe);
        final EditText txtNuitA = (EditText) findViewById(R.id.chauffageNuitA);

        txtJourneeDe.setText(plageJourneeDe);
        txtJourneeA.setText(plageJourneeA);
        txtSoireeDe.setText(plageSoireeDe);
        txtSoireeA.setText(plageSoireeA);
        txtNuitDe.setText(plageNuitDe);
        txtNuitA.setText(plageNuitA);

        final EditText txtJourneeTemp = (EditText) findViewById(R.id.chauffageJourneeTemp);
        final EditText txtSoireeTemp = (EditText) findViewById(R.id.chauffageSoireeTemp);
        final EditText txtNuitTemp = (EditText) findViewById(R.id.chauffageNuitTemp);

        txtJourneeTemp.setText(tempJournee);
        txtSoireeTemp.setText(tempSoiree);
        txtNuitTemp.setText(tempNuit);

        txtJourneeTemp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                tempJournee = txtJourneeTemp.getText().toString();
            }
        });

        txtSoireeTemp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                tempSoiree = txtSoireeTemp.getText().toString();
            }
        });

        txtNuitTemp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                tempNuit = txtNuitTemp.getText().toString();
            }
        });

        txtJourneeDe.setInputType(InputType.TYPE_NULL);
        txtJourneeDe.setFocusableInTouchMode(true);
        txtJourneeDe.setCursorVisible(false);
        txtJourneeDe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(TimePickerActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                txtJourneeDe.setText(hourOfDay + ":" + minute);
                                plageJourneeDe = ((Integer) hourOfDay).toString() + ":" + ((Integer) minute).toString();
                            }
                        }, 0,0, false);
                timePickerDialog.show();
            }
        });

        txtJourneeA.setInputType(InputType.TYPE_NULL);
        txtJourneeA.setFocusableInTouchMode(true);
        txtJourneeA.setCursorVisible(false);
        txtJourneeA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(TimePickerActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                txtJourneeA.setText(hourOfDay + ":" + minute);
                                plageJourneeA = ((Integer) hourOfDay).toString() + ":" + ((Integer) minute).toString();

                            }
                        }, 0,0, false);
                timePickerDialog.show();
            }
        });


        txtSoireeDe.setInputType(InputType.TYPE_NULL);
        txtSoireeDe.setFocusableInTouchMode(true);
        txtSoireeDe.setCursorVisible(false);
        txtSoireeDe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(TimePickerActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                txtSoireeDe.setText(hourOfDay + ":" + minute);
                                plageSoireeDe = ((Integer) hourOfDay).toString() + ":" + ((Integer) minute).toString();

                            }
                        }, 0,0, false);
                timePickerDialog.show();
            }
        });

        txtSoireeA.setInputType(InputType.TYPE_NULL);
        txtSoireeA.setFocusableInTouchMode(true);
        txtSoireeA.setCursorVisible(false);
        txtSoireeA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(TimePickerActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                txtSoireeA.setText(hourOfDay + ":" + minute);
                                plageSoireeA = ((Integer) hourOfDay).toString() + ":" + ((Integer) minute).toString();

                            }
                        }, 0,0, false);
                timePickerDialog.show();
            }
        });


        txtNuitDe.setInputType(InputType.TYPE_NULL);
        txtNuitDe.setFocusableInTouchMode(true);
        txtNuitDe.setCursorVisible(false);
        txtNuitDe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(TimePickerActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                txtNuitDe.setText(hourOfDay + ":" + minute);
                                plageNuitDe = ((Integer) hourOfDay).toString() + ":" + ((Integer) minute).toString();
                            }
                        }, 0,0, false);
                timePickerDialog.show();
            }
        });

        txtNuitA.setInputType(InputType.TYPE_NULL);
        txtNuitA.setFocusableInTouchMode(true);
        txtNuitA.setCursorVisible(false);
        txtNuitA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(TimePickerActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                txtNuitA.setText(hourOfDay + ":" + minute);
                                plageNuitA = ((Integer) hourOfDay).toString() + ":" + ((Integer) minute).toString();
                            }
                        }, 0,0, false);
                timePickerDialog.show();
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

    public void reconnaissanceGesteLayout(View view) {
        Intent intent = new Intent(this, ReconnaissanceGesteActivity.class);
        startActivity(intent);
    }
}
