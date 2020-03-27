package com.phrenologue.dreamcatcherapp.webservice;

import androidx.annotation.Nullable;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IPostService {
    @FormUrlEncoded
    @POST("users/postdream.php")
    Call<ResponseBody> postDreams(@Field("postId") int postId,
                                  @Field("uid") int uid,
                                  @Field("dreamRemembered") int dreamRemembered,
                                  @Field("dreamPeopleName") String dreamPeopleName,
                                  @Field("dreamPeopleExist") int dreamPeopleExist,
                                  @Field("dreamPeopleImpression") int dreamPeopleImpression,
                                  @Field("dreamSound") int dreamSound,
                                  @Field("dreamMusical") int dreamMusical,
                                  @Field("dreamGrayScale") int dreamGrayScale,
                                  @Field("dreamExperience") int dreamExperience,
                                  @Field("dreamLucidityLevel") int dreamLucidityLevel,
                                  @Field("dreamTitle") String dreamTitle,
                                  @Field("dreamContent") String dreamContent,
                                  @Field("dayOfWeek") int dayOfWeek,
                                  @Field("dayOfMonth") int dayOfMonth,
                                  @Field("dayOfYear") int dayOfYear,
                                  @Field("weekOfMonth") int weekOfMonth,
                                  @Field("month") int month,
                                  @Field("year") int year,
                                  @Field("interpretation") String interpretation);

    @FormUrlEncoded
    @POST("users/postsleep.php")
    Call<ResponseBody> postSleeps(@Nullable @Field("uid") int uid,
                                  @Nullable @Field("postId") int postId,
                                  @Nullable @Field("sleepDuration") String sleepDuration,
                                  @Nullable @Field("sleepTime") int sleepTime,
                                  @Nullable @Field("sleepPhysicalActivity") int sleepPhysicalActivity,
                                  @Nullable @Field("sleepFoodConsumption") int sleepFoodConsumption,
                                  @Nullable @Field("sleepParalysis") int sleepParalysis,
                                  @Nullable @Field("dreamRemembered") int dreamRemembered,
                                  @Nullable @Field("dayOfWeek") int dayOfWeek,
                                  @Nullable @Field("dayOfMonth") int dayOfMonth,
                                  @Nullable @Field("dayOfYear") int dayOfYear,
                                  @Nullable @Field("weekOfMonth") int weekOfMonth,
                                  @Nullable @Field("month") int month,
                                  @Nullable @Field("year") int year);

    @FormUrlEncoded
    @POST("users/adddatetosleep.php")
    Call<ResponseBody> addDateToSleep(@Nullable @Field("uid") int uid,
                                      @Nullable @Field("postId") int postId,
                                      @Nullable @Field("dayOfWeek") int dayOfWeek,
                                      @Nullable @Field("dayOfMonth") int dayOfMonth,
                                      @Nullable @Field("dayOfYear") int dayOfYear,
                                      @Nullable @Field("weekOfMonth") int weekOfMonth,
                                      @Nullable @Field("month") int month,
                                      @Nullable @Field("year") int year);

    @GET("users/PercentRemembered.php")
    Call<ResponseBody> getRemembered(@Query("uid") int uid);

    @GET("users/DailyMood.php")
    Call<ResponseBody> getDailyMood(@Query("uid") int uid);

    @GET("users/PercentSound.php")
    Call<ResponseBody> getSound(@Query("uid") int uid);

    @GET("users/PercentMusical.php")
    Call<ResponseBody> getMusical(@Query("uid") int uid);

    @GET("users/PercentColorful.php")
    Call<ResponseBody> getGrayScale(@Query("uid") int uid);

    @GET("users/PercentMood.php")
    Call<ResponseBody> getMood(@Query("uid") int uid);

    @GET("users/PercentLucidity.php")
    Call<ResponseBody> getLucidity(@Query("uid") int uid);

    @GET("users/DreamDescription.php")
    Call<ResponseBody> getDescription(@Query("uid") int uid);
}
