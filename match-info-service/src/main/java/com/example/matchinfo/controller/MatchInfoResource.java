package com.example.matchinfo.controller;

import com.example.matchinfo.dto.Country;
import com.example.matchinfo.dto.League;
import com.example.matchinfo.dto.Match;
import com.example.matchinfo.dto.Team;
import com.example.matchinfo.service.MatchInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/match")
public class MatchInfoResource {

    Logger logger = LoggerFactory.getLogger(MatchInfoResource.class);

    @Autowired
    MatchInfoService matchInfoService;

    @RequestMapping(value = "/{countryId}", method = RequestMethod.GET)
    @ResponseBody
    public Match getMatch(@PathVariable("countryId") String countryId){
        logger.debug("Started searching Match Details--");

        Match match = matchInfoService.getMatch(countryId);

        logger.debug("Ended searching Match Details--");

        return match;

    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
