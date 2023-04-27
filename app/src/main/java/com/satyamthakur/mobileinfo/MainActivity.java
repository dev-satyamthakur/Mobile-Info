package com.satyamthakur.mobileinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.Camera;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    final String TAG = "MYAPPACTIVITY";
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tvMain);

        StringBuilder sb = new StringBuilder();
        sb.append("\n" + "Manufacturer : " + Build.MANUFACTURER);
        sb.append("\n" + "Model : " + Build.MODEL);


        // for ram
        ActivityManager actManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        actManager.getMemoryInfo(memInfo);
        long totalMemory = memInfo.totalMem;
        sb.append("\n" + "Total RAM : " + String.format("%.2f", (double)totalMemory / 1073741824.0) + " GB");




        // for storage
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getBlockCount();
        String size =  Formatter.formatFileSize(this, availableBlocks * blockSize);
        sb.append("\n" + "Total Storage : " + size);

        // for battery
        BatteryManager bm = (BatteryManager) getApplicationContext().getSystemService(BATTERY_SERVICE);
        int batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        sb.append("\n" + "Battery Level : " + batLevel + "%");

        // android version
        sb.append("\n" + "Android Version : " + Build.VERSION.RELEASE);

        //// Code For IMEI AND IMSI NUMBER
        tv.setText(sb);


        Log.d(TAG, String.valueOf(Build.VERSION.SDK_INT));
        Log.d(TAG, String.valueOf(Build.DEVICE));
        Log.d(TAG, String.valueOf(Build.MODEL));
        Log.d(TAG, String.valueOf(Build.MANUFACTURER));
        Log.d(TAG, Build.DISPLAY);
        Log.d(TAG, Build.FINGERPRINT);
        Log.d(TAG, Build.HARDWARE);
        Log.d(TAG, Build.HOST);
        Log.d(TAG, Build.ID);
        Log.d(TAG, Build.PRODUCT);
        Log.d(TAG, Build.BRAND);

        Log.d(TAG, Build.VERSION.BASE_OS);
        Log.d(TAG, Build.VERSION.RELEASE);
        Log.d(TAG, Build.VERSION.CODENAME);
        Log.d(TAG, Build.VERSION.SECURITY_PATCH);
        Log.d(TAG, Build.VERSION.SDK);
        Log.d(TAG, Build.VERSION.SDK);
    }


}