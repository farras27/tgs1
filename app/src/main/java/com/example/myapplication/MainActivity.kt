package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var isFragmentOneLoaded = true
    val manager = supportFragmentManager
    var pindahkanan: Button? = null
    var pindahkiri: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pindahkanan = findViewById<Button>(R.id.button_kanan)
        pindahkiri = findViewById<Button> (R.id.button_kiri)
        val PindahKiri  = findViewById<Button>(R.id.button_kiri)
        showFragementUtama()

        pindahkanan?.setOnClickListener({
        if(isFragmentOneLoaded)
            showFragmentTwo()
            else
            showFragementUtama()
        })

        PindahKiri.setOnClickListener({
            if(isFragmentOneLoaded)
                showFragmentOne()
            else
                showFragementUtama()
        })

    }

    fun showFragmentOne(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentOne()
        transaction.replace(R.id.fragment_holder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = false
        pindahkanan?.isEnabled = true
        pindahkiri?.isEnabled = false
    }
    fun showFragmentTwo(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentTwo()
        transaction.replace(R.id.fragment_holder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = true
        pindahkanan?.isEnabled = false
        pindahkiri?.isEnabled = true
    }

    fun showFragementUtama(){
        val transaction = manager.beginTransaction()
        val fragment = FragementUtama()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = true
        pindahkanan?.isEnabled = true
        pindahkiri?.isEnabled = true
    }
}
