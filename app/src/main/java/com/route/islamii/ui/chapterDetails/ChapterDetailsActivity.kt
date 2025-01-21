package com.route.islamii.ui.chapterDetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.route.islamii.R

class ChapterDetailsActivity : AppCompatActivity() {
    companion object {
        const val POSITION = "position"
        const val TITLE = "title"

    }

    lateinit var chapterTitle: String
    var chapterPosition: Int = -1
    lateinit var tvTitle: TextView
    lateinit var versesRecycler: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_details)
        initParameters()
        initViews()
        readChapters()
    }


    private fun readChapters() {
        val allFileContent = assets.open("${chapterPosition + 1}.txt")
            .bufferedReader().use { it.readText() }
        val versesList = allFileContent.split("\n")
        bindVerses(versesList)

    }

    private fun bindVerses(versesList: List<String>) {
        val versesAdapter = VersesRecyclerAdapter(versesList)
        versesRecycler.adapter = versesAdapter

    }

    private fun initViews() {
        val toolBar: Toolbar = findViewById(R.id.tool_bar)
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        title = ""
        tvTitle = findViewById(R.id.title_chapter)
        tvTitle.text = chapterTitle
        versesRecycler = findViewById(R.id.verses_recycler)
    }


    private fun initParameters() {
        chapterTitle = intent.getStringExtra(TITLE) ?: ""
        chapterPosition = intent.getIntExtra(POSITION, -1)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}