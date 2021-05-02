package com.example.matchinfo.dto;

public class Position {

    private String overAllLeaguePosition;

    public Position() {
    }

    public String getOverAllLeaguePosition() {
        return overAllLeaguePosition;
    }

    public void setOverAllLeaguePosition(String overAllLeaguePosition) {
        this.overAllLeaguePosition = overAllLeaguePosition;
    }

    @Override
    public String toString() {
        return "Position{" +
                "overAllLeaguePosition='" + overAllLeaguePosition + '\'' +
                '}';
    }
}
