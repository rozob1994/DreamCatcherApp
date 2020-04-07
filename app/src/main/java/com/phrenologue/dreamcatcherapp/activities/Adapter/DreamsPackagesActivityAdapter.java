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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.activities.ExpandedDreamActivity;
import com.phrenologue.dreamcatcherapp.activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.QuestionnaireEntry;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class DreamsPackagesActivityAdapter extends RecyclerView.Adapter<DreamsPackagesActivityAdapter.DreamsPackagesHolder> {
    List<String> titles;
    List<String> contents;
    List<Integer> postIds;
    Context context;
    LayoutInflater inflater;
    SharedPreferences sp;

    public DreamsPackagesActivityAdapter(Context context, @Nullable List<String> titles,
                                         @Nullable List<String> contents,
                                         @Nullable List<Integer> postIds) {
        this.titles = titles;
        this.contents = contents;
        this.context = context;
        this.postIds = postIds;
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
        holder.title.setText(titlec);
        holder.content.setText(contentc);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int postId1 = postIds.get(position);
                Dream dream = Dream.getInstance();
                dream.setPostId(postId1);
                ApiPostCaller postCaller = new ApiPostCaller();
                sp = context.getSharedPreferences("dreamChoosing", Context.MODE_PRIVATE);
                if (sp.getBoolean("fromLucidityQuestionnaire", false)){
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
                                            Toast.makeText(context, "Error Editing Dream.",Toast.LENGTH_LONG).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(String errorMessage) {
                                        Toast.makeText(context, "Connection Error",Toast.LENGTH_LONG).show();
                                    }
                                });
                            } else {
                                Toast.makeText(context, "Error Editing Questionnaire Results.",Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(String errorMessage) {
                            Toast.makeText(context, "Connection Error.",Toast.LENGTH_LONG).show();
                        }
                    }, postId1);


                } else {
                    Intent intent= new Intent(context, ExpandedDreamActivity.class);
                    int postId = postIds.get(position);
                    intent.putExtra("postId", postId);
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
        private RelativeLayout relativeLayout;
        public DreamsPackagesHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.dreams_package_title);
            content = itemView.findViewById(R.id.dreams_package_description);
            relativeLayout= itemView.findViewById(R.id.rel_dreams_package);
        }
    }
}
