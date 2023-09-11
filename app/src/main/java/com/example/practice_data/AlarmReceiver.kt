package com.example.practice_data


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

       val title = intent?.getStringExtra("title")
        val content = intent?.getStringExtra("content")

        if (context != null && title != null && content != null){
            val notification = Notification(context)
            notification.showNotification()
        }
    }
}