package org.d3if3030.anggrek

import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.os.Bundle
import org.d3if3030.anggrek.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cariButton.setOnClickListener { cariAnggrek() }
    }
    private fun cariAnggrek() {
        Log.d("MainActivity", "Tombol diklik!")
    }

}