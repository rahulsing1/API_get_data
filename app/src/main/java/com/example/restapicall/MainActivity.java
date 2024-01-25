package com.example.restapicall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.restapicall.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity   {
    List<Usermodel> alluserList;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.recycaler.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        RetrofitInstance.getInstance().apiInterface.getUsers().enqueue(new Callback<List<Usermodel>>() {
            @Override
            public void onResponse(Call<List<Usermodel>> call, Response<List<Usermodel>> response) {
                alluserList = response.body();

                for (int i = 0; i < alluserList.size(); i++) {

                    Log.d("DAta", "onResponse: " + alluserList.get(i).getTitle());

                    binding.recycaler.setAdapter(new userAdapter(MainActivity.this,alluserList));
                }
            }

            @Override
            public void onFailure(Call<List<Usermodel>> call, Throwable t) {

            }
        });



    }
}