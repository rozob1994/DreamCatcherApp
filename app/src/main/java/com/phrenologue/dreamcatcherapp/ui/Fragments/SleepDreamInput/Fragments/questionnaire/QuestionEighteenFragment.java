package com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.activities.viewInterfaces.IQuestionnaire;
import com.phrenologue.dreamcatcherapp.presenters.QuestionnairePresenter;

import java.util.Objects;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionEighteenFragment extends Fragment implements IQuestionnaire {

    private com.phrenologue.dreamcatcherapp.databinding.FragmentQuestionEighteenBinding binding;
    private AppCompatCheckBox yesBtn, notSureBtn, noBtn;
    private int questionNo;
    private QuestionnairePresenter presenter;

    public QuestionEighteenFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= com.phrenologue.dreamcatcherapp.databinding.FragmentQuestionEighteenBinding.inflate(inflater, container, false);
        View view= binding.getRoot();

        SharedPreferences sp = Objects.requireNonNull(getContext()).getSharedPreferences("questionnaire",
                Context.MODE_PRIVATE);
        presenter = new QuestionnairePresenter(this);
        yesBtn = binding.checkboxYesBtn;
        notSureBtn = binding.checkboxNotSureBtn;
        noBtn = binding.checkboxNoBtn;
        questionNo = 18;
        SharedPreferences languagePrefs = getContext().getSharedPreferences("languages", Context.MODE_PRIVATE);
        presenter.setTypeFace(languagePrefs);
        if (sp.getBoolean("hasAns" + questionNo + "", false)) {
            presenter.loadAns(sp, questionNo, yesBtn, notSureBtn, noBtn);
        }

        presenter.saveAns(sp, questionNo,yesBtn,notSureBtn,noBtn);

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();;
                QuestionNineteenFragment fragment = new QuestionNineteenFragment();
                transaction.replace(R.id.your_placeholder, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                container.removeAllViews();
            }
        });

        binding.btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();;
                QuestionSeventeenFragment fragment = new QuestionSeventeenFragment();
                transaction.replace(R.id.your_placeholder, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                container.removeAllViews();
            }
        });

        return view;
    }

    @Override
    public void setPersianTypeFace() {
        Typeface fontTitle = Typeface.createFromAsset(getContext().getAssets(), "fonts/kalameh_black.ttf");
        Typeface fontSubTitle = Typeface.createFromAsset(getContext().getAssets(), "fonts/kalameh_bold.ttf");
        binding.questionEighteenTitle.setTypeface(fontTitle);
        binding.questionEighteen.setTypeface(fontSubTitle);
        binding.checkboxYesBtn.setTypeface(fontTitle);
        binding.checkboxNoBtn.setTypeface(fontTitle);
        binding.checkboxNotSureBtn.setTypeface(fontTitle);
        binding.btnNext.setTypeface(fontTitle);
        binding.btnPrev.setTypeface(fontTitle);
    }

    @Override
    public void setPersianFontSize() {
        binding.questionEighteenTitle.setTextSize(30f);
        binding.questionEighteen.setTextSize(25f);
        binding.checkboxYesBtn.setTextSize(20f);
        binding.checkboxNoBtn.setTextSize(20f);
        binding.checkboxNotSureBtn.setTextSize(20f);
        binding.btnNext.setTextSize(20f);
        binding.btnPrev.setTextSize(20f);
    }

    @Override
    public void setEnglishTypeFace() {
        binding.questionEighteen.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionEighteenTitle.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionEighteen.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
    }
}
