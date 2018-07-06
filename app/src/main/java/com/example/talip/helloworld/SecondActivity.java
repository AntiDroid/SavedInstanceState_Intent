package com.example.talip.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Gib mir den "Zweck" dieser Activity und gib mir davon
        // den angefügten Wert, der bei Bezeichner soundso zu finden ist.
        String textEingabe = this.getIntent().getStringExtra("message");

        // Bei Integern gibt man Default-Werte angeben, falls die Activity
        // auf anderem Wege gestartet wird, damit die App nicht abstürzt.
        int value = getIntent().getIntExtra("zahl", 0000);

        TextView tv = findViewById(R.id.textView);
        tv.setText("Datenerfassung " + value + ": " + textEingabe);
    }
}
