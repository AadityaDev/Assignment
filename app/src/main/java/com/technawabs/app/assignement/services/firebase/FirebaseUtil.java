package com.technawabs.app.assignement.services.firebase;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.HashMap;

public class FirebaseUtil {

    public static void logEvents(Bundle bundle, String eventName ,FirebaseAnalytics mFirebaseAnalytics){
        if(bundle!=null&&mFirebaseAnalytics!=null&&eventName!=null){
            mFirebaseAnalytics.logEvent(eventName,bundle);
        }
    }


}
