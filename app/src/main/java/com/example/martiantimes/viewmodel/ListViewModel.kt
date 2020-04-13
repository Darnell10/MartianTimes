package com.example.martiantimes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.martiantimes.model.MartianResponse
import io.reactivex.disposables.CompositeDisposable

class ListViewModel(application: Application) : AndroidViewModel(application) {

    val articles by lazy { MutableLiveData<List<MartianResponse>>() }
    val loading by lazy { MutableLiveData<Boolean>() }
    val loaderError by lazy { MutableLiveData<Boolean>() }

    private val disposable = CompositeDisposable()


}