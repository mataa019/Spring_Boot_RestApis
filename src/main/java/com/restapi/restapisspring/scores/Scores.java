package com.restapi.restapisspring.scores;

public class Scores {
    public int wins;
    public int ties;
    public int looses;

    public  Scores(int Wins, int Ties, int Looses){
        this.looses= Looses;
        this.ties = Ties;
        this.wins = Wins;
    }
    public int getWins() {
        return wins;
    }

    public int getTies() {
        return ties;
    }

    public int getLooses() {
        return looses;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public void setLooses(int looses) {
        this.looses = looses;
    }
}
