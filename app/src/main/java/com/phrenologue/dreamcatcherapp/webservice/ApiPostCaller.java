package com.phrenologue.dreamcatcherapp.webservice;

import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.Users;
import com.phrenologue.dreamcatcherapp.parameters.dateParameters.parameters.Date;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;

import org.json.JSONException;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiPostCaller {
    public ApiPostCaller() {
    }

    IPostService postService = ApiClient.getRetrofit().create(IPostService.class);

    public void saveSleepSeparately(IResponseMessage responseMessage) {
        Users user = Users.getInstance();
        Sleep sleep = Sleep.getInstance();
        Dream dream = Dream.getInstance();
        Date date = Date.getInstance();
        Call<ResponseBody> call = postService.postSleeps(user.getUid(), sleep.getDuration(),
                sleep.getTime(), sleep.getPhysicalActivity(), sleep.getFoodConsumption(),
                sleep.getSleepParalysis(), dream.getDreamChecklist().isRemembered(),
                date.getDayOfWeek(), date.getDayOfMonth(), date.getDayOfYear(), date.getWeekOfMonth(),
                date.getMonth(), date.getYear());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamsDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamsDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());

                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamsWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamsWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamsMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamsMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamCheckListDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamCheckListDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamCheckListWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamCheckListWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamCheckListMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamCheckListMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamCheckListRelatedDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamCheckListRelatedDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                responseMessage.onFailure(t.getMessage().toString());

            }
        });
    }

    public void getDreamCheckListRelatedWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamCheckListRelatedWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                responseMessage.onFailure(t.getMessage().toString());

            }
        });
    }

    public void getDreamCheckListRelatedMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamCheckListRelatedMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                responseMessage.onFailure(t.getMessage().toString());

            }
        });
    }

    public void getDreamCheckListExperienceDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamCheckListExperienceDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());

            }
        });
    }

    public void getDreamCheckListExperienceWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamCheckListExperienceWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());

            }
        });
    }

    public void getDreamCheckListExperienceMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamCheckListExperienceMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                responseMessage.onFailure(t.getMessage().toString());

            }
        });
    }

    public void getDreamCheckListFalseAwakeDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamCheckListFalseAwakeDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());

            }
        });
    }

    public void getDreamCheckListFalseAwakeWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamCheckListFalseAwakeWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamCheckListFalseAwakeMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamCheckListFalseAwakeMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamCheckListGrayScaleDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamCheckListGrayScaleDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamCheckListGrayScaleWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamCheckListGrayScaleWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamCheckListGrayScaleMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamCheckListGrayScaleMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamCheckListRememberedDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamCheckListRememberedDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamCheckListRememberedWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamCheckListRememberedWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamCheckListRememberedMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamCheckListRememberedMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamDescriptionDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamDescriptionDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamDescriptionWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamDescriptionWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamDescriptionMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamDescriptionMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamDescriptionContentDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamDescriptionContentDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamDescriptionContentWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamDescriptionContentWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamDescriptionContentMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamDescriptionContentMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamDescriptionTitleDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamDescriptionTitleDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamDescriptionTitleWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamDescriptionTitleWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamDescriptionTitleMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamDescriptionTitleMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamLucidityDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamLucidityDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamLucidityWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamLucidityWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamLucidityMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamLucidityMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamLucidityLucidDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamLucidityLucidDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamLucidityLucidWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamLucidityLucidWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamLucidityLucidMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamLucidityLucidMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamLucidityLucidityLevelDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamLucidityLucidityLevelDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamLucidityLucidityLevelWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamLucidityLucidityLevelWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamPeopleDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamPeopleDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamPeopleWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamPeopleWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamPeopleMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamPeopleMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamPeopleExistDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamPeopleExistDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamPeopleExistWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamPeopleExistWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamPeopleExistMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamPeopleExistMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamPeopleImpressionDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamPeopleImpressionDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamPeopleImpressionWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamPeopleImpressionWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamPeopleImpressionMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamPeopleImpressionMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamPeopleNameDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamPeopleNameDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamPeopleNameWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamPeopleNameWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamPeopleNameMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamPeopleNameMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamSoundPropsDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamSoundPropsDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamSoundPropsWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamSoundPropsWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamSoundPropsMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamSoundPropsMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamSoundPropsHasSoundDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamSoundPropsHasSoundDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamSoundPropsHasSoundWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamSoundPropsHasSoundWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamSoundPropsHasSoundMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamSoundPropsHasSoundMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamSoundPropsIsMusicalDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamSoundPropsIsMusicalDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamSoundPropsIsMusicalWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamSoundPropsIsMusicalWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getDreamSoundPropsIsMusicalMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamSoundPropsIsMusicalMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSleepsDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepsDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSleepsWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepsWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSleepsMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepsMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSleepsDurationDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepsDurationDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSleepsDurationWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepsDurationWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSleepsDurationMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepsDurationMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSleepsFoodDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepsFoodDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSleepsFoodWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepsFoodWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSleepsFoodMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepsFoodMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSleepsParalysisDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepsParalysisDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSleepsParalysisWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepsParalysisWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSleepsParalysisMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepsParalysisMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSleepsPhysicalDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepsPhysicalDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSleepsPhysicalWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepsPhysicalWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSleepsPhysicalMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepsPhysicalMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSleepsTimeDaily(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepsTimeDaily(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSleepsTimeWeekly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepsTimeWeekly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }

    public void getSleepsTimeMonthly(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepsTimeMonthly(Users.getInstance().getUid());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseMessage.onSuccess(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                responseMessage.onFailure(t.getMessage().toString());
            }
        });
    }


}
