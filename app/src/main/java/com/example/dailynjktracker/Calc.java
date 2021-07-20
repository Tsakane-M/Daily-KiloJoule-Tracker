package com.example.dailynjktracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class Calc extends AppCompatActivity {

    private TextView food_cat;
    private TextView exer_cat;

    //check which one of categories is seleted
    private boolean selectedcatisfood;

    private TextView breakfast;
    private TextView lunch;
    private TextView dinner;

    private EditText edittext;
    private TextView send;

    private double totalnjk;
    private TextView totalnjkv;

    private double foodtotal;
    private TextView foodtotalv;

    private double exercisetotal;
    private TextView exercisetotalv;

    private SimpleDateFormat currentdate;
    private SimpleDateFormat currentdate2;
    private SimpleDateFormat currentdate3;

    private TextView todaydatetime;
    private String todaysdate;
    private  String todaysdateday;
    private  String todaysdatetime;

    private ImageView addbtn;

    private HashMap<String, Double> days;

    private HashMap<String, String> foodandexercise;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        food_cat = findViewById(R.id.foodcat);
        exer_cat = findViewById(R.id.exercat);

        selectedcatisfood = true;

        breakfast = findViewById(R.id.breakfast);
        lunch = findViewById(R.id.lunch);
        dinner = findViewById(R.id.dinner);

        edittext = findViewById(R.id.editText);
        send = findViewById(R.id.send);

        totalnjk = 0.0;
        totalnjkv = findViewById(R.id.totalnjk);

        foodtotal = 0.0;
        foodtotalv = findViewById(R.id.foodtotal);

        exercisetotal = 0.0;
        exercisetotalv = findViewById(R.id.extotal);

        currentdate = new SimpleDateFormat("EEE, d MMM HH:mm");
        String datetime = currentdate.format(new Date());

        currentdate2 = new SimpleDateFormat("EEE");
        String datetime2 = currentdate2.format(new Date());

        currentdate3 = new SimpleDateFormat("HH:mm");
        String datetime3 = currentdate2.format(new Date());

        todaydatetime = findViewById(R.id.todaydatetime);
        todaydatetime.setText(datetime);

        todaysdate = datetime;
        todaysdateday = datetime2;
        todaysdatetime = datetime3;

        addbtn = findViewById(R.id.addbtn);

        days = new HashMap<String, Double>();
        foodandexercise = new HashMap<String, String>();

    }

    public void FoodClicked(View view){
        food_cat.setTextColor(Color.parseColor("#52A646"));
        exer_cat.setTextColor(Color.parseColor("#000000"));

        breakfast.setText(R.string.f_breakfast);
        lunch.setText(R.string.f_lunch);
        dinner.setText(R.string.f_dinner);

        selectedcatisfood = true;

    }

    public void ExerciseClicked(View view){
        food_cat.setTextColor(Color.parseColor("#000000"));
        exer_cat.setTextColor(Color.parseColor("#52A646"));

        breakfast.setText(R.string.f_gym);
        lunch.setText(R.string.f_jogging);
        dinner.setText(R.string.f_workout);

        selectedcatisfood = false;
    }

    public void BreakfastClicked(View view){
        breakfast.setTextColor(Color.parseColor("#ffffff"));
        breakfast.setBackgroundResource(R.drawable.selectedcate);

        lunch.setTextColor(Color.parseColor("#9A9A9A"));
        lunch.setBackgroundResource(R.drawable.nonselectedcat);

        dinner.setTextColor(Color.parseColor("#9A9A9A"));
        dinner.setBackgroundResource(R.drawable.nonselectedcat);
    }

    public void LunchClicked(View view){
        lunch.setTextColor(Color.parseColor("#ffffff"));
        lunch.setBackgroundResource(R.drawable.selectedcate);

        breakfast.setTextColor(Color.parseColor("#9A9A9A"));
        breakfast.setBackgroundResource(R.drawable.nonselectedcat);

        dinner.setTextColor(Color.parseColor("#9A9A9A"));
        dinner.setBackgroundResource(R.drawable.nonselectedcat);
    }

    public void DinnerClicked(View view){
        dinner.setTextColor(Color.parseColor("#ffffff"));
        dinner.setBackgroundResource(R.drawable.selectedcate);

        breakfast.setTextColor(Color.parseColor("#9A9A9A"));
        breakfast.setBackgroundResource(R.drawable.nonselectedcat);

        lunch.setTextColor(Color.parseColor("#9A9A9A"));
        lunch.setBackgroundResource(R.drawable.nonselectedcat);
    }

    public void AddClicked(View view){
        if(edittext.getVisibility()==View.VISIBLE){
            edittext.setVisibility(View.INVISIBLE);
            send.setVisibility(View.INVISIBLE);
            addbtn.setImageResource(R.drawable.addg);
            days.put(todaysdate,totalnjk);

            String str = String.valueOf(foodtotal)+" b" +String.valueOf(exercisetotal);
            foodandexercise.put(todaysdate,str);
            String datetimenm = currentdate.format(new Date());
            todaysdate = datetimenm;
            todaydatetime.setText(todaysdate);

            totalnjk = 0.0;
            totalnjkv.setText("0.0");
            foodtotal = 0.0;
            foodtotalv.setText("0.0");
            exercisetotal = 0.0;
            exercisetotalv.setText("0.0");
            Toast toast = Toast.makeText(getApplicationContext(),"Saved to Diary",Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();

        }
        else{
            edittext.setVisibility(View.VISIBLE);
            send.setVisibility(View.VISIBLE);
            addbtn.setImageResource(R.drawable.uploadicon);
        }
    }

    public void Home(View view){
        if(days!=null){
            if(days.get(todaysdate)!=totalnjk){
                days.put(todaysdate,totalnjk);
            }
        }
        super.onBackPressed();
    }

    public void SaveData(View view){
        String userinput = edittext.getText().toString();
        Double inputnum = Double.valueOf(userinput);
        if(selectedcatisfood==true){
            Double y = foodtotal+inputnum;
            foodtotal = Math.round(y*10)/10.0;
        }
        else{
            Double z = exercisetotal+inputnum;
            exercisetotal = Math.round(z*10)/10.0;
        }

        Double x = foodtotal-exercisetotal;
        totalnjk = Math.round(x*10)/10.0;
        SaveToViews();
    }

    public void SaveToViews(){
        foodtotalv.setText(String.valueOf(foodtotal));
        //foodtotalv.setText(R.string.foodtotal);

        totalnjkv.setText(String.valueOf(totalnjk));
        //totalnjkv.setText(R.string.totalnjk);

        exercisetotalv.setText(String.valueOf(exercisetotal));
        //exercisetotalv.setText(R.string.exercisetotal);
        edittext.getText().clear();
    }

    //record to diary when diryis clicked and when state is closing, this intent must always take data
    public void OpenDiary(View view){
        Intent diary = new Intent(getApplicationContext(), DairyEntry.class);
        diary.putExtra("hashmap",days);
        diary.putExtra("hashmap2",foodandexercise);
        startActivity(diary);
    }
}
