package com.imanancin.panduanhaji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.imanancin.panduanhaji.ui.GuideActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void hajiQiran(View view) {
        Intent intent = new Intent(this, GuideActivity.class);
        intent.putExtra("type_haji", "haji_qiran.json");
        startActivity(intent);
    }
}