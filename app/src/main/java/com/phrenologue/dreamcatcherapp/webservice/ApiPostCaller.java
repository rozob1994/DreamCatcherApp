package com.phrenologue.dreamcatcherapp.webservice;

import android.util.Log;

import androidx.annotation.Nullable;

import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.QuestionnaireEntry;
import com.phrenologue.dreamcatcherapp.parameters.Users;
import com.phrenologue.dreamcatcherapp.parameters.dateParameters.parameters.Date;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDate;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDescription;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamInterpretation;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamLucidity;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamPeople;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamSound;
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

    public void delDream(IResponseMessage responseMessage) {
        int postId = Dream.getInstance().getPostId();
        Call<ResponseBody> call = postService.delDream(postId);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    assert response.body() != null;
                    responseMessage.onSuccess(response.body().string());
                    Log.e("","");
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

    public void postQEntry(IResponseMessage responseMessage, int postId) {
        Users user = Users.getInstance();
        QuestionnaireEntry entry = QuestionnaireEntry.getInstance();
        entry.setResult();
        Call<ResponseBody> call = postService.postQEntry(user.getUid(), postId,
                entry.getqOne(), entry.getqTwo(), entry.getqThree(), entry.getqFour(),
                entry.getqFive(), entry.getqSix(), entry.getqSeven(), entry.getqEight(),
                entry.getqNine(), entry.getqTen(), entry.getqEleven(), entry.getqTwelve(),
                entry.getqThirteen(), entry.getqFourteen(), entry.getqFifteen(), entry.getqSixteen(),
                entry.getqSeventeen(), entry.getqEighteen(), entry.getqNineteen(), entry.getResult());
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

    public void addPostIdToIdQ(IResponseMessage responseMessage, int postId) {
        QuestionnaireEntry entry = QuestionnaireEntry.getInstance();
        Call<ResponseBody> call = postService.addPostIdToIdQ(postId, entry.getId());
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

    public void getDreamSleepQuestCounts(IResponseMessage responseMessage) {
        Users user = Users.getInstance();
        int uid = user.getUid();
        Call<ResponseBody> call = postService.getDreamSleepQuestCounts(uid);
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

    public void getRemembered(IResponseMessage responseMessage) {
        Users user = Users.getInstance();
        Call<ResponseBody> call = postService.getRemembered(user.getUid());
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

    public void postPeople(IResponseMessage responseMessage) {
        Dream dream = Dream.getInstance();
        DreamPeople people = DreamPeople.getInstance();
        Call<ResponseBody> call = postService.postPeople(dream.getPostId(), people.getFirstName(),
                people.getFirstImpression(), people.getSecondName(), people.getSecondImpression(),
                people.getThirdName(), people.getThirdImpression(), people.getFourthName(),
                people.getFourthImpression(), people.getFifthName(), people.getFifthImpression(),
                people.getSixthName(), people.getSixthImpression(), people.getSeventhName(),
                people.getSeventhImpression(), people.getEighthName(), people.getEighthImpression(),
                people.getNinthName(), people.getNinthImpression(), people.getTenthName(),
                people.getTenthImpression());
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

    public void editDream(IResponseMessage responseMessage) {
        Dream dream = Dream.getInstance();
        DreamDate date = DreamDate.getInstance();
        Call<ResponseBody> call = postService.editDream(dream.getPostId(), "",
                0, 0,
                dream.getDreamSound().getSound(), dream.getDreamSound().getMusical(),
                dream.getDreamChecklist().getGrayScale(), dream.getDreamChecklist().getExperience(),
                dream.getDreamLucidity().getLucidityLevel(), dream.getDreamDescription().getTitle(),
                dream.getDreamDescription().getContent(), date.getDayOfMonth(), date.getMonth(),
                date.getYear(), dream.getDreamInterpretation().getInterpretation());
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

    public void addLucidityToDream(IResponseMessage responseMessage) {
        Dream dream = Dream.getInstance();
        QuestionnaireEntry entry = QuestionnaireEntry.getInstance();
        Call<ResponseBody> call = postService.addLucidityToDream(dream.getPostId(),
                entry.getResult());
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

    public void editPeople(IResponseMessage responseMessage) {
        Dream dream = Dream.getInstance();
        DreamPeople people = DreamPeople.getInstance();
        Call<ResponseBody> call = postService.editPeople(dream.getPostId(), people.getFirstName(),
                people.getFirstImpression(), people.getSecondName(), people.getSecondImpression(),
                people.getThirdName(), people.getThirdImpression(), people.getFourthName(),
                people.getFourthImpression(), people.getFifthName(), people.getFifthImpression(),
                people.getSixthName(), people.getSixthImpression(), people.getSeventhName(),
                people.getSeventhImpression(), people.getEighthName(), people.getEighthImpression(),
                people.getNinthName(), people.getNinthImpression(), people.getTenthName(),
                people.getTenthImpression());
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

    public void addDateToSleep(IResponseMessage responseMessage) {
        Date date = Date.getInstance();
        Sleep sleep = Sleep.getInstance();
        Users user = Users.getInstance();
        Call<ResponseBody> call = postService.addDateToSleep(user.getUid(), sleep.getPostId(),
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

    public void saveDreamSeparately(IResponseMessage responseMessage) {
        DreamChecklist checklist = DreamChecklist.getInstance();
        DreamPeople people = DreamPeople.getInstance();
        DreamSound sound = DreamSound.getInstance();
        DreamLucidity lucidity = DreamLucidity.getInstance();
        DreamDescription description = DreamDescription.getInstance();
        DreamInterpretation interpretation = DreamInterpretation.getInstance();
        Users user = Users.getInstance();
        Dream dream = Dream.getInstance();
        Date date = Date.getInstance();
        Call<ResponseBody> call = postService.postDreams(dream.getPostId(), user.getUid(),
                1, "People.Names",
                1, 0,
                sound.getSound(), sound.getMusical(),
                checklist.getGrayScale(),
                checklist.getExperience(),
                lucidity.getLucidityLevel(),
                description.getTitle(), description.getContent(),
                date.getDayOfWeek(), date.getDayOfMonth(), date.getDayOfYear(), date.getWeekOfMonth(),
                date.getMonth(), date.getYear(), interpretation.getInterpretation());
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

    public void saveSleepSeparately(IResponseMessage responseMessage, @Nullable Integer remembered) {
        Users user = Users.getInstance();
        Sleep sleep = Sleep.getInstance();
        Dream dream = Dream.getInstance();
        Date date = Date.getInstance();
        Call<ResponseBody> call = postService.postSleeps(user.getUid(), sleep.getPostId(), sleep.getDuration(),
                sleep.getTime(), sleep.getPhysicalActivity(), sleep.getFoodConsumption(),
                sleep.getSleepParalysis(), remembered,
                date.getDayOfWeek(), date.getDayOfMonth(), date.getDayOfYear(), date.getWeekOfMonth(),
                date.getMonth(), date.getYear());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("", "");
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

    public void getDailyMood(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDailyMood(Users.getInstance().getUid());
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

    public void getSoundPercent(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSound(Users.getInstance().getUid());
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

    public void getMusicalPercent(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getMusical(Users.getInstance().getUid());
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

    public void getGrayScalePercent(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getGrayScale(Users.getInstance().getUid());
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

    public void getMoodPercent(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getMood(Users.getInstance().getUid());
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

    public void getLucidityPercent(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getLucidity(Users.getInstance().getUid());
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

    public void getDreamDescription(IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getAllDreams(Users.getInstance().getUid());
        Log.e("", "");
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

    public void getDreamProps(int postId, IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getDreamProps(postId);
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

    public void getSleepProps(int postId, IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getSleepProps(postId);

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

    public void getPeopleProps(int postId, IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getPeopleProps(postId);
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

    public void getQResult(int postId, IResponseMessage responseMessage) {
        Call<ResponseBody> call = postService.getQResult(postId);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    assert response.body() != null;
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
