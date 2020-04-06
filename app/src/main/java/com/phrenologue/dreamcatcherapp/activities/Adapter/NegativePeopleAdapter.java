package com.phrenologue.dreamcatcherapp.activities.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NegativePeopleAdapter extends RecyclerView.Adapter<NegativePeopleAdapter.NegativePeopleHolder> {


    @NonNull
    @Override
    public NegativePeopleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NegativePeopleHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class NegativePeopleHolder extends RecyclerView.ViewHolder {
        public NegativePeopleHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
