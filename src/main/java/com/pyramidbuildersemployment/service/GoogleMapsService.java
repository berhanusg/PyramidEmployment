package com.pyramidbuildersemployment.service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GoogleMapsService {

    @Value("${google-maps.api-key}")
    private String apiKey;

    public GeoApiContext getGeoApiContext() {
        return new GeoApiContext.Builder().apiKey(apiKey).build();
    }
    public LatLng getLatLngFromAddress(String address) {
        GeoApiContext context = getGeoApiContext();
        try {
            GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
            if (results != null && results.length > 0) {
                return results[0].geometry.location;
            }
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
