package org.techtown.navigation_test.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.techtown.navigation_test.R

class MainActivity : AppCompatActivity() {

//    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
    }
}