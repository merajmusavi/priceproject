package com.example.fragmentkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentkt.databinding.ActivityMainBinding
import com.example.fragmentkt.fragments.DolorFragment
import com.example.fragmentkt.fragments.GoldFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,DolorFragment()).commit()

        binding.btnChange.setOnClickListener {
            val currentFragment = supportFragmentManager.findFragmentById(R.id.frameLayout)
            val newFragment = if (currentFragment is DolorFragment) GoldFragment() else DolorFragment()
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, newFragment).commit()

        }



    }
}