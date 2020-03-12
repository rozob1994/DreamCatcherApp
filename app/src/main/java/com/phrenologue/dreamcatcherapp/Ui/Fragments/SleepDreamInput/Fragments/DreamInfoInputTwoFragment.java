package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import com.phrenologue.dreamcatcherapp.Activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.databinding.FragmentDreamInfoInputTwoBinding;
import com.phrenologue.dreamcatcherapp.presenters.DreamInputPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DreamInfoInputTwoFragment extends Fragment {
    DreamInputPresenter presenter;
    private FragmentDreamInfoInputTwoBinding binding;
    AppCompatEditText title, content;
    Spinner day, month, year;

    public DreamInfoInputTwoFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDreamInfoInputTwoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        presenter = new DreamInputPresenter();
        title = binding.edtTextTitle;
        content = binding.edtTxtContent;
        day = binding.spinnerDay;
        month = binding.spinnerMonth;
        year = binding.spinnerYear;

        //_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_[BUTTON]_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_//

        binding.btnLoginAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean dreamSaved = presenter.saveCompleteDream(title, content, day, month, year);
                if (dreamSaved) {
                    Toast.makeText(getContext(), "Dream Saved.",
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getContext(),
                            ProfileActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "Error.", Toast.LENGTH_LONG).show();
                    Log.e("","");
                }


            }
        });


        return view;
    }
}
