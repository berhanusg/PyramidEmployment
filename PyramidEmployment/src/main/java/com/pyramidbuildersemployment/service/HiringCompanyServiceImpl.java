package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.models.HiringCompany;

import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.repository.HiringRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HiringCompanyServiceImpl implements HiringCompanyService{



    @Autowired
    private  HiringRepoInterface hiringRepoInterface;;

    public HiringCompanyServiceImpl(HiringRepoInterface hiringRepoInterface) {
        this.hiringRepoInterface = hiringRepoInterface;
    }


    @Override
    public List<HiringCompany> getAllAllHiringCompanies() {
         return (List<HiringCompany>) hiringRepoInterface.findAll();
    }

    @Override
    public HiringCompany getHiringCompanyById(long id) {
        return null;
    }

    @Override
    public HiringCompany saveAll(HiringCompany hiringCompany) {
        return null;
    }

    @Override
    public HiringCompany updateHiringCompany(HiringCompany hiringCompany) {
        return null;
    }

    @Override
    public void deleteHiringCompany(long id) {

    }

    @Override
    public HiringCompany registerhiringCompany(HiringCompany hiringCompany) {
        return hiringRepoInterface.save(hiringCompany);
    }
    }




