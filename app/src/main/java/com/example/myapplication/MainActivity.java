package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.api_interface.ApiInterface;
import com.example.myapplication.models.UserModel;
import com.example.myapplication.network.NetworkClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getUsers();
        }

       private void getUsers(){
           ApiInterface client =  NetworkClient.getRetrfitClient().create(ApiInterface.class);
           Call<UserModel> call;
           call = client.getUsers();
           call.enqueue(new Callback<UserModel>() {
               @Override
               public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                   Log.e("response",response.body().toString());

               }

               @Override
               public void onFailure(Call<UserModel> call, Throwable t) {
                   Log.e("error",t.toString());

               }
           });
       }



}
