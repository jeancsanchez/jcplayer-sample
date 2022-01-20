package com.dev.hazhanjalal.sampleforjcplayer.utils;

import android.app.Activity;
import android.content.Context;

public class Utils {
    public static Context activeContext;
    
    public Utils(Context cn) {
        activeContext = cn;
    }
    
    
    public static Activity getActivity() {
        return ((Activity) activeContext);
    }
}
