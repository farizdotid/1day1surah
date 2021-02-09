package com.farizdotid.a1day1surah.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    private lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = this.setBinding()
        setContentView(binding.root)

        onViewReady(savedInstanceState)
    }

    abstract fun setBinding(): T

    protected open fun onViewReady(savedInstanceState: Bundle?) {

    }
}