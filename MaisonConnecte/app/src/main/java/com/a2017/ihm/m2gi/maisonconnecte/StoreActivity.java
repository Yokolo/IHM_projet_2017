package com.a2017.ihm.m2gi.maisonconnecte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class StoreActivity extends AppCompatActivity {

    public static boolean isStoreCourantOuvert = false;
    public static boolean isStoreGeneralOuvert = false;

    private Switch switchStoreCourant;
    private Switch switchStoreGeneral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        switchStoreCourant = findViewById(R.id.switchStoreCourant);
        switchStoreCourant.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isStoreCourantOuvert = b;
            }
        });

        switchStoreGeneral = findViewById(R.id.switchStoreGeneral);
        switchStoreGeneral.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isStoreGeneralOuvert = b;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        switchStoreCourant.setChecked(isStoreCourantOuvert);
        switchStoreGeneral.setChecked(isStoreGeneralOuvert);
    }
}
