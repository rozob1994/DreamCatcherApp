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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.activities.ExpandedDreamActivity;
import com.phrenologue.dreamcatcherapp.activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.QuestionnaireEntry;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Post;
import com.phrenologue.dreamcatcherapp.ui.costumeFont.MoonTextView;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class DreamsPackagesActivityAdapter extends RecyclerView.Adapter<DreamsPackagesActivityAdapter.DreamsPackagesHolder> {
    private List<Post> posts;
    private List<Integer> postIds;
    private Context context;
    private LayoutInflater inflater;
    private SharedPreferences sp;

    public DreamsPackagesActivityAdapter(Context context, List<Post> posts, List<Integer> postIds) {
        this.postIds = postIds;
        this.context = context;
        this.posts = posts;
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

        String titlec = posts.get(position).getTitle();
        String contentc = posts.get(position).getContent();
        int dayNightC = posts.get(position).getSleepTime();
        int experience = posts.get(position).getExperience();
        String day = posts.get(position).getDay() + "";
        String month = posts.get(position).getMonth() + "";
        String year = posts.get(position).getYear() + "";
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
        return posts.size();
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
}
