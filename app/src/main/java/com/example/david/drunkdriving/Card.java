package com.example.david.drunkdriving;

import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Created by David on 3/7/2017.
 */

//card only created for this game specifically.
    //another field could be added specifying the value for each card
public class Card implements Comparable {

    public String getCardType() {
        return cardType;
    }

    private String cardType;
    private String cardSuit;
    //used for the compareTo method
    public int id = 0;

    public Card(String cardType,String cardSuit){
        this.cardType = cardType;
        this.cardSuit = cardSuit;
    }
    public Card(String cardType,String cardSuit ,int id){
        this.cardType = cardType;
        this.cardSuit = cardSuit;
        this.id = id;
    }

    @Override
    public String toString() {
        return cardType+cardSuit;
    }


    @Override
    public int compareTo(@NonNull Object o) {
        Card c = (Card) o;
        return this.id - c.id;
    }
}
