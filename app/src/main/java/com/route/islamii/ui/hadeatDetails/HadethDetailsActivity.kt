package com.route.islamii.ui.hadeatDetails

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.islamii.databinding.ActivityHadethDetailsBinding
import com.route.islamii.ui.home.hadeth.Hadeth
import com.route.islamii.ui.home.hadeth.HadethFragment.Companion.HADETH

class HadethDetailsActivity : AppCompatActivity() {
    var hadeth: Hadeth? = null
    lateinit var binding: ActivityHadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        readExtra()
        initViews()


    }

    private fun initViews() {
        title = ""
        setSupportActionBar(binding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        binding.titleChapter.text = hadeth?.title
        binding.content.content.text = hadeth?.content
    }

    private fun readExtra() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getParcelableExtra(HADETH, Hadeth::class.java)
        } else {
            hadeth = intent.getParcelableExtra(HADETH) as Hadeth?
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}