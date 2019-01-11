package com.example.android.simplealarmapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equalsIgnoreCase("alarm")) {
            Bundle bundle = intent.getExtras();
            Toast.makeText(context, bundle.getString("msg"), Toast.LENGTH_LONG).show();
        } else if (intent.getAction().equalsIgnoreCase("android.intent.action.BOOT_COMPLETED")) {
            // when you restart your phone
            SaveData saveData = new SaveData(context);
            saveData.loadData();
        }

    }
}
