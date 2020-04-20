package com.example.myapplication.api_interface;

import com.example.myapplication.models.UserModel;
import com.example.myapplication.models.userPhotos;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("users")
    Call<UserModel> getUsers();
    @GET("photos")
    Call<userPhotos> getPhotos();

}
