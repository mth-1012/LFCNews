package com.example.minhthanh.lfcnews;

import java.io.Serializable;

/**
 * Created by Minh Thanh on 26/3/2017.
 */

public class Players implements Serializable {
    String name;
    String position;
    int jerseyNumber;
    String dateOfBirth;
    String nationality;
    String contractUntil;
    String marketValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateofBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getContractUntil() {
        return contractUntil;
    }

    public void setContractUntil(String contractUntil) {
        this.contractUntil = contractUntil;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    public Players() {

    }

    public Players(String name, String position, int jerseyNumber, String dateofBirth, String nationality, String contractUntil, String marketValue) {

        this.name = name;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.dateOfBirth = dateofBirth;
        this.nationality = nationality;
        this.contractUntil = contractUntil;
        this.marketValue = marketValue;
    }
}
