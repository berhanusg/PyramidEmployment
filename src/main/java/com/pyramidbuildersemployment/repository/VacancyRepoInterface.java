package com.pyramidbuildersemployment.repository;

import com.pyramidbuildersemployment.models.Vacancy;
import org.springframework.data.repository.CrudRepository;

public interface VacancyRepoInterface extends CrudRepository<Vacancy, Long>{
}
