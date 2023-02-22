package com.pyramidbuildersemployment.repository;

import com.pyramidbuildersemployment.models.HiringCompany;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class HiringRepoImple implements HiringRepoInterface{


    private HiringRepoImple hiringRepo;

    @Autowired
    public HiringRepoImple(HiringRepoImple hiringRepo) {
        this.hiringRepo = hiringRepo;

    }
    @Override
    public <S extends HiringCompany> S save(S entity) {
        return null;
    }

    @Override
    public <S extends HiringCompany> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<HiringCompany> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<HiringCompany> findAll() {
        return null;
    }

    @Override
    public Iterable<HiringCompany> findAllById(Iterable<Long> longs) {
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
    public void delete(HiringCompany entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends HiringCompany> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
