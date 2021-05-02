package com.example.matchinfo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {
   // @JsonProperty("teamId")
    private String team_key;
   // @JsonProperty("teamName")
    private String team_name;

    public String getTeam_key() {
        return team_key;
    }

    public void setTeam_key(String team_key) {
        this.team_key = team_key;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }
}
