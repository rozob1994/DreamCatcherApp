package com.catchydreams.dreamcatcher.activities.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.catchydreams.dreamcatcher.R;

public class PositivePeopleAdapter extends RecyclerView.Adapter<PositivePeopleAdapter.PositivePeopleHolder> {

    LayoutInflater inflater;

    //public PostivePeopleAdapter (Context context, ){}


    @NonNull
    @Override
    public PositivePeopleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.postive_people_package, parent, false);
        return new PositivePeopleHolder(view);
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
