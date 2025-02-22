package com.androiddevs.mvvmnewsapp.db

import androidx.room.TypeConverter
import com.androiddevs.mvvmnewsapp.models.Source
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromSource(source : Source) : String{
        return source.name
    }

    @TypeConverter
    fun toSource(name : String) : Source {
        return Source(name, name)
    }


}