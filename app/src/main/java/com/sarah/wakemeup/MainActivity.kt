package com.sarah.wakemeup

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val savedata = SaveData(applicationContext)
        tvTime.text = savedata.getHour().toString() + ":" + savedata.getMinute().toString()

    }
    fun SetTime(view:View){
        val popUpTime = PopUpTime()
        popUpTime.show(fragmentManager,"Select your Time")
    }
    @SuppressLint("SetTextI18n")
    fun timeSetter(hour:Int, minute:Int){
        tvTime.text = hour.toString()+ ":" +minute.toString()
        val savedata = SaveData(applicationContext)
        savedata.SaveData(hour,minute)
        savedata.setAlarm()
    }
}
