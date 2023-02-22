package com.pyramidbuildersemployment.repository;

import com.pyramidbuildersemployment.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class CandidateRepoImpl implements CandidateRepoInterface {

    private CandidateRepoImpl candidateRepo;

    @Autowired
    public CandidateRepoImpl(CandidateRepoImpl candidateRepo) {
        this.candidateRepo = candidateRepo;

    }
    @Override
    public <S extends Address> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Address> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Address> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Address> findAll() {
        return null;
    }

    @Override
    public Iterable<Address> findAllById(Iterable<Long> longs) {
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
    public void delete(Address entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Address> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
