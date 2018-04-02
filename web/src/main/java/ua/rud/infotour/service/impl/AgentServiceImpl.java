package ua.rud.infotour.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.rud.infotour.domain.Agent;
import ua.rud.infotour.repository.AgentRepository;
import ua.rud.infotour.service.AgentService;

@Service
public class AgentServiceImpl implements AgentService {
    private AgentRepository agentRepository;

    @Autowired
    public AgentServiceImpl(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @Override public Agent addAgent(String name) {
        Agent agent = new Agent();
        agent.setName(name);
        return agentRepository.saveAndFlush(agent);
    }
}
