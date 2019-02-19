package com.example.hdev.broadcastreceiverexample

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // Giong bien static
    companion object {
        val ACTION_LOCAL : String = "LOCAL_BROADCAST"
        val ACTION : String = "android.intent.action.AIRPLANE_MODE"
        val ID : String = "id"
    }
    private val myReceiver: LocalBroadcastReceiver = LocalBroadcastReceiver()
    private var btn_send : Button? = null
    private val localBroadcastManager = LocalBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView();
        // Dang ky Broadcast: App nao dang ky cung co the bat duoc.
        var filter1 = IntentFilter(ACTION)
        registerReceiver(myReceiver, filter1)

        // Dang ky Local Broadcast: Chi bat duoc event trong app.
        var filter2 = IntentFilter(ACTION_LOCAL)
        LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver, filter2)
    }

    private fun initView() {
        btn_send = findViewById(R.id.btn_send)
        btn_send?.setOnClickListener(this)
    }

    override fun onPause() {
        unregisterReceiver(myReceiver)
        super.onPause()
    }

    override fun onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myReceiver)
        super.onDestroy()
    }

    override fun onClick(v: View?) {
        if (v == null) return
        when(v.id){
            R.id.btn_send -> {
                var intent = Intent(ACTION_LOCAL)
                intent.putExtra(ID, "123")
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
            }
        }
    }
}
