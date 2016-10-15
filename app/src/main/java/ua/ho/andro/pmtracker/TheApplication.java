package ua.ho.andro.pmtracker;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

public class TheApplication extends Application{
    private static TheApplication instance;


    public static TheApplication getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        MobileAds.initialize(getApplicationContext(), getString(R.string.banner_ad_unit_id));
        AdRequest adRequest = new AdRequest.Builder().build();
    }
}
