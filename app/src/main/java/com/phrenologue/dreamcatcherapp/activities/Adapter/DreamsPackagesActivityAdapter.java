package com.phrenologue.dreamcatcherapp.activities.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.activities.ExpandedDreamActivity;
import com.phrenologue.dreamcatcherapp.activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.QuestionnaireEntry;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.ui.costumeFont.MoonTextView;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class DreamsPackagesActivityAdapter extends RecyclerView.Adapter<DreamsPackagesActivityAdapter.DreamsPackagesHolder> {
    private List<String> titles;
    private List<String> contents;
    private List<Integer> postIds;
    private List<Integer> sounds;
    private List<Integer> musics;
    private List<Integer> grayScales;
    private List<Integer> experiences;
    private List<Integer> lucidityLevels;
    private List<Integer> days;
    private List<Integer> months;
    private List<Integer> years;
    private List<String> interpretations;
    private List<Integer> sleepTimes;
    private Context context;
    private LayoutInflater inflater;
    private SharedPreferences sp;

    public DreamsPackagesActivityAdapter(Context context, @Nullable List<String> titles,
                                         @Nullable List<String> contents,
                                         @Nullable List<Integer> postIds,
                                         List<Integer> sounds,
                                         List<Integer> musics,
                                         List<Integer> grayScales,
                                         List<Integer> experiences,
                                         List<Integer> lucidityLevels,
                                         List<Integer> days,
                                         List<Integer> months,
                                         List<Integer> years,
                                         List<String> interpretations,
                                         List<Integer> sleepTimes) {
        this.titles = titles;
        this.contents = contents;
        this.context = context;
        this.postIds = postIds;
        this.sounds = sounds;
        this.musics = musics;
        this.grayScales = grayScales;
        this.experiences = experiences;
        this.lucidityLevels = lucidityLevels;
        this.days = days;
        this.months = months;
        this.years = years;
        this.interpretations = interpretations;
        this.sleepTimes = sleepTimes;
        inflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public DreamsPackagesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.dreams_package, parent, false);
        return new DreamsPackagesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DreamsPackagesHolder holder, int position) {

        String titlec = titles.get(position);
        String contentc = contents.get(position);
        int dayNightC = sleepTimes.get(position);
        int experience = experiences.get(position);
        String day = days.get(position) + "";
        String month = months.get(position) + "";
        String year = years.get(position) + "";
        String date = year + "/" + month + "/" + day;

        holder.title.setText(titlec);
        holder.content.setText(contentc);

        setViews(dayNightC, holder, experience);

        holder.dateTitle.setText(date);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int postId1 = postIds.get(position);
                Dream dream = Dream.getInstance();
                dream.setPostId(postId1);
                ApiPostCaller postCaller = new ApiPostCaller();
                sp = context.getSharedPreferences("dreamChoosing", Context.MODE_PRIVATE);
                if (sp.getBoolean("fromLucidityQuestionnaire", false)) {
                    postCaller.addPostIdToIdQ(new IResponseMessage() {
                        @Override
                        public void onSuccess(Object response) throws JSONException {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            boolean status = jsonObject.getBoolean("status");
                            if (status) {
                                postCaller.addLucidityToDream(new IResponseMessage() {
                                    @Override
                                    public void onSuccess(Object response) throws JSONException {
                                        JSONObject jsonObject = new JSONObject(response.toString());
                                        boolean status = jsonObject.getBoolean("status");
                                        if (status) {
                                            Dream.delDream();
                                            QuestionnaireEntry.delQuestionnaireEntry();
                                            Intent intent = new Intent(context, ProfileActivity.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                            context.startActivity(intent);
                                        } else {
                                            Toast.makeText(context, "Error Editing Dream.", Toast.LENGTH_LONG).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(String errorMessage) {
                                        Toast.makeText(context, "Connection Error", Toast.LENGTH_LONG).show();
                                    }
                                });
                            } else {
                                Toast.makeText(context, "Error Editing Questionnaire Results.", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(String errorMessage) {
                            Toast.makeText(context, "Connection Error.", Toast.LENGTH_LONG).show();
                        }
                    }, postId1);


                } else {
                    Intent intent = new Intent(context, ExpandedDreamActivity.class);
                    int postId = postIds.get(position);
                    intent.putExtra("postId", postId);
                    intent.putExtra("sleepTime", dayNightC);
                    intent.putExtra("date", date);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    class DreamsPackagesHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView title;
        private AppCompatTextView content;
        private AppCompatImageView dayNight;
        private AppCompatImageView experience;
        private MoonTextView dateTitle;
        private RelativeLayout relativeLayout;

        public DreamsPackagesHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.dreams_package_title);
            content = itemView.findViewById(R.id.dreams_package_description);
            dayNight = itemView.findViewById(R.id.package_day_time);
            dateTitle = itemView.findViewById(R.id.title_date);
            relativeLayout = itemView.findViewById(R.id.rel_dreams_package);
            experience = itemView.findViewById(R.id.package_mood);
        }
    }
    private void setViews(int dayNightC, DreamsPackagesHolder holder,
                          int experience){
        setSleepTimeView(dayNightC, holder);
        setExperienceView(experience, holder);
    }

    private void setSleepTimeView(int dayNightC, DreamsPackagesHolder holder) {
        if (dayNightC == 2) {
            holder.dayNight.setImageResource(R.drawable.ic_night_symbol);
        } else if (dayNightC == 1) {
            holder.dayNight.setImageResource(R.drawable.ic_day_symbol);
        } else {
            holder.dayNight.setImageResource(R.drawable.ic_night_symbol);
            holder.dayNight.setColorFilter(R.color.gray);
        }
    }

    private void setExperienceView(int experience, DreamsPackagesHolder holder) {
        if (experience == 0) {
            holder.experience.setImageResource(R.drawable.ic_sad_emoji);
        } else if (experience == 2) {
            holder.experience.setImageResource(R.drawable.ic_happy_emoji);
        } else {
            holder.experience.setImageResource(R.drawable.ic_poker_face_emoji);
        }
    }
}
