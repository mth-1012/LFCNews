package com.example.minhthanh.lfcnews;

import java.util.ArrayList;

/**
 * Created by Minh Thanh on 26/3/2017.
 */

public class ArrayListPlayers {
    ArrayList<Players> players;

    public ArrayList<Players> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Players> players) {
        this.players = players;
    }

    public ArrayListPlayers() {

    }

    public ArrayListPlayers(ArrayList<Players> players) {

        this.players = players;
    }
}
