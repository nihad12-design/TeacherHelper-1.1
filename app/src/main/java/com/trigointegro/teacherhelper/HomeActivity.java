package com.trigointegro.teacherhelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView salarytxt, marktxt;
    CardView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        salarytxt = findViewById(R.id.SalaryText);
        info = findViewById(R.id.Info);
        marktxt = findViewById(R.id.MarkText);
        salarytxt.setOnClickListener(v -> {
            Intent Salaryactivity = new Intent(HomeActivity.this, SalaryActivity.class);
            startActivity(Salaryactivity);
        });
        info.setOnClickListener(v -> Toast.makeText(HomeActivity.this, "Emal Mərhələsindədir", Toast.LENGTH_SHORT).show());
        marktxt.setOnClickListener(v -> {
            Intent YearlyPriceActivity = new Intent(HomeActivity.this, YearlyPriceActivity.class);
            startActivity(YearlyPriceActivity);
        });
    }

}