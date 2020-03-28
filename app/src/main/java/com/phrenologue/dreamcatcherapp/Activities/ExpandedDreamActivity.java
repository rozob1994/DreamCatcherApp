package com.phrenologue.dreamcatcherapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.phrenologue.dreamcatcherapp.databinding.ActivityExpandedDreamBinding;
import com.phrenologue.dreamcatcherapp.managers.SharedPreferencesManager;
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
        Log.e("", "");
        ApiPostCaller apiPostCaller = new ApiPostCaller();
        apiPostCaller.getDreamProps(postId, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                JSONArray jsonArray = new JSONArray(response.toString());
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                Log.e("", "");
                people.setName(jsonObject.getString("dreamPeopleName"));
                people.setExistent(jsonObject.getInt("dreamPeopleExist"));
                people.setImpression(jsonObject.getInt("dreamPeopleImpression"));

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
    }
}
