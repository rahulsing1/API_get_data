package com.example.restapicall;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("/photos")
    Call<List<Usermodel>> getUsers();


    @POST
    Call<Post>createpost(@Body POST post);
}
