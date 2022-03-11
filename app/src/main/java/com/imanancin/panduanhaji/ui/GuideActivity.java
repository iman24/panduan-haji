package com.imanancin.panduanhaji.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.imanancin.panduanhaji.R;
import com.imanancin.panduanhaji.adapter.GuidePagerAdapter;
import com.imanancin.panduanhaji.fragment.GuideFragment;
import com.imanancin.panduanhaji.model.Guide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {

    // Array buat nampung data guide
    ArrayList<Guide> guides = new ArrayList<>();
    GuidePagerAdapter guidePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        String type_haji = getIntent().getStringExtra("type_haji");

        loadUrlData(type_haji);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        guidePagerAdapter = new GuidePagerAdapter(getSupportFragmentManager(), guides);
        viewPager.setAdapter(guidePagerAdapter);



    }

    public void loadUrlData(String typ) {


        try {
            JSONObject jsonObject = new JSONObject(loadJSONFromAsset(typ));
//            Log.e("JSONX", loadJSONFromAsset());
            JSONArray array = jsonObject.getJSONArray("items");
            for (int i = 0; i < array.length() ; i++) {
                JSONObject jo = array.getJSONObject(i);
                Guide guide = new Guide(jo.getString("title"),jo.getString("filename") );
                guides.add(guide);
            }


//            adapter.setData(wallLists);
        } catch (JSONException e) {

            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset(String f) {
        String json = null;
        try {
            InputStream is = getAssets().open(f);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}