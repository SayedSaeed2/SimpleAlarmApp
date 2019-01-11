package com.example.android.simplealarmapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

public class SaveData {

    private Context context;
    private SharedPreferences sharedPreferences;

    public SaveData(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("myRef", Context.MODE_PRIVATE);
    }

    public void saveData(int hour, int minute) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("hour", hour);
        editor.putInt("minute", minute);
        editor.commit();
    }

    public void loadData() {
        int minute = sharedPreferences.getInt("minute", 0);
        int hour = sharedPreferences.getInt("hour", 0);
        alarmSet(hour, minute);
    }

    public void alarmSet(int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(context, MyReceiver.class);
        intent.setAction("alarm");
        intent.putExtra("msg", "Hello from Alarm");

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }


}
