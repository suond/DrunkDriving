package com.example.david.drunkdriving;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * Created by David on 3/13/2017.
 */

public class QueenDeck extends DeckofCard {

    public QueenDeck() {
        createQueenDeck();
    }

    public QueenDeck(int numPlayer){
        createQueenDeck(numPlayer);
    }

    //default constructor made for the max no. of players
    public void createQueenDeck() {

        cards.add(new Card("two","spade",1));
        cards.add(new Card("three","spade",2));
        cards.add(new Card("four","spade",3));
        cards.add(new Card("five","spade",4));
        cards.add(new Card("six","spade",5));
        cards.add(new Card("seven","spade",6));
        cards.add(new Card("eight","spade",7));
        random = new Random();
        decksize = cards.size();
        originalsize = decksize;

    }

    //constructor for a specific number of player
    public void createQueenDeck(int numofPlayer) {
    //creates deck
        cards.add(new Card("two","spade",1));
        cards.add(new Card("three","spade",2));
        cards.add(new Card("four","spade",3));
        cards.add(new Card("five","spade",4));
        cards.add(new Card("six","spade",5));
        cards.add(new Card("seven","spade",6));
        cards.add(new Card("eight","spade",7));
        random = new Random();
        decksize = numofPlayer;
        originalsize = decksize;

    }
    //organize the dack back in numerical order (2-8)
    public void resortDeck() {
        Collections.sort(cards);
    }
}