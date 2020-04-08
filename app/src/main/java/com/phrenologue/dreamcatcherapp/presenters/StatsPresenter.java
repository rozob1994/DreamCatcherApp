package com.phrenologue.dreamcatcherapp.presenters;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.phrenologue.dreamcatcherapp.R;
import com.phrenologue.dreamcatcherapp.ui.colorPalette.ColorPalettes;
import com.phrenologue.dreamcatcherapp.parameters.IResponseMessage;
import com.phrenologue.dreamcatcherapp.ui.costumeFont.MoonTextView;
import com.phrenologue.dreamcatcherapp.webservice.ApiPostCaller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.IntStream;

public class StatsPresenter {

    public void drawDreamRememberedPercent(Context context, PieChart rememberedChart) {
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getRemembered(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {
                JSONArray jsonArray = new JSONArray(response.toString());

                ArrayList<Integer> list = new ArrayList();

                for (int i = 0; i < jsonArray.length(); i++) {
                    list.add(jsonArray.getInt(i));
                }

                float countOnes = 0;
                float countZeroes = 0;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == 0) {
                        countZeroes++;
                    }
                    countOnes++;

                }

                ArrayList<PieEntry> entries = new ArrayList<>();
                entries.add(new PieEntry((countOnes * 100) / (countOnes + countZeroes), "Remembered"));
                entries.add(new PieEntry((countZeroes * 100) / (countOnes + countZeroes), "Forgotten"));
                PieDataSet pieDataSet = new PieDataSet(entries, "Percent of dreams remembered.");
                pieDataSet.setColors(ColorPalettes.PIECHARTS);
                pieDataSet.setValueTextColor(context.getResources().getColor(R.color.white));
                PieData pieData = new PieData(pieDataSet);
                Legend legend = rememberedChart.getLegend();
                legend.setEnabled(false);
                rememberedChart.setData(pieData);
                rememberedChart.invalidate();
                rememberedChart.setDrawHoleEnabled(false);

            }

