package com.example.androidpract21

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mainViewModel : MainActivityStopwatchViewModel=ViewModelProvider(this).get(MainActivityStopwatchViewModel::class.java)
        mainViewModel.getPastedtime().observe(this){
            value ->
            findViewById<TextView>(R.id.timeLabel).setText((((value?: 0)/10) /100.0).toString())
        }

        findViewById<Button>(R.id.timerButton).setOnClickListener {
            if(!mainViewModel.isWorks()){
                mainViewModel.startTimer()
                findViewById<Button>(R.id.timerButton).setText(getString(R.string.stop))
            }
            else{
                mainViewModel.stopTimer()
                findViewById<Button>(R.id.timerButton).setText(getString(R.string.start))
            }

        }
    }
}