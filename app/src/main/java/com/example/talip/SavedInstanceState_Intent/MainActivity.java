package com.example.talip.SavedInstanceState_Intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int counter = 0;

    // Wird aufgerufen, wenn die Activity aus dem nichts erstellt wird.
    // Eine ggf. vorhandene alte Session-Info dieser Activity wird mitgegeben.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null)
            counter = savedInstanceState.getInt("saveMyCounter");

        TextView tv = findViewById(R.id.hitCounter);
        tv.setText(Integer.toString(counter));
    }

    // Alle session-relevanten Infos werden in dieser Methode gesichert,
    // falls die Activity ***destroyed*** wird, um später wieder verfügbar zu sein.
    // Diese Methode dient nur für die Datensicherung während der App-Laufzeit.
    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putInt("saveMyCounter", counter);
        super.onSaveInstanceState(outState);
    }

    public void onClickNext(View v) {

        // Eine View ist ein Bauelement innerhalb einer Activity,
        // wie ein Button oder ein Textfeld.
        EditText et = findViewById(R.id.editText);

        // Ein Intent ist ein Auftrag eine neue Activity zu starten.
        // Man kann diesen Auftrag mit zusätzlichen Daten für die
        // neue Activity bestücken.
        Intent intent = new Intent(this, SecondActivity.class);

        // Daten mit einem zugehörigen String-Bezeichner anfügen.
        intent.putExtra("message", et.getText().toString());
        intent.putExtra("zahl", 1);

        // Den Activity-Auftrag auslösen.
        startActivity(intent);
    }

    public void onHit(View v) {

        counter++;
        TextView tv = findViewById(R.id.hitCounter);
        tv.setText(Integer.toString(counter));
    }
}
