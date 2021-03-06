package com.kafkamgt.uiapi.controller;


import com.kafkamgt.uiapi.model.charts.TeamOverview;
import com.kafkamgt.uiapi.service.UtilControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;


@RestController
@RequestMapping("/")
public class UtilController {

    @Autowired
    private UtilControllerService utilControllerService;

    @RequestMapping(value = "/getAuth", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<HashMap<String, String>> getAuth() {
        return new ResponseEntity<>(utilControllerService.getAuth(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getDashboardStats", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<HashMap<String, String>> getDashboardStats() {
        return new ResponseEntity<>(utilControllerService.getDashboardStats(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getActivityLogForTeamOverview", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TeamOverview> getActivityLogForTeamOverview(@RequestParam("activityLogForTeam")
                                                                              String activityLogForTeam) {
        return new ResponseEntity<>(utilControllerService.getActivityLogForTeamOverview(activityLogForTeam), HttpStatus.OK);
    }

    @RequestMapping(value = "/getExecAuth", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getExecAuth() {
        return new ResponseEntity<>(utilControllerService.getExecAuth(), HttpStatus.OK);
    }

    @GetMapping("/logout")
    public void getLogoutPage(HttpServletRequest request, HttpServletResponse response){
        utilControllerService.getLogoutPage(request, response);
    }

}
