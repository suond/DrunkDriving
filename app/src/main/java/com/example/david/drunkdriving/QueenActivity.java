package com.example.david.drunkdriving;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;

public class QueenActivity extends AppCompatActivity {
    QueenDeck queenDeck;
    GridLayout gridLayout;
    Integer numPlayer;
    TextView testingTextView;
    boolean gameDone = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queen);
        Bundle data = getIntent().getExtras();
        numPlayer = (Integer)data.get(startingActivity.numPlayerTag);
        if (numPlayer != null) {
            queenDeck = new QueenDeck(numPlayer);
        } else {
            //default if numplayer doesn't pass for some reason
            numPlayer = 4;
            queenDeck = new QueenDeck(numPlayer);
        }

        gridLayout = (GridLayout) findViewById(R.id.theGridLayout);
        testingTextView = (TextView) findViewById(R.id.testingTextView);
        CreateCardGrid();

    }
    public void CreateCardGrid() {
        gridLayout.setOrientation(GridLayout.HORIZONTAL);
        gridLayout.setColumnCount(2);
        for (int i = 0; i<numPlayer; i++) {
            Card pickedCard = queenDeck.grabCard();
            /*TextView temp = new TextView(this);
            temp.setText("CHAINED TO THE RHYTHM");
            //use card toString to find the 2 card
            temp.setTag(pickedCard.toString());
            temp.setTextSize(15);
            temp.setPadding(50, 25, 10, 25);
            temp.setOnClickListener(handleOnClick(temp));
            gridLayout.addView(temp);*/
            ImageView temp = new ImageView(this);
            temp.setImageResource(R.drawable.deckfacedown);
            temp.setPadding(8,8,8,8);
            temp.setOnClickListener(handleOnClick(temp));
            temp.setTag(pickedCard.toString());
            gridLayout.addView(temp);
        }

    }

    public void returnToMain(View view){
        onBackPressed();
    }
    View.OnClickListener handleOnClick(final ImageView button){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(!gameDone) {
                String buttonTag = (String) button.getTag();
                int resId = getResources().getIdentifier(buttonTag,"drawable","com.example.david.drunkdriving");
                button.setImageResource(resId);
                if(buttonTag.equals("twospade")){
                    gameDone = true;
                    testingTextView.setText("WELP DRINK UP (click to go back)");
                    testingTextView.setVisibility(View.VISIBLE);
                    queenDeck.resetDeck();
                    queenDeck.resortDeck();

                }
               }
            }
        };
    } //end of method
}
