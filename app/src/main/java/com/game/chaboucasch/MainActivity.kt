package com.game.chaboucasch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.game.chaboucasch.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    private val homeFragment = HomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(HomeFragment())
    }
    fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.addToBackStack(null)
        transaction.replace(R.id.Fragment_layout, fragment)
        transaction.commit()
    }
}
