package com.example.androidpract21

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityStopwatchViewModel : ViewModel() {
    var stopwatchWorks: MutableLiveData<Boolean> =MutableLiveData(false)
    var currentTime:MutableLiveData<Long> =MutableLiveData<Long>(0)
    var startedTime:MutableLiveData<Long> =MutableLiveData<Long>(0)

    val timerTask= Runnable {
        startedTime.postValue(System.currentTimeMillis())

        while (stopwatchWorks.value!!){
            currentTime.postValue(System.currentTimeMillis()-startedTime.value!!)
            Thread.sleep(1000/60)
        }
    }


    fun getPastedtime():LiveData<Long?>{
        return currentTime
    }

    fun startTimer(){
        if (!stopwatchWorks.value!!){
            stopwatchWorks.setValue(true)
            Thread(timerTask).start()
        }
    }
    fun stopTimer(){
        stopwatchWorks.setValue(false)
    }

    fun isWorks():Boolean{
        return stopwatchWorks.value!!
    }
}