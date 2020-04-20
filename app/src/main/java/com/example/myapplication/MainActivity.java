package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.service.autofill.AutofillService;
import android.util.Log;

import com.example.myapplication.adapter.PhotoAdapter;
import com.example.myapplication.api_interface.ApiInterface;
import com.example.myapplication.models.UserModel;
import com.example.myapplication.models.userPhotos;
import com.example.myapplication.network.NetworkClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    PhotoAdapter adapter;
    userPhotos photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.photo_recycler);

        getphotos();
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

       public void getphotos(){
        ApiInterface client = NetworkClient.getRetrfitClient().create(ApiInterface.class);
        Call<userPhotos> Call;
        Call= client.getPhotos();
        Call.enqueue(new Callback<userPhotos>() {
            @Override
            public void onResponse(retrofit2.Call<userPhotos> call, Response<userPhotos> response) {
                Log.e("response", response.body().toString());
                photos = response.body();
                adapter = new PhotoAdapter(MainActivity.this,photos);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(retrofit2.Call<userPhotos> call, Throwable t) {
               Log.e( "error",t.toString());
            }
        });
       }



}
