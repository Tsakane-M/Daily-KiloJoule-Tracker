package com.example.dailynjktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DairyEntry extends AppCompatActivity {

    public HashMap<String,Double> diarydays;
    public HashMap<String,String> diarydays2;
    private TextView date1;
    private ImageView imgone;
    private TextView njkone;

    private TextView date2;
    private ImageView imgtwo;
    private TextView njktwo;

    private TextView date3;
    private ImageView imgthree;
    private TextView njkthree;

    private TextView date4;
    private ImageView imgfour;
    private TextView njkfour;

    private TextView avgtextv;
    private Double avg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_entry);
        Bundle data = getIntent().getExtras();

        if(data==null){
            return;
        }
        try{
            diarydays = (HashMap<String,Double>)data.getSerializable("hashmap");
            diarydays2 = (HashMap<String,String>)data.getSerializable("hashmap2");
        }
        catch (Exception e){return;}


        imgone = findViewById(R.id.dayone);
        njkone = findViewById(R.id.njkpdayvalue1);
        date1 = findViewById(R.id.datetime1);

        imgtwo = findViewById(R.id.daytwo);
        njktwo = findViewById(R.id.njkpdayvalue2);
        date2 = findViewById(R.id.datetime2);

        imgthree = findViewById(R.id.daythree);
        njkthree = findViewById(R.id.njkpdayvalue3);
        date3 = findViewById(R.id.datetime3);

        imgfour = findViewById(R.id.dayfour);
        njkfour = findViewById(R.id.njkpdayvalue4);
        date4 = findViewById(R.id.datetime4);

        avgtextv = findViewById(R.id.avrgnjkvalue);
        avg = 0.0;
    }

    @Override
    protected void onStart() {
        MakeDiary();
        super.onStart();
    }

    public void MakeDiary(){
        Iterator<Map.Entry<String,Double>> it = diarydays.entrySet().iterator();

        int d1 = 1;
        while (it.hasNext()){
            Map.Entry<String,Double> pair = (Map.Entry<String, Double>)it.next();
            if(d1==1){
                date1.setText(pair.getKey());
                njkone.setText(String.valueOf(pair.getValue()));
                avg = avg+pair.getValue();
                imgone.setVisibility(View.VISIBLE);
                date1.setVisibility(View.VISIBLE);
                njkone.setVisibility(View.VISIBLE);

            }
            else if(d1==2){
                date2.setText(pair.getKey());
                njktwo.setText(String.valueOf(pair.getValue()));
                avg = avg+pair.getValue();
                imgtwo.setVisibility(View.VISIBLE);
                date2.setVisibility(View.VISIBLE);
                njktwo.setVisibility(View.VISIBLE);
            }
            else if(d1==3){
                date3.setText(pair.getKey());
                njkthree.setText(String.valueOf(pair.getValue()));
                avg = avg+pair.getValue();
                imgthree.setVisibility(View.VISIBLE);
                date3.setVisibility(View.VISIBLE);
                njkthree.setVisibility(View.VISIBLE);
            }
            else{
                date4.setText(pair.getKey());
                njkfour.setText(String.valueOf(pair.getValue()));
                avg = avg+pair.getValue();
                imgfour.setVisibility(View.VISIBLE);
                date4.setVisibility(View.VISIBLE);
                njkfour.setVisibility(View.VISIBLE);
            }
            avgtextv.setText(String.valueOf(avg/diarydays.size()));
            ++d1;
        }

    }

    public void OpenDayOne(View view){

        Intent day = new Intent(getApplicationContext(), DaySummary.class);
        day.putExtra("hashmap",diarydays);
        day.putExtra("hashmap2",diarydays2);
        startActivity(day);
    }

    public void OpenDayTwo(View view){
        Intent day = new Intent(getApplicationContext(), DaySummary.class);
        day.putExtra("hashmap",diarydays);
        day.putExtra("hashmap2",diarydays2);
        startActivity(day);
    }
    public void OpenDayThree(View view){
        Intent day = new Intent(getApplicationContext(), DaySummary.class);
        day.putExtra("hashmap",diarydays);
        day.putExtra("hashmap2",diarydays2);
        startActivity(day);
    }
    public void OpenDayFour(View view){
        Intent day = new Intent(getApplicationContext(), DaySummary.class);
        day.putExtra("hashmap",diarydays);
        day.putExtra("hashmap2",diarydays2);
        startActivity(day);
    }

    public void AddClicked(View view){
        super.onBackPressed();
    }

    public void Home(View view){
        Intent dayone = new Intent(getApplicationContext(), MainActivity.class);
        //diary.putExtra("hashmap",days);
        startActivity(dayone);
    }


}
