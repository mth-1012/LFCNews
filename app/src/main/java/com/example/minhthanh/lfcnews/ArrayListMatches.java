package com.example.minhthanh.lfcnews;

import java.util.ArrayList;

/**
 * Created by Minh Thanh on 20/3/2017.
 */

public class ArrayListMatches {
    Object _links;
    int count;
    ArrayList<Match> fixtures;

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = _links;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayListMatches() {
    }

    @Override
    public String toString() {
        return "ArrayListMatches{" +
                "fixtures=" + fixtures +
                '}';
    }

    public ArrayList<Match> getFixtures() {
        return fixtures;
    }

    public void setFixtures(ArrayList<Match> fixtures) {
        this.fixtures = fixtures;
    }

    public ArrayListMatches(ArrayList<Match> fixtures) {

        this.fixtures = fixtures;
    }
}
