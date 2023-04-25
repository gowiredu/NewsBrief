package com.gowiredu.newsbrief.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.gowiredu.newsbrief.R
import com.gowiredu.newsbrief.databinding.ActivityNewsBinding
import com.gowiredu.newsbrief.db.ArticleDatabase
import com.gowiredu.newsbrief.repository.NewsRepository

class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding
    lateinit var viewModel: NewsViewModel

    private val newsNavHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
    }
    private val navController by lazy {
        newsNavHostFragment.findNavController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }


        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]

        // sets up bottom navigation
        binding.bottomNavigationView.setupWithNavController(navController)


    }
}
