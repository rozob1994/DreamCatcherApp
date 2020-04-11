package com.phrenologue.dreamcatcherapp.ui.Fragments.SleepDreamInput.Fragments.questionnaire;

import android.content.Context;
import android.content.Intent;
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
import com.phrenologue.dreamcatcherapp.activities.ProfileActivity;
import com.phrenologue.dreamcatcherapp.databinding.FragmentQuestionNineteenBinding;
import com.phrenologue.dreamcatcherapp.managersAndFilters.SharedPreferencesManager;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.parameters.QuestionnaireEntry;
import com.phrenologue.dreamcatcherapp.parameters.Users;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Dream;
import com.phrenologue.dreamcatcherapp.parameters.postParameters.majorParameters.Sleep;
import com.phrenologue.dreamcatcherapp.presenters.QuestionnairePresenter;
import com.phrenologue.dreamcatcherapp.ui.costumeDialog.ViewDialog;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import maes.tech.intentanim.CustomIntent;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionNineteenFragment extends Fragment {

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
        presenter = new QuestionnairePresenter();
        yesBtn = binding.checkboxYesBtn;
        notSureBtn = binding.checkboxNotSureBtn;
        noBtn = binding.checkboxNoBtn;
        questionNo = 19;
        sp2 = getContext().getSharedPreferences("dreamToLucidityQuestionnaire", Context.MODE_PRIVATE);

        if (sp.getBoolean("hasAns" + questionNo + "", false)) {
            presenter.loadAns(sp, questionNo, yesBtn, notSureBtn, noBtn);
        }

        presenter.saveAns(sp, questionNo, yesBtn, notSureBtn, noBtn);

        binding.questionNineteen.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionNineteenTitle.setTypeface(Typeface.DEFAULT_BOLD);
        binding.questionNineteen.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

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
                                            sp2.edit().clear().apply();
                                            Dream.delDream();
                                            Sleep.delSleep();
                                            QuestionnaireEntry.delQuestionnaireEntry();
                                            SharedPreferencesManager.clearDreamSleepQuest(Objects.requireNonNull(getContext()));
                                            Intent intent = new Intent(getContext(), ProfileActivity.class);
                                            startActivity(intent);
                                            CustomIntent.customType(getContext(), "fadein-to-fadeout");
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
                                ViewDialog dialog = new ViewDialog();
                                dialog.showDialog(getActivity(), getContext(), "");
                            }
                        }

                        @Override
                        public void onFailure(String errorMessage) {

                        }
                    }, 0);
                }


            }
        });

        return view;
    }
}
