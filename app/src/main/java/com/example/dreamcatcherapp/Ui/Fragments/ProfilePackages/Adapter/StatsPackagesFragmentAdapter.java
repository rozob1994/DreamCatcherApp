package com.example.dreamcatcherapp.Ui.Fragments.ProfilePackages.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dreamcatcherapp.Models.StatsPackages;
import com.example.dreamcatcherapp.R;
import com.example.dreamcatcherapp.databinding.StatsPackageBinding;

import java.util.List;

public class StatsPackagesFragmentAdapter extends RecyclerView.Adapter<StatsPackagesFragmentAdapter.StatsPackagesHolder> {

    List<StatsPackages> statsPackages;
    Context context;
    LayoutInflater inflater;
    public StatsPackagesFragmentAdapter (Context context, List<StatsPackages> packages){
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
