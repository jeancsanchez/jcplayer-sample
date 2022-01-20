package com.dev.hazhanjalal.sampleforjcplayer.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.dev.hazhanjalal.sampleforjcplayer.R;
import com.dev.hazhanjalal.sampleforjcplayer.implementations.ShowAudioPlayer;
import com.dev.hazhanjalal.sampleforjcplayer.utils.Utils;

public class SecondActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        Utils.activeContext = this;
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return super.onCreateOptionsMenu(menu);
        
    }
    
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_audio:
                ShowAudioPlayer.showAudioPlayer();
                break;
            case android.R.id.home:
                finish();
                break;
        }
        
        return super.onOptionsItemSelected(item);
    }
    
}