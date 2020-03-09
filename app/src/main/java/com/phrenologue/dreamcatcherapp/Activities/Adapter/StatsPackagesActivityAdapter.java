package com.phrenologue.dreamcatcherapp.Activities.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.Models.StatsPackages;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.StatsPackageBinding;

import java.util.List;

public class StatsPackagesActivityAdapter extends RecyclerView.Adapter<StatsPackagesActivityAdapter.StatsPackagesHolder> {

    List<StatsPackages> statsPackages;
    Context context;
    LayoutInflater inflater;
    public StatsPackagesActivityAdapter(Context context, List<StatsPackages> packages){
        statsPackages= packages;
        this.context= context;
        inflater= LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public StatsPackagesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.stats_package, null);
        return new StatsPackagesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatsPackagesHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return statsPackages.size();
    }

    class StatsPackagesHolder extends RecyclerView.ViewHolder {

        private StatsPackageBinding binding;

        public StatsPackagesHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
