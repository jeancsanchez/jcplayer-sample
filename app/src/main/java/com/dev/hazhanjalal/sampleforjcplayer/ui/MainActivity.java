package com.dev.hazhanjalal.sampleforjcplayer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.dev.hazhanjalal.sampleforjcplayer.R;
import com.dev.hazhanjalal.sampleforjcplayer.utils.Utils;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new Utils(this);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        
        Utils.activeContext = this;
    }
    
    
    public void openSecond(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}