            @Override
            public void onFailure(String errorMessage) {
            }
        });

    }

    public void drawSoundPercent(PieChart soundChart) {
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getSoundPercent(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {

                JSONArray jsonArray = new JSONArray(response.toString());

                ArrayList<Integer> list = new ArrayList();

                for (int i = 0; i < jsonArray.length(); i++) {
                    list.add(jsonArray.getInt(i));
                }

                float countOnes = 0;
                float countZeroes = 0;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == 0) {
                        countZeroes++;
                    }
                    countOnes++;

                }
                Log.e("", "");

                ArrayList<PieEntry> entries = new ArrayList<>();
                entries.add(new PieEntry((countOnes * 100) / (countOnes + countZeroes), "Has Sound"));
                entries.add(new PieEntry((countZeroes * 100) / (countOnes + countZeroes), "Mute"));
                PieDataSet pieDataSet = new PieDataSet(entries, "Percent of dreams with sounds.");
                pieDataSet.setColors(ColorPalettes.PIECHARTS);
                PieData pieData = new PieData(pieDataSet);
                soundChart.setData(pieData);
                soundChart.getLegend().setTextColor(R.color.design_default_color_secondary_variant);
                soundChart.invalidate();
                soundChart.setDrawHoleEnabled(false);
            }

            @Override
            public void onFailure(String errorMessage) {
                Log.e("", "");
            }
        });
    }

    public void drawMusicalPercent(PieChart musicalChart) {
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getMusicalPercent(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {

                JSONArray jsonArray = new JSONArray(response.toString());

                ArrayList<Integer> list = new ArrayList();

                for (int i = 0; i < jsonArray.length(); i++) {
                    list.add(jsonArray.getInt(i));
                }

                float countOnes = 0;
                float countZeroes = 0;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == 0) {
                        countZeroes++;
                    }
                    countOnes++;

                }
                Log.e("", "");

                ArrayList<PieEntry> entries = new ArrayList<>();
                entries.add(new PieEntry((countOnes * 100) / (countOnes + countZeroes), "Musical Dreams"));
                entries.add(new PieEntry((countZeroes * 100) / (countOnes + countZeroes), "Non-Musical Dreams"));
                PieDataSet pieDataSet = new PieDataSet(entries, "Percent of musical dreams.");
                pieDataSet.setColors(ColorPalettes.PIECHARTS);
                PieData pieData = new PieData(pieDataSet);
                musicalChart.setData(pieData);
                musicalChart.invalidate();
                musicalChart.setDrawHoleEnabled(false);
            }

            @Override
            public void onFailure(String errorMessage) {
                Log.e("", "");
            }
        });
    }

    public void drawColorfulPercent(PieChart colorfulChart) {
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getGrayScalePercent(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {

                JSONArray jsonArray = new JSONArray(response.toString());

                ArrayList<Integer> list = new ArrayList();

                for (int i = 0; i < jsonArray.length(); i++) {
                    list.add(jsonArray.getInt(i));
                }

                float countTwos = 0;
                float countOnes = 0;
                float countZeroes = 0;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == 0) {
                        countZeroes++;
                    } else if (list.get(j) == 1) {
                        countOnes++;
                    } else {
                        countTwos++;
                    }


                }
                Log.e("", "");

                ArrayList<PieEntry> entries = new ArrayList<>();
                entries.add(new PieEntry((countOnes * 100) / (countOnes + countTwos), "Grayscale dreams"));
                entries.add(new PieEntry((countTwos * 100) / (countOnes + countTwos), "Colorful dreams"));
                PieDataSet pieDataSet = new PieDataSet(entries, "Percent of colorful dreams.");
                pieDataSet.setColors(ColorPalettes.PIECHARTS);
                PieData pieData = new PieData(pieDataSet);
                colorfulChart.setData(pieData);
                colorfulChart.invalidate();
                colorfulChart.setDrawHoleEnabled(false);
            }

            @Override
            public void onFailure(String errorMessage) {
                Log.e("", "");
            }
        });
    }

    public void drawLucidityPercent(PieChart lucidityChart) {
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getLucidityPercent(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {

                JSONArray jsonArray = new JSONArray(response.toString());

                ArrayList<Integer> list = new ArrayList();

                for (int i = 0; i < jsonArray.length(); i++) {
                    list.add(jsonArray.getInt(i));
                }

                float countTwos = 0;
                float countOnes = 0;
                float countZeroes = 0;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == 0) {
                        countZeroes++;
                    } else if (list.get(j) == 1) {
                        countOnes++;
                    } else {
                        countTwos++;
                    }


                }
                Log.e("", "");

                ArrayList<PieEntry> entries = new ArrayList<>();
                entries.add(new PieEntry((countOnes * 100) / (countOnes + countTwos), "Grayscale dreams"));
                entries.add(new PieEntry((countTwos * 100) / (countOnes + countTwos), "Colorful dreams"));
                PieDataSet pieDataSet = new PieDataSet(entries, "Percent of colorful dreams.");
                pieDataSet.setColors(ColorPalettes.PIECHARTS);
                PieData pieData = new PieData(pieDataSet);
                lucidityChart.setData(pieData);
                lucidityChart.invalidate();
                lucidityChart.setDrawHoleEnabled(false);
            }

            @Override
            public void onFailure(String errorMessage) {
                Log.e("", "");
            }
        });
    }

    public void drawMoodPercent(PieChart moodChart) {
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getMoodPercent(new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {

                JSONArray jsonArray = new JSONArray(response.toString());

                ArrayList<Integer> list = new ArrayList();

                for (int i = 0; i < jsonArray.length(); i++) {
                    list.add(jsonArray.getInt(i));
                }
                float countNines = 0;
                float countEights = 0;
                float countSevens = 0;
                float countSixes = 0;
                float countFives = 0;
                float countFours = 0;
                float countThrees = 0;
                float countTwos = 0;
                float countOnes = 0;
                float countZeroes = 0;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == 0) {
                        countZeroes++;
                    } else if (list.get(j) == 1) {
                        countOnes++;
                    } else if (list.get(j) == 2) {
                        countTwos++;
                    } else if (list.get(j) == 3) {
                        countThrees++;
                    } else if (list.get(j) == 4) {
                        countFours++;
                    } else if (list.get(j) == 5) {
                        countFives++;
                    } else if (list.get(j) == 6) {
                        countSixes++;
                    } else if (list.get(j) == 7) {
                        countSevens++;
                    } else if (list.get(j) == 8) {
                        countEights++;
                    } else if (list.get(j) == 9) {
                        countNines++;
                    }
                }
                ArrayList<Float> counts = new ArrayList<Float>();
                counts.add(countZeroes);
                counts.add(countOnes);
                counts.add(countTwos);
                counts.add(countThrees);
                counts.add(countFours);
                counts.add(countFives);
                counts.add(countSixes);
                counts.add(countSevens);
                counts.add(countEights);
                counts.add(countNines);
                Log.e("", "");


                ArrayList<PieEntry> entries = new ArrayList<>();

                entries.add(new PieEntry(percentCalc(0, counts), "Worst Mood"));
                entries.add(new PieEntry(percentCalc(1, counts), "1"));
                entries.add(new PieEntry(percentCalc(2, counts), "2"));
                entries.add(new PieEntry(percentCalc(3, counts), "3"));
                entries.add(new PieEntry(percentCalc(4, counts), "4"));
                entries.add(new PieEntry(percentCalc(5, counts), "5"));
                entries.add(new PieEntry(percentCalc(6, counts), "6"));
                entries.add(new PieEntry(percentCalc(7, counts), "7"));
                entries.add(new PieEntry(percentCalc(8, counts), "8"));
                entries.add(new PieEntry(percentCalc(9, counts), "9"));
                PieDataSet pieDataSet = new PieDataSet(entries, "Percent of colorful dreams.");
                pieDataSet.setColors(ColorTemplate.PASTEL_COLORS);
                PieData pieData = new PieData(pieDataSet);
                moodChart.setData(pieData);
                moodChart.invalidate();
                moodChart.setDrawHoleEnabled(false);
            }

            @Override
            public void onFailure(String errorMessage) {
                Log.e("", "");
            }
        });
    }

    public static void drawSingleLucidityLevel(PieChart lucidityChart, int postId,
                                               MoonTextView percentageText) {
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getQResult(postId, new IResponseMessage() {
            @Override
            public void onSuccess(Object response) throws JSONException {

                JSONObject jsonObject = new JSONObject(response.toString());
                JSONArray jsonArray = jsonObject.getJSONArray("0");

                boolean status = jsonObject.getBoolean("status");
                if (status) {
                    int result = jsonArray.getJSONObject(0).getInt("result");
                    int percentage = (int) (((float) result / 38f) * 100);
                    String percentageStr = "%" + percentage + "" + " Lucid";
                    percentageText.setText(percentageStr);
                    int remainder = 100 - percentage;
                    ArrayList<PieEntry> entries = new ArrayList<>();
                    entries.add(new PieEntry(percentage, "Lucid"));
                    entries.add(new PieEntry(remainder, "Not Lucid"));
                    PieDataSet dataSet = new PieDataSet(entries, "Lucidity Percentage");
                    PieData pieData = new PieData(dataSet);
                    lucidityChart.setData(pieData);
                    lucidityChart.invalidate();
                    lucidityChart.setDrawHoleEnabled(false);
                }

            }

            @Override
            public void onFailure(String errorMessage) {
                Log.e("", "");
            }
        });
    }

    private float percentCalc(int index, ArrayList<Float> count) {
        float sumOfCounts = 0;
        for (int i = 0; i < count.size(); i++) {
            sumOfCounts = sumOfCounts + count.get(i);
        }
        float result = (count.get(index) / sumOfCounts) * 100;
        return result;
    }


    public void drawDailyMood(LineChart lineChart) {
        ApiPostCaller postCaller = new ApiPostCaller();
        postCaller.getDailyMood(new IResponseMessage() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSuccess(Object response) throws JSONException {
                JSONArray jsonArray = new JSONArray(response.toString());
                ArrayList<JSONArray> jsonArrays = new ArrayList();

                for (int i = 0; i < jsonArray.length(); i++) {
                    jsonArrays.add(jsonArray.getJSONArray(i));
                }

                Integer[] dayOfMonth = new Integer[jsonArrays.size()];
                Integer[] experience = new Integer[jsonArrays.size()];

                for (int j = 0; j < jsonArrays.size(); j++) {
                    dayOfMonth[j] = jsonArrays.get(j).getInt(0);
                    experience[j] = jsonArrays.get(j).getInt(1);
                }

                ArrayList<Entry> entries = new ArrayList<>();

                Integer[] second = IntStream.range(0, dayOfMonth.length)
                        .boxed()
                        .map(x -> new AbstractMap.SimpleEntry<>(dayOfMonth[x], experience[x]))
                        .sorted(Comparator.comparing(AbstractMap.SimpleEntry::getKey))
                        .map(AbstractMap.SimpleEntry::getValue)
                        .toArray(Integer[]::new);


                for (int i = 0; i < dayOfMonth.length; i++) {
                    entries.add(new Entry(dayOfMonth[i], second[i]));
                }
                Log.e("", "");
                LineDataSet set = new LineDataSet(entries, "Daily Mood Report");
                LineData data = new LineData(set);
                lineChart.setData(data);
                lineChart.invalidate();
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });
    }
}
