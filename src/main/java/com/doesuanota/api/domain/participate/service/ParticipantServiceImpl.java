package com.doesuanota.api.domain.participate.service;

import com.doesuanota.api.infrastructure.repository.participant.Participant;
import com.doesuanota.api.infrastructure.repository.participant.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository repository;

    @Autowired
    public ParticipantServiceImpl(final ParticipantRepository repository) {
        this.repository = repository;
    }

    public Participant register(final Participant participant) {
        return repository.save(participant);
    }
}
