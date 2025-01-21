package com.route.islamii.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.route.islamii.R
import com.route.islamii.ui.home.hadeth.HadethFragment
import com.route.islamii.ui.home.quran.QuranFragment
import com.route.islamii.ui.home.radio.RadioFragment
import com.route.islamii.ui.home.tasbeh.TasbehFragment

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNav = findViewById(R.id.navigation_bottom)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_quran -> {
                    showTap(QuranFragment())
                }

                R.id.navigation_hadeth -> {
                    showTap(HadethFragment())
                }

                R.id.navigation_tasbeh -> {
                    showTap(TasbehFragment())
                }

                R.id.navigation_radio -> {
                    showTap(RadioFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
        bottomNav.selectedItemId = R.id.navigation_quran


    }

    fun showTap(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()

    }
}
