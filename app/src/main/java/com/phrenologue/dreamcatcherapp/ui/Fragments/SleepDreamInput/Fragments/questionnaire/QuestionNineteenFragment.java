package com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.activities.viewInterfaces.IQuestionnaire;
import com.phrenologue.dreamcatcherapp.databinding.FragmentQuestionNineteenBinding;
import com.phrenologue.dreamcatcherapp.managersAndFilters.SharedPreferencesManager;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.QuestionnaireEntry;
import com.phrenologue.dreamcatcherapp.parameters.Users;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.presenters.QuestionnairePresenter;
import com.phrenologue.dreamcatcherapp.ui.customDialog.dialogViews.LucidityResutlsDialog;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionNineteenFragment extends Fragment implements IQuestionnaire {

    private FragmentQuestionNineteenBinding binding;
    private AppCompatCheckBox yesBtn, notSureBtn, noBtn;
    private int questionNo;
    private QuestionnairePresenter presenter;
    private SharedPreferences sp2;

    public QuestionNineteenFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuestionNineteenBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        SharedPreferences sp = Objects.requireNonNull(getContext()).getSharedPreferences("questionnaire",
                Context.MODE_PRIVATE);
        presenter = new QuestionnairePresenter(this);
        yesBtn = binding.checkboxYesBtn;
        notSureBtn = binding.checkboxNotSureBtn;
        noBtn = binding.checkboxNoBtn;
        questionNo = 19;
        sp2 = getContext().getSharedPreferences("dreamToLucidityQuestionnaire", Context.MODE_PRIVATE);
        SharedPreferences languagePrefs = getContext().getSharedPreferences("languages", Context.MODE_PRIVATE);
        presenter.setTypeFace(languagePrefs);
        if (sp.getBoolean("hasAns" + questionNo + "", false)) {
            presenter.loadAns(sp, questionNo, yesBtn, notSureBtn, noBtn);
        }

        presenter.saveAns(sp, questionNo, yesBtn, notSureBtn, noBtn);

        binding.btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                QuestionEighteenFragment fragment = new QuestionEighteenFragment();
                transaction.replace(R.id.your_placeholder, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                container.removeAllViews();
            }
        });
        ApiPostCaller postCaller = new ApiPostCaller();


        binding.btnResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sp2.getBoolean("fromDream", false)) {
                    Users.getInstance().checkSetLevelChange(getContext());
                    QuestionnaireEntry entry = QuestionnaireEntry.getInstance();
                    entry.setResult();
                    postCaller.postQEntry(new IResponseMessage() {
                        @Override
                        public void onSuccess(Object response) throws JSONException {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            boolean status = jsonObject.getBoolean("status");
                            if (status) {
                                postCaller.addLucidityToDream(new IResponseMessage() {
                                    @Override
                                    public void onSuccess(Object response) throws JSONException {
                                        JSONObject jsonObject1 = new JSONObject(response.toString());
                                        boolean status = jsonObject1.getBoolean("status");
                                        if (status) {
                                            entry.setId(jsonObject.getInt("id"));
                                            SharedPreferencesManager.clearDreamSleepQuest(Objects.requireNonNull(getContext()));
                                            LucidityResutlsDialog dialog = new LucidityResutlsDialog();
                                            dialog.showDialog(getActivity(), getContext(), "");
                                        } else {
                                            Toast.makeText(getContext(), "Error Saving Results",
                                                    Toast.LENGTH_LONG).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(String errorMessage) {
                                        Toast.makeText(getContext(), "Connection Error.",
                                                Toast.LENGTH_LONG).show();
                                    }
                                });



                            } else {
                                Toast.makeText(getContext(), "Error Saving Results",
                                        Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(String errorMessage) {
                            Toast.makeText(getContext(), "Connection Error.",
                                    Toast.LENGTH_LONG).show();
                        }
                    }, Dream.getInstance().getPostId());

                } else {
                    binding.loadingBg.setVisibility(View.VISIBLE);
                    binding.loadingBg.setAlpha(0.5f);
                    Users user = Users.getInstance();
                    user.checkSetLevelChange(getContext());
                    QuestionnaireEntry entry = QuestionnaireEntry.getInstance();
                    entry.setResult();
                    sp2.edit().clear().apply();
                    postCaller.postQEntry(new IResponseMessage() {
                        @Override
                        public void onSuccess(Object response) throws JSONException {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            boolean status = jsonObject.getBoolean("status");
                            if (status) {
                                entry.setId(jsonObject.getInt("id"));
                                binding.loadingBg.setVisibility(View.GONE);
                                LucidityResutlsDialog dialog = new LucidityResutlsDialog();
                                dialog.showDialog(getActivity(), getContext(), "");
                            } else {
                                Toast.makeText(getContext(), "Error Saving Resutls",
                                        Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(String errorMessage) {
                            Toast.makeText(getContext(), "Connection Error.", Toast.LENGTH_LONG).show();

                        }
                    }, 0);
                }


            }
        });

        return view;
    }

    @Override
    public void setPersianTypeFace() {
        Typeface fontTitle = Typeface.createFromAsset(getContext().getAssets(), "fonts/kalameh_black.ttf");
        Typeface fontSubTitle = Typeface.createFromAsset(getContext().getAssets(), "fonts/kalameh_bold.ttf");
        binding.questionNineteenTitle.setTypeface(fontTitle);
        binding.questionNineteen.setTypeface(fontSubTitle);
        binding.checkboxYesBtn.setTypeface(fontTitle);
        binding.checkboxNoBtn.setTypeface(fontTitle);
        binding.checkboxNotSureBtn.setTypeface(fontTitle);
        binding.btnResults.setTypeface(fontTitle);
        binding.btnPrev.setTypeface(fontTitle);
    }

    @Override
    public void setPersianFontSize() {
        binding.questionNineteenTitle.setTextSize(30f);
        binding.questionNineteen.setTextSize(25f);
        binding.checkboxYesBtn.setTextSize(20f);
        binding.checkboxNoBtn.setTextSize(20f);
        binding.checkboxNotSureBtn.setTextSize(20f);
        binding.btnResults.setTextSize(20f);
        binding.btnPrev.setTextSize(20f);
    }

    @Override
    public void setEnglishTypeFace() {
        binding.questionNineteen.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionNineteenTitle.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionNineteen.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
    }

    @Override
    public void onLanguageChanged() {

    }
}
