package com.example.stud.musicapp.api;

import retrofit2.Retrofit;

public class apiService {
    public static apiClient getService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.theaudiodb.com/api/v1/json/1/")
                .build();

        return retrofit.create(apiClient.class);


    }

}
