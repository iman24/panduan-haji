package com.imanancin.panduanhaji;

import static com.imanancin.panduanhaji.config.Settings.ADMOB_APP_OPEN_AD_ID;
import static com.imanancin.panduanhaji.config.Settings.ADMOB_INTERSTITIAL_ID;
import static com.imanancin.panduanhaji.config.Settings.ADMOB_NATIVE_ID;
import static com.imanancin.panduanhaji.config.Settings.AD_STATUS;
import static com.imanancin.panduanhaji.config.Settings.AD_NETWORK;
import static com.imanancin.panduanhaji.config.Settings.APPLOVIN_INTERSTITIAL_ID;
import static com.imanancin.panduanhaji.config.Settings.APPLOVIN_INTERSTITIAL_ZONE_ID;
import static com.imanancin.panduanhaji.config.Settings.APPLOVIN_NATIVE_MANUAL_ID;
import static com.imanancin.panduanhaji.config.Settings.BACKUP_AD_NETWORK;
import static com.imanancin.panduanhaji.config.Settings.ADMOB_BANNER_ID;
import static com.imanancin.panduanhaji.config.Settings.INTERVAL_INTERSTITIAL;
import static com.imanancin.panduanhaji.config.Settings.MOPUB_INTERSTITIAL_ID;
import static com.imanancin.panduanhaji.config.Settings.STARTAPP_APP_ID;
import static com.imanancin.panduanhaji.config.Settings.UNITY_BANNER_ID;
import static com.imanancin.panduanhaji.config.Settings.APPLOVIN_BANNER_ID;
import static com.imanancin.panduanhaji.config.Settings.APPLOVIN_BANNER_ZONE_ID;
import static com.imanancin.panduanhaji.config.Settings.MOPUB_BANNER_ID;
import static com.imanancin.panduanhaji.config.Settings.UNITY_GAME_ID;
import static com.imanancin.panduanhaji.config.Settings.UNITY_INTERSTITIAL_ID;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.solodroid.ads.sdk.format.AdNetwork;
import com.solodroid.ads.sdk.format.AppOpenAdManager;
import com.solodroid.ads.sdk.format.BannerAd;
import com.solodroid.ads.sdk.format.InterstitialAd;
import com.solodroid.ads.sdk.format.NativeAd;

import com.imanancin.panduanhaji.ui.GuideActivity;

public class MainActivity extends AppCompatActivity {

    AdNetwork.Initialize adNetwork;
    BannerAd.Builder bannerAd;
    InterstitialAd.Builder interstitialAd;
    NativeAd.Builder nativeAd;
    public int intercount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init
        adNetwork = new AdNetwork.Initialize(this)
                .setAdStatus(AD_STATUS)
                .setAdNetwork(AD_NETWORK)
                .setBackupAdNetwork(BACKUP_AD_NETWORK)
                .setAdMobAppId(null)
                .setStartappAppId(STARTAPP_APP_ID)
                .setUnityGameId(UNITY_GAME_ID)
                .setAppLovinSdkKey(getResources().getString(R.string.applovin_sdk_key))
                .setMopubBannerId(MOPUB_BANNER_ID)
                .setDebug(BuildConfig.DEBUG)
                .build();


        // banner ad
        bannerAd = new BannerAd.Builder(this)
                .setAdStatus(AD_STATUS)
                .setAdNetwork(AD_NETWORK)
                .setBackupAdNetwork(BACKUP_AD_NETWORK)
                .setAdMobBannerId(ADMOB_BANNER_ID)
                .setUnityBannerId(UNITY_BANNER_ID)
                .setAppLovinBannerId(APPLOVIN_BANNER_ID)
                .setAppLovinBannerZoneId(APPLOVIN_BANNER_ZONE_ID)
                .setMopubBannerId(MOPUB_BANNER_ID)
                .setDarkTheme(false)
                .build();


        // inter
        interstitialAd = new InterstitialAd.Builder(this)
                .setAdStatus(AD_STATUS)
                .setAdNetwork(AD_NETWORK)
                .setBackupAdNetwork(BACKUP_AD_NETWORK)
                .setAdMobInterstitialId(ADMOB_INTERSTITIAL_ID)
                .setUnityInterstitialId(UNITY_INTERSTITIAL_ID)
                .setAppLovinInterstitialId(APPLOVIN_INTERSTITIAL_ID)
                .setAppLovinInterstitialZoneId(APPLOVIN_INTERSTITIAL_ZONE_ID)
                .setMopubInterstitialId(MOPUB_INTERSTITIAL_ID)
                .setInterval(1)
                .build();

        nativeAd = new NativeAd.Builder(this)
                .setAdStatus(AD_STATUS)
                .setAdNetwork(AD_NETWORK)
                .setBackupAdNetwork(BACKUP_AD_NETWORK)
                .setAdMobNativeId(ADMOB_NATIVE_ID)
                .setAppLovinNativeId(APPLOVIN_NATIVE_MANUAL_ID)
                .setDarkTheme(false)
                .build();

        new AppOpenAdManager().showAdIfAvailable(this, ADMOB_APP_OPEN_AD_ID);

    }

    public void hajiQiran(View view) {
        Intent intent = new Intent(this, GuideActivity.class);
        intent.putExtra("type_haji", "haji_qiran.json");
        startActivity(intent);
        if (INTERVAL_INTERSTITIAL == intercount) {
            interstitialAd.show();
            intercount = 0;
        } else {
            intercount++;
        }

    }

    public void hajiIfrad(View view) {
        Intent intent = new Intent(this, GuideActivity.class);
        intent.putExtra("type_haji", "haji_ifrad.json");
        startActivity(intent);
        if (INTERVAL_INTERSTITIAL == intercount) {
            interstitialAd.show();
            intercount = 0;
        } else {
            intercount++;
        }
    }

    public void hajiTamattu(View view) {
        Intent intent = new Intent(this, GuideActivity.class);
        intent.putExtra("type_haji", "haji_tamatu.json");
        startActivity(intent);
        if (INTERVAL_INTERSTITIAL == intercount) {
            interstitialAd.show();
            intercount = 0;
        } else {
            intercount++;
        }
    }

    public void umrah(View view) {
        Intent intent = new Intent(this, GuideActivity.class);
        intent.putExtra("type_haji", "umrah.json");
        startActivity(intent);
        if (INTERVAL_INTERSTITIAL == intercount) {
            interstitialAd.show();
            intercount = 0;
        } else {
            intercount++;
        }
    }
}