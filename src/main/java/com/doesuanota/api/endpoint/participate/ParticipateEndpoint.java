package com.doesuanota.api.endpoint.participate;

import com.doesuanota.api.domain.participate.service.ParticipateService;
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
@RequestMapping("/participate")
public class ParticipateEndpoint {

    private final ParticipateService service;

    @Autowired
    public ParticipateEndpoint(ParticipateService service){
        this.service = service;
    }


    @RequestMapping(method = POST, produces = {APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity create(@RequestBody ParticipateResource resource) {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }



}
