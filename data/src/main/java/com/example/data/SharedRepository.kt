package com.example.data

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedRepository @Inject constructor(
    @ApplicationContext context: Context
) {
    private var pref = context.getSharedPreferences(Constans.PREF_NAME, Context.MODE_PRIVATE)
    private val editor = pref.edit()

    fun saveNameCoffee(nameCoffee: String) {
        editor.putString(Constans.NAME_COFFEE, nameCoffee)
        editor.apply()
    }

    fun getNameCoffee():String?{
        return pref.getString(Constans.NAME_COFFEE, "Please add coffee name")
    }

    fun savePrice(price: Int) {
        editor.putInt(Constans.PRICE, price)
        editor.apply()
    }

    fun getPrice():Int{
        return pref.getInt(Constans.PRICE, 20)
    }

    fun saveNumberGlasses(numberGlasses: Int) {
        editor.putInt(Constans.NUMBER_GLASSES, numberGlasses)
        editor.apply()
    }

    fun getNumberGlasses():Int{
        return pref.getInt(Constans.NUMBER_GLASSES, 1)
    }

    fun saveIsFree(isFree: Boolean) {
        editor.putBoolean(Constans.IS_FREE, isFree)
        editor.apply()
    }

    fun getIsFree():Boolean{
        return pref.getBoolean(Constans.IS_FREE, false)
    }
}