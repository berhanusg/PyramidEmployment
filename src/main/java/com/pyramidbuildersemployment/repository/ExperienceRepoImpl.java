package com.pyramidbuildersemployment.repository;

import com.pyramidbuildersemployment.models.Experience;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ExperienceRepoImpl implements ExperienceRepoInterface{


    private ExperienceRepoImpl experienceRepo;

    @Autowired
    public ExperienceRepoImpl(ExperienceRepoImpl experienceRepo) {
        this.experienceRepo = experienceRepo;

    }
    @Override
    public <S extends Experience> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Experience> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Experience> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Experience> findAll() {
        return null;
    }

    @Override
    public Iterable<Experience> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Experience entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Experience> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
