package com.example.david.drunkdriving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.Random;

/**
 * Created by David on 3/7/2017.
 */

public abstract class DeckofCard {

    protected ArrayList<Card> cards = new ArrayList<>();
    protected int decksize;
    protected int originalsize;
    protected Random random;

    public DeckofCard(){}

    //used to grab a card
    public Card grabCard() {
        int swapPosition = random.nextInt(decksize);
        Card returned = cards.get(swapPosition);
        cardSwap(swapPosition);
        decrementDeckSize();
        //resets the deck if there are no more cards to draw
        if(decksize ==0 ){
            resetDeck();
        }
        return returned;

    }
    protected void cardSwap(int swapPosition) {
        Collections.swap(cards, swapPosition, decksize-1);

    }

    public void decrementDeckSize(){
        decksize--;
    }

    public void resetDeck() {
        decksize = originalsize;
    }


}
