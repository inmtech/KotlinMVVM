package com.app.kotlindemo.util

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*


/**
 * TODO: Add a class header comment!
 */
class CommonUtils {
    companion object {


        fun isInternetAvailable(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
            val isConnected: Boolean = activeNetwork?.isConnected == true
            return isConnected
        }



        fun changeScreenTitle(activity: BaseActivity, screenName: String) {
            (activity as AppCompatActivity).supportActionBar!!.setTitle(screenName)
        }

        fun displayToastShort(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        fun displayToastLong(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }

        fun validateControl(context: Context, editText: EditText): Boolean {
            var result: Boolean = false
            if (!editText.text.toString().isEmpty())
                result = true
            return result
        }

        fun getCurrentDate(dateFormat: String): String {
            val sdf = SimpleDateFormat(dateFormat)
            sdf.timeZone = TimeZone.getTimeZone("UTC")
            val currentDate = sdf.format(Date())
            return currentDate.toString()
        }

        fun getConvertedDate(strDate: String): String {
            var spf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            spf.setTimeZone(TimeZone.getTimeZone("UTC"))
            val newDate = spf.parse(strDate)
            spf = SimpleDateFormat("dd/MM/yyyy")
            return spf.format(newDate)
        }

        fun hideKeyboard(context: Context, view: View) {
            val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
        }
    }
}