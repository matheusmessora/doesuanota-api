package com.doesuanota.api.endpoint.participant;

import com.doesuanota.api.domain.participant.Participant;
import com.doesuanota.api.domain.participant.ParticipantFactory;
import com.doesuanota.api.domain.participant.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("participants")
public class ParticipantEndpoint {

    @Autowired
    private ParticipantService service;

    @Autowired
    private ParticipantFactory factory;

    @RequestMapping(method = POST, produces = {APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<ParticipantResource> create(@RequestBody ParticipantResource resource) {

        final Participant createdParticipant = service.register(factory.convert(resource));
        return new ResponseEntity<>(new ParticipantResource(createdParticipant), HttpStatus.CREATED);
    }

    @RequestMapping(method = GET, produces = {APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<List<ParticipantResource>> getAll() {

        final List<Participant> participants = service.findAll();
        if(participants.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        final List<ParticipantResource> resources = participants.stream().map(ParticipantResource::new).collect(Collectors.toList());
        resources.forEach(ParticipantResource::maskEmail);

        return new ResponseEntity<>(resources, HttpStatus.OK);
    }
}
