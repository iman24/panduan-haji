package com.imanancin.panduanhaji;

import static com.imanancin.panduanhaji.config.Settings.ADMOB_APP_OPEN_AD_ID;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.multidex.MultiDex;
import com.google.android.gms.ads.MobileAds;

import com.imanancin.panduanhaji.config.Settings;
import com.solodroid.ads.sdk.format.AppOpenAdManager;
import com.solodroid.ads.sdk.util.OnShowAdCompleteListener;

// this class for OpenAD admob implementation
// add   android:name=".MyApplication" in manifest inside <application tag
public class MyApplication extends Application implements Application.ActivityLifecycleCallbacks, LifecycleObserver {

    private static MyApplication mInstance;
    private AppOpenAdManager appOpenAdManager;
    Activity currentActivity;

    public MyApplication() {
        mInstance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        this.registerActivityLifecycleCallbacks(this);
        MobileAds.initialize(this, initializationStatus -> {
        });
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
        appOpenAdManager = new AppOpenAdManager();

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onMoveToForeground() {
        // Show the ad (if available) when the app moves to foreground.
        if (Settings.AD_NETWORK.equals("admob")) {
            appOpenAdManager.showAdIfAvailable(currentActivity, ADMOB_APP_OPEN_AD_ID);
        }
    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {
        if (Settings.AD_NETWORK.equals("admob")) {
            if (!appOpenAdManager.isShowingAd) {
                currentActivity = activity;
            }
        }
    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    public void showAdIfAvailable(@NonNull Activity activity, @NonNull OnShowAdCompleteListener onShowAdCompleteListener) {
        // We wrap the showAdIfAvailable to enforce that other classes only interact with MyApplication
        // class.
        if (Settings.AD_NETWORK.equals("admob")) {
            appOpenAdManager.showAdIfAvailable(activity, ADMOB_APP_OPEN_AD_ID, onShowAdCompleteListener);
        }
    }

}