package com.example.polestaruser.reminder;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.widget.Toast;

import java.util.List;

public class timeReciever extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {

        String num=intent.getStringExtra("mobile_number");
        String text=intent.getStringExtra("sms_msg");
        int selectedSIM=intent.getIntExtra("SIM",0);
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                SubscriptionManager localSubscriptionManager = SubscriptionManager.from(context);
                if (localSubscriptionManager.getActiveSubscriptionInfoCount() > 1) {
                    List localList = localSubscriptionManager.getActiveSubscriptionInfoList();

                    SubscriptionInfo simInfo = (SubscriptionInfo) localList.get(selectedSIM);

                    //SendSMS From SIM One
                    SmsManager.getSmsManagerForSubscriptionId(simInfo.getSubscriptionId()).sendTextMessage(num, null, text, null, null);
                    Toast.makeText(context, "SMS ", Toast.LENGTH_SHORT).show();
                    //SendSMS From SIM Two
                   // SmsManager.getSmsManagerForSubscriptionId(simInfo2.getSubscriptionId()).sendTextMessage(customer.getMobile(), null, smsText, sentPI, deliveredPI);
                }

            } else {
                SmsManager.getDefault().sendTextMessage(num, null, text, null, null);
                Toast.makeText(context, "SMS ", Toast.LENGTH_SHORT).show();            }

        }catch (SecurityException e){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        catch (Exception error){
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            error.printStackTrace();
        }


        /*        try{
                SmsManager.getDefault().sendTextMessage(num, null, text, null, null);


            } catch (Exception e) {

            }
*/
    }


}
