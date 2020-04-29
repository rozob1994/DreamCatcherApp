package com.catchydreams.dreamcatcher.webservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    private static final String KEY_URL = "http://phrenologue.com/api/";

    public static Retrofit getRetrofit(){
        if (retrofit == null ){
            retrofit = new Retrofit.Builder().baseUrl(KEY_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
