package com.dev.hazhanjalal.sampleforjcplayer.implementations;

import android.app.Dialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.dev.hazhanjalal.sampleforjcplayer.R;
import com.dev.hazhanjalal.sampleforjcplayer.utils.Utils;
import com.example.jean.jcplayer.JcPlayerManagerListener;
import com.example.jean.jcplayer.general.JcStatus;
import com.example.jean.jcplayer.model.JcAudio;
import com.example.jean.jcplayer.view.JcPlayerView;

import java.util.ArrayList;

public class ShowAudioPlayer {
    static String contextText = "";
    static Dialog dialog;
    static JcPlayerView audio_player;
    static ArrayList<JcAudio> jcAudios;
    static JcPlayerManagerListener audioManager;
    
    //called from SeconActivity
    public static void showAudioPlayer() {
        if (dialog == null || (!Utils.activeContext.toString().equals(contextText))) {
            
            //init dialog
            dialog = new Dialog(Utils.activeContext, R.style.alert_fullscreen_default_background);
            dialog.setContentView(R.layout.layout_audio_player);
            
            audio_player = dialog.findViewById(R.id.audio_player);
            
            //used to check if next call is from same context. (the second part of the if statement.)
            contextText = Utils.activeContext.toString();
        }
        
        ImageView imgDismiss = dialog.findViewById(R.id.imgDismiss);
        imgDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        
        //add playlist data
        refreshAudio();
        
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.TOP;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setAttributes(wlp);
        
        dialog.show();
    }
    
    private static void refreshAudio() {
        if (jcAudios == null) {
            jcAudios = new ArrayList<>();
        } else {
            jcAudios.clear();
        }
        
        //adding values to the playlist
        addDataToPlaylist();
        
        //I had it always init the manager before (no null check then init), had same results.
        if (audioManager == null) {
            audioManager = new JcPlayerManagerListener() {
                @Override
                public void onPreparedAudio(JcStatus jcStatus) {
                    //put it here so it displays notification upon playing audio.
                    audio_player.createNotification(R.mipmap.ic_launcher);
                    
                    /*
                    In my main app I have another condition here that looks at the audio file playing
                    and performs another action based on the file that is playing.
                     */
                    
                }
                
                @Override
                public void onCompletedAudio() {
                
                }
                
                @Override
                public void onPaused(JcStatus jcStatus) {
                
                }
                
                @Override
                public void onContinueAudio(JcStatus jcStatus) {
                }
                
                @Override
                public void onPlaying(JcStatus jcStatus) {
                }
                
                @Override
                public void onTimeChanged(JcStatus jcStatus) {
                }
                
                @Override
                public void onStopped(JcStatus jcStatus) {
                }
                
                @Override
                public void onJcpError(Throwable throwable) {
                
                }
            };
            
        }
        
        audio_player.initPlaylist(jcAudios, audioManager);
    }
    
    public static void addDataToPlaylist() {
        jcAudios.add(JcAudio.createFromURL("Longing Redemptions", "http://haxhan.6te.net/longing.mp3"));
        jcAudios.add(JcAudio.createFromURL("The Island", "http://haxhan.6te.net//the_island.mp3"));
        // ...
    }
}
