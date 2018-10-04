package com.example.polestaruser.reminder;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

public class timeReciever extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {

        String num=intent.getStringExtra("mobile_number");
        String text=intent.getStringExtra("sms_msg");

                try{
                SmsManager.getDefault().sendTextMessage(num, null, text, null, null);
                Toast.makeText(context, "SMS ", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }

    }


}
