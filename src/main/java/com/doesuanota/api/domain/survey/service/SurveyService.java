package com.doesuanota.api.domain.survey.service;

import com.doesuanota.api.domain.survey.Answer;
import com.doesuanota.api.domain.survey.Survey;

import java.util.List;

public interface SurveyService {

    Survey findByToken(String token);

    Survey answer(String token, List<Answer> answers);
}
