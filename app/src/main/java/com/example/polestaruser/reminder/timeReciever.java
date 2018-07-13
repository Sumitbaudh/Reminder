package com.example.polestaruser.reminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

public class timeReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String num="9958935565";
        String text="hii";


        try {

            SmsManager.getDefault().sendTextMessage(num, null, text, null, null);
            Toast.makeText(context, "SMS sent", Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
