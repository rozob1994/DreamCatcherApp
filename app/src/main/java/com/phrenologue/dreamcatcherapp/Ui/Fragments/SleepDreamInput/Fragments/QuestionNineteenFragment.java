package com.phrenologue.dreamcatcherapp.Ui.Fragments.SleepDreamInput.Fragments;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.Ui.costumeDialog.ViewDialog;
import com.phrenologue.dreamcatcherapp.databinding.FragmentQuestionNineteenBinding;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionNineteenFragment extends Fragment {

    private FragmentQuestionNineteenBinding binding;

    public QuestionNineteenFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentQuestionNineteenBinding.inflate(inflater,container,false);
        View view= binding.getRoot();

        binding.questionNineteen.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionNineteenTitle.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionNineteen.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        binding.btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();;
                QuestionEighteenFragment fragment = new QuestionEighteenFragment();
                transaction.replace(R.id.your_placeholder, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                container.removeAllViews();
            }
        });

        binding.btnResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("","");
                ViewDialog dialog= new ViewDialog();
                dialog.showDialog(getActivity(),getContext(),"");
            }
        });

        return view;
    }
}
