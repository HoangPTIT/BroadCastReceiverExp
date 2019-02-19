package com.example.hdev.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class LocalBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent == null) return
        when (intent.action) {
            MainActivity.ACTION -> {
                Log.d("TAG", intent.action)
            }

            MainActivity.ACTION_LOCAL -> {
                Log.d("TAG", intent.getStringExtra(MainActivity.ID))
            }
        }
    }
}