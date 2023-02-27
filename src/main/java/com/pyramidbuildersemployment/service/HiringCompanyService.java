package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.models.Experience;
import com.pyramidbuildersemployment.models.HiringCompany;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  HiringCompanyService   {

    List<HiringCompanyService> getAllAllHiringCompanies();

    HiringCompany getHiringCompanyById(long id);

    HiringCompany saveAll(HiringCompany hiringCompany);

    HiringCompany updateHiringCompany(HiringCompany hiringCompany);

    void deleteHiringCompany(long id);
    public HiringCompany registerhiringCompany(HiringCompany hiringCompany);
    
}
