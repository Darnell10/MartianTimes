package com.example.martiantimes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.martiantimes.model.MartianResponse
import com.example.martiantimes.model.MartianService
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class ListViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main


    private val articles by lazy { MutableLiveData<List<MartianResponse>>() }
    private val loading by lazy { MutableLiveData<Boolean>() }
    private val loaderError by lazy { MutableLiveData<Boolean>() }

    private val martianService = MartianService()

    private val disposable = CompositeDisposable()

    suspend fun fetchFromRemote() {

        coroutineScope {
            viewModelScope.launch {

                try {
                    val fetchArticles = withContext(Dispatchers.IO) {
                        martianService.getArticles()
                    }
                    showArticles(fetchArticles)
                } catch (e: Exception) {
                    showError(e)
                }

            }
        }

    }


    private fun showArticles(list: List<MartianResponse>) {
        articles.value = list
        loading.value = false
        loaderError.value = false
    }

    private fun showError(exception: Exception) {
        return showError(exception)
    }


    fun martianTranslator(words: String): String? {
        val upperCaseMartian = " Boinga "
        val lowerCaseMartian = " boinga "
        val wordArray = words.split(" ").toTypedArray()
        var result = " "
        for (word in wordArray) {
            result += if (word.length > 3 && Character.isUpperCase(word[0])) {
                upperCaseMartian
            } else if (word.length > 3 && Character.isLowerCase(word[0])) {
                lowerCaseMartian
            } else {
                " $word"
            }
        }
        return result
    }

}