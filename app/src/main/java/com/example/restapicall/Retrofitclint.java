package com.example.restapicall;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitclint {
    public static Retrofit retrofit;

    public static Retrofit getRetrofitinstante() {
      if (retrofit==null)
          retrofit=new Retrofit.Builder()
                  .baseUrl("https://reqres.in/")
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();
      return  retrofit;
    }
}
