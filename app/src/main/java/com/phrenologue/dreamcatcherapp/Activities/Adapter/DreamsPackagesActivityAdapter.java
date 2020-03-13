package com.phrenologue.dreamcatcherapp.Activities.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.databinding.DreamsPackageBinding;

import java.util.ArrayList;

public class DreamsPackagesActivityAdapter extends RecyclerView.Adapter<DreamsPackagesActivityAdapter.DreamsPackagesHolder> {
    RelativeLayout relativeLayout;
    AppCompatImageView navBar;
    AppCompatTextView title;
    AppCompatTextView content;
    ArrayList<String> titles;
    ArrayList<String> contents;
    Context context;
    LayoutInflater inflater;
    public DreamsPackagesActivityAdapter(Context context, @Nullable ArrayList<String> titles,
                                         @Nullable ArrayList<String> contents) {
        this.titles = titles;
        this.contents = contents;
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
        String titlec = titles.get(position);
        String contentc = contents.get(position);
        title.setText(titlec);
        content.setText(contentc);
        navBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menu= new PopupMenu(context, navBar);
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
        return titles.size();
    }

    class DreamsPackagesHolder extends RecyclerView.ViewHolder {

        private DreamsPackageBinding binding;

        public DreamsPackagesHolder(@NonNull View itemView) {
            super(itemView);
            binding = DreamsPackageBinding.inflate(inflater);
            navBar = binding.dreamsPackageNavBar;
            relativeLayout = binding.relDreamsPackage;
            title = binding.dreamsPackageTitle;
            content = binding.dreamsPackageDescription;




        }
    }
}
