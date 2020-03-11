package com.phrenologue.dreamcatcherapp.Activities.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.Models.DreamsPackages;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.DreamsPackageBinding;

import java.util.List;

public class DreamsPackagesActivityAdapter extends RecyclerView.Adapter<DreamsPackagesActivityAdapter.DreamsPackagesHolder> {

    List<DreamsPackages> dreamsPackages;
    Context context;
    LayoutInflater inflater;
    public DreamsPackagesActivityAdapter(Context context, @Nullable List<DreamsPackages>  packages ) {
        dreamsPackages= packages;
        this.context= context;
        inflater= LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public DreamsPackagesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.dreams_package, null);
        return new DreamsPackagesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DreamsPackagesHolder holder, int position) {
        DreamsPackages packages= dreamsPackages.get(position);

        holder.binding.dreamsPackageNavBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menu= new PopupMenu(context, holder.binding.dreamsPackageNavBar);
                menu.inflate(R.menu.tabs);
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){
                            case R.id.edit:

                                break;

                            case R.id.delete:

                                break;
                        }
                        return false;
                    }
                });

            }
        });

    }

    @Override
    public int getItemCount() {
        return dreamsPackages.size();
    }

    class DreamsPackagesHolder extends RecyclerView.ViewHolder {

        private DreamsPackageBinding binding;

        public DreamsPackagesHolder(@NonNull View itemView) {
            super(itemView);


        }
    }
}
