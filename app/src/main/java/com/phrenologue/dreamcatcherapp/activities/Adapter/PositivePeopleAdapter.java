package com.phrenologue.dreamcatcherapp.activities.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PositivePeopleAdapter extends RecyclerView.Adapter<PositivePeopleAdapter.PositivePeopleHolder> {

    @NonNull
    @Override
    public PositivePeopleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PositivePeopleHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class PositivePeopleHolder extends RecyclerView.ViewHolder {
        public PositivePeopleHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
