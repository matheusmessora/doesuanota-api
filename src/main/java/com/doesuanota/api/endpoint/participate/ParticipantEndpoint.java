package com.doesuanota.api.endpoint.participate;

import com.doesuanota.api.domain.participant.ParticipantFactory;
import com.doesuanota.api.domain.participant.service.ParticipantService;
import com.doesuanota.api.domain.participant.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("participant")
public class ParticipantEndpoint {

    @Autowired
    private ParticipantService service;

    @Autowired
    private ParticipantFactory factory;

    @Autowired
    public ParticipantEndpoint(ParticipantService service, final ParticipantFactory factory){
        this.service = service;
        this.factory = factory;
    }

    @RequestMapping(method = POST, produces = {APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<ParticipantResource> create(@RequestBody ParticipantResource resource) {

        final Participant createdParticipant = service.register(factory.convert(resource));
        return new ResponseEntity<>(new ParticipantResource(createdParticipant), HttpStatus.CREATED);
    }
}
