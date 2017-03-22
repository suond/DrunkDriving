package com.example.david.drunkdriving;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class startingActivity extends AppCompatActivity {
    Integer numberOfPlayers = 2;
    public static final String numPlayerTag = "numPlayer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        //creates the spinner and sets the adapter to the string array
        //specified in the xml
        Spinner spinner = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinneritem,android.R.layout.simple_spinner_item);
        //creates the layout when the spinner shows the option
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //sets the number of players to a variable to be passed when ready
                String temp = (String)parent.getItemAtPosition(position);
                numberOfPlayers = Integer.parseInt(temp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
    }

    public void startMainActivity(View view){
        Intent start = new Intent(this, MainActivity.class);
        start.putExtra(numPlayerTag,numberOfPlayers);
        startActivity(start);
    }


}
