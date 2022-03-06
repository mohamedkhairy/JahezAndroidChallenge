package net.jahez.jahezchallenge.presentation.utils

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.util.DisplayMetrics
import net.jahez.jahezchallenge.presentation.MainActivity
import java.util.*


fun Activity.setAppLocale( lang: String?) {
    val myLocale = Locale(lang)
    val res: Resources = resources
    val dm: DisplayMetrics = res.displayMetrics
    val conf: Configuration = res.configuration
    conf.setLocale(myLocale)
    res.updateConfiguration(conf, dm)
    conf.setLayoutDirection(myLocale)
}

fun Activity.restartActivity(){
    val refresh = Intent(this, MainActivity::class.java)
    startActivity(refresh)
    finish()
}