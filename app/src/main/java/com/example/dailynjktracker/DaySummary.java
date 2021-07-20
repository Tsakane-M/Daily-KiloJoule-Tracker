package com.example.dailynjktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DaySummary extends AppCompatActivity {

    private HashMap<String,Double> summap;
    private HashMap<String,String> summap2;

    private TextView day1time;
    private TextView day2time;
    private TextView day3time;
    private TextView day4time;

    private TextView day1;
    private TextView day2;
    private TextView day3;
    private TextView day4;

    private TextView day1day;
    private TextView day2day;
    private TextView day3day;
    private TextView day4day;

    private TextView day1total;
    private Double day1totalv;
    private Double day2total;
    private Double day3total;
    private Double day4total;

    private TextView day1totalfood;
    private String day1totalfoodv;
    private String day2totalfood;
    private String day3totalfood;
    private String day4totalfood;

    private TextView day1totalex;
    private String day1totalexv;
    private String day2totalex;
    private String day3totalex;
    private String day4totalex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_summary);
        Bundle data = getIntent().getExtras();

        if(data==null){
            return;
        }
        try{
            summap  = (HashMap<String,Double>)data.getSerializable("hashmap");
            summap2  = (HashMap<String,String>)data.getSerializable("hashmap2");
        }
        catch (Exception e){return;}

        day1time = findViewById(R.id.day1date);
        day2time = findViewById(R.id.day2date);
        day3time = findViewById(R.id.day3date);
        day4time = findViewById(R.id.day4date);

        day1 = findViewById(R.id.day1);
        day2 = findViewById(R.id.day2);
        day3 = findViewById(R.id.day3);
        day4 = findViewById(R.id.day4);

        day1day = findViewById(R.id.day1day);
        day2day = findViewById(R.id.day2day);
        day3day = findViewById(R.id.day3day);
        day4day = findViewById(R.id.day4day);

        day1total = findViewById(R.id.totalnjk);
        day2total = 0.0;
        day3total = 0.0;
        day4total = 0.0;
        day1totalv = 0.0;

        day1totalfood = findViewById(R.id.foodtotal);
        day2totalfood = "0.0";
        day3totalfood = "0.0";
        day4totalfood = "0.0";
        day1totalfoodv = "0.0";


        day1totalex = findViewById(R.id.extotal);
        day2totalex = "0.0";
        day3totalex = "0.0";
        day4totalex = "0.0";
        day1totalexv = "0.0";


        Iterator<Map.Entry<String,String>> it2 = summap2.entrySet().iterator();
        int cc = 1;
        while (it2.hasNext()) {
            Map.Entry<String, String> pair2 = (Map.Entry<String, String>) it2.next();
            if(cc==1){
                day1totalfood.setText(String.valueOf(pair2.getValue()));
                day1totalfoodv = String.valueOf(pair2.getValue());
                day1totalex.setText(String.valueOf(pair2.getValue()));
                day1totalexv = String.valueOf(pair2.getValue());
            }
            else if(cc==2){
                day2totalfood = pair2.getValue();
                day2totalex = pair2.getValue();
            }
            else if(cc==3){
                day3totalfood = pair2.getValue();
                day3totalex = pair2.getValue();
            }
            else{
                day4totalfood = pair2.getValue();
                day4totalex = pair2.getValue();
            }
            ++cc;
        }


        Iterator<Map.Entry<String,Double>> it = summap.entrySet().iterator();
        int c = 1;
        while (it.hasNext()){
            Map.Entry<String,Double> pair = (Map.Entry<String, Double>)it.next();
            if(c==1){
                String keystr = pair.getKey();
                day1time.setText(keystr.substring(10));
                day1time.setVisibility(View.VISIBLE);
                day1.setVisibility(View.VISIBLE);
                day1day.setVisibility(View.VISIBLE);
                day1total.setText(String.valueOf(pair.getValue()));
                day1totalv = pair.getValue();
            }
            else if(c==2){
                String keystr = pair.getKey();
                day2time.setText(keystr.substring(10));
                day2time.setVisibility(View.VISIBLE);
                day2.setVisibility(View.VISIBLE);
                day2day.setVisibility(View.VISIBLE);
                day2total = pair.getValue();
            }
            else if(c==3){
                String keystr = pair.getKey();
                day3time.setText(keystr.substring(10));
                day3time.setVisibility(View.VISIBLE);
                day3.setVisibility(View.VISIBLE);
                day3day.setVisibility(View.VISIBLE);
                day3total = pair.getValue();
            }
            else{
                String keystr = pair.getKey();
                day4time.setText(keystr.substring(10));
                day4time.setVisibility(View.VISIBLE);
                day4.setVisibility(View.VISIBLE);
                day4day.setVisibility(View.VISIBLE);
                day4total = pair.getValue();
            }
            ++c;
        }


    }

    public void OpenDiary(View view){
        super.onBackPressed();
    }
    public void AddClicked(View view){
        Intent diary = new Intent(getApplicationContext(), Calc.class);
        startActivity(diary);
    }

    public void Home(View view){
        Intent dayone = new Intent(getApplicationContext(), MainActivity.class);
        //diary.putExtra("hashmap",days);
        startActivity(dayone);
    }

    public void DayOneClicked(View view){
        day1day.setTextColor(Color.parseColor("#FFFFFF"));
        day1time.setTextColor(Color.parseColor("#FFFFFF"));
        day1.setTextColor(Color.parseColor("#FFFFFF"));
        day1.setBackgroundResource(R.drawable.seletecteddaytoday);

        day2day.setTextColor(Color.parseColor("#9A9A9A"));
        day2time.setTextColor(Color.parseColor("#000000"));
        day2.setTextColor(Color.parseColor("#000000"));
        day2.setBackgroundResource(R.drawable.daytodaynav);

        day3day.setTextColor(Color.parseColor("#9A9A9A"));
        day3time.setTextColor(Color.parseColor("#000000"));
        day3.setTextColor(Color.parseColor("#000000"));
        day3.setBackgroundResource(R.drawable.daytodaynav);

        day4day.setTextColor(Color.parseColor("#9A9A9A"));
        day4time.setTextColor(Color.parseColor("#000000"));
        day4.setTextColor(Color.parseColor("#000000"));
        day4.setBackgroundResource(R.drawable.daytodaynav);
        day1total.setText(String.valueOf(day1totalv));

        int bstrindex = day1totalfoodv.indexOf("b");

        day1totalfood.setText(day1totalfoodv.substring(0,bstrindex));
        day1totalex.setText(day1totalexv.substring(bstrindex+1));

    }

    public void DayTwoClicked(View view){
        day2day.setTextColor(Color.parseColor("#FFFFFF"));
        day2time.setTextColor(Color.parseColor("#FFFFFF"));
        day2.setTextColor(Color.parseColor("#FFFFFF"));
        day2.setBackgroundResource(R.drawable.seletecteddaytoday);

        day1day.setTextColor(Color.parseColor("#9A9A9A"));
        day1time.setTextColor(Color.parseColor("#000000"));
        day1.setTextColor(Color.parseColor("#000000"));
        day1.setBackgroundResource(R.drawable.daytodaynav);

        day3day.setTextColor(Color.parseColor("#9A9A9A"));
        day3time.setTextColor(Color.parseColor("#000000"));
        day3.setTextColor(Color.parseColor("#000000"));
        day3.setBackgroundResource(R.drawable.daytodaynav);

        day4day.setTextColor(Color.parseColor("#9A9A9A"));
        day4time.setTextColor(Color.parseColor("#000000"));
        day4.setTextColor(Color.parseColor("#000000"));
        day4.setBackgroundResource(R.drawable.daytodaynav);
        day1total.setText(String.valueOf(day2total));

        int bstrindex = day1totalfoodv.indexOf("b");

        day1totalfood.setText(day2totalfood.substring(0,bstrindex));
        day1totalex.setText(day2totalex.substring(bstrindex+1));

    }

    public void DayThreeClicked(View view){
        day3day.setTextColor(Color.parseColor("#FFFFFF"));
        day3time.setTextColor(Color.parseColor("#FFFFFF"));
        day3.setTextColor(Color.parseColor("#FFFFFF"));
        day3.setBackgroundResource(R.drawable.seletecteddaytoday);

        day1day.setTextColor(Color.parseColor("#9A9A9A"));
        day1time.setTextColor(Color.parseColor("#000000"));
        day1.setTextColor(Color.parseColor("#000000"));
        day1.setBackgroundResource(R.drawable.daytodaynav);

        day2day.setTextColor(Color.parseColor("#9A9A9A"));
        day2time.setTextColor(Color.parseColor("#000000"));
        day2.setTextColor(Color.parseColor("#000000"));
        day2.setBackgroundResource(R.drawable.daytodaynav);

        day4day.setTextColor(Color.parseColor("#9A9A9A"));
        day4time.setTextColor(Color.parseColor("#000000"));
        day4.setTextColor(Color.parseColor("#000000"));
        day4.setBackgroundResource(R.drawable.daytodaynav);
        day1total.setText(String.valueOf(day3total));

        int bstrindex = day1totalfoodv.indexOf("b");

        day1totalfood.setText(day3totalfood.substring(0,bstrindex));
        day1totalex.setText(day3totalex.substring(bstrindex+1));

    }

    public void DayFourClicked(View view){
        day4day.setTextColor(Color.parseColor("#FFFFFF"));
        day4time.setTextColor(Color.parseColor("#FFFFFF"));
        day4.setTextColor(Color.parseColor("#FFFFFF"));
        day4.setBackgroundResource(R.drawable.seletecteddaytoday);

        day1day.setTextColor(Color.parseColor("#9A9A9A"));
        day1time.setTextColor(Color.parseColor("#000000"));
        day1.setTextColor(Color.parseColor("#000000"));
        day1.setBackgroundResource(R.drawable.daytodaynav);

        day2day.setTextColor(Color.parseColor("#9A9A9A"));
        day2time.setTextColor(Color.parseColor("#000000"));
        day2.setTextColor(Color.parseColor("#000000"));
        day2.setBackgroundResource(R.drawable.daytodaynav);

        day3day.setTextColor(Color.parseColor("#9A9A9A"));
        day3time.setTextColor(Color.parseColor("#000000"));
        day3.setTextColor(Color.parseColor("#000000"));
        day3.setBackgroundResource(R.drawable.daytodaynav);
        day1total.setText(String.valueOf(day4total));


        int bstrindex = day1totalfoodv.indexOf("b");

        day1totalfood.setText(day4totalfood.substring(0,bstrindex));
        day1totalex.setText(day4totalex.substring(bstrindex+1));


    }
}
