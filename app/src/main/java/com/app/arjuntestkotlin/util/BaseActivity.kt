package com.app.kotlindemo.util

import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    /*fun replaceFragment(context: Context, fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, fragment, fragment.javaClass.name)
        ft.commit()
    }

    fun addFragment(context: Context, fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.container, fragment, fragment.javaClass.name)
    }*/
}