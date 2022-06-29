package com.bytesoft.api2retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static String BASE_URL="https://reqres.in/";

    public static Retrofit getRetrofitInstance() {

        if (retrofit == null){

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
        return retrofit;


    }
}
