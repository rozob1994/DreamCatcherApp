package com.catchydreams.dreamcatcher.activities.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.catchydreams.dreamcatcher.R;
import com.catchydreams.dreamcatcher.activities.ExpandedDreamActivity;
import com.catchydreams.dreamcatcher.activities.ProfileActivity;
import com.catchydreams.dreamcatcher.activities.viewInterfaces.IFinishListener;
import com.catchydreams.dreamcatcher.constants.PersianFont;
import com.catchydreams.dreamcatcher.parameters.IResponseMessage;
import com.catchydreams.dreamcatcher.parameters.QuestionnaireEntry;
import com.catchydreams.dreamcatcher.parameters.postParameters.majorParameters.Dream;
import com.catchydreams.dreamcatcher.ui.customFont.MoonTextView;
import com.catchydreams.dreamcatcher.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class DreamsPackagesActivityAdapter extends RecyclerView.Adapter<DreamsPackagesActivityAdapter.DreamsPackagesHolder> {
    private List<Integer> postIds;
    private List<Integer> sleepTimes;
    private List<Integer> experiences;
    private List<Integer> days;
    private List<Integer> months;
    private List<Integer> years;
    private List<String> titles;
    private List<String> contents;
    private Context context;
    private LayoutInflater inflater;
    private SharedPreferences sp;
    private IFinishListener iFinishListener;
    public DreamsPackagesActivityAdapter(Context context, List<Integer> postIds,
                                         List<Integer> sleepTimes, List<Integer> experiences,
                                         List<Integer> days, List<Integer> months,
                                         List<Integer> years, List<String> titles,
                                         List<String> contents) {
        this.postIds = postIds;
        this.context = context;
        this.sleepTimes = sleepTimes;
        this.experiences = experiences;
        this.days = days;
        this.months = months;
        this.years = years;
        this.titles = titles;
        this.contents = contents;
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

        String titleci = titles.get(position);
        String titlec = contentShort(titleci);
        String contentc = contents.get(position);
        int dayNightC = sleepTimes.get(position);
        int experience = experiences.get(position);
        String day = days.get(position) + "";
        String month = months.get(position) + "";
        String year = years.get(position) + "";
        String date = year + "/" + month + "/" + day;

        holder.title.setText(contentc);
        holder.content.setText(titlec);

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
        return postIds.size();
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
        setLanguageFonts(holder);
    }

    private void setSleepTimeView(int dayNightC, DreamsPackagesHolder holder) {
        if (dayNightC == 2) {
            holder.dayNight.setImageResource(R.drawable.ic_night_symbol);
            holder.dayNight.setColorFilter(context.getResources().getColor(R.color.ic_night_light));
        } else if (dayNightC == 1) {
            holder.dayNight.setImageResource(R.drawable.ic_day_symbol);
        } else {
            holder.dayNight.setVisibility(View.INVISIBLE);
        }
    }

    private void setExperienceView(int experience, DreamsPackagesHolder holder) {
        if (experience == 0) {
            holder.experience.setImageResource(R.drawable.ic_sad_emoji);
        } else if (experience == 1) {
            holder.experience.setImageResource(R.drawable.ic_poker_face_emoji);
        } else if (experience == 2) {
            holder.experience.setImageResource(R.drawable.ic_happy_emoji);
        } else {
            holder.experience.setVisibility(View.INVISIBLE);
        }
    }

    private void setLanguageFonts(DreamsPackagesHolder holder){
        SharedPreferences languagePrefs = context.getSharedPreferences("languages", Context.MODE_PRIVATE);
        String language = languagePrefs.getString("language", "en");
        if (language.equals("fa")) {
            Typeface titleFont = Typeface.createFromAsset(context.getAssets(), PersianFont.title);
            Typeface contentFont = Typeface.createFromAsset(context.getAssets(), PersianFont.subTitle);
            Typeface dateFont = Typeface.createFromAsset(context.getAssets(), PersianFont.regular);
            holder.title.setTypeface(titleFont);
            holder.content.setTypeface(contentFont);
            holder.dateTitle.setTypeface(dateFont);
        }
    }

    private String contentShort(String content) {
        SharedPreferences languagePrefs = context.getSharedPreferences("languages", Context.MODE_PRIVATE);
        String language = languagePrefs.getString("language", "en");
        if (content.length()>40){
            if (language.equals("fa")) {
                return content.substring(0,126) + "... دیدن ادامه‌ی رؤیا";
            } else {
                return content.substring(0,126) + "... read more.";
            }
        } else {
            return content;
        }
    }
}
