package com.catchydreams.dreamcatcher.webservice;

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
    Call<ResponseBody> postDreams(@Nullable @Field("postId") Integer postId,
                                  @Nullable @Field("uid") Integer uid,
                                  @Nullable @Field("dreamRemembered") Integer dreamRemembered,
                                  @Nullable @Field("dreamPeopleName") String dreamPeopleName,
                                  @Nullable @Field("dreamPeopleExist") Integer dreamPeopleExist,
                                  @Nullable @Field("dreamPeopleImpression") Integer dreamPeopleImpression,
                                  @Nullable @Field("dreamSound") Integer dreamSound,
                                  @Nullable @Field("dreamMusical") Integer dreamMusical,
                                  @Nullable @Field("dreamGrayScale") Integer dreamGrayScale,
                                  @Nullable @Field("dreamExperience") Integer dreamExperience,
                                  @Nullable @Field("dreamLucidityLevel") Integer dreamLucidityLevel,
                                  @Nullable @Field("dreamTitle") String dreamTitle,
                                  @Nullable @Field("dreamContent") String dreamContent,
                                  @Nullable @Field("sleepTime") Integer sleepTime,
                                  @Nullable @Field("dayOfWeek") Integer dayOfWeek,
                                  @Nullable @Field("dayOfMonth") Integer dayOfMonth,
                                  @Nullable @Field("dayOfYear") Integer dayOfYear,
                                  @Nullable @Field("weekOfMonth") Integer weekOfMonth,
                                  @Nullable @Field("month") Integer month,
                                  @Nullable @Field("year") Integer year,
                                  @Nullable @Field("interpretation") String interpretation);

    @FormUrlEncoded
    @POST("users/EditDream.php")
    Call<ResponseBody> editDream(@Nullable @Field("postId") Integer postId,
                                 @Nullable @Field("dreamPeopleName") String peopleName,
                                 @Nullable @Field("dreamPeopleExist") Integer peopleExist,
                                 @Nullable @Field("dreamPeopleImpression") Integer peopleImpression,
                                 @Nullable @Field("dreamSound") Integer sound,
                                 @Nullable @Field("dreamMusical") Integer musical,
                                 @Nullable @Field("dreamGrayScale") Integer grayScale,
                                 @Nullable @Field("dreamExperience") Integer dreamExperience,
                                 @Nullable @Field("dreamLucidityLevel") Integer dreamLucidityLevel,
                                 @Nullable @Field("dreamTitle") String dreamTitle,
                                 @Nullable @Field("dreamContent") String dreamContent,
                                 @Nullable @Field("dayOfMonth") Integer dayOfMonth,
                                 @Nullable @Field("month") Integer month,
                                 @Nullable @Field("year") Integer year,
                                 @Nullable @Field("interpretation") String interpretation);

    @FormUrlEncoded
    @POST("users/postsleep.php")
    Call<ResponseBody> postSleeps(@Nullable @Field("uid") Integer uid,
                                  @Nullable @Field("postId") Integer postId,
                                  @Nullable @Field("sleepDuration") String sleepDuration,
                                  @Nullable @Field("sleepTime") Integer sleepTime,
                                  @Nullable @Field("sleepPhysicalActivity") Integer sleepPhysicalActivity,
                                  @Nullable @Field("sleepFoodConsumption") Integer sleepFoodConsumption,
                                  @Nullable @Field("sleepParalysis") Integer sleepParalysis,
                                  @Nullable @Field("dreamRemembered") Integer dreamRemembered,
                                  @Nullable @Field("dayOfWeek") Integer dayOfWeek,
                                  @Nullable @Field("dayOfMonth") Integer dayOfMonth,
                                  @Nullable @Field("dayOfYear") Integer dayOfYear,
                                  @Nullable @Field("weekOfMonth") Integer weekOfMonth,
                                  @Nullable @Field("month") Integer month,
                                  @Nullable @Field("year") Integer year);

    @FormUrlEncoded
    @POST("users/adddatetosleep.php")
    Call<ResponseBody> addDateToSleep(@Nullable @Field("uid") Integer uid,
                                      @Nullable @Field("postId") Integer postId,
                                      @Nullable @Field("dayOfWeek") Integer dayOfWeek,
                                      @Nullable @Field("dayOfMonth") Integer dayOfMonth,
                                      @Nullable @Field("dayOfYear") Integer dayOfYear,
                                      @Nullable @Field("weekOfMonth") Integer weekOfMonth,
                                      @Nullable @Field("month") Integer month,
                                      @Nullable @Field("year") Integer year);

    @FormUrlEncoded
    @POST("users/PostPeople.php")
    Call<ResponseBody> postPeople(@Nullable @Field("postId") Integer postId,
                                  @Nullable @Field("firstPerson") String firstPerson,
                                  @Nullable @Field("firstImpression") Integer firstImpression,
                                  @Nullable @Field("secondPerson") String secondPerson,
                                  @Nullable @Field("secondImpression") Integer secondImpression,
                                  @Nullable @Field("thirdPerson") String thirdPerson,
                                  @Nullable @Field("thirdImpression") Integer thirdImpression,
                                  @Nullable @Field("fourthPerson") String fourthPerson,
                                  @Nullable @Field("fourthImpression") Integer fourthImpression,
                                  @Nullable @Field("fifthPerson") String fifthPerson,
                                  @Nullable @Field("fifthImpression") Integer fifthImpression,
                                  @Nullable @Field("sixthPerson") String sixthPerson,
                                  @Nullable @Field("sixthImpression") Integer sixthImpression,
                                  @Nullable @Field("seventhPerson") String seventhPerson,
                                  @Nullable @Field("seventhImpression") Integer seventhImpression,
                                  @Nullable @Field("eighthPerson") String eighthPerson,
                                  @Nullable @Field("eighthImpression") Integer eighthImpression,
                                  @Nullable @Field("ninthPerson") String ninthPerson,
                                  @Nullable @Field("ninthImpression") Integer ninthImpression,
                                  @Nullable @Field("tenthPerson") String tenthPerson,
                                  @Nullable @Field("tenthImpression") Integer tenthImpression);

    @FormUrlEncoded
    @POST("users/EditPeople.php")
    Call<ResponseBody> editPeople(@Nullable @Field("postId") Integer postId,
                                  @Nullable @Field("firstPerson") String firstPerson,
                                  @Nullable @Field("firstImpression") Integer firstImpression,
                                  @Nullable @Field("secondPerson") String secondPerson,
                                  @Nullable @Field("secondImpression") Integer secondImpression,
                                  @Nullable @Field("thirdPerson") String thirdPerson,
                                  @Nullable @Field("thirdImpression") Integer thirdImpression,
                                  @Nullable @Field("fourthPerson") String fourthPerson,
                                  @Nullable @Field("fourthImpression") Integer fourthImpression,
                                  @Nullable @Field("fifthPerson") String fifthPerson,
                                  @Nullable @Field("fifthImpression") Integer fifthImpression,
                                  @Nullable @Field("sixthPerson") String sixthPerson,
                                  @Nullable @Field("sixthImpression") Integer sixthImpression,
                                  @Nullable @Field("seventhPerson") String seventhPerson,
                                  @Nullable @Field("seventhImpression") Integer seventhImpression,
                                  @Nullable @Field("eighthPerson") String eighthPerson,
                                  @Nullable @Field("eighthImpression") Integer eighthImpression,
                                  @Nullable @Field("ninthPerson") String ninthPerson,
                                  @Nullable @Field("ninthImpression") Integer ninthImpression,
                                  @Nullable @Field("tenthPerson") String tenthPerson,
                                  @Nullable @Field("tenthImpression") Integer tenthImpression);

    @FormUrlEncoded
    @POST("users/PostQEntry.php")
    Call<ResponseBody> postQEntry(@Field("uid") int uid,
                                  @Field("postId") int postId,
                                  @Nullable @Field("q1") Integer q1,
                                  @Nullable @Field("q2") Integer q2,
                                  @Nullable @Field("q3") Integer q3,
                                  @Nullable @Field("q4") Integer q4,
                                  @Nullable @Field("q5") Integer q5,
                                  @Nullable @Field("q6") Integer q6,
                                  @Nullable @Field("q7") Integer q7,
                                  @Nullable @Field("q8") Integer q8,
                                  @Nullable @Field("q9") Integer q9,
                                  @Nullable @Field("q10") Integer q10,
                                  @Nullable @Field("q11") Integer q11,
                                  @Nullable @Field("q12") Integer q12,
                                  @Nullable @Field("q13") Integer q13,
                                  @Nullable @Field("q14") Integer q14,
                                  @Nullable @Field("q15") Integer q15,
                                  @Nullable @Field("q16") Integer q16,
                                  @Nullable @Field("q17") Integer q17,
                                  @Nullable @Field("q18") Integer q18,
                                  @Nullable @Field("q19") Integer q19,
                                  @Nullable @Field("result") Integer result);

    @FormUrlEncoded
    @POST("users/AddLucidityToDream.php")
    Call<ResponseBody> addLucidityToDream(@Field("postId") int postId,
                                          @Field("dreamLucidityLevel") int dreamLucidityLevel);

    @FormUrlEncoded
    @POST("users/AddPostIdToIdQ.php")
    Call<ResponseBody> addPostIdToIdQ(@Field("postId") int postId,
                                      @Field("id") int id);

    @FormUrlEncoded
    @POST("users/DelDream.php")
    Call<ResponseBody> delDream(@Field("postId") int postId);

    @GET("users/QResult.php")
    Call<ResponseBody> getQResult(@Query("postId") int postId);

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

    @GET("users/AllDreams.php")
    Call<ResponseBody> getAllDreams(@Query("uid") int uid);

    @GET("users/alldreamprops.php")
    Call<ResponseBody> getDreamProps(@Query("postId") int postId);

    @GET("users/AllSleepProps.php")
    Call<ResponseBody> getSleepProps(@Query("postId") int postId);

    @GET("users/PeopleProps.php")
    Call<ResponseBody> getPeopleProps(@Query("postId") int postId);


}
