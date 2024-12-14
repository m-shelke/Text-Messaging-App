package com.example.textmessagingapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

       Bundle bundle = intent.getExtras();

       Object[] smsObj = (Object[]) bundle.get("pdus");

       for (Object obj : smsObj){

          SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) obj);

         String MobNo= smsMessage.getOriginatingAddress();
         String messageBody = smsMessage.getMessageBody();

           Log.d("MESSAGR", "Message No "+MobNo + ", Message Body "+messageBody);

           SmsManager smsManager = SmsManager.getDefault();

           smsManager.sendTextMessage("+917058264634",null,"Hell",null,null);
       }

    }
}
