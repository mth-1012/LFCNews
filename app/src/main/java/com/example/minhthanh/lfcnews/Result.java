package com.example.minhthanh.lfcnews;

/**
 * Created by Minh Thanh on 20/3/2017.
 */

public class Result {
    int goalsHomeTeam;
    int goalsAwayTeam;

    @Override
    public String toString() {
        return "Result{" +
                "goalsHomeTeam='" + goalsHomeTeam + '\'' +
                ", goalsAwayTeam='" + goalsAwayTeam + '\'' +
                '}';
    }

    public int getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(int goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public int getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(int goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public Result() {

    }

    public Result(int goalsHomeTeam, int goalsAwayTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
        this.goalsAwayTeam = goalsAwayTeam;
    }
}
