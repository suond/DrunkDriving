package com.example.david.drunkdriving;

import java.util.Collections;
import java.util.Random;

/**
 * Created by David on 3/13/2017.
 */

public class MainDeck extends DeckofCard {

    public MainDeck() {

        createDrunkDrivingDeck();
    }



    private void createDrunkDrivingDeck() {
        //adds all the aces
        cards.add(new Card("ace","spade")); cards.add(new Card("ace","heart"));
        cards.add(new Card("ace","clover"));cards.add(new Card("ace","diamond"));
        //kings
        cards.add(new Card("king","spade")); cards.add(new Card("king","heart"));
        cards.add(new Card("king","clover"));cards.add(new Card("king","diamond"));
        //queens
        cards.add(new Card("queen","spade")); cards.add(new Card("queen","heart"));
        cards.add(new Card("queen","clover"));cards.add(new Card("queen","diamond"));
        //jacks
        cards.add(new Card("jack","spade")); cards.add(new Card("jack","heart"));
        cards.add(new Card("jack","clover"));cards.add(new Card("jack","diamond"));
        //tens
        cards.add(new Card("ten","spade")); cards.add(new Card("ten","heart"));
        cards.add(new Card("ten","clover"));cards.add(new Card("ten","diamond"));
        //nines
        cards.add(new Card("nine","spade")); cards.add(new Card("nine","heart"));
        cards.add(new Card("nine","clover"));cards.add(new Card("nine","diamond"));
        random = new Random();
        decksize = cards.size();
        originalsize = decksize;

    }


}
