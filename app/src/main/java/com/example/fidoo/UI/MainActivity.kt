package com.example.fidoo.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fidoo.R
import com.example.fidoo.databinding.ActivityMainBinding
import com.example.fidoo.API.NetworkHelperClass
import com.example.fidoo.DATA.Data
import com.example.fidoo.UI.ADAPTER.ResponseAdapter
import com.example.fidoo.UI.VIEWMODEL.ResponseViewModel
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var list = ArrayList<Data>()
    lateinit var responseAdapter : ResponseAdapter
    private lateinit var responseViewModel: ResponseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        responseViewModel = ViewModelProvider(this).get(ResponseViewModel::class.java)

        FirebaseMessaging.getInstance().subscribeToTopic("notification")
        /**
         * starting the shimmer effect
         */
        binding.shimmerFrameLayout.startShimmerAnimation()
        setAdapter()
        CoroutineScope(Dispatchers.IO).launch {
            delay(1500)
            responseViewModel.callAPi()
        }

        /**
         * observing each data inside the list using live data
         */
        this.responseViewModel.liveData.observe(this) {
            it.let {
                when (it) {
                    is NetworkHelperClass.OnSuccess -> {
                        binding.shimmerFrameLayout.stopShimmerAnimation()
                        binding.recyclerView.visibility = View.VISIBLE
                        list = it.responseList as ArrayList<Data>
                        setAdapter()
                    }
                    else -> {
                        Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
    /**
     * setting all the data in recyclerview
     */
    private fun setAdapter() {
        responseAdapter = ResponseAdapter(list)
        val linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.apply {
            adapter = responseAdapter
            layoutManager = linearLayoutManager
        }
    }
}