package com.phrenologue.dreamcatcherapp.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.activities.viewInterfaces.IDreamExpandedView;
import com.phrenologue.dreamcatcherapp.databinding.ActivityExpandedDreamBinding;
import com.phrenologue.dreamcatcherapp.managersAndFilters.SharedPreferencesManager;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDescription;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamInterpretation;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;
import com.phrenologue.dreamcatcherapp.presenters.DreamExpandedPresenter;
import com.phrenologue.dreamcatcherapp.presenters.StatsPresenter;
import com.phrenologue.dreamcatcherapp.ui.costumeFont.MoonTextView;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import maes.tech.intentanim.CustomIntent;

public class ExpandedDreamActivity extends AppCompatActivity implements IDreamExpandedView {
    SharedPreferencesManager spManager;
    Dream dream;
    Sleep sleep;
    DreamExpandedPresenter presenter;
    boolean clicked;
    private ActivityExpandedDreamBinding binding;
    private SharedPreferences sp2, sleepSp, dreamOneSp, dreamTwoSp, peopleSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExpandedDreamBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        SharedPreferencesManager.clearDreamSleepQuest(getApplicationContext());
        sleepSp = Objects.requireNonNull(getApplicationContext()).getSharedPreferences("sleep", Context.MODE_PRIVATE);
        dreamOneSp = Objects.requireNonNull(getApplicationContext())
                .getSharedPreferences("dream", Context.MODE_PRIVATE);
        dreamTwoSp = getApplicationContext().getSharedPreferences("dreamTwo", Context.MODE_PRIVATE);
        dream = Dream.getInstance();
        sleep = Sleep.getInstance();
        spManager = new SharedPreferencesManager();
        presenter = new DreamExpandedPresenter(this);
        sp2 = getSharedPreferences("dreamToLucidityQuestionnaire", Context.MODE_PRIVATE);

        int postId = getIntent().getIntExtra("postId", 0);
        int sleepTime = getIntent().getIntExtra("sleepTime", 0);

        dream.setPostId(postId);
        String dateLoaded = getIntent().getStringExtra("date");
        Log.e("","");
        presenter.loadPost(postId, dateLoaded, sleepSp, dreamOneSp, dreamTwoSp);

        SharedPreferences sp = getSharedPreferences("loadedSleepProps", MODE_PRIVATE);

        sp.edit().putInt("sleepTime", sleepTime).apply();



        sleep.setTime(sp.getInt("sleepTime", 0));

        clicked = false;



        StatsPresenter.drawSingleLucidityLevel(binding.pieChart, postId, binding.txtPercentage,
                binding.noDataRel, binding.txtPercentage);



        binding.relDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!clicked) {
                    binding.expandableDescription.expand();
                    binding.titleDescription.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.txt_glow));
                    clicked = true;
                } else {
                    binding.expandableDescription.collapse();
                    binding.titleDescription.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.gray));
                    clicked = false;
                }
            }
        });

        binding.btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp2.edit().putBoolean("fromDream", true).apply();
                Intent intent = new Intent(getApplicationContext(), LucidDreamingQuestionnaireActivity.class);
                startActivity(intent);
                finish();
            }
        });


        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewThread thread = new NewThread();
                thread.start();
            }
        });


        binding.relInterpretation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!clicked) {
                    binding.expandableInterpretation.expand();
                    binding.titleInterpretation.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.txt_glow));
                    clicked = true;
                } else {
                    binding.expandableInterpretation.collapse();
                    binding.titleInterpretation.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.gray));
                    clicked = false;
                }
            }
        });

        binding.relPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!clicked) {
                    binding.expandablePeople.expand();
                    binding.titlePeople.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.txt_glow));
                    clicked = true;
                } else {
                    binding.expandablePeople.collapse();
                    binding.titlePeople.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.gray));
                    clicked = false;
                }
            }
        });

        binding.btnEdtDream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), EditDreamInputActivity.class);
                startActivity(intent);
                CustomIntent.customType(ExpandedDreamActivity.this, "fadein-to-fadeout");
                finish();
            }
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.edit().clear().apply();
                Intent intent = new Intent(getApplicationContext(), DreamsPackagesActivity.class);
                startActivity(intent);
                CustomIntent.customType(ExpandedDreamActivity.this, "fadein-to-fadeout");
                finish();
            }
        });

    }

    @Override
    public void showProgressBar() {
        binding.loadingBg.setVisibility(View.VISIBLE);
        binding.loadingBg.setAlpha(0.95f);
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        binding.loadingBg.setVisibility(View.GONE);
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setPeopleView(int index, String name, int textColor) {
        List<MoonTextView> names = Arrays.asList(binding.nameOne, binding.nameTwo, binding.nameThree,
                binding.nameFour, binding.nameFive, binding.nameSix, binding.nameSeven,
                binding.nameNine, binding.nameTen);
        MoonTextView person = names.get(index);
        person.setText(name);
        person.setTextColor(getResources().getColor(textColor));

    }

    @Override
    public void setMoodView(int drawable) {
        binding.mood.setImageResource(drawable);
    }

    @Override
    public void hideMood() {
        binding.mood.setVisibility(View.GONE);
    }

    @Override
    public void setSleepTimeView(int drawable) {
        binding.dayTime.setImageResource(drawable);
    }

    @Override
    public void hideSleepTime() {
        binding.dayTime.setVisibility(View.GONE);
    }

    @Override
    public void setFoodView(int drawable) {
        binding.food.setImageResource(drawable);
    }

    @Override
    public void setPhysicalView(int drawable) {
        binding.activity.setImageResource(drawable);
    }

    @Override
    public void setColorView(int drawable) {
        binding.color.setImageResource(drawable);
    }

    @Override
    public void setMusicalView(int drawable) {
        binding.sound.setImageResource(drawable);
    }

    @Override
    public void setInterpretationText() {
        binding.dreamsPackageInterpretation.setText(DreamInterpretation.getInstance()
                .getInterpretation());
    }

    @Override
    public void setTitleText() {
        binding.dreamsPackageTitle.setText(DreamDescription.getInstance().getTitle());
    }

    @Override
    public void setContentText() {
        binding.dreamsPackageDescription.setText(DreamDescription.getInstance().getContent());
    }

    @Override
    public void setDateText(String dateLoaded) {
        binding.titleDate.setText(dateLoaded);
    }

    @Override
    public void onSuccess(Object responseMessage) {
        presenter.setPeopleToViews();
    }

    @Override
    public void onError() {
        Toast.makeText(getApplicationContext(), "Loading failed.", Toast.LENGTH_LONG).show();

    }

    class NewThread extends Thread {
        @Override
        public void run() {
            ApiPostCaller apiPostCaller = new ApiPostCaller();
            apiPostCaller.delDream(new IResponseMessage() {
                @Override
                public void onSuccess(Object response) throws JSONException {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    boolean status = jsonObject.getBoolean("status");
                    if (status) {
                        Intent intent = new Intent(getApplicationContext(), DreamsPackagesActivity.class);
                        startActivity(intent);
                        Toast.makeText(ExpandedDreamActivity.this, "Dream was Successfully deleted!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(String errorMessage) {

                }
            });
        }
    }




}

