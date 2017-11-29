package com.a2017.ihm.m2gi.maisonconnecte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class LumiereActivity extends AppCompatActivity {

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
    }

    @Override
    protected void onResume() {
        super.onResume();

        switchLumiereCourante.setChecked(isLumiereCouranteOn);
        switchLumiereGenerale.setChecked(isLumiereGeneraleOn);
    }
}
