package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.PbbackendApplication;
import com.pyramidbuildersemployment.models.JobListing;
import com.pyramidbuildersemployment.repository.JobListingRepoInterface;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest(classes = PbbackendApplication.class)
//public class JobListingServiceImplTest {
//@Autowired
//JobListingRepoInterface jobListingRepoInterface;
//@Autowired
//JobListingService jobListingService;

//@Test
//public void JobListingServiceImplTest(){
//    List<JobListing> joblist = jobListingService.searchJobListings(  "Cook", "Seattle", 80000.00);
// //   assertThat(jobList).isNotNull();
//
//    for(int i =0; i<joblist.size(); i++){
//
//        System.out.println(joblist.get(i).toString());
//    }
//   // System.out.println((joblist.toArray()));
//}


//    class JobListingServiceTest {
//
//        @Mock
//        @Autowired
//        private JobListingRepoInterface jobListingRepoInterface;
//
//        @InjectMocks
//        @Autowired
//        private JobListingService jobListingService;
//
//        @BeforeEach
//        void setUp() throws Exception {
//            MockitoAnnotations.initMocks(this);
//        }

//        @Test
//        void testSearchJobListings() {
//            String jobTitle = "Engineer";
//            String location = "San Francisco";
//            Double salary = 80000.0;

//           String jobListing1 = new JobListing( "Software Engineer", "Java developer", 90000.0, "San Francisco");
//            JobListing jobListing2 = new JobListing( "Electrical Engineer", "Circuit design", 85000.0, "San Francisco");
//            JobListing jobListing3 = new JobListing( "Mechanical Engineer", "Product design", 80000.0, "Los Angeles");
//
//            List<JobListing> jobListings = new ArrayList<>();
//            jobListings.add(jobListing1);
//            jobListings.add(jobListing2);
//
//            Mockito.when(jobListingRepoInterface.findByJobTitleContainingIgnoreCase(jobTitle)).thenReturn(jobListings);
//            Mockito.when(jobListingRepoInterface.findByLocationContainingIgnoreCase(location)).thenReturn(jobListings);
//            Mockito.when(jobListingRepoInterface.findBySalaryGreaterThanEqual(salary)).thenReturn(jobListings);
//
//            List<JobListing> result = jobListingService.searchJobListings(jobTitle, location, salary);
//
//            assertNotNull(result);
//            assertEquals(2, result.size());
//        }
//    }
//
