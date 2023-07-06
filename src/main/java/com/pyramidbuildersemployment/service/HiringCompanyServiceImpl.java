package com.pyramidbuildersemployment.service;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import com.pyramidbuildersemployment.HiringCompanyNullException;
import com.pyramidbuildersemployment.models.HiringCompany;
import com.pyramidbuildersemployment.models.JobListing;
import com.pyramidbuildersemployment.repository.HiringRepoInterface;
import com.pyramidbuildersemployment.repository.JobListingRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HiringCompanyServiceImpl implements HiringCompanyService {
    private final String hiringCompanyId = null;
    @Autowired
    private GoogleMapsService googleMapsService;

    @Autowired
    private HiringRepoInterface hiringRepoInterface;


//    @Autowired
//   private JobListing jobListing; // assume a new JobListing is created, replace with actual code if different



    @Autowired
    private JobListingRepoInterface jobListingRepoInterface;
    public HiringCompanyServiceImpl(HiringRepoInterface hiringRepoInterface) {
        this.hiringRepoInterface = hiringRepoInterface;
    }

    public List<HiringCompany> getAllHiringCompanies() {
        return (List<HiringCompany>) hiringRepoInterface.findAll();
    }

    public List<HiringCompany> getHiringCompaniesByLocation(String location, int radiusInMeters) {
        LatLng locationLatLng = googleMapsService.getLatLngFromAddress(location);
        List<HiringCompany> allHiringCompanies = getAllHiringCompanies();

        return allHiringCompanies.stream()
                .filter(company -> isWithinRadius(company, locationLatLng, radiusInMeters))
                .collect(Collectors.toList());
    }

    private boolean isWithinRadius(HiringCompany company, LatLng location, int radiusInMeters) {
        LatLng companyLatLng = new LatLng(company.getLatitude(), company.getLongitude());
        DistanceMatrix distanceMatrix = DistanceMatrixApi.newRequest(googleMapsService.getGeoApiContext())
                .origins(location)
                .destinations(companyLatLng)
                .awaitIgnoreError();

        long distanceInMeters = distanceMatrix.rows[0].elements[0].distance.inMeters;
        return distanceInMeters <= radiusInMeters;
    }

    @Override
    public List<HiringCompany> getAllAllHiringCompanies() {
        return (List<HiringCompany>) hiringRepoInterface.findAll();
    }

    @Override
    public HiringCompany getHiringCompanyById() {
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


    public void CreateJobListing(Long hiringCompanyID ) throws HiringCompanyNullException  {
       // Long hiringCompanyId1 = getHiringCompanyById().getId(); // replace this with the actual code for getting the id
        JobListing jobListing = new JobListing();
        Optional<HiringCompany> optionalHiringCompany = hiringRepoInterface.findById(hiringCompanyID);

        if (optionalHiringCompany.isPresent()) {
            HiringCompany hiringCompany = optionalHiringCompany.get();
            jobListing.setHiringCompany(hiringCompany);
        } else {
            throw new HiringCompanyNullException("Hiring company with ID: " + hiringCompanyID + " is null.");
        }

        jobListingRepoInterface.save(jobListing);


    }
}



/*

Click on the "File" menu.
Click on "Invalidate Caches / Restart..."
Click on "Invalidate and Restart"
 */
