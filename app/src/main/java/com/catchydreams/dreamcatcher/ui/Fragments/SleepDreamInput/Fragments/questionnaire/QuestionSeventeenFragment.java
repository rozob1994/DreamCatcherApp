package com.catchydreams.dreamcatcher.ui.Fragments.SleepDreamInput.Fragments.questionnaire;

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

import com.catchydreams.dreamcatcher.R;
import com.catchydreams.dreamcatcher.activities.viewInterfaces.IQuestionnaire;
import com.catchydreams.dreamcatcher.databinding.FragmentQuestionSeventeenBinding;
import com.catchydreams.dreamcatcher.presenters.QuestionnairePresenter;

import java.util.Objects;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionSeventeenFragment extends Fragment implements IQuestionnaire {

    private FragmentQuestionSeventeenBinding binding;
    private AppCompatCheckBox yesBtn, notSureBtn, noBtn;
    private int questionNo;
    private QuestionnairePresenter presenter;

    public QuestionSeventeenFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentQuestionSeventeenBinding.inflate(inflater, container, false);
        View view= binding.getRoot();

        SharedPreferences sp = Objects.requireNonNull(getContext()).getSharedPreferences("questionnaire",
                Context.MODE_PRIVATE);
        presenter = new QuestionnairePresenter(this);
        yesBtn = binding.checkboxYesBtn;
        notSureBtn = binding.checkboxNotSureBtn;
        noBtn = binding.checkboxNoBtn;
        questionNo = 17;
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
                QuestionEighteenFragment fragment = new QuestionEighteenFragment();
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
                QuestionSixteenFragment fragment = new QuestionSixteenFragment();
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
        binding.questionSeventeenTitle.setTypeface(fontTitle);
        binding.questionSeventeen.setTypeface(fontSubTitle);
        binding.checkboxYesBtn.setTypeface(fontTitle);
        binding.checkboxNoBtn.setTypeface(fontTitle);
        binding.checkboxNotSureBtn.setTypeface(fontTitle);
        binding.btnNext.setTypeface(fontTitle);
        binding.btnPrev.setTypeface(fontTitle);
    }

    @Override
    public void setPersianFontSize() {
        binding.questionSeventeenTitle.setTextSize(30f);
        binding.questionSeventeen.setTextSize(25f);
        binding.checkboxYesBtn.setTextSize(20f);
        binding.checkboxNoBtn.setTextSize(20f);
        binding.checkboxNotSureBtn.setTextSize(20f);
        binding.btnNext.setTextSize(20f);
        binding.btnPrev.setTextSize(20f);
    }

    @Override
    public void setEnglishTypeFace() {
        binding.questionSeventeen.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionSeventeenTitle.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionSeventeen.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
    }

    @Override
    public void onLanguageChanged() {

    }
}
