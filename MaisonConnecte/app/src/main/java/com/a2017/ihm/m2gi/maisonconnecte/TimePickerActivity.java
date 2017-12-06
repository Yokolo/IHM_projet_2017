package com.a2017.ihm.m2gi.maisonconnecte;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

public class TimePickerActivity extends AppCompatActivity {


    static String plageJourneeDe = "";
    static String plageJourneeA = "";
    static String plageSoireeDe = "";
    static String plageSoireeA = "";
    static String plageNuitDe = "";
    static String plageNuitA = "";


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


        txtJourneeDe.setInputType(InputType.TYPE_NULL);
        txtJourneeDe.setFocusableInTouchMode(true);
        txtJourneeDe.requestFocus();
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
        txtJourneeA.requestFocus();
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
        txtSoireeDe.requestFocus();
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
        txtSoireeA.requestFocus();
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
        txtNuitDe.requestFocus();
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
        txtNuitA.requestFocus();
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


    }
}
