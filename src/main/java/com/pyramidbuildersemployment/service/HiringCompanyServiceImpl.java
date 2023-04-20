package com.pyramidbuildersemployment.service;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import com.pyramidbuildersemployment.models.HiringCompany;
import com.pyramidbuildersemployment.repository.HiringRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HiringCompanyServiceImpl implements HiringCompanyService{

    @Autowired
    private GoogleMapsService googleMapsService;

    @Autowired
    private  HiringRepoInterface hiringRepoInterface;;

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




