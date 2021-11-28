package com.lealpy.predictor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.lealpy.predictor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        initObservers()

    }

    private fun initViews() {

        binding.getPredictionBtn.setOnClickListener {
            viewModel.onBtnClicked()
        }

    }

    private fun initObservers() {

        viewModel.prediction.observe(this) { prediction ->
            binding.predictionTV.text = prediction
        }

        viewModel.predictionVisibility.observe(this) { predictionVisibility ->
            binding.predictionCV.visibility = predictionVisibility
        }

        viewModel.clickCounterText.observe(this) { clickCounter ->
            binding.predictionCounterTV.text = clickCounter
        }

    }

}