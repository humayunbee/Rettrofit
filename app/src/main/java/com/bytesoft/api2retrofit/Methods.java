package com.bytesoft.api2retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Methods {


    @GET("api/users?pag=2")
    Call<Model> getAllData();

                        }
