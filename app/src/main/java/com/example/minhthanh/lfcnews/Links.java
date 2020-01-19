package com.example.minhthanh.lfcnews;

/**
 * Created by Minh Thanh on 22/3/2017.
 */

public class Links {
    teamLink homeTeam;
    teamLink awayTeam;

    public teamLink getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(teamLink homeTeam) {
        this.homeTeam = homeTeam;
    }

    public teamLink getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(teamLink awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Links() {

    }

    public Links(teamLink homeTeam, teamLink awayTeam) {

        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }
}
