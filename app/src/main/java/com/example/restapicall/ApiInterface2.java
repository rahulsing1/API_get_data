package com.example.restapicall;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface2 {
    @FormUrlEncoded
    @POST("/api/users")
    Call<user>getuserinformation(@Field("name")String name ,@Field("job")String job );
}
