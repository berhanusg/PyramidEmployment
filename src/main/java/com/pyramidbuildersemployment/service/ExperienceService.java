package com.pyramidbuildersemployment.service;


import com.pyramidbuildersemployment.models.Experience;

import java.util.List;

public interface ExperienceService {

     List<ExperienceService> getAllAllexperiencs();

     Experience getExperienceById(long id);

     Experience saveAll(Experience expereince);

     Experience updateExperience(Experience expereince);

     void deleteExperience(long id);
}
