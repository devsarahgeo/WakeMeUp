package com.sarah.wakemeup

import android.app.DialogFragment
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TimePicker
import kotlinx.android.synthetic.main.popup_time.*
import kotlinx.android.synthetic.main.popup_time.view.*

class PopUpTime:DialogFragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val myView = inflater!!.inflate(R.layout.popup_time,container,false)
        val buDone = myView.btndone as Button
        val timepicker = myView.timepicker as TimePicker
        buDone.setOnClickListener {
            val myActivity = activity as MainActivity
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                myActivity.timeSetter(timepicker.hour,timepicker.minute)
            }else{
                myActivity.timeSetter(timepicker.currentHour,timepicker.currentMinute)
            }
            this.dismiss()
        }

        return myView
    }
}