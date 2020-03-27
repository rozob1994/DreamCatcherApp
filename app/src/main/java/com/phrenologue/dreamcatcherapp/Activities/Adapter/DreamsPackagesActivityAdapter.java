package com.phrenologue.dreamcatcherapp.Activities.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.Activities.ExpandedDreamActivity;
import com.phrenologue.dreamcatcherapp.R;

import java.util.List;

public class DreamsPackagesActivityAdapter extends RecyclerView.Adapter<DreamsPackagesActivityAdapter.DreamsPackagesHolder> {
    List<String> titles;
    List<String> contents;
    List<Integer> postIds;
    Context context;
    LayoutInflater inflater;

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
                Intent intent= new Intent(context, ExpandedDreamActivity.class);
                int postId = postIds.get(position);
                intent.putExtra("postId", postId);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
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
