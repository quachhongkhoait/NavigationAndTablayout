package com.example.bt2_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bt2_app.adapter.PagerAdapter;
import com.example.bt2_app.fragment.FragmentChat;
import com.example.bt2_app.fragment.FragmentHome;
import com.example.bt2_app.fragment.FragmentMyPager;
import com.example.bt2_app.fragment.FragmentNew;
import com.google.android.material.tabs.TabLayout;

public class IntroductionActivity extends AppCompatActivity {

    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        mTextView = findViewById(R.id.tvDone);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SessionManager.getInstance().setKeySaveFirstApp(false);
                Intent intent = new Intent(IntroductionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}