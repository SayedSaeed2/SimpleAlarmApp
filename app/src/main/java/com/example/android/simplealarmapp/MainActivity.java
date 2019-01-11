package com.example.android.simplealarmapp;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView alarmTextView;
    private Button alarmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmTextView = findViewById(R.id.alarm_tv);
        alarmButton = findViewById(R.id.alarm_btn);

        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                PopTime popTime = new PopTime();
                popTime.show(fm, "Show Alarm");
            }
        });

    }

    public void setTime(int hour, int minute) {
        // save data
        SaveData saveData = new SaveData(this);
        saveData.alarmSet(hour, minute);
        saveData.saveData(hour, minute);
    }

}
