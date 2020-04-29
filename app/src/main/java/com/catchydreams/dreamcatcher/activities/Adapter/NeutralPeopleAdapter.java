package com.catchydreams.dreamcatcher.activities.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NeutralPeopleAdapter extends RecyclerView.Adapter<NeutralPeopleAdapter.NeutralPeopleHolder> {

    @NonNull
    @Override
    public NeutralPeopleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NeutralPeopleHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class NeutralPeopleHolder extends RecyclerView.ViewHolder {
        public NeutralPeopleHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
