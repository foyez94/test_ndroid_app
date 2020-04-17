package com.example.myapplication.api_interface;

import com.example.myapplication.models.UserModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("users")
    Call<UserModel> getUsers();
}
