package com.phrenologue.dreamcatcherapp.webservice;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IUserService {

    @GET("login.php")
    Call<ResponseBody> login(@Query("username") String user, @Query("password") String pass);



    @FormUrlEncoded
    @POST("signup.php")
    Call<ResponseBody> signUp(@Field("username") String user, @Field("password") String pass,
                              @Field("uid") int uid);

}
