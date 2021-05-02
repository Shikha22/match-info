package com.example.matchinfo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class Match {

    private Country country;

    private List<League> leagues;

    private List<Map<String,Team>> teams;

    private Position position;

    public Match() {

    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }

    public List<Map<String, Team>> getTeams() {
        return teams;
    }

    public void setTeams(List<Map<String, Team>> teams) {
        this.teams = teams;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
