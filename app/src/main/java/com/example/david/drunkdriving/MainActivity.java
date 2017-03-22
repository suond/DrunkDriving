package com.example.david.drunkdriving;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MainDeck deck;
    int kingsLeft;
    //image button adds a weird border around the image so use view instead
    ImageView deckButton;
    TextView kingsTextView;
    TextView showRule;
    Integer numPlayer;
    ImageView currentCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         deck = new MainDeck();
        //sets the value for the textview for the kings
        kingsLeft = 4;
        kingsTextView = (TextView)findViewById(R.id.showKingsLeft);
        kingsTextView.setText(Integer.toString(kingsLeft) +" kings left");
        //the imageview for the card
        currentCard = (ImageView)findViewById(R.id.currentcard);
        showRule = (TextView)findViewById(R.id.cardRuleTextview);
        deckButton = (ImageView) findViewById(R.id.deckButton);

        //used to grab the number of players that are in the game
        Bundle data = getIntent().getExtras();
        numPlayer = (Integer)data.get(startingActivity.numPlayerTag);
        if(numPlayer != null)
            Log.i("NOPLAYER",numPlayer.toString());


    }

    public void changeCard(View view){

        Card grabbedCard = deck.grabCard();
        //used to get the R id for the drawable of the card.
        //Card's toString matches the name of the drawable id
        int resId = getResources().getIdentifier(grabbedCard.toString(),"drawable","com.example.david.drunkdriving");
        currentCard.setImageResource(resId);
        //sets it visible once a card has been drawn
        currentCard.setVisibility(View.VISIBLE);

        if (grabbedCard.getCardType().equals("king")) {
            kingsLeft--;
            kingsTextView.setText(Integer.toString(kingsLeft) + " kings left");
            //game over
            if (kingsLeft == 0) {
                deck.resetDeck();
                TextView ripTextView = (TextView)findViewById(R.id.ripTextView);
                ripTextView.setVisibility(View.VISIBLE);
                //disable buttonclick
                disableButton();
                Button replayButton = (Button) findViewById(R.id.replayButton);
                replayButton.setVisibility(View.VISIBLE);
                showRule.setText("DRINK UP!");
                return;
            }
        }

        setRule(grabbedCard);

        if(grabbedCard.getCardType().equals("queen")){
            final Intent intent = new Intent(MainActivity.this,QueenActivity.class);
            //unclickable until after the queen's game is done
            deckButton.setClickable(false);
            //passes the number of player so the queens activity show the correct number of cards
            intent.putExtra(startingActivity.numPlayerTag,numPlayer);
            //creates a short delay to automatically launch the queens game.
            //countdowntimer had an odd behavior that handler doesn't
            //launches after 2 second
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(intent);
                    deckButton.setClickable(true);
                }
            },2000);

        }
    }//end of changeCard

    //used to set the rule for the textview that shows what to do
    private void setRule(Card card){
        showRule.setVisibility(View.VISIBLE);
        switch (card.getCardType()){
            case "nine":
                showRule.setText("Person left drinks");
                return;
            case "ten":
                showRule.setText("Person right drinks");
                return;
            case "jack":
                showRule.setText("Person who flip drinks");
                return;
            case "queen":
                showRule.setText("Queens Game (plz wait)");
                return;
            case "king":
                showRule.setText("Pour in the cup");
                return;
            default:
                showRule.setText("Pick someone to drink");
        }
    }

    //replays the game and launches startActivity
    public void replaygame(View view){

        Intent intent = new Intent(this, startingActivity.class);
        //this flag tells android to remove this activity from the stack
        //so pressing back will not return to this activity.
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }
    private void disableButton() {
        deckButton.setClickable(false);

    }
}
