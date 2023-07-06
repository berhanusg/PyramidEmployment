package com.pyramidbuildersemployment.service;

//import com.pyramidbuildersemployment.models.Experience;
import com.pyramidbuildersemployment.models.HiringCompany;

import java.util.List;

public interface  HiringCompanyService   {

    List<HiringCompany> getAllAllHiringCompanies();

    HiringCompany getHiringCompanyById();

    HiringCompany saveAll(HiringCompany hiringCompany);

    HiringCompany updateHiringCompany(HiringCompany hiringCompany);

    void deleteHiringCompany(long id);
    public HiringCompany registerhiringCompany(HiringCompany hiringCompany);
    
}
