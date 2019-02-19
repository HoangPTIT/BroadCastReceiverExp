package com.example.hdev.broadcastreceiverexample

import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    // Khoi tao
    var myReceiver: MyReceiver = MyReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Dang ky nhan su kien
        var filter = IntentFilter( "android.intent.action.AIRPLANE_MODE")
        registerReceiver(myReceiver, filter)
    }

    override fun onPause() {
        unregisterReceiver(myReceiver)
        super.onPause()
    }
}
