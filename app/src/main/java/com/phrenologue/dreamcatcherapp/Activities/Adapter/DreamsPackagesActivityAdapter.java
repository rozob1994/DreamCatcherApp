package com.phrenologue.dreamcatcherapp.Activities.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.R;

import java.util.List;

public class DreamsPackagesActivityAdapter extends RecyclerView.Adapter<DreamsPackagesActivityAdapter.DreamsPackagesHolder> {
    List<String> titles;
    List<String> contents;
    Context context;
    LayoutInflater inflater;

    public DreamsPackagesActivityAdapter(Context context, @Nullable List<String> titles,
                                         @Nullable List<String> contents) {
        this.titles = titles;
        this.contents = contents;
        this.context = context;
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

    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    class DreamsPackagesHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView title;
        private AppCompatTextView content;
        public DreamsPackagesHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.dreams_package_title);
            content = itemView.findViewById(R.id.dreams_package_description);
        }
    }
}
