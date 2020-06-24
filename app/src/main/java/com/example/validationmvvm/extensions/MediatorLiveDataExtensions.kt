package com.example.validationmvvm.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer

fun <S> MediatorLiveData<S>.addSources(onChanged: Observer<S>, vararg sources: LiveData<S>) {
    for (source in sources) {
        addSource(source, onChanged)
    }
}