package com.example.minhthanh.lfcnews;

/**
 * Created by Minh Thanh on 20/3/2017.
 */

public class Match {
    String homeTeamName;
    String awayTeamName;
    String status;
    Result result;
    Links _links;
    int matchday;

    public int getMatchday() {
        return matchday;
    }

    public void setMatchday(int matchday) {
        this.matchday = matchday;
    }

    public Match(String homeTeamName, String awayTeamName, String status, Result result, Links _links, int matchday) {

        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.status = status;
        this.result = result;
        this._links = _links;
        this.matchday = matchday;
    }

    public Match(String homeTeamName, String awayTeamName, String status, Result result, Links _links) {
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.status = status;
        this.result = result;
        this._links = _links;
    }

    public Links get_links() {

        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }

    @Override
    public String toString() {
        return "Match{" +
                "homeTeamName='" + homeTeamName + '\'' +
                ", awayTeamName='" + awayTeamName + '\'' +
                ", status='" + status + '\'' +
                ", result=" + result +
                '}';
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Match(String homeTeamName, String awayTeamName, String status, Result result) {

        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.status = status;
        this.result = result;
    }

    public Match() {

    }
}
