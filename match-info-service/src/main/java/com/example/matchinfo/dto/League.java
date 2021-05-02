package com.example.matchinfo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class League {
    //@JsonProperty("leagueId")
    private String league_id;
   // @JsonProperty("leagueName")
    private String league_name;

    public League() {

    }

    public String getLeague_id() {
        return league_id;
    }

    public void setLeague_id(String league_id) {
        this.league_id = league_id;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }
}
