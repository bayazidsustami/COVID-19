package com.the_b.covid_19.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.the_b.covid_19.main.country.CountryFragment
import com.the_b.covid_19.main.global.GlobalFragment
import com.the_b.covid_19.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var contents: FrameLayout?=null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            R.id.global -> {
                val fragment =
                    GlobalFragment.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.country -> {
                val fragment =
                    CountryFragment.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.help -> {
                val fragment =
                    HelpFragment.newInstance()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, fragment, fragment.javaClass.simpleName)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var menu: Menu = bottom_nav.menu
        bottom_nav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = GlobalFragment.newInstance()
        addFragment(fragment)
    }
}
