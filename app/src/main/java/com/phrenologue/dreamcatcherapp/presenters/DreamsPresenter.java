package com.phrenologue.dreamcatcherapp.presenters;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.phrenologue.dreamcatcherapp.Activities.Adapter.DreamsPackagesActivityAdapter;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class DreamsPresenter {
    private Context context;
    public DreamsPresenter(Context context){
        this.context = context;
    }

    public void getDescription(RecyclerView dreamRecycler){
        ;
    }
}
