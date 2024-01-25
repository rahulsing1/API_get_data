package com.example.restapicall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.restapicall.databinding.ActivityMain2Binding;
import com.example.restapicall.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.d("TAG", "Enter : "   );
        binding.btnpost.setOnClickListener(view -> {
            btnsendpostrequestclick();
        });

        binding.btnsentgetactivity.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity2.this,MainActivity.class);
            startActivity(intent);
        });
    }
    private void btnsendpostrequestclick() {
        ApiInterface2 apiInterface2 = Retrofitclint.getRetrofitinstante().create(ApiInterface2.class);
        String name=binding.name.getText().toString();
        String job=binding.job.getText().toString();
        Call<user> call = apiInterface2.getuserinformation(name, job);
         binding.viewjob.setText(job);
        binding.viewname.setText(name);
      //  Log.d("binding.name.setText(name);", "Name: "binding.viewname);
        call.enqueue(new Callback<user>() {
            @Override
            public void onResponse(Call<user> call, Response<user> response) {
                Log.d("TAG", "onResponse: " + response.code());
                Log.d("TAG", "onResponse: " + response.body());
                Log.d("getCreatedAt", "getCreatedAt: " + response.body().getCreatedAt());
                Log.d("Job", "Job: " + response.body().getJob());
                Log.d("Name", "Name: " + response.body().getName());
            }
            @Override
            public void onFailure(Call<user> call, Throwable t) {
                Log.e("TAG", "error gfghfbgfnbhf: " + t.getMessage());
            }
        });
    }
}