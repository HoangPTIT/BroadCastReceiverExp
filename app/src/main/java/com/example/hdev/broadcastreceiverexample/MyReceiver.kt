package com.example.hdev.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // context: Có thể start một Activity hay Service
        // Intent nhận được những thông tin từ hệ thống
        Log.d("TAG", intent?.action)
    }
}