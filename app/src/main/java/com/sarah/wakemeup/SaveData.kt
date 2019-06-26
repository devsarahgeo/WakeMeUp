package com.sarah.wakemeup

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import java.util.*

class SaveData() {
    var context: Context?= null
    var sharedRef:SharedPreferences?=null
    constructor(context: Context) : this() {
        this.context=context
        sharedRef = context.getSharedPreferences("myRef",Context.MODE_PRIVATE)
    }

    fun SaveData(hours:Int,minutes:Int){
        val editor = sharedRef!!.edit()
        editor.putInt("hour",hours)
        editor.putInt("minute",minutes)
        editor.apply()
    }
    fun getHour():Int{
        return sharedRef!!.getInt("hour",0)
    }
    fun getMinute():Int{
        return sharedRef!!.getInt("minute",0)
    }
    fun setAlarm(){
        val hours = getHour()
        val minutes = getMinute()
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY,hours)
        calendar.set(Calendar.MINUTE,minutes)
        calendar.set(Calendar.SECOND,0)

        val am = context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context,AlarmBroadcastReceiver::class.java)
        intent.putExtra("message","Alarm time")
        intent.action = "com.tester.alarmanager"
        val pi = PendingIntent.getBroadcast(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
        //when alarm time set is reached(calendar.timeinmillis),then call the pendingintent(i.e.send notification)
        am.setRepeating(AlarmManager.RTC_WAKEUP,calendar.timeInMillis,AlarmManager.INTERVAL_DAY,pi)
    }
}