package com.doesuanota.api.endpoint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/participate")
public class ParticipateEndpoint {

    @RequestMapping(method = POST, produces = {APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity create() {
//        IntegrationLogDataContract resource = this.findLastByNfeKey(nfeKey);
//
//        if (resource == null) {
//            throw new NotFoundException("Not found any epec with the given nfe key: " + nfeKey);
//        }
//
//        return builder()
//                .addEntity(resource.getResponseInvoice())
//                .addHttpStatus(OK)
//                .build();

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



}
