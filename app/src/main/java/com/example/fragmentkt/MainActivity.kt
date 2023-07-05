package com.example.fragmentkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fragmentkt.databinding.ActivityMainBinding
import com.example.fragmentkt.fragments.DolorFragment
import com.example.fragmentkt.fragments.GoldFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tablayout.getTabAt(1)?.select()
        binding.tablayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val manager = supportFragmentManager
                val transaction = manager.beginTransaction()
                if (tab?.position == 0) {
                    transaction.replace(R.id.frameFrag, GoldFragment()).commit()
                } else {
                    transaction.replace(R.id.frameFrag, DolorFragment()).commit()
                }


            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }
}