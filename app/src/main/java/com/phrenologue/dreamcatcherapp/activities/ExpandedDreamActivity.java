package com.phrenologue.dreamcatcherapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.databinding.ActivityExpandedDreamBinding;
import com.phrenologue.dreamcatcherapp.managersAndFilters.SharedPreferencesManager;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamChecklist;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDate;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDescription;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamInterpretation;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamLucidity;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamPeople;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamSound;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import maes.tech.intentanim.CustomIntent;

public class ExpandedDreamActivity extends AppCompatActivity {
    SharedPreferencesManager spManager;
    Dream dream;
    DreamPeople people;
    DreamChecklist checklist;
    DreamDate date;
    DreamDescription description;
    DreamInterpretation interpretation;
    DreamLucidity lucidity;
    DreamSound sound;
    Sleep sleep;
    private ActivityExpandedDreamBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExpandedDreamBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        dream = Dream.getInstance();
        people = DreamPeople.getInstance();
        checklist = DreamChecklist.getInstance();
        date = DreamDate.getInstance();
        description = DreamDescription.getInstance();
        interpretation = DreamInterpretation.getInstance();
        lucidity = DreamLucidity.getInstance();
        sound = DreamSound.getInstance();
        sleep = Sleep.getInstance();
        spManager = new SharedPreferencesManager();
        int postId = getIntent().getIntExtra("postId", 0);
        dream.setPostId(postId);
        ApiPostCaller apiPostCaller = new ApiPostCaller();
        apiPostCaller.getPeopleProps(postId, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                DreamPeople people = DreamPeople.getInstance();
                JSONArray jsonArray = new JSONArray(response.toString());
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                ArrayList<Integer> impressions = new ArrayList<>();
                impressions.add(0, jsonObject.getInt("firstImpression"));
                impressions.add(1, jsonObject.getInt("secondImpression"));
                impressions.add(2, jsonObject.getInt("thirdImpression"));
                impressions.add(3, jsonObject.getInt("fourthImpression"));
                impressions.add(4, jsonObject.getInt("fifthImpression"));
                impressions.add(5, jsonObject.getInt("sixthImpression"));
                impressions.add(6, jsonObject.getInt("seventhImpression"));
                impressions.add(7, jsonObject.getInt("eighthImpression"));
                impressions.add(8, jsonObject.getInt("ninthImpression"));
                impressions.add(9, jsonObject.getInt("tenthImpression"));

                ArrayList<String> names = new ArrayList<>();
                names.add(0, jsonObject.getString("firstPerson"));
                names.add(1, jsonObject.getString("secondPerson"));
                names.add(2, jsonObject.getString("thirdPerson"));
                names.add(3, jsonObject.getString("fourthPerson"));
                names.add(4, jsonObject.getString("fifthPerson"));
                names.add(5, jsonObject.getString("sixthPerson"));
                names.add(6, jsonObject.getString("seventhPerson"));
                names.add(7, jsonObject.getString("eighthPerson"));
                names.add(8, jsonObject.getString("ninthPerson"));
                names.add(9, jsonObject.getString("tenthPerson"));

                for (int i = 0; i < 10; i++) {
                    people.setImpression(i, impressions.get(i));
                }

                for (int i = 0; i < 10; i++) {
                    people.setName(i, names.get(i));
                }

                spManager.savePeopleToSp(getApplicationContext(), people);
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });
        apiPostCaller.getDreamProps(postId, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                JSONArray jsonArray = new JSONArray(response.toString());
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                Log.e("", "");
                people.setExistent(jsonObject.getInt("dreamPeopleExist"));

                checklist.setExperience(jsonObject.getInt("dreamExperience"));
                checklist.setGrayScale(jsonObject.getInt("dreamGrayScale"));

                date.setDayOfMonth(jsonObject.getInt("dayOfMonth"));
                date.setMonth(jsonObject.getInt("month"));
                date.setYear(jsonObject.getInt("year"));

                interpretation.setInterpretation(jsonObject.getString("interpretation"));

                description.setTitle(jsonObject.getString("dreamContent"));
                description.setContent(jsonObject.getString("dreamTitle"));

                sound.setSound(jsonObject.getInt("dreamSound"));
                sound.setMusical(jsonObject.getInt("dreamMusical"));

                lucidity.setLucidityLevel(jsonObject.getInt("dreamLucidityLevel"));

                dream.setDreamPeople(people);
                dream.setDreamChecklist(checklist);
                dream.setDreamInterpretation(interpretation);
                dream.setDreamDescription(description);
                dream.setDreamSound(sound);
                dream.setDreamLucidity(lucidity);


                spManager.saveDreamToSp(getApplicationContext(), dream, date);

                binding.dreamsPackageTitle.setText(description.getTitle());
                binding.dreamsPackageDescription.setText(description.getContent());
            }

            @Override
            public void onFailure(String errorMessage) {
                Log.e("", "");
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

                Intent intent = new Intent(getApplicationContext(), DreamsPackagesActivity.class);
                startActivity(intent);
                CustomIntent.customType(ExpandedDreamActivity.this, "fadein-to-fadeout");
                finish();
            }
        });
    }
}