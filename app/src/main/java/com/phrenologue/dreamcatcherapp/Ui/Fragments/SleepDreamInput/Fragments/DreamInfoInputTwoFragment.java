package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.phrenologue.dreamcatcherapp.Activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.databinding.FragmentDreamInfoInputTwoBinding;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.dateParameters.parameters.Date;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.dreamParameters.DreamDescription;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class DreamInfoInputTwoFragment extends Fragment {

    private FragmentDreamInfoInputTwoBinding binding;
    Dream dream;
    DreamDescription description;
    Date date;

    public DreamInfoInputTwoFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDreamInfoInputTwoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        dream = Dream.getInstance();
        description = DreamDescription.getInstance();
        date = Date.getInstance();

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[BUTTON]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        binding.btnLoginAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiPostCaller postCaller = new ApiPostCaller();

                description.setContent(binding.edtTextTitle.getText().toString());
                description.setTitle(binding.edtTextTitle.getText().toString());
                dream.setDreamDescription(description);

                int day = Integer.parseInt(binding.spinnerDay.getSelectedItem().toString());
                String month = binding.spinnerMonth.getSelectedItem().toString();
                String year = binding.spinnerYear.getSelectedItem().toString();

                date.setCustomDay(year, month, day);

                postCaller.saveDreamSeparately(new IResponseMessage() {
                    @Override
                    public void onSuccess(Object response) throws JSONException {
                        JSONObject jsonObject = new JSONObject(response.toString());
                        boolean status = jsonObject.getBoolean("status");
                        Log.e("", "");
                        if (status) {
                            postCaller.addDateToSleep(new IResponseMessage() {
                                @Override
                                public void onSuccess(Object response) throws JSONException {
                                    JSONObject jsonObject1 = new JSONObject(response.toString());
                                    boolean status1 = jsonObject1.getBoolean("status");
                                    if (status1) {
                                        Dream.delDream();
                                        Sleep.delSleep();
                                        Toast.makeText(getContext(), "Dream Saved.",
                                                Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(getContext(),
                                                ProfileActivity.class);
                                        startActivity(intent);
                                    }
                                }

                                @Override
                                public void onFailure(String errorMessage) {
                                    Toast.makeText(getContext(),"Date couldn't be added to sleep entry.",
                                            Toast.LENGTH_LONG).show();
                                }
                            });

                            Log.e("", "");

                        } else {
                            Toast.makeText(getContext(), "Dream saving failed.",
                                    Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(String errorMessage) {
                        Toast.makeText(getContext(), "Connection Failed",
                                Toast.LENGTH_LONG).show();
                    }
                });

            }
        });


        return view;
    }
}
