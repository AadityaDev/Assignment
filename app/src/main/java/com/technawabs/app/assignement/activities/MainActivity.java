package com.technawabs.app.assignement.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.crashlytics.android.Crashlytics;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;
import com.technawabs.app.assignement.R;
import com.technawabs.app.assignement.constants.AppAnalyticEvents;
import com.technawabs.app.assignement.constants.AppConstant;
import com.technawabs.app.assignement.services.firebase.FirebaseUtil;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    private Button addAnalyticData,crashApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Fabric fabric = new Fabric.Builder(this)
                .kits(new Crashlytics())
                .debuggable(true)           // Enables Crashlytics debugger
                .build();
        Fabric.with(fabric);
        FirebaseCrash.log(AppConstant.FIREBASE_CRASH_CREATED);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        FirebaseCrash.log(AppConstant.FIREBASE_ANAlYTICS_CREATED);

        addAnalyticData = (Button)findViewById(R.id.analytic_data);
        crashApp = (Button)findViewById(R.id.crash_app);

        addAnalyticData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.FLIGHT_NUMBER,"1234343");
                FirebaseUtil.logEvents(bundle, AppAnalyticEvents.BUTTON_CLICKED_KEY.toString(),mFirebaseAnalytics);
            }
        });
        crashApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Crashlytics.getInstance().crash();             }
        });
    }
}
