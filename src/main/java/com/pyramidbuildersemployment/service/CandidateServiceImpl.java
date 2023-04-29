package com.pyramidbuildersemployment.service;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.models.JobListing;
import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.repository.CandidateRepoInterface;
import com.pyramidbuildersemployment.repository.JobListingRepoInterface;
import com.pyramidbuildersemployment.repository.ProffessionRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateServiceImpl implements CandidateService{


    @Autowired
    private GoogleMapsService googleMapsService;
    @Autowired
    private  CandidateRepoInterface candidateReepointerface;

    @Autowired
    private ProffessionRepoInterface proffessionRepoInterface;

    @Autowired
    private JobListingRepoInterface jobListingRepoInterface;
    public CandidateServiceImpl(CandidateRepoInterface candidateReepointerface) {
        this.candidateReepointerface = candidateReepointerface;
    }

    public CandidateServiceImpl() {

    }


    public List<Candidate> getCandidatesByLocation(String location, int radiusInMeters) {
        LatLng locationLatLng = getLatLngFromAddress(location);
        List<Candidate> allCandidates = getAllCandidates();

        return allCandidates.stream()
                .filter(candidate -> isWithinRadius(candidate, locationLatLng, radiusInMeters))
                .collect(Collectors.toList());
    }
    //implement the getLatLngFromAddress method to convert the provided address to a LatLng object
   // using the Google Maps API. The getCandidatesByLocation method will filter candidates based on
    // their distance from the specified location within the given radius.
    private LatLng getLatLngFromAddress(String address) {
        // Implement the logic to get latitude and longitude from address using Google Maps API
        return googleMapsService.getLatLngFromAddress(address);
    }

    private boolean isWithinRadius(Candidate candidate, LatLng location, int radiusInMeters) {
        LatLng candidateLatLng = new LatLng(candidate.getLatitude(), candidate.getLongitude());
        DistanceMatrix distanceMatrix = DistanceMatrixApi.newRequest(googleMapsService.getGeoApiContext())
                .origins(location)
                .destinations(candidateLatLng)
                .awaitIgnoreError();

        long distanceInMeters = distanceMatrix.rows[0].elements[0].distance.inMeters;
        return distanceInMeters <= radiusInMeters;
    }
    @Override
    public List<Candidate> getAllCandidates() {
        return (List<Candidate>) candidateReepointerface.findAll();
    }

    @Override
    public Candidate getCandidateById(long id) {
        return null;
    }

    @Override
    public Candidate saveAll(Candidate candidate) {
        return null;
    }


    @Override
    public Candidate updateCandidate(Candidate candidate) {
        return null;
    }

    @Override
    public void deleteCandidate(long id) {
       deleteCandidate(id);
    }

    public Candidate registerCandidate(Candidate candidate) {
        return candidateReepointerface.save(candidate);
    }


    public List<Candidate> getCandidatesWithJobQualification(Long jobListingId) {


        // Retrieve the JobListing entity using the jobListingId
        Optional<JobListing> jobListingOptional = jobListingRepoInterface.findById(jobListingId);

        List<Profession> professions;
        if (jobListingOptional.isPresent()) {
            JobListing jobListing = jobListingOptional.get();

            // Your logic for getting candidates with job qualification goes here
            professions = jobListing.getProfessions();

        } else {
            // Handle the case when the job listing is not found
            return new ArrayList<>();
        }


        // Get the professions associated with the job listing
        //   List<Profession> professions = jobListing.getProfessions();

        // Create a list to store the candidates with the specific job qualification
        List<Candidate> candidates = new ArrayList<>();

        // Iterate over the professions and add their candidates to the list
        for (Profession profession : professions) {
            candidates.addAll(profession.getCandidates());
        }

        return candidates;
    }


}

/*
The getCandidatesByLocation method filters the list of candidates based on their distance from the specified location within the given radius.

Here's a brief overview of the method's steps:

Convert the provided location (address) to latitude and longitude using the getLatLngFromAddress method.
This method uses the Google Maps Geocoding API to get the coordinates of the address.

Retrieve the list of all candidates with the getAllCandidates method.

Filter the list of candidates using a Stream and the filter method.
 For each candidate, the isWithinRadius method checks if they are within the specified radius.

The isWithinRadius method calculates the distance between the location and the candidate's coordinates using the Google Maps Distance Matrix API. If the distance is less than or equal to the radius, the method returns true, and the candidate is included in the filtered list.

Finally, the filtered list of candidates is collected using collect(Collectors.toList()).


 */
