package com.mycode.jpmc.network;

import com.mycode.jpmc.entity.HighSchools;
import com.mycode.jpmc.entity.SATResults;

import java.util.List;
import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface MainAPI {
    @GET("s3k6-pzi2.json")
    Flowable<List<HighSchools>> getHighSchools();

    @GET("f9bf-2cp4.json")
    Flowable<List<SATResults>> getSATResults();
}
