package com.example.androidpract21

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityStopwatchViewModel : ViewModel() {
    var stopwatchWorks: MutableLiveData<Boolean> =MutableLiveData(false)
    var currentTime:MutableLiveData<Long> =MutableLiveData<Long>(0)
    var startedTime:MutableLiveData<Long> =MutableLiveData<Long>(0)

    fun startTimer(task:Runnable){
        if (!stopwatchWorks.value!!){
            stopwatchWorks.postValue(true)
            Thread(task).start()
        }
    }
}