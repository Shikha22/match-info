package com.example.matchinfo.service;

import com.example.matchinfo.client.MatchInfoClient;
import com.example.matchinfo.dto.Country;
import com.example.matchinfo.dto.League;
import com.example.matchinfo.dto.Match;
import com.example.matchinfo.dto.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MatchInfoService {

    @Autowired
    MatchInfoClient matchInfoClient;

    public Match getMatch(String countryId){

        Match match = new Match();

        Country country = matchInfoClient.getCountry(countryId);

        //League
        List<League> leagues = matchInfoClient.getLeagueByCountry(countryId);

        //Team
        List<Map<String,Team>> teams = matchInfoClient.getTeamByLeague(leagues);


        match.setCountry(country);
        match.setLeagues(leagues);
        match.setTeams(teams);

        return match;

    }
}
