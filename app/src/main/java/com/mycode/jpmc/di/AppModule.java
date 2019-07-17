package com.mycode.jpmc.di;

import com.mycode.jpmc.network.MainAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//contains dependencies that are needed for the entire application
@Module
public class AppModule {

    //provides a retrofit instance throughout the whole app

    @Singleton
    @Provides
    static Retrofit provideRetrofitHighSchools(){
        HttpLoggingInterceptor intercept = new HttpLoggingInterceptor();
        intercept.setLevel((HttpLoggingInterceptor.Level.BODY)) ;
        OkHttpClient client  = new OkHttpClient.Builder().addInterceptor(intercept).build();
        Retrofit retro = new Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        return retro;
    }

    @Singleton
    @Provides
    static MainAPI provideMainAPI(Retrofit retrofit){
        return retrofit.create(MainAPI.class);
    }
}
