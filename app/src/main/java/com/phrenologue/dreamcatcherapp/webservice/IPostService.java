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
    @POST("users/EditDream.php")
    Call<ResponseBody> editDream(@Field("postId") int postId,
                                 @Field("dreamPeopleName") String peopleName,
                                 @Field("dreamPeopleExist") int peopleExist,
                                 @Field("dreamPeopleImpression") int peopleImpression,
                                 @Field("dreamSound") int sound,
                                 @Field("dreamMusical") int musical,
                                 @Field("dreamGrayScale") int grayScale,
                                 @Field("dreamExperience") int dreamExperience,
                                 @Field("dreamLucidityLevel") int dreamLucidityLevel,
                                 @Field("dreamTitle") String dreamTitle,
                                 @Field("dreamContent") String dreamContent,
                                 @Field("dayOfMonth") int dayOfMonth,
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

    @FormUrlEncoded
    @POST("users/PostPeople.php")
    Call<ResponseBody> postPeople(@Field("postId") int postId,
                                  @Field("firstPerson") String firstPerson,
                                  @Field("firstImpression") int firstImpression,
                                  @Field("secondPerson") String secondPerson,
                                  @Field("secondImpression") int secondImpression,
                                  @Field("thirdPerson") String thirdPerson,
                                  @Field("thirdImpression") int thirdImpression,
                                  @Field("fourthPerson") String fourthPerson,
                                  @Field("fourthImpression") int fourthImpression,
                                  @Field("fifthPerson") String fifthPerson,
                                  @Field("fifthImpression") int fifthImpression,
                                  @Field("sixthPerson") String sixthPerson,
                                  @Field("sixthImpression") int sixthImpression,
                                  @Field("seventhPerson") String seventhPerson,
                                  @Field("seventhImpression") int seventhImpression,
                                  @Field("eighthPerson") String eighthPerson,
                                  @Field("eighthImpression") int eighthImpression,
                                  @Field("ninthPerson") String ninthPerson,
                                  @Field("ninthImpression") int ninthImpression,
                                  @Field("tenthPerson") String tenthPerson,
                                  @Field("tenthImpression") int tenthImpression);

    @FormUrlEncoded
    @POST("users/EditPeople.php")
    Call<ResponseBody> editPeople(@Field("postId") int postId,
                                  @Field("firstPerson") String firstPerson,
                                  @Field("firstImpression") int firstImpression,
                                  @Field("secondPerson") String secondPerson,
                                  @Field("secondImpression") int secondImpression,
                                  @Field("thirdPerson") String thirdPerson,
                                  @Field("thirdImpression") int thirdImpression,
                                  @Field("fourthPerson") String fourthPerson,
                                  @Field("fourthImpression") int fourthImpression,
                                  @Field("fifthPerson") String fifthPerson,
                                  @Field("fifthImpression") int fifthImpression,
                                  @Field("sixthPerson") String sixthPerson,
                                  @Field("sixthImpression") int sixthImpression,
                                  @Field("seventhPerson") String seventhPerson,
                                  @Field("seventhImpression") int seventhImpression,
                                  @Field("eighthPerson") String eighthPerson,
                                  @Field("eighthImpression") int eighthImpression,
                                  @Field("ninthPerson") String ninthPerson,
                                  @Field("ninthImpression") int ninthImpression,
                                  @Field("tenthPerson") String tenthPerson,
                                  @Field("tenthImpression") int tenthImpression);

    @FormUrlEncoded
    @POST("users/PostQEntry.php")
    Call<ResponseBody> postQEntry(@Field("uid") int uid,
                                  @Field("postId") int postId,
                                  @Field("q1") int q1,
                                  @Field("q2") int q2,
                                  @Field("q3") int q3,
                                  @Field("q4") int q4,
                                  @Field("q5") int q5,
                                  @Field("q6") int q6,
                                  @Field("q7") int q7,
                                  @Field("q8") int q8,
                                  @Field("q9") int q9,
                                  @Field("q10") int q10,
                                  @Field("q11") int q11,
                                  @Field("q12") int q12,
                                  @Field("q13") int q13,
                                  @Field("q14") int q14,
                                  @Field("q15") int q15,
                                  @Field("q16") int q16,
                                  @Field("q17") int q17,
                                  @Field("q18") int q18,
                                  @Field("q19") int q19,
                                  @Field("result") int result);

    @FormUrlEncoded
    @POST("users/AddLucidityToDream.php")
    Call<ResponseBody> addLucidityToDream(@Field("postId") int postId,
                                          @Field("dreamLucidityLevel") int dreamLucidityLevel);

    @FormUrlEncoded
    @POST("users/AddPostIdToIdQ.php")
    Call<ResponseBody> addPostIdToIdQ(@Field("postId") int postId,
                                      @Field("id") int id);

    @GET("users/DreamSleepQuestCounts.php")
    Call<ResponseBody> getDreamSleepQuestCounts(@Query("uid") int uid);

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

    @GET("users/alldreamprops.php")
    Call<ResponseBody> getDreamProps(@Query("postId") int postId);

    @GET("users/PeopleProps.php")
    Call<ResponseBody> getPeopleProps(@Query("postId") int postId);

}
