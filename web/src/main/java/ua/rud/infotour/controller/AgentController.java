package ua.rud.infotour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.rud.infotour.domain.Agent;
import ua.rud.infotour.service.AgentService;

@RestController
@RequestMapping("agent/")
public class AgentController {
    private AgentService agentService;

    @Autowired
    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @RequestMapping(value = "add/{name}", method = RequestMethod.POST)
    public ResponseEntity<Agent> addNewAgent(@PathVariable("name") String name) {
        Agent agent = agentService.addAgent(name);
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }
}
