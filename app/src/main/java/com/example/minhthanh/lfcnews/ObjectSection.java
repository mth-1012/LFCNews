package com.example.minhthanh.lfcnews;

/**
 * Created by Minh Thanh on 25/3/2017.
 */

public class ObjectSection {
    int imageID;
    String name;

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectSection() {

    }

    public ObjectSection(int imageID, String name) {

        this.imageID = imageID;
        this.name = name;
    }
}
