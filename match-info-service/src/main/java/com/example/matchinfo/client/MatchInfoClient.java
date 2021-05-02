package com.example.matchinfo.client;

import com.example.matchinfo.dto.Country;
import com.example.matchinfo.dto.League;
import com.example.matchinfo.dto.Team;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;


@Component
public class MatchInfoClient {

    @Value("${api.key}")
    private String apiKey;

    @Value("${football.url}")
    private String footBallUrl;

    @Value("${football.action.country.endpoint}")
    private String countryEndpoint;

    @Value("${football.action.leagues.endpoint}")
    private String leaguesEndpoint;

    @Value("${football.action.teams.endpoint}")
    private String teamsEndpoint;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper mapper;

    public Country getCountry(String countryId){

        List<Map<String,String>> countryList =restTemplate.getForObject(footBallUrl+countryEndpoint+"&APIkey="+apiKey,List.class);

        Country country = null;
        for(Map<String,String> map:countryList){
            for(Map.Entry<String,String> entry:map.entrySet()){
                boolean _set = false;
                if(entry.getKey().equals("country_id") && entry.getValue().equals(countryId)){
                    country = mapper.convertValue(map,Country.class);
                    _set = true;
                }
                if(_set) break;

            }
        }
        return country;
    }

    public List<League> getLeagueByCountry(String countryId){

        List<Map<String,String>> leaguesList =restTemplate.getForObject(footBallUrl+leaguesEndpoint+"&country_id="+countryId+"&APIkey="+apiKey,List.class);

        List<League> leagues= new LinkedList<>();

        for(Map<String,String> map:leaguesList){
           League league = mapper.convertValue(map,League.class);
            leagues.add(league);
        }
        return leagues;
    }

    public List<Map<String,Team>> getTeamByLeague(List<League> leagues){

        List<Map<String,Team>> teams= new LinkedList<>();

        for(League league: leagues){
            List<Map<String,String>> teamsList =restTemplate.getForObject(footBallUrl+teamsEndpoint+"&league_id="+league.getLeague_id()+"&APIkey="+apiKey,List.class);

            for(Map<String,String> map:teamsList){
                Map<String,Team> teamMap = new HashMap<>();
                Team team = mapper.convertValue(map,Team.class);
                teamMap.put(league.getLeague_id(),team);
                teams.add(teamMap);
            }
        }


        return teams;
    }

}
