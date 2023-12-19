package com.example.bookstore.ui.landing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookstore.databinding.ActivityLandingBinding
import com.example.bookstore.domain.adapter.BookAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LandingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingBinding
    private val landingViewModel: LandingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listData()
    }

    private fun listData() {
        lifecycleScope.launch {
            binding.progressBar.visibility = View.VISIBLE
            val booksList = landingViewModel.getAllBooks()

            if (booksList.isNotEmpty()) {
                binding.textViewMessage.visibility = View.INVISIBLE

                val layoutManager = LinearLayoutManager(this@LandingActivity)
                binding.recyclerViewBooks.layoutManager = layoutManager
                binding.recyclerViewBooks.adapter = BookAdapter(booksList)
            } else {
                binding.textViewMessage.visibility = View.VISIBLE
            }

            binding.progressBar.visibility = View.INVISIBLE
        }

    }
}