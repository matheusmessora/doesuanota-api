package com.doesuanota.api.infrastructure.repository.participant;

import com.doesuanota.api.domain.participant.Participant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParticipantRepository extends MongoRepository<Participant, String> {
}
