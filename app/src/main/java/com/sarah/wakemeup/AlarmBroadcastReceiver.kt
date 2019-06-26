package com.sarah.wakemeup

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent!!.action.equals("com.tester.alarmanager")){
            val b = intent.extras.getString("message")
            val notifyme = Notification()
            notifyme.Notify(context!!,b,10)
        }else if(intent.action.equals("android.intent.action.BOOT_COMPLETED")){
            val savedata = SaveData(context!!)
            savedata.setAlarm()
        }
    }

}