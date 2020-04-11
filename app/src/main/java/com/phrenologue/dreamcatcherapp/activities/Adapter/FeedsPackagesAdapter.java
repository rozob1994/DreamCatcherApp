package com.phrenologue.dreamcatcherapp.activities.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.models.FeedsPackages;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.FeedPackageBinding;

import java.util.List;

public class FeedsPackagesAdapter extends RecyclerView.Adapter<FeedsPackagesAdapter.FeedsPackagesHolder>{

    List<FeedsPackages> feedsPackages;
    Context context;
    LayoutInflater inflater;

    public FeedsPackagesAdapter (Context context, @Nullable List<FeedsPackages> packages) {
        this.context= context;
        feedsPackages= packages;
        inflater= LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public FeedsPackagesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.feed_package, null);
        return new FeedsPackagesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedsPackagesHolder holder, int position) {
        FeedsPackages packages= feedsPackages.get(position);

    }

    @Override
    public int getItemCount() {
        return feedsPackages.size();
    }

    class FeedsPackagesHolder extends RecyclerView.ViewHolder {

        private FeedPackageBinding binding;

        public FeedsPackagesHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

}
