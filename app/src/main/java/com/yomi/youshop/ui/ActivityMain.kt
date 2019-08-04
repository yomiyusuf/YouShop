package com.yomi.youshop.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.yomi.youshop.R

class ActivityMain : AppCompatActivity() {

    val fm = supportFragmentManager
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_shop -> {
                loadShopFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_cart -> {
                loadCartFragment()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        if(savedInstanceState == null){
            loadShopFragment()
        }
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    fun loadShopFragment(){
        startFragment(FragmentShop(), "Shop", false)
    }

    fun loadCartFragment(){
        startFragment(FragmentCart(), "Cart")
    }

    fun loadDetailFragment(){
        startFragment(FragmentDetail(), "Detail")
    }

    private fun startFragment(fragment: Fragment, tag: String, addToBackStack: Boolean = true){
        val transaction = fm.beginTransaction()
            .replace(R.id.main_content, fragment, tag)
        if (addToBackStack) transaction.addToBackStack(null)
        transaction.commit()
    }
}
