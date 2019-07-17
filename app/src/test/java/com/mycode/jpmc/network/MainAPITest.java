package com.mycode.jpmc.network;

import com.mycode.jpmc.entity.HighSchools;
import com.mycode.jpmc.entity.SATResults;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

import static org.junit.jupiter.api.Assertions.*;

class MainAPITest {
    @Mock
    private MainAPI mainAPI;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getHighschoolAPITest(){
        List<HighSchools> highSchools = new ArrayList<>();
        Flowable<List<HighSchools>> returnData = Flowable.just(highSchools);
        Mockito.when(mainAPI.getHighSchools()).thenReturn(returnData);
        List<HighSchools> returnValue = mainAPI.getHighSchools().blockingFirst();
        Mockito.verify(mainAPI).getHighSchools();
        Mockito.verifyNoMoreInteractions(mainAPI);
        Assertions.assertNotNull(returnValue);
    }

    @Test
    public void getSATresultAPITest(){
        List<SATResults> results = new ArrayList<>();
        Flowable<List<SATResults>> returnData = Flowable.just(results);
        Mockito.when(mainAPI.getSATResults()).thenReturn(returnData);
        List<SATResults> returnValue = mainAPI.getSATResults().blockingFirst();
        Mockito.verify(mainAPI).getSATResults();
        Mockito.verifyNoMoreInteractions(mainAPI);
        Assertions.assertNotNull(returnValue);
    }
}