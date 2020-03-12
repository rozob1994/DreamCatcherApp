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
                                  @Field("year") int year);

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

    @GET("posts/dream/daily.php")
    Call<ResponseBody> getDreamsDaily(@Query("uid") int uid);

    @GET("posts/dream/weekly.php")
    Call<ResponseBody> getDreamsWeekly(@Query("uid") int uid);

    @GET("posts/dream/monthly.php")
    Call<ResponseBody> getDreamsMonthly(@Query("uid") int uid);

    @GET("posts/dream/checklist/daily.php")
    Call<ResponseBody> getDreamCheckListDaily(@Query("uid") int uid);

    @GET("posts/dream/checklist/weekly.php")
    Call<ResponseBody> getDreamCheckListWeekly(@Query("uid") int uid);

    @GET("posts/dream/checklist/monthly.php")
    Call<ResponseBody> getDreamCheckListMonthly(@Query("uid") int uid);

    @GET("posts/dream/checklist/dailyrelated/daily.php")
    Call<ResponseBody> getDreamCheckListRelatedDaily(@Query("uid") int uid);

    @GET("posts/dream/checklist/dailyrelated/weekly.php")
    Call<ResponseBody> getDreamCheckListRelatedWeekly(@Query("uid") int uid);

    @GET("posts/dream/checklist/dailyrelated/monthly.php")
    Call<ResponseBody> getDreamCheckListRelatedMonthly(@Query("uid") int uid);

    @GET("posts/dream/checklist/experience/daily.php")
    Call<ResponseBody> getDreamCheckListExperienceDaily(@Query("uid") int uid);

    @GET("posts/dream/checklist/experience/weekly.php")
    Call<ResponseBody> getDreamCheckListExperienceWeekly(@Query("uid") int uid);

    @GET("posts/dream/checklist/experience/monthly.php")
    Call<ResponseBody> getDreamCheckListExperienceMonthly(@Query("uid") int uid);

    @GET("posts/dream/checklist/falseawake/daily.php")
    Call<ResponseBody> getDreamCheckListFalseAwakeDaily(@Query("uid") int uid);

    @GET("posts/dream/checklist/falseawake/weekly.php")
    Call<ResponseBody> getDreamCheckListFalseAwakeWeekly(@Query("uid") int uid);

    @GET("posts/dream/checklist/falseawake/monthly.php")
    Call<ResponseBody> getDreamCheckListFalseAwakeMonthly(@Query("uid") int uid);

    @GET("posts/dream/checklist/grayscale/daily.php")
    Call<ResponseBody> getDreamCheckListGrayScaleDaily(@Query("uid") int uid);

    @GET("posts/dream/checklist/grayscale/weekly.php")
    Call<ResponseBody> getDreamCheckListGrayScaleWeekly(@Query("uid") int uid);

    @GET("posts/dream/checklist/grayscale/monthly.php")
    Call<ResponseBody> getDreamCheckListGrayScaleMonthly(@Query("uid") int uid);

    @GET("posts/dream/checklist/remembered/daily.php")
    Call<ResponseBody> getDreamCheckListRememberedDaily(@Query("uid") int uid);

    @GET("posts/dream/checklist/remembered/weekly.php")
    Call<ResponseBody> getDreamCheckListRememberedWeekly(@Query("uid") int uid);

    @GET("posts/dream/checklist/remembered/monthly.php")
    Call<ResponseBody> getDreamCheckListRememberedMonthly(@Query("uid") int uid);

    @GET("posts/dream/description/daily.php")
    Call<ResponseBody> getDreamDescriptionDaily(@Query("uid") int uid);

    @GET("posts/dream/description/weekly.php")
    Call<ResponseBody> getDreamDescriptionWeekly(@Query("uid") int uid);

    @GET("posts/dream/description/monthly.php")
    Call<ResponseBody> getDreamDescriptionMonthly(@Query("uid") int uid);

    @GET("posts/dream/description/content/daily.php")
    Call<ResponseBody> getDreamDescriptionContentDaily(@Query("uid") int uid);

    @GET("posts/dream/description/content/weekly.php")
    Call<ResponseBody> getDreamDescriptionContentWeekly(@Query("uid") int uid);

    @GET("posts/dream/description/content/monthly.php")
    Call<ResponseBody> getDreamDescriptionContentMonthly(@Query("uid") int uid);

    @GET("posts/dream/description/title/daily.php")
    Call<ResponseBody> getDreamDescriptionTitleDaily(@Query("uid") int uid);

    @GET("posts/dream/description/title/weekly.php")
    Call<ResponseBody> getDreamDescriptionTitleWeekly(@Query("uid") int uid);

    @GET("posts/dream/description/title/monthly.php")
    Call<ResponseBody> getDreamDescriptionTitleMonthly(@Query("uid") int uid);

    @GET("posts/dream/lucidity/daily.php")
    Call<ResponseBody> getDreamLucidityDaily(@Query("uid") int uid);

    @GET("posts/dream/lucidity/weekly.php")
    Call<ResponseBody> getDreamLucidityWeekly(@Query("uid") int uid);

    @GET("posts/dream/lucidity/monthly.php")
    Call<ResponseBody> getDreamLucidityMonthly(@Query("uid") int uid);

    @GET("posts/dream/lucidity/lucid/daily.php")
    Call<ResponseBody> getDreamLucidityLucidDaily(@Query("uid") int uid);

    @GET("posts/dream/lucidity/lucid/weekly.php")
    Call<ResponseBody> getDreamLucidityLucidWeekly(@Query("uid") int uid);

    @GET("posts/dream/lucidity/lucid/monthly.php")
    Call<ResponseBody> getDreamLucidityLucidMonthly(@Query("uid") int uid);

    @GET("posts/dream/lucidity/luciditylevel/daily.php")
    Call<ResponseBody> getDreamLucidityLucidityLevelDaily(@Query("uid") int uid);

    @GET("posts/dream/lucidity/luciditylevel/weekly.php")
    Call<ResponseBody> getDreamLucidityLucidityLevelWeekly(@Query("uid") int uid);

    @GET("posts/dream/lucidity/luciditylevel/monthly.php")
    Call<ResponseBody> getDreamLucidityLucidityLevelMonthly(@Query("uid") int uid);

    @GET("posts/dream/people/daily.php")
    Call<ResponseBody> getDreamPeopleDaily(@Query("uid") int uid);

    @GET("posts/dream/people/weekly.php")
    Call<ResponseBody> getDreamPeopleWeekly(@Query("uid") int uid);

    @GET("posts/dream/people/monthly.php")
    Call<ResponseBody> getDreamPeopleMonthly(@Query("uid") int uid);

    @GET("posts/dream/people/existent/daily.php")
    Call<ResponseBody> getDreamPeopleExistDaily(@Query("uid") int uid);

    @GET("posts/dream/people/existent/weekly.php")
    Call<ResponseBody> getDreamPeopleExistWeekly(@Query("uid") int uid);

    @GET("posts/dream/people/existent/monthly.php")
    Call<ResponseBody> getDreamPeopleExistMonthly(@Query("uid") int uid);

    @GET("posts/dream/people/impression/daily.php")
    Call<ResponseBody> getDreamPeopleImpressionDaily(@Query("uid") int uid);

    @GET("posts/dream/people/impression/weekly.php")
    Call<ResponseBody> getDreamPeopleImpressionWeekly(@Query("uid") int uid);

    @GET("posts/dream/people/impression/monthly.php")
    Call<ResponseBody> getDreamPeopleImpressionMonthly(@Query("uid") int uid);

    @GET("posts/dream/people/name/daily.php")
    Call<ResponseBody> getDreamPeopleNameDaily(@Query("uid") int uid);

    @GET("posts/dream/people/name/weekly.php")
    Call<ResponseBody> getDreamPeopleNameWeekly(@Query("uid") int uid);

    @GET("posts/dream/people/name/monthly.php")
    Call<ResponseBody> getDreamPeopleNameMonthly(@Query("uid") int uid);

    @GET("posts/dream/sound/daily.php")
    Call<ResponseBody> getDreamSoundPropsDaily(@Query("uid") int uid);

    @GET("posts/dream/sound/weekly.php")
    Call<ResponseBody> getDreamSoundPropsWeekly(@Query("uid") int uid);

    @GET("posts/dream/sound/monthly.php")
    Call<ResponseBody> getDreamSoundPropsMonthly(@Query("uid") int uid);

    @GET("posts/dream/sound/sound/daily.php")
    Call<ResponseBody> getDreamSoundPropsHasSoundDaily(@Query("uid") int uid);

    @GET("posts/dream/sound/sound/weekly.php")
    Call<ResponseBody> getDreamSoundPropsHasSoundWeekly(@Query("uid") int uid);

    @GET("posts/dream/sound/sound/monthly.php")
    Call<ResponseBody> getDreamSoundPropsHasSoundMonthly(@Query("uid") int uid);

    @GET("posts/dream/sound/musical/daily.php")
    Call<ResponseBody> getDreamSoundPropsIsMusicalDaily(@Query("uid") int uid);

    @GET("posts/dream/sound/musical/weekly.php")
    Call<ResponseBody> getDreamSoundPropsIsMusicalWeekly(@Query("uid") int uid);

    @GET("posts/dream/sound/musical/monthly.php")
    Call<ResponseBody> getDreamSoundPropsIsMusicalMonthly(@Query("uid") int uid);

    @GET("posts/sleep/daily.php")
    Call<ResponseBody> getSleepsDaily(@Query("uid") int uid);

    @GET("posts/sleep/weekly.php")
    Call<ResponseBody> getSleepsWeekly(@Query("uid") int uid);

    @GET("posts/sleep/monthly.php")
    Call<ResponseBody> getSleepsMonthly(@Query("uid") int uid);

    @GET("posts/sleep/duration/daily.php")
    Call<ResponseBody> getSleepsDurationDaily(@Query("uid") int uid);

    @GET("posts/sleep/duration/weekly.php")
    Call<ResponseBody> getSleepsDurationWeekly(@Query("uid") int uid);

    @GET("posts/sleep/duration/monthly.php")
    Call<ResponseBody> getSleepsDurationMonthly(@Query("uid") int uid);

    @GET("posts/sleep/foodconsumption/daily.php")
    Call<ResponseBody> getSleepsFoodDaily(@Query("uid") int uid);

    @GET("posts/sleep/foodconsumption/weekly.php")
    Call<ResponseBody> getSleepsFoodWeekly(@Query("uid") int uid);

    @GET("posts/sleep/foodconsumption/monthly.php")
    Call<ResponseBody> getSleepsFoodMonthly(@Query("uid") int uid);

    @GET("posts/sleep/paralysis/daily.php")
    Call<ResponseBody> getSleepsParalysisDaily(@Query("uid") int uid);

    @GET("posts/sleep/paralysis/weekly.php")
    Call<ResponseBody> getSleepsParalysisWeekly(@Query("uid") int uid);

    @GET("posts/sleep/paralysis/monthly.php")
    Call<ResponseBody> getSleepsParalysisMonthly(@Query("uid") int uid);

    @GET("posts/sleep/physicalactivity/daily.php")
    Call<ResponseBody> getSleepsPhysicalDaily(@Query("uid") int uid);

    @GET("posts/sleep/physicalactivity/weekly.php")
    Call<ResponseBody> getSleepsPhysicalWeekly(@Query("uid") int uid);

    @GET("posts/sleep/physicalactivity/monthly.php")
    Call<ResponseBody> getSleepsPhysicalMonthly(@Query("uid") int uid);

    @GET("posts/sleep/time/daily.php")
    Call<ResponseBody> getSleepsTimeDaily(@Query("uid") int uid);

    @GET("posts/sleep/time/weekly.php")
    Call<ResponseBody> getSleepsTimeWeekly(@Query("uid") int uid);

    @GET("posts/sleep/time/monthly.php")
    Call<ResponseBody> getSleepsTimeMonthly(@Query("uid") int uid);

}
