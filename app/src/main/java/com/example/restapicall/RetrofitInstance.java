package com.example.restapicall;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public   class RetrofitInstance {
   public static RetrofitInstance instance;
    String url = "https://jsonplaceholder.typicode.com/photos/";
    ApiInterface apiInterface;

    RetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }


    public static RetrofitInstance getInstance() {
        if (instance == null) {
            instance = new RetrofitInstance();

        }
        return instance;
    }



}
